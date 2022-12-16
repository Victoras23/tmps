# Laboratory work №2. Behavioral Design Patterns

### Course: Software Design Techniques and Mechanisms
### Author: Botnaru Victor, FAF-202

### Objectives 
* Get familiar with Behavioral Design Patterns
* Implement Behavioral Design Patterns for a specific domain 

----

## Behavioral Design Patterns

In software engineering, behavioral design patterns are design patterns that identify common communication patterns among objects. By doing so, these patterns increase flexibility in carrying out communication.
There are following types of Behavioral design patterns.

* `Blackboard`
* `Chain of responsibility`
* `Command`
* `Interpreter`
* `Iterator`
* `Mediator`
* `Memento`
* `Null object`
* `Observer or Publish/Subscribe`
* `Servant`
* `Specification`
* `State`
* `Strategy`
* `Template Method`
* `Visitor`

----

## Used Design Patterns:

### Chain of Responsability

Chain of Responsibility is a behavioral design pattern that lets you pass requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.

Like many other behavioral design patterns, the Chain of Responsibility relies on transforming particular behaviors into stand-alone objects called handlers. In our case, each check should be extracted to its own class with a single method that performs the check. The request, along with its data, is passed to this method as an argument.

The pattern suggests that you link these handlers into a chain. Each linked handler has a field for storing a reference to the next handler in the chain. In addition to processing a request, handlers pass the request further along the chain. The request travels along the chain until all handlers have had a chance to process it.Here’s the best part: a handler can decide not to pass the request further down the chain and effectively stop any further processing.

Use the Chain of Responsibility pattern when your program is expected to process different kinds of requests in various ways, but the exact types of requests and their sequences are unknown beforehand. The pattern lets you link several handlers into one chain and, upon receiving a request, “ask” each handler whether it can process it. This way all handlers get a chance to process the request.

Use the pattern when it’s essential to execute several handlers in a particular order.

 Since you can link the handlers in the chain in any order, all requests will get through the chain exactly as you planned.

Use the CoR pattern when the set of handlers and their order are supposed to change at runtime.

 If you provide setters for a reference field inside the handler classes, you’ll be able to insert, remove or reorder handlers dynamically.

How to implement?

 * Declare the handler interface and describe the signature of a method for handling requests. Decide how the client will pass the request data into the method. The most flexible way is to convert the request into an object and pass it to the handling method as an argument.

 * To eliminate duplicate boilerplate code in concrete handlers, it might be worth creating an abstract base handler class, derived from the handler interface. This class should have a field for storing a reference to the next handler in the chain. Consider making the class immutable. However, if you plan to modify chains at runtime, you need to define a setter for altering the value of the reference field. You can also implement the convenient default behavior for the handling method, which is to forward the request to the next object unless there’s none left. Concrete handlers will be able to use this behavior by calling the parent method.

 * One by one create concrete handler subclasses and implement their handling methods. Each handler should make two decisions when receiving a request: 
  1. Whether it’ll process the request.
  2. Whether it’ll pass the request along the chain.

 * The client may either assemble chains on its own or receive pre-built chains from other objects. In the latter case, you must implement some factory classes to build chains according to the configuration or environment settings.

 * The client may trigger any handler in the chain, not just the first one. The request will be passed along the chain until some handler refuses to pass it further or until it reaches the end of the chain.

 * Due to the dynamic nature of the chain, the client should be ready to handle the following scenarios:
   1. The chain may consist of a single link.
   2. Some requests may not reach the end of the chain.

 Others may reach the end of the chain unhandled.

 ### Implementation 
 ```java
String giveTheData() {
        if (this.badIp.contains(ip)) {
            Information newBadIpInfo = new BadIp();
            return newBadIpInfo.giveTheInfo();
        } else {
            LookForAuth newUser = new LookForAuth(this.isLogined, this.isAdmin);
            return newUser.giveTheData();
        }
    }

String giveTheData() {
        if (this.Auth.contains(this.isLogined)) {
            Information newUser = new User();
            LookForAdmin newAdmin = new LookForAdmin(this.isAdmin);
            return newUser.giveTheInfo() + newAdmin.giveTheData();
        } else {
            Information newGuest = new Guest();
            return newGuest.giveTheInfo();
        }
    }

String giveTheData() {
        if (this.Admin.contains(this.isAdmin)) {
            Information newAdmin = new Admin();
            return newAdmin.giveTheInfo();
        } else {
            return "";
        }
    }
```

