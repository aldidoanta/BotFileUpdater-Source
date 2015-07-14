package validator;
/**
 * Stores constants needed for Validator class
 *
 *
 */
public final class ValidatorConst {
	
	public static final int MAX_LEVEL = 25; //maximum level for a hero
	public static final String[] HERO_AGGRESIONFACTOR = new String[]{"Crystal Maiden", "Warlock"};
	
	public static final String[] ITEM = new String[]{
		/*BASICS*/
		
		//Consumables
		"item_clarity",
		"item_enchanted_mango",
		"item_tango",
		"item_flask",
		"item_smoke_of_deceit",
		"item_tpscroll",
		"item_dust",
		"item_courier",
		"item_flying_courier",
		"item_ward_observer",
		"item_ward_sentry",
		"item_bottle",
		
		//Attributes
		"item_branches",
		"item_gauntlets",
		"item_slippers",
		"item_mantle",
		"item_circlet",
		"item_belt_of_strength",
		"item_boots_of_elves",
		"item_robe",
		"item_ogre_axe",
		"item_blade_of_alacrity",
		"item_staff_of_wizardry",
		
		//Armaments
		"item_ring_of_protection",
		"item_stout_shield",
		"item_quelling_blade",
		"item_orb_of_venom",
		"item_blades_of_attack",
		"item_chainmail",
		"item_quarterstaff",
		"item_helm_of_iron_will",
		"item_broadsword",
		"item_claymore",
		"item_javelin",
		"item_mithril_hammer",
		
		//Arcane
		"item_magic_stick",
		"item_sobi_mask",
		"item_ring_of_regen",
		"item_boots",
		"item_gloves",
		"item_cloak",
		"item_ring_of_health",
		"item_void_stone",
		"item_gem",
		"item_lifesteal",
		"item_shadow_amulet",
		"item_ghost",
		"item_blink",
		
		/*UPGRADES*/
		
		//Common
		"item_magic_wand",
		"item_null_talisman",
		"item_wraith_band",
		"item_poor_mans_shield",
		"item_bracer",
		"item_soul_ring",
		"item_phase_boots",
		"item_power_treads",
		"item_oblivion_staff",
		"item_pers",
		"item_hand_of_midas",
		"item_travel_boots",
		"item_moon_shard",
		
		//Support
		"item_ring_of_basilius",
		"item_headdress",
		"item_buckler",
		"item_urn_of_shadows",
		"item_tranquil_boots",
		"item_ring_of_aquila",
		"item_medallion_of_courage",
		"item_arcane_boots",
		"item_ancient_janggo",
		"item_mekansm",
		"item_vladmir",
		"item_pipe",
		"item_guardian_greaves",
		
		//Caster
		"item_glimmer_cape",
		"item_force_staff",
		"item_veil_of_discord",
		"item_necronomicon",
		"item_dagon",
		"item_cyclone",
		"item_solar_crest",
		"item_rod_of_atos",
		"item_orchid",
		"item_ultimate_scepter",
		"item_refresher",
		"item_sheepstick",
		"item_octarine_core",
		
		//Weapons
		"item_lesser_crit",
		"item_armlet",
		"item_invis_sword",
		"item_basher",
		"item_bfury",
		"item_ethereal_blade",
		"item_silver_edge",
		"item_radiance",
		"item_monkey_king_bar",
		"item_greater_crit",
		"item_butterfly",
		"item_rapier",
		"item_abyssal_blade",
		
		//Armor
		"item_hood_of_defiance",
		"item_vanguard",
		"item_blade_mail",
		"item_soul_booster",
		"item_crimson_guard",
		"item_black_king_bar",
		"item_lotus_orb",
		"item_shivas_guard",
		"item_bloodstone",
		"item_manta",
		"item_sphere",
		"item_assault",
		"item_heart",
		
		//Artifacts
		"item_mask_of_madness",
		"item_helm_of_the_dominator",
		"item_sange",
		"item_yasha",
		"item_maelstrom",
		"item_diffusal_blade",
		"item_desolator",
		"item_heavens_halberd",
		"item_sange_and_yasha",
		"item_skadi",
		"item_mjollnir",
		"item_satanic",
		
		/*SECRET SHOP*/
		"item_energy_booster",
		"item_vitality_booster",
		"item_point_booster",
		"item_platemail",
		"item_talisman_of_evasion",
		"item_hyperstone",
		"item_ultimate_orb",
		"item_demon_edge",
		"item_mystic_staff",
		"item_reaver",
		"item_eagle",
		"item_relic",
		
		/*RECIPES*/
		"item_recipe_wraith_band",
		"item_recipe_bracer",
		"item_recipe_null_talisman",
		"item_recipe_soul_ring",
		"item_recipe_hand_of_midas",
		"item_recipe_travel_boots",
		"item_recipe_travel_boots_2",
		"item_recipe_moon_shard",
		"item_recipe_headdress",
		"item_recipe_buckler",
		"item_recipe_urn_of_shadows",
		"item_recipe_medallion_of_courage",
		"item_recipe_pipe",
		"item_recipe_mekansm",
		"item_recipe_vladmir",
		"item_recipe_ancient_janggo",
		"item_recipe_guardian_greaves",
		"item_recipe_necronomicon",
		"item_recipe_necronomicon_2",
		"item_recipe_necronomicon_3",
		"item_recipe_cyclone",
		"item_recipe_dagon",
		"item_recipe_dagon_2",
		"item_recipe_dagon_3",
		"item_recipe_dagon_4",
		"item_recipe_dagon_5",
		"item_recipe_veil_of_discord",
		"item_recipe_orchid",
		"item_recipe_refresher",
		"item_recipe_force_staff",
		"item_recipe_bloodstone",
		"item_recipe_lesser_crit",
		"item_recipe_armlet",
		"item_recipe_basher",
		"item_recipe_radiance",
		"item_recipe_greater_crit",
		"item_recipe_silver_edge",
		"item_recipe_black_king_bar",
		"item_recipe_manta",
		"item_recipe_shivas_guard",
		"item_recipe_sphere",
		"item_recipe_assault",
		"item_recipe_heart",
		"item_recipe_crimson_guard",
		"item_recipe_lotus_orb",
		"item_recipe_desolator",
		"item_recipe_mjollnir",
		"item_recipe_satanic",
		"item_recipe_diffusal_blade",
		"item_recipe_diffusal_blade_2",
		"item_recipe_yasha",
		"item_recipe_maelstrom",
		"item_recipe_mask_of_madness",
		"item_recipe_sange",
	};			
	
	public static final String[] ITEM_PRIORITY = new String[]{ 
	        "ITEM_CONSUMABLE",
		    "ITEM_CORE",
		    "ITEM_EXTENSION",
		    "ITEM_LUXURY",
		    "ITEM_DERIVED"
	};
	
	public static final String[] ROLE = new String[]{
	        "DOTA_BOT_HARD_CARRY",
        	"DOTA_BOT_SEMI_CARRY",
        	"DOTA_BOT_NUKER",
        	"DOTA_BOT_GANKER",
        	"DOTA_BOT_TANK",
        	"DOTA_BOT_PUSH_SUPPORT",
        	"DOTA_BOT_STUN_SUPPORT",
     		"DOTA_BOT_PURE_SUPPORT"
    };
	
	public static final String[] LANINGINFO = new String[]{
            "SoloDesire",
			"RequiresBabysit",
			"ProvidesBabysit",
			"SurvivalRating",
			"RequiresFarm",
			"ProvidesSetup",
			"RequiresSetup"
	};
}
