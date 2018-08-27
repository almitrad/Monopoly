public abstract class SquareType {
	
	//Can be made by person creating gone class for properties, jail block, etc...
	
	private String name; //Name of the tile
	private String tileType; //eg. Utility, Taxes, Land
	private String owner; //To determine who owns it. O = neutral, 1 for player 1...etc.
	private String hasHouse;
	private double baseRent;
	
	public SquareType () {
		name = "Start";
		tileType = "Ends";
		owner = " ";
		hasHouse = " ";
		baseRent = 150;
	}
	
	public SquareType (String name, String tileType, String owner, String hasHouse, double baseRent) {
		this.name = name;
		this.tileType = tileType;
		this.owner = owner;
		this.hasHouse = hasHouse;
		this.baseRent = baseRent;
		
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return 0;
	}

	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getTileType() {
		return tileType;
	}
	
	public void setTileType (String tileType) {
		this.tileType = tileType;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner (String owner) {
		this.owner = owner;
	}
	
	public String getHasHouse () {
		return hasHouse;
	}
	
	public void setHasHouse (String hasHouse) {
		this.hasHouse = hasHouse;
	}
	
	public double getBaseRent() {
		return baseRent;
	}
	public void setBaseRent (double baseRent) {
		this.baseRent = baseRent;
	}
	
}