package core;

public class HeroBuild {

	public String heroString, loadout, skillbuild, role, laning;

	public HeroBuild(String heroString, String loadout, String skillbuild,
			String role, String laning) {
		this.heroString = heroString;
		this.loadout = loadout;
		this.skillbuild = skillbuild;
		this.role = role;
		this.laning = laning;
	}
	
	private String writeBot(HeroBuild build){
		StringBuffer bot = new StringBuffer("\t\t\"Bot\"").append(System.getProperty("line.separator"));
		bot.append("\t\t{").append(System.getProperty("line.separator"));
		bot.append("\t\t\t\"Loadout\"").append(System.getProperty("line.separator"));
		bot.append("\t\t\t{").append(System.getProperty("line.separator"));
		bot.append(build.loadout);
		bot.append("\t\t\t}").append(System.getProperty("line.separator"));
		bot.append("\t\t\t\"Build\"").append(System.getProperty("line.separator"));
		bot.append("\t\t\t{").append(System.getProperty("line.separator"));
		bot.append(build.skillbuild);
		bot.append("\t\t\t}").append(System.getProperty("line.separator"));
		bot.append(build.role).append(System.getProperty("line.separator"));
		bot.append("\t\t\t\"LaningInfo\"").append(System.getProperty("line.separator"));
		bot.append("\t\t\t{").append(System.getProperty("line.separator"));
		bot.append(build.laning);
		bot.append("\t\t\t}").append(System.getProperty("line.separator"));
		bot.append("\t\t}").append(System.getProperty("line.separator"));
		return bot.toString();
	}
	
	@Override
	public String toString() {
		return this.writeBot(this);
	}

}
