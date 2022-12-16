package command;

public class DeleteSubscription implements Commands {
    private String username;
    Subscriptions subsctriptions;

    DeleteSubscription(String username, Subscriptions subsctriptions) {
        this.username = username;
        this.subsctriptions = subsctriptions;
    }

    @Override
    public String execute() {
        this.subsctriptions.removeSubscriptions(this.username);
        return this.username + " was  deleted";
    }

}
