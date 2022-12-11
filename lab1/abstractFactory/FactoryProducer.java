package abstractFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(boolean portable) {
        if (portable) {
            return new MainComponents();
        } else {
            return new SuplimentarComponents();
        }
    }
}
