package core;

public enum BotImpl {
	Axe("npc_dota_hero_axe", "HERO: Axe"),
	Bane("npc_dota_hero_bane", "HERO: Bane"),
	Bloodseeker("npc_dota_hero_bloodseeker", "HERO: Bloodseeker"),
	CrystalMaiden("npc_dota_hero_crystal_maiden", "HERO: Crystal Maiden" , true),
	DrowRanger("npc_dota_hero_drow_ranger", "HERO: Drow Ranger"),
	EarthShaker("npc_dota_hero_earthshaker", "HERO: Earthshaker"),
	Juggernaut("npc_dota_hero_juggernaut", "HERO: Juggernaut"),
	Nevermore("npc_dota_hero_nevermore", "HERO: Nevermore"),
	Pudge("npc_dota_hero_pudge", "HERO: Pudge"),
	Razor("npc_dota_hero_razor", "HERO: Razor"),
	SandKing("npc_dota_hero_sand_king", "HERO: Sand King"),
	Sven("npc_dota_hero_sven", "HERO: Sven"),
	Tiny("npc_dota_hero_tiny", "HERO: Tiny"),
	VengefulSpirit("npc_dota_hero_vengefulspirit", "HERO: Vengeful Spirit"),
	Windrunner("npc_dota_hero_windrunner", "HERO: Windrunner"),
	Zeus("npc_dota_hero_zuus", "HERO: Zeus"),
	Kunkka("npc_dota_hero_kunkka", "HERO: Kunkka"),
	Lina("npc_dota_hero_lina", "HERO: Lina"),
	Lich("npc_dota_hero_lich", "HERO: Lich"),
	Lion("npc_dota_hero_lion", "HERO: Lion"),
	Tidehunter("npc_dota_hero_tidehunter", "HERO: Tidehunter"),
	WitchDoctor("npc_dota_hero_witch_doctor", "HERO: Witch Doctor"),
	Riki("npc_dota_hero_riki", "HERO: Riki"),
	Sniper("npc_dota_hero_sniper", "HERO: Sniper"),
	Necrolyte("npc_dota_hero_necrolyte", "HERO: Necrolyte"),
	Warlock("npc_dota_hero_warlock", "HERO: Warlock" ,true),
	SkeletonKing("npc_dota_hero_skeleton_king", "HERO: Skeleton King"),
	DeathProphet("npc_dota_hero_death_prophet", "HERO: Death Prophet"),
	PhantomAssassin("npc_dota_hero_phantom_assassin" , "HERO: Phantom Assassin"),
	Viper("npc_dota_hero_viper", "HERO: Viper"),
	Luna("npc_dota_hero_luna", "HERO: Luna"),
	DragonKnight("npc_dota_hero_dragon_knight", "HERO: Dragon Knight"),
	Dazzle("npc_dota_hero_dazzle", "HERO: Dazzle"),
	Omni("npc_dota_hero_omniknight", "HERO: Omniknight"),
	Bounty("npc_dota_hero_bounty_hunter", "HERO: Bounty Hunter"),
	Jakiro("npc_dota_hero_jakiro", "HERO: Jakiro"),
	ChaosKnight("npc_dota_hero_chaos_knight", "HERO: Chaos Knight"),
	Bristleback("npc_dota_hero_bristleback", "HERO: Bristleback"),
	Skywrath("npc_dota_hero_skywrath_mage", "HERO: Skywrath Mage"),
	Oracle("npc_dota_hero_oracle", "HERO: Oracle");
	
	private String heroString, flavorName;
	private boolean factor;
	private BotImpl(String heroString, String flavorName){
		this.heroString = heroString;
		this.flavorName = flavorName;
		this.factor = false;
	}
	
	private BotImpl(String heroString,  String flavorName, boolean factor){
		this.heroString = heroString;
		this.flavorName = flavorName;
		this.factor = factor;
	}
	
	public String getHeroString(){
		return this.heroString;
	}
	
	public String getFlavorName(){
		return this.flavorName;
	}
	
	public boolean hasAggressionFactor(){
		return this.factor;
	}
}
