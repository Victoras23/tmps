package singleton;

public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton createInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("SingleTon works");
    }
}
