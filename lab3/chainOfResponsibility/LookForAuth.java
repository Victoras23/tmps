package chainOfResponsibility;

import java.util.*;

public class LookForAuth {
    private List<String> Auth = new ArrayList<String>();
    private String isLogined, isAdmin;

    LookForAuth(String isLoged, String isAdmin) {
        addUsers();
        this.isLogined = isLoged;
        this.isAdmin = isAdmin;
    }

    String giveTheData() {
        if (this.Auth.contains(this.isLogined)) {
            Information newUser = new User();
            LookForAdmin newAdmin = new LookForAdmin(this.isAdmin);
            return newUser.giveTheInfo() + newAdmin.giveTheData();
        } else {
            Information newGuest = new Guest();
            return newGuest.giveTheInfo();
        }
    }

    private void addUsers() {
        this.Auth.add("User1");
        this.Auth.add("User2");
    }
}
