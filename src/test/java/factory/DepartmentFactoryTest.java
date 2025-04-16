package factory;

import domain.Department;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * DepartmentFactoryTest class
 Author: [Chad Assur] ([222314834])
 */
class DepartmentFactoryTest {
    @Test
    void createDepartment() {
        Department department = DepartmentFactory.createDepartment("D001", "IT", "Building A");

        assertNotNull(department);
        assertEquals("D001", department.getDepartmentId());
        assertEquals("IT", department.getName());
        assertEquals("Building A", department.getLocation());
    }
}

