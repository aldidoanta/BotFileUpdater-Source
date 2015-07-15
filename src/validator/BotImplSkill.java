package validator;

/**
 * Enumeration for hero abilities
 * @author aldidoanta
 *
 */
public enum BotImplSkill{
	Axe("Axe", new String[]{"axe_berserkers_call", "axe_battle_hunger", "axe_counter_helix"}, "axe_culling_blade"),
	Bane("Bane", new String[]{"bane_enfeeble", "bane_brain_sap", "bane_nightmare"}, "bane_fiends_grip"),
	Bloodseeker("Bloodseeker", new String[]{"bloodseeker_bloodrage", "bloodseeker_blood_bath", "bloodseeker_thirst"}, "bloodseeker_rupture"),
	CrystalMaiden("Crystal Maiden", new String[]{"crystal_maiden_crystal_nova", "crystal_maiden_frostbite", "crystal_maiden_brilliance_aura"}, "crystal_maiden_freezing_field"),
	DrowRanger("Drow Ranger", new String[]{"drow_ranger_frost_arrows", "drow_ranger_wave_of_silence", "drow_ranger_trueshot"}, "drow_ranger_marksmanship"),
	EarthShaker("Earthshaker", new String[]{"earthshaker_fissure", "earthshaker_enchant_totem", "earthshaker_aftershock"}, "earthshaker_echo_slam"),
	Juggernaut("Juggernaut", new String[]{"juggernaut_blade_fury", "juggernaut_healing_ward", "juggernaut_blade_dance"}, "juggernaut_omni_slash"),
	Nevermore("Nevermore", new String[]{"nevermore_shadowraze1", "nevermore_necromastery", "nevermore_dark_lord"}, "nevermore_requiem"),
	Pudge("Pudge", new String[]{"pudge_meat_hook", "pudge_rot", "pudge_flesh_heap"}, "pudge_dismember"),
	Razor("Razor", new String[]{"razor_plasma_field", "razor_static_link", "razor_unstable_current"}, "razor_eye_of_the_storm"),
	SandKing("Sand King", new String[]{"sandking_burrowstrike", "sandking_sand_storm", "sandking_caustic_finale"}, "sandking_epicenter"),
	Sven("Sven", new String[]{"sven_storm_bolt", "sven_great_cleave", "sven_warcry"}, "sven_gods_strength"),
	Tiny("Tiny", new String[]{"tiny_avalanche", "tiny_toss", "tiny_craggy_exterior"}, "tiny_grow"),
	VengefulSpirit("Vengeful Spirit", new String[]{"vengefulspirit_magic_missile", "vengefulspirit_wave_of_terror", "vengefulspirit_command_aura"}, "vengefulspirit_nether_swap"),
	Windrunner("Windrunner", new String[]{"windrunner_shackleshot", "windrunner_powershot", "windrunner_windrun"}, "windrunner_focusfire"),
	Zeus("Zeus", new String[]{"zuus_arc_lightning", "zuus_lightning_bolt", "zuus_static_field"}, "zuus_thundergods_wrath"),
	Kunkka("Kunkka", new String[]{"kunkka_torrent", "kunkka_tidebringer", "kunkka_x_marks_the_spot"}, "kunkka_ghostship"),
	Lina("Lina", new String[]{"lina_dragon_slave", "lina_light_strike_array", "lina_fiery_soul"}, "lina_laguna_blade"),
	Lich("Lich", new String[]{"lich_frost_nova", "lich_frost_armor", "lich_dark_ritual"}, "lich_chain_frost"),
	Lion("Lion", new String[]{"lion_impale", "lion_voodoo", "lion_mana_drain"}, "lion_finger_of_death"),
	Tidehunter("Tidehunter", new String[]{"tidehunter_gush", "tidehunter_kraken_shell", "tidehunter_anchor_smash"}, "tidehunter_ravage"),
	WitchDoctor("Witch Doctor", new String[]{"witch_doctor_paralyzing_cask", "witch_doctor_voodoo_restoration", "witch_doctor_maledict"}, "witch_doctor_death_ward"),
	Riki("Riki", new String[]{"riki_smoke_screen", "riki_permanent_invisibility", "riki_backstab"}, "riki_blink_strike"),
	Sniper("Sniper", new String[]{"sniper_shrapnel", "sniper_headshot", "sniper_take_aim"}, "sniper_assassinate"),
	Necrolyte("Necrolyte", new String[]{"necrolyte_death_pulse", "necrolyte_heartstopper_aura", "necrolyte_sadist"}, "necrolyte_reapers_scythe"),
	Warlock("Warlock", new String[]{"warlock_fatal_bonds", "warlock_shadow_word", "warlock_upheaval"}, "warlock_rain_of_chaos"),
	SkeletonKing("Skeleton King", new String[]{"skeleton_king_hellfire_blast", "skeleton_king_vampiric_aura", "skeleton_king_mortal_strike"}, "skeleton_king_reincarnation"),
	DeathProphet("Death Prophet", new String[]{"death_prophet_carrion_swarm", "death_prophet_silence", "death_prophet_witchcraft"}, "death_prophet_exorcism"),
	PhantomAssassin("Phantom Assassin", new String[]{"phantom_assassin_stifling_dagger", "phantom_assassin_phantom_strike", "phantom_assassin_blur"}, "phantom_assassin_coup_de_grace"),
	Viper("Viper", new String[]{"viper_poison_attack", "viper_nethertoxin", "viper_corrosive_skin"}, "viper_viper_strike"),
	Luna("Luna", new String[]{"luna_lucent_beam", "luna_moon_glaive", "luna_lunar_blessing"}, "luna_eclipse"),
	DragonKnight("Dragon Knight", new String[]{"dragon_knight_breathe_fire", "dragon_knight_dragon_tail", "dragon_knight_dragon_blood"}, "dragon_knight_elder_dragon_form"),
	Dazzle("Dazzle", new String[]{"dazzle_poison_touch", "dazzle_shallow_grave", "dazzle_shadow_wave"}, "dazzle_weave"),
	Omni("Omniknight", new String[]{"omniknight_purification", "omniknight_repel", "omniknight_degen_aura"}, "omniknight_guardian_angel"),
	Bounty("Bounty Hunter", new String[]{"bounty_hunter_shuriken_toss", "bounty_hunter_jinada", "bounty_hunter_wind_walk"}, "bounty_hunter_track"),
	Jakiro("Jakiro", new String[]{"jakiro_dual_breath", "jakiro_ice_path", "jakiro_liquid_fire"}, "jakiro_macropyre"),
	ChaosKnight("Chaos Knight", new String[]{"chaos_knight_chaos_bolt", "chaos_knight_reality_rift", "chaos_knight_chaos_strike"}, "chaos_knight_phantasm"),
	Bristleback("Bristleback", new String[]{"bristleback_viscous_nasal_goo", "bristleback_quill_spray", "bristleback_bristleback"}, "bristleback_warpath"),
	Skywrath("Skywrath Mage", new String[]{"skywrath_mage_arcane_bolt", "skywrath_mage_concussive_shot", "skywrath_mage_ancient_seal"}, "skywrath_mage_mystic_flare"),
	Oracle("Oracle", new String[]{"oracle_fortunes_end", "oracle_fates_edict", "oracle_purifying_flames"}, "oracle_false_promise");
	
	private String heroName; //hero name according to "HERO: %name%" string in botfile
	private String[] normalSkill; //list of normal skills
	private String ultSkill; //the ultimate skill
	
	private BotImplSkill(String heroName, String[] normalSkill, String ultSkill){
		this.heroName = heroName;
		this.normalSkill = normalSkill;
		this.ultSkill = ultSkill;
	}
	
	public String getHeroName(){
		return this.heroName;
	}
	
	public String[] getNormalSkill(){
		return this.normalSkill;
	}
	
	public String getUltSkill(){
		return this.ultSkill;
	}
}
