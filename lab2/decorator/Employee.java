package decorator;

public class Employee implements Company {
    @Override
    public String makeJob() {
        return "Employee works";
    }
}
