public class Railroads extends SquareType {
	
	private double rrPrice;
	private double rentWithOneRR;
	private String hasHouse;
	
	
	public Railroads () {
		super();
		rrPrice = 200.00;
		rentWithOneRR = 25.00;
		hasHouse = " ";
	}
	
	public Railroads (double rrPrice, double rentWithOneRR, String name, String tileType, String owner, String hasHouse, double baseRent) {
		super(name, tileType, owner, hasHouse, baseRent);
		this.rentWithOneRR = rentWithOneRR;
		this.rrPrice = rrPrice;
		this.hasHouse = hasHouse;
	}
	
	public double getPrice() {
		return rrPrice;
	}
	
	public double getRentWithTwoRR() {
		return rentWithOneRR * 2;
	}
	
	public double getRentWithThreeRR() {
		return rentWithOneRR * 4;
	}
	
	public double getRentWithFourRR() {
		return rentWithOneRR * 8;
	}
	
	public void setPrice(double rrPrice) {
		this.rrPrice = rrPrice;
	}
	
	public void setRentWithOneRR(double rentWithOneRR) {
		this.rentWithOneRR = rentWithOneRR;
	}
	
	public String getHasHouse () {
		return hasHouse;
	}
	public void setHasHouse (String hasHouse) {
		this.hasHouse = hasHouse;
	}

}