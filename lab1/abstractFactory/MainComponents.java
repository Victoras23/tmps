package abstractFactory;

public class MainComponents extends AbstractFactory {

    @Override
    Computer getComponents(String ComponentType) {
        if (ComponentType.equalsIgnoreCase("MotherBoards")) {
            return new MotherBoards();
        }
        if (ComponentType.equalsIgnoreCase("Processors")) {
            return new Processors();
        }
        if (ComponentType.equalsIgnoreCase("Memory")) {
            return new Memory();
        }
        System.out.println("None of the cases matches");
        return null;
    }

}
