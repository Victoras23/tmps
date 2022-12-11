# Laboratory work №1. Creational Design Patterns

### Course: Software Design Techniques and Mechanisms
### Author: Botnaru Vicor, FAF-202

## Objectives:

1. Get familiar with the Creational DPs;
2. Choose a specific domain;
3. Implement at least 3 CDPs for the specific domain;


## Used Design Patterns:

- Singleton Pattern
Singleton pattern is one of the simplest design patterns. This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object. This pattern involves a single class which is responsible to create an object while making sure that only single object gets created. This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.


- Factory Pattern
The factory design pattern is used when we have a superclass with multiple sub-classes and based on input, we need to return one of the sub-class. This pattern takes out the responsibility of the instantiation of a class from the client program to the factory class.

- Abstract Factory Pattern
Abstract Factory patterns work around a super-factory which creates other factories. This factory is also called as factory of factories. This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
In Abstract Factory pattern an interface is responsible for creating a factory of related objects without explicitly specifying their classes. Each generated factory can give the objects as per the Factory pattern.




## Implementation
In Singleton Patterm we defined a class that has only one instance and provides a global point of access to it. In other words, a class must ensure that only single instance should be created and single object can be used by all other classes. This pattern involves a single class which is responsible to create an object while making sure that only single object gets created. This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.
```java

public class Main {
    public static void main(String[] args) {

        Singleton instance = Singleton.createInstance();

        instance.showMessage();
    }
}
```

In Factory Pattern we defined an interface or abstract class for creating an object but let the subclasses decide which class to instantiate. In other words, subclasses are responsible to create the instance of the class. We create object without exposing the creation logic to the client and refer to newly created object using a common interface.
```java

public class Main {
    public static void main(String[] args) {

        String accountDataType1 = "Name";
        String accountDataType2 = "Location";
        String accountDataType3 = "Birthsday";

        Account name = AccountFactory.createInstance(accountDataType1);
        Account location = AccountFactory.createInstance(accountDataType2);
        Account birthsday = AccountFactory.createInstance(accountDataType3);

        System.out.println("Name: " + name.data());
        System.out.println("Bitrhsday: " + birthsday.data());
        System.out.println("location: " + location.data());
    }
}

```

In Abstract Factory pattern an interface is responsible for creating a factory of related objects without explicitly specifying their classes. Each generated factory can give the objects as per the Factory pattern.
```java

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

```

## Conclusions

While working on this laboratory work, I got familiar with the creational design patterns and how are they implemeted and used. Creational design patterns provide various object creation mechanisms, which increase flexibility and reuse of existing code. These design patterns are used when a decision must be made at the time of instantiation of a class (i.e. creating an object of a class).