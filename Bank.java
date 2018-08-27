public class Bank {
	
	private double balance;
	
	public Bank () {
		balance = 10000;
	}
	
	public Bank (double balance) {
		this.balance = balance; 
	}
	
	public double getBalance() {
		return balance; 
	}
	
	public void setBalance (double balance) {
		this.balance = balance;
	}
	
}