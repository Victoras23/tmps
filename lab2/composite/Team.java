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
