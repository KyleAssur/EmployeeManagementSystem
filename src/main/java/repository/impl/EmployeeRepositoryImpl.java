package repository.impl;

import domain.Employee;
import repository.EmployeeRepository;
import java.util.HashMap;
import java.util.Map;

/*
 * EmployeeFactoryTest class
 * Author: [Kyle Assur] ([219070091])
 */

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static EmployeeRepositoryImpl instance = null;
    private Map<String, Employee> employees;

    private EmployeeRepositoryImpl() {
        this.employees = new HashMap<>();
    }

    public static synchronized EmployeeRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new EmployeeRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Employee create(Employee employee) {
        employees.put(employee.getEmployeeId(), employee);
        return employee;
    }

    @Override
    public Employee read(String employeeId) {
        return employees.get(employeeId);
    }

    @Override
    public Employee update(Employee employee) {
        if (employees.containsKey(employee.getEmployeeId())) {
            employees.put(employee.getEmployeeId(), employee);
            return employee;
        }
        return null;
    }

    @Override
    public boolean delete(String employeeId) {
        return employees.remove(employeeId) != null;
    }

    /*
     * Helper method for testing - clears all employees from the repository
     * This should ONLY be used in test classes
     */

    public void clearForTesting() {
        employees.clear();
    }
}