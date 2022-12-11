package adapter;

public class Main {
    public static void main(String[] args) {
        String kelvin = "277";
        Adapter adapter = new Adapter();
        System.out.print(273 + "°K =");
        adapter.celsius(kelvin);
    }
}