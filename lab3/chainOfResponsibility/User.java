package chainOfResponsibility;

public class User implements Information {

    @Override
    public String giveTheInfo() {
        return " is user";
    }

}
