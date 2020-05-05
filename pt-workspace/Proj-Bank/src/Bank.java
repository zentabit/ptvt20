import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> accounts;
	
	public Bank() {
		this.accounts = new ArrayList<BankAccount>();
	}
	
	int addAccount(String holdername, long idNr) {
		Customer c = findHolder(idNr);
		if(c == null) {
			accounts.add(new BankAccount(holdername, idNr));
			
		} else {
			accounts.add(new BankAccount(c));
		}
		int nbr = accounts.get(accounts.size()-1).getAccountNumber();
		return nbr;
	}
	
	Customer findHolder(long idNr) {
		for(BankAccount acc:accounts) {
			Customer c = acc.getHolder();
			if(c.getIdNr() == idNr) {
				return c;
			}
		}
		
		return null;
	}
	
	boolean removeAccount(int number) {
		
		for(BankAccount acc: accounts) {
			if(acc.getAccountNumber() == number) {
				accounts.remove(acc);
				return true;
			}
		}
		/*
		Iterator<BankAccount> i = accounts.iterator();
		while(i.hasNext()) {
			BankAccount acc = i.next();
			if(acc.getAccountNumber() == number) {
				accounts.remove(acc);
			}
		}
		*/
		return false;
	}
	
	ArrayList<BankAccount> getAllAccounts(){
		// skapa en kopia av de konton vi har (sketchy)
		ArrayList<BankAccount> copy = (ArrayList<BankAccount>) accounts.clone();
		// skapa tom lista som vi returnerar
		ArrayList<BankAccount> sorted = new ArrayList<BankAccount>();
		// selection sort? plockar ut minsta elementet hela tiden genom lexografisk jämförelse
		while(copy.size()>0) {
			BankAccount min = copy.get(0);
			for(BankAccount acc:copy) {
				if(acc.getHolder().getName().compareTo(min.getHolder().getName()) < 0) {
					min = acc;
				}
			}
			// flytta min-kontot
			sorted.add(min);
			copy.remove(copy.indexOf(min));
		}
		
		return sorted;
	}
	
	BankAccount findByNumber(int accountNumber) {
		for(BankAccount acc: accounts) {
			if(acc.getAccountNumber() == accountNumber) {
				return acc;
			}
		}
		return null;
	}
	
	ArrayList<BankAccount> findAccountsForHolder(long idNr){
		ArrayList<BankAccount> retaccs = new ArrayList<BankAccount>();
		for(BankAccount acc: accounts) {
			long nr = acc.getHolder().getIdNr();
			if(nr == idNr) {
				retaccs.add(acc);
			}
		}
		return retaccs;
	}
	
	ArrayList<Customer> findByPartofName(String namePart){
		ArrayList<Customer> custs = new ArrayList<Customer>();
		for(BankAccount acc:accounts) {
			if(acc.getHolder().getName().toLowerCase().contains(namePart.toLowerCase())) {
				if(!custs.contains(acc.getHolder())) {
					custs.add(acc.getHolder());
				}
			}
		}
		return custs;
	}
}
