package decorator;

public class Subdepartment extends Decorator {
    public Subdepartment(Company company) {
        super(company);
    }

    public String HasEmployes() {
        return "Send tasks to employees \n";
    }

    @Override
    public String makeJob() {
        return HasEmployes() + super.makeJob();
    }
}
