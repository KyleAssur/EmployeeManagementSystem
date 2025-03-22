package repository;
import domain.Employee;
import java.util.HashMap;
import java.util.Map;

public class EmployeeRepository implements IRepository<Employee, String> {
    private final Map<String, Employee> employeeDB = new HashMap<>();

    @Override
    public Employee create(Employee employee) {
        employeeDB.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public Employee read(String id) {
        return employeeDB.get(id);
    }

    @Override
    public Employee update(Employee employee) {
        if (employeeDB.containsKey(employee.getId())) {
            employeeDB.put(employee.getId(), employee);
            return employee;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        return employeeDB.remove(id) != null;
    }
}

