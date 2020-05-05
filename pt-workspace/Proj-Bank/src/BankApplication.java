import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankApplication {
	// todo: implementera filhantering med JSON
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		//createTestAccounts(bank);
		loop(bank);
	}

	private static void loop(Bank bank) {
		Scanner s = new Scanner(System.in);
		boolean run = true;

		while (run) {
			try {
				menu();
				int choice = s.nextInt();
				s.nextLine();
				switch (choice) {
				case 0:
					// avsluta
					run = false;
					println("Hejdå!");
					break;
				case 1: {
					// hitta konto utifrån innehavare
					print("id: ");
					long idNr = s.nextLong();
					printAccs(bank.findAccountsForHolder(idNr));
					break;
				}
				case 2:
					// hitta innehavare utifrån del av namn
					print("namn: ");
					String namePart = s.nextLine();
					printCusts(bank.findByPartofName(namePart));
					break;
				case 3: {
					// sätt in
					print("konto:");
					int accNr = s.nextInt();
					print("belopp: ");
					double amount = s.nextDouble();
					if (amount < 0) {
						println("Jahopp.");
						break;
					}
					BankAccount account = bank.findByNumber(accNr);
					if (account != null) {
						account.deposit(amount);
						println(account.toString());
					} else {
						println("Det kontot finns inte!");
					}
					break;
				}
				case 4: {
					// ta ut
					print("från konto:");
					int accNr = s.nextInt();
					print("belopp: ");
					double amount = s.nextDouble();
					BankAccount account = bank.findByNumber(accNr);
					if (account != null) {
						if (account.getAmount() - amount < 0) {
							println("Så mycket kan du inte ta ut! Du har bara " + account.getAmount() + " på kontot.");
							break;
						}
						account.withdraw(amount);
						println(account.toString());
					} else {
						println("Det kontot finns inte!");
					}

					break;
				}
				case 5:
					// överföring
					print("från konto: ");
					int from = s.nextInt();
					print("till konto: ");
					int to = s.nextInt();
					print("belopp: ");
					int amount = s.nextInt();
					BankAccount fromAcc = bank.findByNumber(from);
					BankAccount toAcc = bank.findByNumber(to);
					if (fromAcc != null && toAcc != null) {
						fromAcc.withdraw(amount);
						toAcc.deposit(amount);
						println(bank.findByNumber(from).toString());
						println(bank.findByNumber(to).toString());
					} else {
						println("Tyvärr, ett (eller båda) konto(na) existerar inte!");
					}

					break;
				case 6: {
					// skapa konto
					print("Namn: ");
					String holdername = s.nextLine();
					print("id: ");
					long idNr = s.nextLong();
					int accNr = bank.addAccount(holdername, idNr);
					println("konto skapat: " + accNr);
					break;
				}
				case 7: {
					// ta bort konto
					print("konto: ");
					int accNr = s.nextInt();
					if (!bank.removeAccount(accNr)) {
						println("Felaktigt kontonummer!");
					}
					break;
				}
				case 8:
					// lista alla konton
					ArrayList<BankAccount> accs = bank.getAllAccounts();
					printAccs(accs);
					break;
				default:
					// inget menyalternativ kunde hittas
					println("Felaktig input!");
					break;
				}

			} catch (InputMismatchException e) {
				println("Vänligen mata in korrekt indata, dummer.");
				s.nextLine();
			} //catch (Exception e) {
			//	println("Nånting gick fel! Prova gärna igen");
			//}

		}
	}

	private static void printCusts(ArrayList<Customer> custs) {
		for (Customer cust : custs) {
			println(cust.toString());
		}
	}

	private static void createTestAccounts(Bank bank) {
		bank.addAccount("Emil Babayev", (long) 4111194444.0);
		bank.addAccount("Test Testsson", 1000000000);
		bank.addAccount("Test Testsson", 1000000000);
		bank.addAccount("Dorotea Svensson", 2020);
		bank.addAccount("Dorotea Persson", 110000000);
		bank.addAccount("Ingvar från Älmhult", 2001010001);
	}

	static void menu() {
		println(". . . - - - . . . . . . - - - . . . . . . - - - . . . . . . - - - . . . . . . - - - . . . . . . - - - . . .");
		println("1. Hitta konto utifrån innehavare");
		println("2. Sök kontoinnehavare utifrån (del av) namn");
		println("3. Sätt in");
		println("4. Ta ut");
		println("5. Överföring");
		println("6. Skapa konto");
		println("7. Ta bort konto");
		println("8. Skriv ut konton");
		println("0. Avsluta");
		print("val: ");
	}

	static void println(String s) {
		System.out.println(s);
	}

	static void print(String s) {
		System.out.print(s);
	}

	static void printAccs(ArrayList<BankAccount> accs) {
		for (BankAccount acc : accs) {
			println(acc.toString());
		}
	}

}
