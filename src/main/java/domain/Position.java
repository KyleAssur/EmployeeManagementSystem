package domain;

/*
 * Position class
 * Author: (Ona-Odwa Faku) (222878746)

 */
public class Position {
    private String positionId;
    private String title;
    private String description;
    private String salaryGrade;

    private Position(Builder builder) {
        this.positionId = builder.positionId;
        this.title = builder.title;
        this.description = builder.description;
        this.salaryGrade = builder.salaryGrade;
    }

    // Getters for all fields

    public static class Builder {
        private String positionId;
        private String title;
        private String description;
        private String salaryGrade;

        // Builder methods for each field

        public Position build() {
            return new Position(this);
        }
    }
}

