package factory;

import domain.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * PositionFactoryTest class
 * Author: (Ona-Odwa Faku) (222878746)
 */
class PositionFactoryTest {
    @Test
    void createPosition() {
        Position position = PositionFactory.createPosition(
                "P001",
                "Software Developer",
                "Develops software applications",
                "SG5"
        );

        assertNotNull(position);
        assertEquals("P001", position.getPositionId());
        assertEquals("Software Developer", position.getTitle());
        assertEquals("Develops software applications", position.getDescription());
        assertEquals("SG5", position.getSalaryGrade());
    }
}
