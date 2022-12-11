package abstractFactory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = FactoryProducer.getFactory(true);

        Computer MotherBoard = factory.getComponents("MotherBoards");
        Computer Memory = factory.getComponents("Memory");
        Computer Processors = factory.getComponents("Processors");

        MotherBoard.data();
        Memory.data();
        Processors.data();

        AbstractFactory factoryFalse = FactoryProducer.getFactory(false);

        Computer Memory1 = factoryFalse.getComponents("Memory");
        Computer VideoAdaptors = factoryFalse.getComponents("VideoAdaptors");
        Memory1.data();
        VideoAdaptors.data();
    }
}
