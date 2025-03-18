package repository;

import domain.Department;
import java.util.HashMap;
import java.util.Map;

public class DepartmentRepository implements IRepository<Department, String> {
    private final Map<String, Department> departmentDB = new HashMap<>();

    @Override
    public Department create(Department department) {
        departmentDB.put(department.getId(), department);
        return department;
    }

    @Override
    public Department read(String id) {
        return departmentDB.get(id);
    }

    @Override
    public Department update(Department department) {
        if (departmentDB.containsKey(department.getId())) {
            departmentDB.put(department.getId(), department);
            return department;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        return departmentDB.remove(id) != null;
    }
}
