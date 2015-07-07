package core;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class BuildSaver {
	
	private BuildReader br;
	
	public BuildSaver(String filePath){
		this.br = new BuildReader(filePath);
	}
	
	public void saveBuilds() throws Exception{
		List<HeroBuild> buildList = br.readBuilds();
		for (HeroBuild b : buildList){
			String fileName = "builds\\" + b.heroString.substring(6) + ".txt";
			BufferedWriter writer =  new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8"));
			writer.write(b.toString());
			writer.flush();
			writer.close();
		}

	}
}
