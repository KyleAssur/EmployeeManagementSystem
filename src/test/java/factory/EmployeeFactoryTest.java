package factory;

import domain.Employee;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/*
 * EmployeeFactoryTest class
 * Author: [Kyle Assur] ([219070091])
 */

class EmployeeFactoryTest {
    @Test
    void createEmployee() {
        Employee employee = EmployeeFactory.createEmployee("E001", "John", "Doe",
                "john.doe@company.com", LocalDate.now(), "D001", "P001");

        assertNotNull(employee);
        assertEquals("E001", employee.getEmployeeId());
        assertEquals("John", employee.getFirstName());
    }
}
