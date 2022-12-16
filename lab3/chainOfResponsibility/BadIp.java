package chainOfResponsibility;

public class BadIp implements Information {

    @Override
    public String giveTheInfo() {
        return " has bad Ip";
    }

}
