package decorator;

public class Department extends Decorator {
    public Department(Company company) {
        super(company);
    }

    public String HasSubdepartments() {
        return "Send tasks to subdepartments \n";
    }

    @Override
    public String makeJob() {
        return HasSubdepartments() + super.makeJob();
    }
}
