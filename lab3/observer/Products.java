package observer;

import java.util.*;

public class Products {
    private List<String> iphonesFollowers = new ArrayList<String>();
    private List<String> samsungsFollowers = new ArrayList<String>();
    private int iphones = 0, samsungs = 0;

    Products(List<String> iphones, List<String> samsungs) {
        this.iphonesFollowers = iphones;
        this.samsungsFollowers = samsungs;
    }

    public void addIphones(int i) {
        this.iphones += i;
    }

    public void addSamsungs(int i) {
        this.samsungs += i;
    }

    public void sellIphones(int i) {
        this.iphones = this.iphones - i;
    }

    public void sellSamsungs(int i) {
        this.samsungs = this.samsungs - i;
    }

    public List notifyIphone() {
        return this.iphonesFollowers;
    }

    public List notifySamsung() {
        return this.samsungsFollowers;
    }

    public int iphoneQuantity() {
        return this.iphones;
    }

    public int samsungQuantity() {
        return this.samsungs;
    }
}
