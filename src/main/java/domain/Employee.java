package domain;

import java.time.LocalDate;

/*
 * EmployeeFactoryTest class
 * Author: [Kyle Assur] ([219070091])
 */

public class Employee {
    private final String employeeId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final LocalDate hireDate;
    private final String departmentId;
    private final String positionId;

    private Employee(Builder builder) {
        this.employeeId = builder.employeeId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.hireDate = builder.hireDate;
        this.departmentId = builder.departmentId;
        this.positionId = builder.positionId;
    }

    // Getters for all fields
    public String getEmployeeId() { return employeeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public LocalDate getHireDate() { return hireDate; }
    public String getDepartmentId() { return departmentId; }
    public String getPositionId() { return positionId; }

    public static class Builder {
        private String employeeId;
        private String firstName;
        private String lastName;
        private String email;
        private LocalDate hireDate;
        private String departmentId;
        private String positionId;

        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder hireDate(LocalDate hireDate) {
            this.hireDate = hireDate;
            return this;
        }

        public Builder departmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Builder positionId(String positionId) {
            this.positionId = positionId;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}