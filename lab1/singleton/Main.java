package singleton;

public class Main {
    public static void main(String[] args) {

        Singleton instance = Singleton.createInstance();

        instance.showMessage();
    }
}