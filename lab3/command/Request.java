package command;

public class Request {
    public static void main(String[] args) {
        Subscriptions subscriptions = new Subscriptions();

        Commands action1 = new AddSubscription("user1", subscriptions);
        Commands action2 = new AddSubscription("user2", subscriptions);
        Commands action3 = new AddSubscription("user3", subscriptions);
        Commands action4 = new DeleteSubscription("user2", subscriptions);
        Commands action5 = new DeleteSubscription("user3", subscriptions);

        System.out.println(action1.execute());
        System.out.println(action2.execute());
        System.out.println(action3.execute());
        System.out.println(action4.execute());
        System.out.println(action5.execute());

        System.out.println("List of subscriptions: " + subscriptions.getTheList());
    }
}
