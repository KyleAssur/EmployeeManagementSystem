package repository;

import domain.Position;
import factory.PositionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.impl.PositionRepositoryImpl;
import static org.junit.jupiter.api.Assertions.*;

/*
 * PositionRepositoryTest class
 * Author: (Ona-Odwa Faku) (222878746)
 */
class PositionRepositoryTest {
    private PositionRepository repository;

    @BeforeEach
    void setUp() {
        repository = PositionRepositoryImpl.getInstance();
        // Clear the repository before each test
        ((PositionRepositoryImpl) repository).clearForTesting();
    }

    @Test
    void createAndReadPosition() {
        Position position = PositionFactory.createPosition(
                "P002",
                "HR Manager",
                "Manages HR department",
                "SG7"
        );

        Position created = repository.create(position);
        Position found = repository.read("P002");

        assertNotNull(created);
        assertNotNull(found);
        assertEquals(position.getPositionId(), found.getPositionId());
        assertEquals("HR Manager", found.getTitle());
    }

    @Test
    void updatePosition() {
        Position position = PositionFactory.createPosition(
                "P003",
                "Accountant",
                "Handles finances",
                "SG6"
        );

        repository.create(position);

        Position updated = new Position.Builder()
                .positionId("P003")
                .title("Senior Accountant")
                .description("Handles company finances")
                .salaryGrade("SG7")
                .build();

        repository.update(updated);

        Position found = repository.read("P003");
        assertEquals("Senior Accountant", found.getTitle());
        assertEquals("SG7", found.getSalaryGrade());
    }

    @Test
    void deletePosition() {
        Position position = PositionFactory.createPosition(
                "P004",
                "Intern",
                "Learning the ropes",
                "SG1"
        );

        repository.create(position);
        assertTrue(repository.delete("P004"));
        assertNull(repository.read("P004"));
    }
}
