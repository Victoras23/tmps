package chainOfResponsibility;

import java.util.*;

public class LookForBadIpAddress {
    private List<String> badIp = new ArrayList<String>();
    private String ip, isLogined, isAdmin;

    LookForBadIpAddress(String ip, String isLoged, String isAdmin) {
        addBadIpAddress();
        this.ip = ip;
        this.isLogined = isLoged;
        this.isAdmin = isAdmin;
    }

    String giveTheData() {
        if (this.badIp.contains(ip)) {
            Information newBadIpInfo = new BadIp();
            return newBadIpInfo.giveTheInfo();
        } else {
            LookForAuth newUser = new LookForAuth(this.isLogined, this.isAdmin);
            return newUser.giveTheData();
        }
    }

    private void addBadIpAddress() {
        this.badIp.add("1234567890");
        this.badIp.add("2234567890");
        this.badIp.add("3234567890");
        this.badIp.add("4234567890");

    }
}
