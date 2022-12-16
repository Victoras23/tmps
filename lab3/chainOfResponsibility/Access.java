package chainOfResponsibility;

public class Access {
    public static void main(String[] args) {
        LookForBadIpAddress user1 = new LookForBadIpAddress("1234567890", "User 1", "Admin 1");
        LookForBadIpAddress user2 = new LookForBadIpAddress("0987654321", "User 1", "Admin 1");
        LookForBadIpAddress user3 = new LookForBadIpAddress("0987654321", "User1", "Admin 1");
        LookForBadIpAddress user4 = new LookForBadIpAddress("0987654321", "User1", "Admin1");

        System.out.println("user1" + user1.giveTheData());
        System.out.println("user2" + user2.giveTheData());
        System.out.println("user3" + user3.giveTheData());
        System.out.println("user4" + user4.giveTheData());
    }
}
