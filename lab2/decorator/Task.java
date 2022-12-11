package decorator;

public class Task {
    public static void main(String[] args) {
        Company company = new Department(new Subdepartment(new Employee()));

        System.out.println(company.makeJob());
    }
}
