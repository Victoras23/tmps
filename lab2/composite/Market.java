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
