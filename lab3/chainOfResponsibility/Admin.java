package chainOfResponsibility;

public class Admin implements Information {

    @Override
    public String giveTheInfo() {
        return " and admin";
    }

}
