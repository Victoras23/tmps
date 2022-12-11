package abstractFactory;

public class SuplimentarComponents extends AbstractFactory {

    @Override
    Computer getComponents(String ComponentType) {
        if (ComponentType.equalsIgnoreCase("Memory")) {
            return new Memory();
        }
        if (ComponentType.equalsIgnoreCase("VideoAdaptors")) {
            return new VideoAdaptors();
        }
        System.out.println("None of the cases matches");
        return null;
    }

}
