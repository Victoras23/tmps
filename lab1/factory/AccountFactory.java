package factory;

public class AccountFactory {
    static Account createInstance(String accountName) {
        if (accountName.equalsIgnoreCase("Name")) {
            return new Name();
        } else if (accountName.equalsIgnoreCase("Location")) {
            return new Location();
        } else {
            return new Birthsday();
        }
    }
}
