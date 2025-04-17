package factory;
import domain.Department;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * DepartmentFactoryTest class
 * Author: (Ona-Odwa Faku) (222878746)
 */


public class DepartmentFactoryTest {

    @Test
    public void testCreateDepartment() {
        // Create a Department instance using the factory
        Department department = DepartmentFactory.createDepartment("D001", "IT Department");

        // Assertions
        assertNotNull(department, "Department should not be null");
        assertEquals("D001", department.getId(), "Department ID should match");
        assertEquals("IT Department", department.getName(), "Department name should match");
    }

    @Test
    public void testCreateDepartmentWithNullValues() {
        // Create a Department with null values
        Department department = DepartmentFactory.createDepartment(null, null);

        // Assertions
        assertNotNull(department, "Department should still be created");
        assertNull(department.getId(), "Department ID should be null");
        assertNull(department.getName(), "Department name should be null");
    }
}
