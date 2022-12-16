package observer;

public class AddAPtroduct implements Observer {
    Products products;

    AddAPtroduct(Products products) {
        this.products = products;
    }

    private void add(int number, String type) {
        if (type == "iphone") {
            this.products.addIphones(number);
        } else {
            this.products.addSamsungs(number);
        }
    }

    @Override
    public String productAvalable(int number, String type) {
        add(number, type);
        String ReturnData;
        if (type.equals("iphone")) {
            if (this.products.iphoneQuantity() > 0) {
                ReturnData = "was notifyed that they are " + this.products.iphoneQuantity() + " iphones in store\n";
            } else {
                ReturnData = " was notifyed we dont have any iphones\n";
            }
        } else {
            if (this.products.samsungQuantity() > 0) {
                ReturnData = "was notifyed that they are " + this.products.samsungQuantity() + " samsungs in store\n";
            } else {
                ReturnData = " was notifyed we dont have any samsungs\n";
            }
        }
        return ReturnData;
    }
}
