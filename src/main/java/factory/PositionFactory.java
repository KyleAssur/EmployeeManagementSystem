package factory;

import domain.Position;

/*
 * PositionFactory class
 * Author: (Ona-Odwa Faku) (222878746)
 *
 */
public class PositionFactory {
    public static Position createPosition(String positionId, String title,
                                          String description, String salaryGrade) {
        return new Position.Builder()
                .positionId(positionId)
                .title(title)
                .description(description)
                .salaryGrade(salaryGrade)
                .build();
    }
}
