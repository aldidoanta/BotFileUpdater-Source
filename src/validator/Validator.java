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
 *
 *
 */
public class Validator {
	
	/**
	 * Gets value of an attribute (surrounded by "{ }") that exists in a string
  	 * isObj determines whether the value is an object or not
	 * @param attr name of the attribute 
	 * @param str the string where the attribute and its value exist
	 * @param isObject search options, true if the attribute-value pair is an object
	 * @return value of attribute attr; null if attr is not found within the string str
	 */
	public String getVDFObject(String attr, String str, boolean isObject){
		String result = null;
		int beginIdx, endIdx, currentIdx;
		int braceCounter, quoteCounter;
		boolean isFound;
		
		//regex used to find the attr
		String searchAttr = "\"" + attr + "\""; //add double quotes
	    String regex_obj = "\"" + attr + "\"\\s*\\{";
	    String regex_nonobj = "\"" + attr + "\"\\s*";
	    
	    //create Pattern object and compile
	    Pattern regexp_obj = Pattern.compile(regex_obj);
	    Pattern regexp_nonobj = Pattern.compile(regex_nonobj);
	    
	    //create Matcher object
	    Matcher m = (isObject ? regexp_obj.matcher(str) : regexp_nonobj.matcher(str)); //use regex based on isObj value
	    if(m.find()){
	    	beginIdx = m.start() + searchAttr.length();
	        endIdx = -1;

	        braceCounter = 0;
	        isFound = false;
	        currentIdx = beginIdx;

	        if(isObject){ //if the value is an object
	          //assume the file is a valid VDF
	          do{
	            if(str.charAt(currentIdx) == '{'){
	              if(braceCounter == 0){ //check the first open brace
	                beginIdx = currentIdx;
	              }
	              braceCounter++;
	              if(braceCounter == 0){
	                isFound = true;
	              }
	            }
	            else if(str.charAt(currentIdx) == '}'){
	              braceCounter--;
	              if(braceCounter == 0){
	                isFound = true;
	              }
	            }
	            currentIdx++;
	          }
	          while(!isFound);

	          endIdx = currentIdx - 1; //assign the index of the closing brace
	        }
	        else{ //not an Object
	          quoteCounter = 0;
	          while(quoteCounter < 2){
	            if(str.charAt(currentIdx) == '\"'){
	              quoteCounter++;
	              if(quoteCounter == 1){
	                beginIdx = currentIdx + 1; //get first character inside quote
	              }
	              else if(quoteCounter == 2){
	                endIdx = currentIdx - 1; //get last character inside quote
	              }
	            }
	            currentIdx++;
	          }
	        }
	        
	        result = str.substring(beginIdx,endIdx+1); 
	    }
	    
		return result;
	}
	
	/**
	 * Validates stored build, checking for errors
	 * @param the string of the bot build
	 * @param hero the name of the hero
	 */
	public static void validateBuild(String content, String hero, DefaultListModel<String> listModel){
		try {
			int lineNumber = 0; //current line number
			int braceCount = 0; //used for reading braces
			String key = null; //current examined key
			String line = null; //used for reading the multi-line string
			
			//used for regex
			Pattern keyPattern = Pattern.compile("^\\s*\"(\\w+)\"\\s*$");
			Pattern keyvaluePattern = Pattern.compile("^\\s*\"(\\w+)\"\\s+\"(.+)\"\\s*$");
			Matcher keyMatcher = null;
			Matcher keyValueMatcher = null;
			
			BufferedReader br = new BufferedReader(new StringReader(content));
			while((line = br.readLine()) != null){
				lineNumber++;
				
				//search for "key"
				keyMatcher = keyPattern.matcher(line);
				keyValueMatcher = keyvaluePattern.matcher(line);
				
				if(keyMatcher.find()){
					
					if(key == null){
						if(!keyMatcher.group(1).equals("Bot")){
							printError(lineNumber, "\"Bot\" must be the first key", listModel);
						}
						else{
							key = "Bot"; //found "Bot" key
						}
					}
					else if (key.equals("Bot")){
						switch(keyMatcher.group(1)){ //search for child of "Bot"
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
								printError(lineNumber, "\""+keyMatcher.group(1)+"\""+" needs a value next to it, enclosed with quotes", listModel);
								break;
							default:
								printError(lineNumber, "\""+keyMatcher.group(1)+"\""+" is not a valid child of \"Bot\"", listModel);
						}
					}
				}
				else if(keyValueMatcher.find()){
					
					if (key.equals("Bot")){
						switch(keyValueMatcher.group(1)){ //search for child of "Bot"
							case "HeroType":
								
								String herotypeValue = keyValueMatcher.group(2);
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
								
								String aggressionfactorValue = keyValueMatcher.group(2); 
								//validate AggressionFactor
								if(Arrays.asList(ValidatorConst.HERO_AGGRESIONFACTOR).contains(hero)){ //checks if current hero has "AggressionFactor" attribute
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
								printError(lineNumber, "\""+keyValueMatcher.group(1)+"\""+" is not a valid child of \"Bot\"", listModel);
						}
					}
					else if (key.equals("Loadout")) {
						
						String loadoutKey = keyValueMatcher.group(1);
						String loadoutValue = keyValueMatcher.group(2);
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
						String buildValue = keyValueMatcher.group(2);
						
						//search for hero skill in BotImplSkill enum
						for(BotImplSkill b: BotImplSkill.values()){
							if(hero.equals(b.getHeroName())){
								normalSkill = b.getNormalSkill();
								ultSkill = b.getUltSkill();
								break;
							}
						}
						
						//check if the attribute value is valid
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
						String laninginfoKey = keyValueMatcher.group(1);
						String laninginfoValue = keyValueMatcher.group(2);
						try{
							Integer.parseInt(laninginfoValue); //checks if the attribute value is a valid number
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
	 * prints error message to log
	 * @param lineNumber current line number where the error occurs
	 * @param listModel TODO
	 * @param messsage the error message
	 */
	public static void printError(int lineNumber, String message, DefaultListModel<String> listModel){
		listModel.addElement("Error at line " + lineNumber + ": " + message);
	}
	
}
