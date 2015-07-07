package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

public class FileUpdater {
	
	private String newFilePath;
	
	public FileUpdater(String newFilePath){
		this.newFilePath = newFilePath;
	}
	
	private String getData(List<HeroBuild> builds) throws Exception{
		StringBuffer file = new StringBuffer();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(newFilePath)));
		String in = "";
		for (HeroBuild build : builds){
			while(!(in = reader.readLine()).contains(build.heroString)){
				file.append(in).append(System.getProperty("line.separator"));
			}
			file.append(in).append(System.getProperty("line.separator"));
			while(!(in = reader.readLine()).contains("\"Bot\"")){
				file.append(in).append(System.getProperty("line.separator"));
			}
			file.append(build);
			int i = 0;
			while (i < 4){
				if (in.contains("}")){
					i++;
				}
				in = reader.readLine();
			}
			file.append(in).append(System.getProperty("line.separator"));
		}
		while (!((in = reader.readLine()) == null)){
			file.append(in).append(System.getProperty("line.separator"));
		}
			file.deleteCharAt(file.length() - 1);
			reader.close();
		return file.toString();
		
	}
	
	public void update(List<HeroBuild> builds) throws Exception{
		String file = this.getData(builds);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("updated\\npc_heroes.txt"),"UTF-8"));
		writer.write(file);
		writer.flush();
		writer.close();
	}
	
	private String getDataFromSavedBuild() throws Exception{
		StringBuffer file = new StringBuffer();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(newFilePath)));
		String in = "";
		for (BotImpl bot : BotImpl.values()){
			while(!(in = reader.readLine()).contains(bot.getFlavorName())){
				file.append(in).append(System.getProperty("line.separator"));
			}
			file.append(in).append(System.getProperty("line.separator"));
			while(!(in = reader.readLine()).contains("\"Bot\"")){
				file.append(in).append(System.getProperty("line.separator"));
			}
			BufferedReader savedBotFile = new BufferedReader(new InputStreamReader(new FileInputStream("builds\\" + bot.getFlavorName().substring(6) + ".txt")));
			StringBuffer savedBot = new StringBuffer();
			String botIn = "";
			while (!((botIn = savedBotFile.readLine()) == null)){
				savedBot.append(botIn).append(System.getProperty("line.separator"));
			}
			savedBotFile.close();
			file.append(savedBot.toString());
			int i = 0;
			while (i < 4){
				if (in.contains("}")){
					i++;
				}
				in = reader.readLine();
			}
			file.append(in).append(System.getProperty("line.separator"));
		}
		while (!((in = reader.readLine()) == null)){
			file.append(in).append(System.getProperty("line.separator"));
		}
			file.deleteCharAt(file.length() - 1);
			reader.close();
		return file.toString();
	}
	
	public void updateFromSavedBuild() throws Exception{
		String file = this.getDataFromSavedBuild();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("updated\\npc_heroes.txt"),"UTF-8"));
		writer.write(file);
		writer.flush();
		writer.close();
	}
}
