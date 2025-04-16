package repository;

import domain.Department;
import factory.DepartmentFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.impl.DepartmentRepositoryImpl;
import static org.junit.jupiter.api.Assertions.*;

/**
 * DepartmentRepositoryTest class
 * Author: [Chad Assur] ([222314834])
 */
class DepartmentRepositoryTest {
    private DepartmentRepository repository;

    @BeforeEach
    void setUp() {
        repository = DepartmentRepositoryImpl.getInstance();
    }

    @Test
    void create() {
        Department department = DepartmentFactory.createDepartment("D001", "HR", "Building B");
        Department created = repository.create(department);

        assertNotNull(created);
        assertEquals(department.getDepartmentId(), created.getDepartmentId());
    }

    @Test
    void read() {
        Department department = DepartmentFactory.createDepartment("D002", "Finance", "Building C");
        repository.create(department);

        Department found = repository.read("D002");
        assertNotNull(found);
        assertEquals("Finance", found.getName());
    }

    // Additional test methods for update and delete
}


