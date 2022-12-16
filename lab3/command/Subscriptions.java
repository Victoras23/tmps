package command;

import java.util.*;

public class Subscriptions {
    List<String> Subscriptions = new ArrayList<String>();

    public void addSubscriptions(String username) {
        this.Subscriptions.add(username);
    }

    public void removeSubscriptions(String username) {
        this.Subscriptions.remove(username);
    }

    public List getTheList() {
        return this.Subscriptions;
    }
}
