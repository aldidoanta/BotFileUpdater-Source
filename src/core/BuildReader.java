package core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BuildReader {
	
	private String filePath;
	
	public BuildReader(String path){
		this.filePath = path;
	}
	
	public List<HeroBuild> readBuilds() throws Exception{
		List<HeroBuild> builds = new ArrayList<HeroBuild>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
		String in = "";
		for (BotImpl b : BotImpl.values()){
			String heroString = b.getFlavorName();
			StringBuffer loadout = new StringBuffer();
			StringBuffer skillbuild = new StringBuffer();
			StringBuffer role = new StringBuffer();
			StringBuffer laning = new StringBuffer();
			while(!(in = reader.readLine()).contains(heroString)){
				continue;
			}
			while(!(in = reader.readLine()).contains("\"Bot\"")){
				continue;
			}
			for (int i = 0; i < 4; i++){
				while(this.getKeyword(in) < 1){
					in = reader.readLine();
				}
				switch (this.getKeyword(in)){
					case 1: 
						reader.readLine();
						while(!(in = reader.readLine()).contains("}")){
							loadout.append(in).append(System.getProperty("line.separator"));
						}
						loadout.deleteCharAt(loadout.length() - 1);
						break;
					case 2:
						reader.readLine();
						while(!(in = reader.readLine()).contains("}")){
							skillbuild.append(in).append(System.getProperty("line.separator"));
						}
						skillbuild.deleteCharAt(skillbuild.length() - 1);
						break;
					case 3:
						reader.readLine();
						while(!(in = reader.readLine()).contains("}")){
							laning.append(in).append(System.getProperty("line.separator"));
						}
						laning.deleteCharAt(laning.length() - 1);
						break;
					case 4:
						if (b.hasAggressionFactor()){
							role.append(in).append(System.getProperty("line.separator"));
							in = reader.readLine();
							role.append(in);
						} else {
							role.append(in);
						}
						in = reader.readLine();
						break;
					default:
						System.out.println("Should not happen");
						in = reader.readLine();
				}
			}		
			HeroBuild temp = new HeroBuild(heroString, loadout.toString(), skillbuild.toString(), role.toString(), laning.toString());
			builds.add(temp);
		}
		reader.close();
		return builds;
	}
	
	private int getKeyword(String in){
		if (in.contains("Loadout")){
			return 1;
		}
		if (in.contains("Build")){
			return 2;
		}
		if (in.contains("Laning")){
			return 3;
		}
		if (in.contains("HeroType")){
			return 4;
		}
		return 0;
	}
}
