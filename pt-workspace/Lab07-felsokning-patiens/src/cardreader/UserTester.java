package cardreader;

public class UserTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserTable ut = new UserTable();
		System.out.println(ut.find(24073));
		System.out.println(ut.find(24074));
		System.out.println(ut.find(97368));
		System.out.println(ut.testFind());
		System.out.println(ut.findByName("Jens Holmgren"));
		System.out.println(ut.getNbrUsers());
		//ut.print();
		ut.add(new User(1234, "Test Testsson"));
		System.out.println(ut.find(1234));
		//ut.print();
	}

}
