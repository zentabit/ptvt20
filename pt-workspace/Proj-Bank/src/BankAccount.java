
public class BankAccount {
	private Customer holder;
	private double accountAmount;
	private int accountNr;
	private static int currentAccountNumber = 1000;
	
	public BankAccount(String holdername, long holderId) {
		this.holder = new Customer(holdername, holderId);
		this.accountAmount = 0;
		this.accountNr = accNbr();
	}
	
	public BankAccount(Customer holder) {
		this.holder = holder;
		this.accountAmount = 0;
		this.accountNr = accNbr();
	}
	
	public Customer getHolder() {
		return holder;
	}
	
	public int getAccountNumber() {
		return accountNr;
	}
	
	public double getAmount(){
		return accountAmount;
	}
	
	public void deposit(double amount) {
		accountAmount += amount;
	}
	
	public void withdraw(double amount) {
		accountAmount -= amount;
	}
	
	public String toString() {
		return "Konto " + accountNr + " (" + holder.toString() + "): " + accountAmount;
	}
	
	private int accNbr() {
		currentAccountNumber++;
		return currentAccountNumber;
	}
}
