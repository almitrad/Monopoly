public class Taxes extends SquareType {
	
	private static double taxPrice;


public Taxes () {
	taxPrice = 100.00;
}

public Taxes (double taxPrice, String name, String tileType, String owner, String hasHouse, double baseRent) {
	super(name, tileType, owner, hasHouse, baseRent);
	this.taxPrice = taxPrice;
}

public double getPrice() {
	return taxPrice;
}

public void setPrice (double taxPrice) {
	this.taxPrice = taxPrice;
}

}