package factory;

import domain.Employee;

public class EmployeeFactory {

    public static Employee createEmployee(String id, String name, String position, double salary) {
        return new Employee.Builder()
                .setId(id)
                .setName(name)
                .setPosition(position)
                .setSalary(salary)
                .build();
    }

}