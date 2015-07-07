package core;

public enum BaseItem {
	BlinkDagger("Blink Dagger", "item_blink"),
	QuellingBlade("Quelling Blade", "item_quelling_blade"),
	StoutShield("Stout Shield", "item_stout_shield"),
	Branch("Ironwood Branch", "item_branches"),
	Circlet("Circlet", "item_circlet"),
	Boots("Boots", "item_boots"),
	MagicStick("Magic Stick", "item_magic_stick"),
	GhostScepter("Ghost Scepter", "item_ghost"),
	Clarity("Clarity","item_clarity"),
	Mango("Mango", "item_enchanted_mango"),
	Pot("Pot", "item_flask"),
	Bottle("Bottle", "item_bottle"),
	Tango("Tango", "item_tango");
	
	
	
	private String name, code;
	
	private BaseItem(String name, String code){
		this.code = code;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String getCode() {
		return this.code;
	}
}
