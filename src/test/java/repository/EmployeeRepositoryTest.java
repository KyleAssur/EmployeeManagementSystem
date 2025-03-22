package repository;


import domain.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeRepositoryTest {
    private EmployeeRepository repository;
    private Employee employee;

    @BeforeEach
    void setUp() {
        repository = new EmployeeRepository();
        employee = new Employee.Builder()
                .setId("E001")
                .setName("John Doe")
                .setPosition("Software Engineer")
                .setSalary(85000)
                .build();
    }

    @Test
    void testCreate() {
        Employee created = repository.create(employee);
        assertNotNull(created);
        assertEquals("John Doe", created.getName());
    }

    @Test
    void testRead() {
        repository.create(employee);
        Employee readEmployee = repository.read("E001");
        assertNotNull(readEmployee);
        assertEquals("Software Engineer", readEmployee.getPosition());
    }

    @Test
    void testUpdate() {
        repository.create(employee);
        Employee updatedEmployee = new Employee.Builder()
                .setId("E001")
                .setName("Jane Doe")
                .setPosition("Senior Engineer")
                .setSalary(95000)
                .build();

        repository.update(updatedEmployee);
        Employee fetched = repository.read("E001");
        assertNotNull(fetched);
        assertEquals("Jane Doe", fetched.getName());
    }

    @Test
    void testDelete() {
        repository.create(employee);
        assertTrue(repository.delete("E001"));
        assertNull(repository.read("E001"));
    }
}
