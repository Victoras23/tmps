package observer;

import java.util.*;

public class ManageTheNotification {
    public static void main(String[] args) {
        List<String> iphone = new ArrayList<String>();
        List<String> samsung = new ArrayList<String>();
        samsung.add("user1");
        samsung.add("user2");
        samsung.add("user3");
        iphone.add("user1");
        iphone.add("user4");
        iphone.add("user5");
        samsung.add("user6");
        iphone.add("user6");
        Products products = new Products(iphone, samsung);

        Observer add = new AddAPtroduct(products);
        Observer sell = new RemoveAProduct(products);

        System.out.println(products.notifyIphone() + add.productAvalable(5, "iphone"));
        System.out.println(products.notifySamsung() + add.productAvalable(2, "samsungs"));
        System.out.println(products.notifyIphone() + sell.productAvalable(1, "iphone"));
        System.out.println(products.notifySamsung() + sell.productAvalable(1, "samsungs"));
        System.out.println(products.notifyIphone() + sell.productAvalable(4, "iphone"));
        System.out.println(products.notifySamsung() + sell.productAvalable(1, "samsungs"));
    }
}
