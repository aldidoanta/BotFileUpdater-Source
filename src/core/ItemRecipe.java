package core;

public enum ItemRecipe {
	MoonShard("Moon Shard", "item_moon_shard", new String[]{"item_hyperstone", "item_hyperstone", "item_recipe_moon_shard"}),
	MagicWand("Magic Wand", "item_magic_wand", new String[]{"item_magic_stick", "item_circlet", "item_branches", "item_branches"}),
	BoT("Boots of Travel", "item_travel_boots", new String[]{"item_boots", "item_recipe_travel_boots"}),
	PhaseBoots("Phase Boots", "item_phase_boots", new String[]{"item_boots", "item_blades_of_attack", "item_blades_of_attack"}),
	PowerTreadsAgi("Power Treads Agility", "item_power_treads", new String[]{"item_boots","item_gloves","item_boots_of_elves"}),
	PowerTreadsInt("Power Treads Intelligence", "item_power_treads", new String[]{"item_boots","item_gloves","item_robe"}),
	PowerTreadsStr("Power Treads Strength", "item_power_treads", new String[]{"item_boots","item_gloves","item_belt_of_strength"}),
	Midas("Hand of Midas", "item_hand_of_midas", new String[]{"item_gloves", "item_recipe_hand_of_midas"}),
	PoorMansShield("Poor Man's Shield", "item_poor_mans_shield", new String[]{"item_stout_shield", "item_slippers", "item_slippers"}),
	Bracer("Bracer", "item_bracer", new String[]{"item_circlet", "item_gauntlets", "item_recipe_bracer"}),
	WraithBand("Wraith Band", "item_wraith_band", new String[]{"item_circlet", "item_slippers", "item_recipe_wraith_band"}),
	NullTalisman("Null Talisman", "item_null_talisman", new String[]{"item_circlet", "item_mantle", "item_recipe_null_talisman"}),
	Buckler("Buckler", "item_buckler", new String[]{"item_chainmail", "item_branches", "item_recipe_buckler"}),
	Basilius("Ring of Basilius", "item_ring_of_basilius", new String[]{"item_ring_of_protection", "item_sobi_mask"}),
	Urn("Urn of Shadows", "item_urn_of_shadows", new String[]{"item_gauntlets", "item_gauntlets", "item_sobi_mask", "item_recipe_urn_of_shadows"}),
	Headdress("Headdress", "item_headdress", new String[]{"item_ring_of_regen", "item_branches", "item_recipe_headdress"}),
	Sheepstick("Sheepstick", "item_sheepstick", new String[]{"item_mystic_staff", "item_ultimate_orb", "item_void_stone"}),
	OblivionStaff("Oblivion Staff", "item_oblivion_staff", new String[]{"item_quarterstaff", "item_robe", "item_sobi_mask"}),
	Perseverance("Perseverance", "item_pers", new String[]{"item_ring_of_health", "item_void_stone"}),
	Euls("Eul's Scepter of Divinity", "item_cyclone", new String[]{"item_staff_of_wizardry", "item_void_stone", "item_sobi_mask", "item_recipe_cyclone"}),
	ForceStaff("Force Staff", "item_force_staff", new String[]{"item_staff_of_wizardry" ,"item_ring_of_regen", "item_recipe_force_staff"}),
	Aghs("Aghanim's Scepter", "item_ultimate_scepter", new String[]{"item_point_booster", "item_ogre_axe", "item_staff_of_wizardry", "item_blade_of_alacrity"}),
	Assault("Assault Cuirass", "item_assault_cuirass", new String[]{"item_hyperstone", "item_platemail", "item_chainmail", "item_recipe_assault_cuirass"}),
	Heart("Heart", "item_heart", new String[]{"item_reaver", "item_vitality_booster", "item_recipe_heart"}),
	BKB("Black King Bar", "item_black_king_bar", new String[]{"item_ogre_axe", "item_mithril_hammer", "item_recipe_black_king_bar"}),
	Shiva("Shiva's Guard", "item_shivas_guard", new String[]{"item_platemail", "item_mystic_staff", "item_recipe_shivas_guard"}),
	SoulRing("Soul Ring", "item_soul_ring", new String[]{"item_ring_of_regen", "item_sobi_mask", "item_recipe_soul_ring"}),
	SoulBooster("Soul Booster", "item_soul_booster", new String[]{"item_point_booster", "item_vitality_booster", "item_energy_booster"}),
	Vanguard("Vanguard", "item_vanguard", new String[]{"item_stout_shield", "item_ring_of_health", "item_vitality_booster",}),
	BladeMail("Blade Mail", "item_blade_mail", new String[]{"item_broadsword", "item_chainmail", "item_robe"}),
	Hood("Hood of Defiance", "item_hood_of_defiance", new String[]{"item_ring_of_health", "item_cloak", "item_ring_of_regen", "item_ring_of_regen"}),
	Rapier("Divine Rapier", "item_rapier", new String[]{"item_relic", "item_demon_edge"}),
	MKB("Monkey King Bar", "item_monkey_king_bar", new String[]{"item_demon_edge", "item_javelin", "item_javelin"}),
	Radiance("Radiance", "item_radiance", new String[]{"item_relic", "item_recipe_radiance"}),
	Butterfly("Butterfly", "item_butterfly", new String[]{"item_eagle", "item_talisman_of_evasion", "item_quarterstaff"}),
	Basher("Basher", "item_basher", new String[]{"item_belt_of_strength", "item_javelin", "item_recipe_basher"}),
	Yasha("Yasha", "item_yasha", new String[]{"item_blade_of_alacrity", "item_boots_of_elves", "item_recipe_yasha"}),
	Sange("Sange", "item_sange", new String[]{"item_ogre_axe", "item_belt_of_strength", "item_recipe_sange"}),
	LesserCrit("Lesser Crit", "item_lesser_crit", new String[]{"item_broadsword", "item_blades_of_attack", "item_recipe_lesser_crit"}),
	Armlet("Armlet", "item_armlet", new String[]{"item_helm_of_iron_will", "item_gloves", "item_blades_of_attack", "item_recipe_armlet"}),
	ShadowBlade("Shadow Blade", "item_invis_sword", new String[]{"item_shadow_amulet", "item_claymore"}),
	Dominator("Helm of the Dominator", "item_helm_of_the_dominator", new String[]{"item_helm_of_iron_will", "item_lifesteal"}),
	Maelstrom("Maelstrom", "item_maelstrom", new String[]{"item_mithril_hammer", "item_gloves", "item_recipe_maelstrom"}),
	Skadi("Eye of Skadi", "item_skadi", new String[]{"item_ultimate_orb", "item_ultimate_orb", "item_point_booster", "item_orb_of_venom"}),
	Desolator("Desolator", "item_desolator", new String[]{"item_mithril_hammer", "item_mithril_hammer", "item_recipe_desolator"}),
	MoM("Mask of Madness", "item_mask_of_madness", new String[]{"item_lifesteal", "item_recipe_mask_of_madness"}),
	Diffusal("Diffusal Blade 1", "item_diffusal_blade", new String[]{"item_blade_of_alacrity", "item_blade_of_alacrity", "item_robe", "item_recipe_diffusal_blade"}),
	Ethereal("Ethereal Blade", "item_ethereal_blade", new String[]{"item_eagle", "item_ghost"}),
	Arcanes("Arcane Boots", "item_arcane_boots", new String[]{"item_boots", "item_energy_booster"}),
	Medallion("Medallion of Courage", "item_medallion_of_courage", new String[]{"item_chainmail", "item_sobi_mask", "item_recipe_medallion_of_courage"}),
	Atos("Rod of Atos", "item_rod_of_atos", new String[]{"item_vitality_booster", "item_staff_of_wizardry", "item_staff_of_wizardry"}),
	Tranquils("Tranquil Boots", "item_tranquil_boots", new String[]{"item_boots", "item_ring_of_protection", "item_ring_of_regen"}),
	GlimmerCape("Glimmer Cape", "item_glimmer_cape", new String[]{"item_shadow_amulet", "item_cloak"}),
	
