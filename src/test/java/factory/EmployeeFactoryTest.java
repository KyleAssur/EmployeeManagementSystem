package factory;

import domain.Employee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeFactoryTest {
    @Test
    public void testCreateEmployee() {
        Employee employee = EmployeeFactory.createEmployee("101", "John Doe", "Manager", 75000);
        assertNotNull(employee);
        assertEquals("John Doe", employee.getName());
    }
}
