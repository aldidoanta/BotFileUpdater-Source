package validator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;

/**
 * Class for validator functionality of BotFileUpdater
 * @author aldidoanta
 *
 */
public class Validator {
		
	/**
	 * Validates stored build, checking for errors
	 * @param the string of the bot build
	 * @param hero the name of the hero
	 */
	public void validateBuild(String content, String hero, DefaultListModel<String> listModel){
		try {
			int lineNumber = 0; //current line number
			int braceCount = 0; //used for counting the number of braces
			String key = null; //current examined key
			String line = null; //used for reading the multiline string
			
			//used in key-value pattern matching
			Pattern keyPattern = Pattern.compile("^\\s*\"(\\w+)\"\\s*$");
			Pattern keyvaluePattern = Pattern.compile("^\\s*\"(\\w+)\"\\s+\"(.+)\"\\s*$");
			Matcher keyMatcher = null;
			Matcher keyvalueMatcher = null;
			
			BufferedReader br = new BufferedReader(new StringReader(content));
			while((line = br.readLine()) != null){ //read line by line
				lineNumber++;
				
				//search for a single key or a pair of key-value
				keyMatcher = keyPattern.matcher(line);
				keyvalueMatcher = keyvaluePattern.matcher(line);
				
				if(keyMatcher.find()){
					String keyName = keyMatcher.group(1); 
					if(key == null){
						if(keyName.equals("Bot")){
							key = "Bot"; //found "Bot" key
						}
						else{
							printError(lineNumber, "\"Bot\" must be the first key", listModel);
						}
					}
					else if (key.equals("Bot")){
						switch(keyName){ //search for subkey of "Bot" key
							case "Loadout":
								key = "Loadout";
								break;
							case "Build":
								key = "Build";
								break;
							case "LaningInfo":
								key = "LaningInfo";
								break;
							case "HeroType":
							case "AggressionFactor":
								printError(lineNumber, "\"" + keyName + "\"" + " needs a value next to it, enclosed in quotes", listModel);
								break;
							default:
								printError(lineNumber, "\"" + keyName + "\""+" is not a valid subkey of \"Bot\"", listModel);
						}
					}
				}
				else if(keyvalueMatcher.find()){
					String keyName = keyvalueMatcher.group(1); 
					if (key.equals("Bot")){
						switch(keyName){ //search for subkey of "Bot"
							case "HeroType":
								
								String herotypeValue = keyvalueMatcher.group(2);
								//validate HeroType
								String[] roleTokens = herotypeValue.split("\\|");
								for (String token : roleTokens){
									token = token.trim();
									if(!Arrays.asList(ValidatorConst.ROLE).contains(token)){
										printError(lineNumber, "\"" + token + "\" is not a valid value for \"HeroType\" key", listModel);
									}
								}
								break;
							case "AggressionFactor":
								
								String aggressionfactorValue = keyvalueMatcher.group(2); 
								//validate AggressionFactor
								if(Arrays.asList(ValidatorConst.HERO_AGGRESIONFACTOR).contains(hero)){ //checks if current hero has "AggressionFactor" key
									try{
										Float.parseFloat(aggressionfactorValue); //checks if "AggressionFactor" value is a valid float number
									}
									catch (NumberFormatException e){
										printError(lineNumber, "the value of \"AggressionFactor\" is not a valid decimal number", listModel);
									}
								}
								else{
									printError(lineNumber, "found \"AggressionFactor\" key in " + hero + " bot build", listModel);
								}
								break;
							default:
								printError(lineNumber, "\""+keyName+"\""+" is not a valid child of \"Bot\"", listModel);
						}
					}
					else if (key.equals("Loadout")) {
						
						String loadoutKey = keyvalueMatcher.group(1);
						String loadoutValue = keyvalueMatcher.group(2);
						//validate Loadout
						if(!Arrays.asList(ValidatorConst.ITEM).contains(loadoutKey)){
							printError(lineNumber, "\"" + loadoutKey + "\" is not a valid value for item build", listModel);
						}
						if(loadoutValue.matches("(.*)\\s*\\|\\s*ITEM_SELLABLE")){
							loadoutValue = loadoutValue.replaceAll("\\s*\\|\\s*ITEM_SELLABLE", "");  //remove "ITEM_SELLABLE" suffix
						}
						if(!Arrays.asList(ValidatorConst.ITEM_PRIORITY).contains(loadoutValue)){
							printError(lineNumber, "\"" + loadoutValue + "\" is not a valid value for item build", listModel);
						}
					}
					else if (key.equals("Build")) {
						//validate Build
						String[]normalSkill = null;
						String ultSkill = null;
						String buildValue = keyvalueMatcher.group(2);
						
						//search for hero skill in BotImplSkill enum
						for(BotImplSkill b: BotImplSkill.values()){
							if(hero.equals(b.getHeroName())){
								normalSkill = b.getNormalSkill();
								ultSkill = b.getUltSkill();
								break;
							}
						}
						
						//check if the skill name is valid
						//TODO skill level requirement validation
						if((!Arrays.asList(normalSkill).contains(buildValue))
								&& (!buildValue.equals(ultSkill))
								&& (!buildValue.equals("attribute_bonus")))
						{
							printError(lineNumber, "\"" + buildValue + "\" is not a valid value for " + hero + " skill build", listModel);
						}
					}
					else if (key.equals("LaningInfo")) {
						//validate LaningInfo
						String laninginfoKey = keyvalueMatcher.group(1);
						String laninginfoValue = keyvalueMatcher.group(2);
						try{
							Integer.parseInt(laninginfoValue); //checks if the value is a valid number
						}
						catch (NumberFormatException e){
							printError(lineNumber, "the value of \""+ laninginfoKey + "\" is not a valid number", listModel);
						}
					}
				}
				
				if(line.contains("{")){
					braceCount++;
				}
				if(line.contains("}")){
					braceCount--;
					if(key != null){
						switch(key){ //check current key before the closing brace
							case "Bot":
								key = null; //no parent key
								break;
							case "Loadout":
							case "Build":
							case "LaningInfo": //return to parent key, which is "Bot"
								key = "Bot";
								break;
						}	
					}
				}
			}
			if(braceCount > 0){
				printError(0, "expected \"}\" character to complete the VDF format", listModel);
			}
			else if(braceCount < 0){
				printError(0, "expected \"{\" character to complete the VDF format", listModel);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Prints error message to log
	 * @param lineNumber current line number where the error occurs
	 * @param message the error message
	 * @param listModel the DefaultListModel of the log JList
	 */
	public void printError(int lineNumber, String message, DefaultListModel<String> listModel){
		listModel.addElement("Error at line " + lineNumber + ": " + message);
	}
}