----

### Command

Command is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request. This transformation lets you pass requests as a method arguments, delay or queue a request’s execution, and support undoable operations.

Imagine that you’re working on a new text-editor app. Your current task is to create a toolbar with a bunch of buttons for various operations of the editor. You created a very neat Button class that can be used for buttons on the toolbar, as well as for generic buttons in various dialogs.

While all of these buttons look similar, they’re all supposed to do different things. Where would you put the code for the various click handlers of these buttons? The simplest solution is to create tons of subclasses for each place where the button is used. These subclasses would contain the code that would have to be executed on a button click.

Before long, you realize that this approach is deeply flawed. First, you have an enormous number of subclasses, and that would be okay if you weren’t risking breaking the code in these subclasses each time you modify the base Button class. Put simply, your GUI code has become awkwardly dependent on the volatile code of the business logic.

So, what is the Solution? Good software design is often based on the principle of separation of concerns, which usually results in breaking an app into layers. The most common example: a layer for the graphical user interface and another layer for the business logic. The GUI layer is responsible for rendering a beautiful picture on the screen, capturing any input and showing results of what the user and the app are doing. However, when it comes to doing something important, like calculating the trajectory of the moon or composing an annual report, the GUI layer delegates the work to the underlying layer of business logic. Use the Command pattern when you want to parametrize objects with operations.

 The Command pattern can turn a specific method call into a stand-alone object. This change opens up a lot of interesting uses: you can pass commands as method arguments, store them inside other objects, switch linked commands at runtime, etc.

Here’s an example: you’re developing a GUI component such as a context menu, and you want your users to be able to configure menu items that trigger operations when an end user clicks an item.

Use the Command pattern when you want to queue operations, schedule their execution, or execute them remotely.

 As with any other object, a command can be serialized, which means converting it to a string that can be easily written to a file or a database. Later, the string can be restored as the initial command object. Thus, you can delay and schedule command execution. But there’s even more! In the same way, you can queue, log or send commands over the network.

How to Implement? 
 * Declare the command interface with a single execution method.

 * Start extracting requests into concrete command classes that implement the command interface. Each class must have a set of fields for storing the request arguments along with a reference to the actual receiver object. All these values must be initialized via the command’s constructor.

 * Identify classes that will act as senders. Add the fields for storing commands into these classes. Senders should communicate with their commands only via the command interface. Senders usually don’t create command objects on their own, but rather get them from the client code.

 * Change the senders so they execute the command instead of sending a request to the receiver directly.

 * The client should initialize objects in the following order: 1. Create receivers. -> 2. Create commands, and associate them with receivers if needed. -> 3. Create senders, and associate them with specific commands.

  ### Implementation 

```java
    public class AddSubscription implements Commands {
    private String username;
    private Subscriptions subsctriptions;

    AddSubscription(String username, Subscriptions subsctriptions) {
        this.username = username;
        this.subsctriptions = subsctriptions;
    }

    @Override

    public String execute() {
        this.subsctriptions.addSubscriptions(this.username);
        return this.username + " was added";
    }
}
```

----

### Observer

Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.

The object that has some interesting state is often called subject, but since it’s also going to notify other objects about the changes to its state, we’ll call it publisher. All other objects that want to track changes to the publisher’s state are called subscribers.

The Observer pattern suggests that you add a subscription mechanism to the publisher class so individual objects can subscribe to or unsubscribe from a stream of events coming from that publisher. Fear not! Everything isn’t as complicated as it sounds. In reality, this mechanism consists of 1) an array field for storing a list of references to subscriber objects and 2) several public methods which allow adding subscribers to and removing them from that list.

Another real life example would be if you subscribe to a newspaper or magazine, you no longer need to go to the store to check if the next issue is available. Instead, the publisher sends new issues directly to your mailbox right after publication or even in advance.

The publisher maintains a list of subscribers and knows which magazines they’re interested in. Subscribers can leave the list at any time when they wish to stop the publisher sending new magazine issues to them.  

