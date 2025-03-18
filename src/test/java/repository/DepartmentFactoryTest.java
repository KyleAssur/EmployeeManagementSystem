package repository;

import domain.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DepartmentRepositoryTest {
    private DepartmentRepository repository;
    private Department department;

    @BeforeEach
    void setUp() {
        repository = new DepartmentRepository();
        department = new Department.Builder()
                .setId("D001")
                .setName("IT Department")
                .build();
    }

    @Test
    void testCreate() {
        Department created = repository.create(department);
        assertNotNull(created);
        assertEquals("IT Department", created.getName());
    }

    @Test
    void testRead() {
        repository.create(department);
        Department readDepartment = repository.read("D001");
        assertNotNull(readDepartment);
        assertEquals("IT Department", readDepartment.getName());
    }

    @Test
    void testUpdate() {
        repository.create(department);
        Department updatedDepartment = new Department.Builder()
                .setId("D001")
                .setName("Human Resources")
                .build();

        repository.update(updatedDepartment);
        Department fetched = repository.read("D001");
        assertNotNull(fetched);
        assertEquals("Human Resources", fetched.getName());
    }

    @Test
    void testDelete() {
        repository.create(department);
        assertTrue(repository.delete("D001"));
        assertNull(repository.read("D001"));
    }
}

