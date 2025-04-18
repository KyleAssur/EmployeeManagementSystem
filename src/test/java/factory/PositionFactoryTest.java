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
    void createPosition_ShouldReturnPositionWithCorrectAttributes() {
        // Arrange
        String expectedId = "P001";
        String expectedTitle = "Software Developer";
        String expectedDescription = "Develops applications";
        String expectedGrade = "SG5";

        // Act
        Position position = PositionFactory.createPosition(
                expectedId,
                expectedTitle,
                expectedDescription,
                expectedGrade
        );

        // Assert
        assertNotNull(position, "Position should not be null");
        assertEquals(expectedId, position.getPositionId(), "Position ID should match");
        assertEquals(expectedTitle, position.getTitle(), "Title should match");
        assertEquals(expectedDescription, position.getDescription(), "Description should match");
        assertEquals(expectedGrade, position.getSalaryGrade(), "Salary grade should match");
    }

    @Test
    void createPosition_WithNullValues_ShouldHandleGracefully() {
        // Act
        Position position = PositionFactory.createPosition(
                null,
                null,
                null,
                null
        );

        // Assert
        assertNotNull(position, "Position should still be created");
        assertNull(position.getPositionId(), "Position ID should be null");
        assertNull(position.getTitle(), "Title should be null");
        assertNull(position.getDescription(), "Description should be null");
        assertNull(position.getSalaryGrade(), "Salary grade should be null");
    }
}