Use the Observer pattern when changes to the state of one object may require changing other objects, and the actual set of objects is unknown beforehand or changes dynamically.

 You can often experience this problem when working with classes of the graphical user interface. For example, you created custom button classes, and you want to let the clients hook some custom code to your buttons so that it fires whenever a user presses a button.

The Observer pattern lets any object that implements the subscriber interface subscribe for event notifications in publisher objects. You can add the subscription mechanism to your buttons, letting the clients hook up their custom code via custom subscriber classes.

 Use the pattern when some objects in your app must observe others, but only for a limited time or in specific cases.

The subscription list is dynamic, so subscribers can join or leave the list whenever they need to.

How to Implement?

* Look over your business logic and try to break it down into two parts: the core functionality, independent from other code, will act as the publisher; the rest will turn into a set of subscriber classes.

* Declare the subscriber interface. At a bare minimum, it should declare a single update method.

* Declare the publisher interface and describe a pair of methods for adding a subscriber object to and removing it from the list. Remember that publishers must work with subscribers only via the subscriber interface.

* Decide where to put the actual subscription list and the implementation of subscription methods. Usually, this code looks the same for all types of publishers, so the obvious place to put it is in an abstract class derived directly from the publisher interface. Concrete publishers extend that class, inheriting the subscription behavior. However, if you’re applying the pattern to an existing class hierarchy, consider an approach based on composition: put the subscription logic into a separate object, and make all real publishers use it.

* Create concrete publisher classes. Each time something important happens inside a publisher, it must notify all its subscribers.

* Implement the update notification methods in concrete subscriber classes. Most subscribers would need some context data about the event. It can be passed as an argument of the notification method. But there’s another option. Upon receiving a notification, the subscriber can fetch any data directly from the notification. In this case, the publisher must pass itself via the update method. The less flexible option is to link a publisher to the subscriber permanently via the constructor.

* The client must create all necessary subscribers and register them with proper publishers.

### Implementation 
```java
public class AddAPtroduct implements Observer {
    Products products;

    AddAPtroduct(Products products) {
        this.products = products;
    }

    private void add(int number, String type) {
        if (type == "iphone") {
            this.products.addIphones(number);
        } else {
            this.products.addSamsungs(number);
        }
    }

    @Override
    public String productAvalable(int number, String type) {
        add(number, type);
        String ReturnData;
        if (type.equals("iphone")) {
            if (this.products.iphoneQuantity() > 0) {
                ReturnData = "was notifyed that they are " + this.products.iphoneQuantity() + " iphones in store\n";
            } else {
                ReturnData = " was notifyed we dont have any iphones\n";
            }
        } else {
            if (this.products.samsungQuantity() > 0) {
                ReturnData = "was notifyed that they are " + this.products.samsungQuantity() + " samsungs in store\n";
            } else {
                ReturnData = " was notifyed we dont have any samsungs\n";
            }
        }
        return ReturnData;
    }
}
```

----

# Conclusion

In this laboratory work I've studied the Behavioral Design Patterns, and applied in a laboratory work some of them, globally adding them to update the whole project I have been working on this semester on TMPS course. So, the usefulness of using a design pattern is obvious. The design pattern can accelerate the development process. It provides proven development paradigms, which helps save time without having to reinvent patterns every time a problem arises.Because the design pattern is created to fix known problems, they can be predicted before they become visible during the implementation process. Again, the design pattern speeds up the development process. Standardization related to the design pattern is also very useful to facilitate code readability.

In short, the design pattern is useful when moving from an analysis model to a development model. It can be used in a concrete way in several cases, in particular for managing the payroll system when changing a salary and keeping the system informed of the changes this implies. Thanks to the design pattern, it is possible to document the solutions to be adopted based on previous practices and lessons learned. Several software components are used in the implementation of the design pattern. The model therefore speeds up a process that involves several components. Developers use the language they are familiar with in the application of each solution.

In software engineering, behavioral design patterns are design patterns that identify common communication patterns among objects. By doing so, these patterns increase flexibility in carrying out communication. Behavioral design patterns are concerned with algorithms and the assignment of responsibilities between objects. By understanding them, the quality of written code is getting higher which make a better coder from every worker. 

As a result of this laboratory work, I got familiar with the concepts of Behavioral Design Patterns, applied my theoretical knowledges into practical one, and finished the setting of simulation thematic I choose in the beggining of this study semester.