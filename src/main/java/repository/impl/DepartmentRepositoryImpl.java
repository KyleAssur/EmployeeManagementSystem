package repository.impl;

import domain.Department;
import repository.DepartmentRepository;
import java.util.HashMap;
import java.util.Map;

/**
 * DepartmentRepository implementation
 * Author: [Chad Assur] ([222314834])
 */
public class DepartmentRepositoryImpl implements DepartmentRepository {
    private static DepartmentRepositoryImpl instance = null;
    private Map<String, Department> departments;

    private DepartmentRepositoryImpl() {
        this.departments = new HashMap<>();
    }

    public static synchronized DepartmentRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new DepartmentRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Department create(Department department) {
        departments.put(department.getDepartmentId(), department);
        return department;
    }

    @Override
    public Department read(String departmentId) {
        return departments.get(departmentId);
    }

    @Override
    public Department update(Department department) {
        departments.put(department.getDepartmentId(), department);
        return department;
    }

    @Override
    public boolean delete(String departmentId) {
        return departments.remove(departmentId) != null;
    }
}

