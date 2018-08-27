public class Player2 implements Pieces{
	
	private String name;
	private String owner;
	private String location; 
	private double balance;
	
	public Player2() {
		name = "o";
		owner = "Player 2";
		location = "Start/Go";
		balance = 1500;
		
	}
	
	public Player2(String name, String owner, double balance) {
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
	
	public String getOwner () {
		return owner;
	}
	
	public void setOwner (String owner) {
		this.owner = owner;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location; 
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

}