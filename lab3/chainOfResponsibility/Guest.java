package chainOfResponsibility;

public class Guest implements Information {

    @Override
    public String giveTheInfo() {
        return " is a guest";
    }
}
