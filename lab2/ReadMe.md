# Laboratory work №2. Structural Design Patterns

### Course: Software Design Techniques and Mechanisms
### Author: Botnaru Victor, FAF-202

## Used Design Patterns:

- Adapter Pattern
Adapter pattern works as a bridge between two incompatible interfaces. This type of design pattern comes under structural pattern as this pattern combines the capability of two independent interfaces.
This pattern involves a single class which is responsible to join functionalities of independent or incompatible interfaces. A real life example could be a case of card reader which acts as an adapter between memory card and a laptop. We plugin the memory card into card reader and card reader into the laptop so that memory card can be read via laptop.

- Composite Pattern
Composite pattern is used where we need to treat a group of objects in similar way as a single object. Composite pattern composes objects in term of a tree structure to represent part as well as whole hierarchy. This type of design pattern comes under structural pattern as this pattern creates a tree structure of group of objects.
This pattern creates a class that contains group of its own objects. This class provides ways to modify its group of same objects.

- Decorator Pattern
Decorator pattern allows a user to add new functionality to an existing object without altering its structure. This type of design pattern comes under structural pattern as this pattern acts as a wrapper to existing class.
This pattern creates a decorator class which wraps the original class and provides additional functionality keeping class methods signature intact.


## Implementation
In Adapter Pattern the implementation uses the object composition principle: the adapter implements the interface of one object and wraps the other one. 
```java
package adapter;

public class Main {
    public static void main(String[] args) {
        String kelvin = "277";
        Adapter adapter = new Adapter();
        System.out.print(273 + "°K =");
        adapter.celsius(kelvin);
    }
}
```
In Composite Pattern we have a class ```Team``` which acts as composite pattern actor class. ```Project```, our demo class will use ```Team``` class to add department level hierarchy and print all teams working on projects.
```java
package composite;

import java.util.*;

public class Team {
    private List<Employee> employees = new ArrayList<Employee>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void StartWorking() {
        System.out.println("Market starts working");
        for (Employee employee : employees) {
            employee.works();
        }
    }
}

```
```java
package composite;

public class Market {
    public static void main(String[] args) {
        Team team = new Team();

        Employee bodyGuard = new BodyGuards();
        Employee bodyGuard2 = new BodyGuards();
        Employee bodyGuard3 = new BodyGuards();
        Employee seller = new Seller();
        Employee seller2 = new Seller();
        Employee seller3 = new Seller();
        Employee seller4 = new Seller();
        Employee clinner = new Clinner();
        Employee clinner2 = new Clinner();
        Employee clinner3 = new Clinner();
        Employee clinner4 = new Clinner();

        team.addEmployee(bodyGuard);
        team.addEmployee(bodyGuard2);
        team.addEmployee(bodyGuard3);
        team.addEmployee(seller);
        team.addEmployee(seller2);
        team.addEmployee(seller3);
        team.addEmployee(seller4);
        team.addEmployee(clinner);
        team.addEmployee(clinner2);
        team.addEmployee(clinner3);
        team.addEmployee(clinner4);

        team.removeEmployee(clinner2);
        team.removeEmployee(bodyGuard2);

        team.StartWorking();
    }
}

```

In Decorator Pattern we're going to create a ```Developer``` interface and concrete classes implementing the ```Developer``` interface.
```java
package decorator;

public interface Company {
    public String makeJob();
}

```
We will then create an abstract decorator class ```DeveloperDecorator``` implementing the ```Developer``` interface and having ```Developer``` object as its instance variable.
```java
package decorator;

public class Decorator implements Company {
    Company company;

    public Decorator(Company company) {
        this.company = company;
    }

    @Override
    public String makeJob() {
        return company.makeJob();
    }
}

```



## Conclusions

While working on this laboratory work, I got familiar with the structural design patterns and how are they implemeted and used. Structural design patterns explain how to assemble objects and classes into larger structures, while keeping these structures flexible and efficient. The patterns in structural designs show how unique pieces of a system can be combined together in an extensible and flexible manner. So, with the help structural design pattern we can target and change a specific parts of the structure without changing the entire structure.