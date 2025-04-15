package repository;

import domain.Employee;
import factory.EmployeeFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.impl.EmployeeRepositoryImpl;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/*
 * EmployeeFactoryTest class
 * Author: [Kyle Assur] ([219070091])
 */

class EmployeeRepositoryTest {
    private EmployeeRepository repository;
    private LocalDate testDate = LocalDate.of(2025, 3, 15);

    @BeforeEach
    void setUp() {
        repository = EmployeeRepositoryImpl.getInstance();
        // Clear the repository before each test
        ((EmployeeRepositoryImpl) repository).clearForTesting();
    }

    @Test
    void createAndReadEmployee() {
        Employee employee = EmployeeFactory.createEmployee(
                "E001",
                "John",
                "Doe",
                "john.doe@company.com",
                testDate,
                "D001",
                "P001"
        );

        Employee created = repository.create(employee);
        Employee found = repository.read("E001");

        assertNotNull(created);
        assertNotNull(found);
        assertEquals(employee.getEmployeeId(), found.getEmployeeId());
        assertEquals("John", found.getFirstName());
        assertEquals("Doe", found.getLastName());
        assertEquals("D001", found.getDepartmentId());
    }

    @Test
    void updateEmployee() {
        // Create initial employee
        Employee employee = EmployeeFactory.createEmployee(
                "E002",
                "Jane",
                "Smith",
                "jane.smith@company.com",
                testDate,
                "D002",
                "P002"
        );
        repository.create(employee);

        // Update the employee
        Employee updated = new Employee.Builder()
                .employeeId("E002")
                .firstName("Jane")
                .lastName("Johnson") // Changed last name
                .email("jane.johnson@company.com") // Changed email
                .hireDate(testDate)
                .departmentId("D003") // Changed department
                .positionId("P002")
                .build();

        repository.update(updated);

        // Verify changes
        Employee found = repository.read("E002");
        assertEquals("Johnson", found.getLastName());
        assertEquals("jane.johnson@company.com", found.getEmail());
        assertEquals("D003", found.getDepartmentId());
    }

    @Test
    void deleteEmployee() {
        Employee employee = EmployeeFactory.createEmployee(
                "E003",
                "Bob",
                "Brown",
                "bob.brown@company.com",
                testDate,
                "D001",
                "P003"
        );

        repository.create(employee);
        assertTrue(repository.delete("E003"));
        assertNull(repository.read("E003"));
    }

    @Test
    void readNonExistentEmployee() {
        assertNull(repository.read("E999"));
    }

    @Test
    void deleteNonExistentEmployee() {
        assertFalse(repository.delete("E999"));
    }

    @Test
    void updateNonExistentEmployee() {
        Employee employee = new Employee.Builder()
                .employeeId("E999")
                .firstName("Non")
                .lastName("Existent")
                .email("none@company.com")
                .hireDate(testDate)
                .departmentId("D999")
                .positionId("P999")
                .build();

        assertNull(repository.update(employee));
    }
}