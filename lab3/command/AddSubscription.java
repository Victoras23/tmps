package command;

public class AddSubscription implements Commands {
    private String username;
    private Subscriptions subsctriptions;

    AddSubscription(String username, Subscriptions subsctriptions) {
        this.username = username;
        this.subsctriptions = subsctriptions;
    }

    @Override

    public String execute() {
        this.subsctriptions.addSubscriptions(this.username);
        return this.username + " was added";
    }
}
