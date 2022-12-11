package adapter;

public class Adapter {
    CelsiusDegree coupute = new CelsiusDegree();

    public void celsius(String value) {
        coupute.celsius(Integer.parseInt(value));
    }
}
