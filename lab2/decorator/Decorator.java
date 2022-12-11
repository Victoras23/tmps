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
