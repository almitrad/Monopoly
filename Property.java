public class Property extends SquareType {
	
	private String grouping;
	private double price;
	private double baseRent;
	private String hasHouse;
	
	public Property() {
		super();
		grouping = "a";
		price = 200.00;
		baseRent = 100.00;
		hasHouse = " ";
		
	}
	
	public Property(String grouping, double price, double baseRent, String name, String tileType, String owner, String hasHouse) {
		super(name, tileType, owner, hasHouse, baseRent);
		this.grouping = grouping; 
		this.price = price;
		this.baseRent = baseRent;
		this.hasHouse = hasHouse;
	}
	
	public String getGrouping() {
		return grouping;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getBaseRent() {
		return baseRent;
	}
	
	public double getRentWithSet() {
		return baseRent*2;
	}
	
	public double getRentWithOneHouse() {
		return baseRent * 3;
	}
	
	public double getRentWithTwoHouse(){
		return (baseRent * 3) + 10;
	}
	
	public double getRentWithThreeHouse() {
		return (baseRent * 3) + 20;
	}
	
	public double getRentWithFourHouse() {
		return (baseRent * 3) + 30;
	}
	
	public double getRentWithHotel() {
		return baseRent * 5;
	}
	
	public double getHouseCost() {
		return baseRent * 1.5;
	}
	
	public double getHotelCost() {
		return baseRent * 1.5;
	}
	
	public void setGrouping(String grouping) {
		this.grouping = grouping;
	}
	
	public void setPrice (double price) {
		this.price = price;
	}
	
	public String getHasHouse() {
		return hasHouse;
	}
	
	public void setHasHouse (String hasHouse) {
		this.hasHouse = hasHouse;
	}
	
	
}