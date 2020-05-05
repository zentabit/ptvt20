
public class Customer {
	private String name;
	private int custNr;
	private long idNr;
	private static int currentCustomerNr = 100;
	
	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		this.custNr = currentCustomerNr;
		currentCustomerNr++;
	}
	
	public String getName() {
		return name;
	}
	
	public long getIdNr() {
		return idNr;
	}
	
	public int getCustomerNr() {
		return custNr;
	}
	
	public String toString() {
		return name + ", id " + idNr + ", kundnr " + custNr;
	}
}
