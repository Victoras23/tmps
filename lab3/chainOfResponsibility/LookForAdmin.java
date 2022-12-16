package chainOfResponsibility;

import java.util.*;

public class LookForAdmin {
    private List<String> Admin = new ArrayList<String>();
    private String isAdmin;

    LookForAdmin(String isAdmin) {
        addUsers();
        this.isAdmin = isAdmin;
    }

    String giveTheData() {
        if (this.Admin.contains(this.isAdmin)) {
            Information newAdmin = new Admin();
            return newAdmin.giveTheInfo();
        } else {
            return "";
        }
    }

    private void addUsers() {
        this.Admin.add("Admin1");
    }
}