	Aquila("Ring of Aquila", "item_ring_of_aquila", new ItemRecipe[]{ItemRecipe.WraithBand, ItemRecipe.Basilius}),
	Halberd("Heaven's Halberd", "item_talisman_of_evasion;item_heavens_halberd", new ItemRecipe[]{ItemRecipe.Sange}),
	Abyssal("Abyssal Blade", "item_relic;item_recipe_abyssal_blade", new ItemRecipe[]{ItemRecipe.Basher}),
	Veil("Veil of Discord", "item_helm_of_iron_will;item_recipe_veil_of_discord", new ItemRecipe[]{ItemRecipe.NullTalisman}),
	SolarCrest("Solar Crest", "item_talisman_of_evasion;item_recipe_solar_crest", new ItemRecipe[]{ItemRecipe.Medallion}),
	Drums("Drums of Endurance", "item_robe;item_recipe_ancient_janggo", new ItemRecipe[]{ItemRecipe.Bracer}),
	OctarineCore("Ocatarine Core", "item_mystic_staff;item_octarine_core", new ItemRecipe[]{ItemRecipe.SoulBooster}),
	Diffusal2("Diffusal Blade 2", "item_recipe_diffusal_blade_2", new ItemRecipe[]{ItemRecipe.Diffusal}),
	Mjollnir("Mjöllnir", "item_hyperstone;item_recipe_mjollnir", new ItemRecipe[]{ItemRecipe.Maelstrom}),
	Satanic("Satanic", "item_reaver;item_recipe_satanic", new ItemRecipe[]{ItemRecipe.Dominator}),
	SnY("Sange and Yasha", "item_sange_and_yasha", new ItemRecipe[]{ItemRecipe.Sange, ItemRecipe.Yasha}),
	SilverEdge("Silver Edge", "item_recipe_silver_edge", new ItemRecipe[]{ItemRecipe.ShadowBlade, ItemRecipe.Sange}),
	Manta("Manta Style", "item_ultimate_orb;item_recipe_manta", new ItemRecipe[]{ItemRecipe.Yasha}),
	BattleFury("Battle Fury", "item_broadsword;item_claymore;item_quelling_blade;item_battle_fury", new ItemRecipe[]{ItemRecipe.Perseverance}),
	GreaterCrit("Greater Crit", "item_demon_edge;item_recipe_greater_crit", new ItemRecipe[]{ItemRecipe.LesserCrit}),
	Crimson("Crimson Guard", "item_recipe_crimson_guard", new ItemRecipe[]{ItemRecipe.Vanguard, ItemRecipe.Buckler}),
	LotusOrb("Lotus Orb", "item_platemail;item_recipe_lotus_orb", new ItemRecipe[]{ItemRecipe.Perseverance}),
	Linkens("Linken's Sphere", "item_ultimate_orb;item_recipe_sphere", new ItemRecipe[]{ItemRecipe.Perseverance}),
	BloodStone("Blood Stone", "item_recipe_bloodstone", new ItemRecipe[]{ItemRecipe.SoulBooster, ItemRecipe.SoulRing}),
	Refresher("Refresher Orb", "item_recipe_refresher", new ItemRecipe[]{ItemRecipe.Perseverance, ItemRecipe.Perseverance}),
	Necronomicon("Necronomicon 1", "item_necronomicon", new String[]{"item_staff_of_wizardry", "item_belt_of_strength", "item_recipe_necronomicon"}),
	Necronomicon2("Necronomicon 2", "item_recipe_necronomicon_2", new ItemRecipe[]{ItemRecipe.Necronomicon}),
	Necronomicon3("Necronomicon 3", "item_recipe_necronomicon_3", new ItemRecipe[]{ItemRecipe.Necronomicon2}),
	Dagon("Dagon 1", "item_staff_of_wizardry;item_recipe_dagon", new ItemRecipe[]{ItemRecipe.NullTalisman}),
	Dagon2("Dagon 2", "item_recipe_dagon_2", new ItemRecipe[]{ItemRecipe.Dagon}),
	Dagon3("Dagon 3", "item_recipe_dagon_3", new ItemRecipe[]{ItemRecipe.Dagon2}),
	Dagon4("Dagon 4", "item_recipe_dagon_4", new ItemRecipe[]{ItemRecipe.Dagon3}),
	Dagon5("Dagon 5", "item_recipe_dagon_5", new ItemRecipe[]{ItemRecipe.Dagon4}),
	Orchid("Orchid Malevolence", "item_recipe_orchid", new ItemRecipe[]{ItemRecipe.OblivionStaff, ItemRecipe.OblivionStaff}),
	BoT2("Boots of Travel 2", "item_recipe_travel_boots_2", new ItemRecipe[]{ItemRecipe.BoT}),
	Pipe("Pipe of Insight", "item_recipe_pipe", new ItemRecipe[]{ItemRecipe.Hood, ItemRecipe.Headdress}),
	Mekansm("Mekansm", "item_recipe_mekansm", new ItemRecipe[]{ItemRecipe.Headdress, ItemRecipe.Buckler}),
	Vlads("Vladmir's Offering", "item_lifesteal;item_recipe_vladmir", new ItemRecipe[]{ItemRecipe.Basilius, ItemRecipe.Headdress}),
	Greaves("Guardian Greaves", "item_recipe_guardian_greaves", new ItemRecipe[]{ItemRecipe.Mekansm, ItemRecipe.Arcanes});
	
	private String name, finishedItem;
	private String[] components;
	

	private ItemRecipe[] itemComponents;
	private ItemRecipe(String name, String finishedItem, String[] components){
		this.finishedItem = finishedItem;
		this.name = name;
		this.components = components;
		this.itemComponents = null;
	}
	
	private ItemRecipe(String name, String recipe, ItemRecipe[] itemComponents){
		this.finishedItem = recipe;
		this.name = name;
		this.components = null;
		this.itemComponents = itemComponents;
	}
	
	public String getName() {
		return this.name;
	}

	public String getFinishedItem() {
		return this.finishedItem;
	}

	public String[] getComponents() {
		return this.components;
	}

	public ItemRecipe[] getItemComponents() {
		return this.itemComponents;
	}
}
