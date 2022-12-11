package factory;

public class Main {
    public static void main(String[] args) {

        String accountDataType1 = "Name";
        String accountDataType2 = "Location";
        String accountDataType3 = "Birthsday";

        Account name = AccountFactory.createInstance(accountDataType1);
        Account location = AccountFactory.createInstance(accountDataType2);
        Account birthsday = AccountFactory.createInstance(accountDataType3);

        System.out.println("Name: " + name.data());
        System.out.println("Bitrhsday: " + birthsday.data());
        System.out.println("location: " + location.data());
    }
}
