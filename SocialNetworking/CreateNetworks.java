
public class CreateNetworks {

	public static void main(String[] args) {
		SocialNetwork network1 = new SocialNetwork();
		SocialNetwork network2 = new SocialNetwork();

		network1.add("joe", "doe", "jd@uwo.ca");
		network1.add("jan", "doe", "jane@uwo.ca");

		network2.add("cs", "1027", "cs1027@uwo.ca");

		System.out.println("Friends in network 1");
		network1.printFriends();

		System.out.println("\nFriends in network 2");
		network2.printFriends();
	}

}
