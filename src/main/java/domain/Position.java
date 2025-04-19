package domain;

/*
 * Position class
 * Author: (Ona-Odwa Faku) (222878746)

 */

public class Position {
    private final String positionId;
    private final String title;
    private final String description;
    private final String salaryGrade;

    private Position(Builder builder) {
        this.positionId = builder.positionId;
        this.title = builder.title;
        this.description = builder.description;
        this.salaryGrade = builder.salaryGrade;
    }

    // Getters
    public String getPositionId() {
        return positionId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSalaryGrade() {
        return salaryGrade;
    }

    // Builder class
    public static class Builder {
        private String positionId;
        private String title;
        private String description;
        private String salaryGrade;

        public Builder positionId(String positionId) {
            this.positionId = positionId;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder salaryGrade(String salaryGrade) {
            this.salaryGrade = salaryGrade;
            return this;
        }

        public Position build() {
            return new Position(this);
        }
    }
}

