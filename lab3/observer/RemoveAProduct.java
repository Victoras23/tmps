package observer;

public class RemoveAProduct implements Observer {
    Products products;

    RemoveAProduct(Products products) {
        this.products = products;
    }

    private void remove(int number, String type) {
        if (type == "iphone") {
            this.products.sellIphones(number);
        } else {
            this.products.sellSamsungs(number);
        }
    }

    @Override
    public String productAvalable(int number, String type) {
        this.remove(number, type);
        String ReturnData;
        if (type.equals("iphone")) {
            if (this.products.iphoneQuantity() > 0) {
                ReturnData = " was notifyed that they are " + this.products.iphoneQuantity() + " iphones in store\n";
            } else {
                ReturnData = " was notifyed that we dont have any iphones\n";
            }
        } else {
            if (this.products.samsungQuantity() > 0) {
                ReturnData = " was notifyed that they are " + this.products.samsungQuantity() + " samsungs in store\n";
            } else {
                ReturnData = " was notifyed that we dont have any samsungs\n";
            }
        }
        return ReturnData;
    }

}
