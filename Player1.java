public class Player1 implements Pieces {
	
	private String name;
	private String owner;
	private String location;
	private double balance; 
	
	public Player1() {
		name = "x";
		owner = "Player 1";
		location = "Start/Go";
		balance = 1500; 
	}
	
	public Player1(String name, String owner, String location, double balance) {
		
		this.name = name;
		this.owner = owner;
		this.location = location;
		this.balance = balance; 
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public  String getOwner () {
		return owner;
	}
	
	public void setOwner (String owner) {
		this.owner = owner;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation( String location) {
		this.location = location; 
	}
	
	public double getBalance () {
		return balance; 
	}
	
	public void setBalance (double balance) {
		this.balance = balance; 
	}
	
}