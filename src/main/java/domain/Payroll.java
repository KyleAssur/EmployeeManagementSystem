package domain;
//Payroll.java
/* Payroll model class
 * Author: [Hadley Booysen ] [221447628]
 * Date: [18-04-2025]
 */

import java.time.LocalDate;

public class Payroll {//start of class

    private String payrollId;
    private String employeeId;
    private double basicSalary;
    private double bonuses;
    private double deductions;
    private double netSalary;
    private LocalDate paymentDate;

    private Payroll(Builder builder) {
        this.payrollId = builder.payrollId;
        this.employeeId = builder.employeeId;
        this.basicSalary = builder.basicSalary;
        this.bonuses = builder.bonuses;
        this.deductions = builder.deductions;
        this.netSalary = builder.netSalary;
        this.paymentDate = builder.paymentDate;
    }

    public String getPayrollId() {
        return payrollId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getBonuses() {
        return bonuses;
    }

    public double getDeductions() {
        return deductions;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public double getNetSalary() {
        return netSalary;
    }
// Getters for all fields

    public static class Builder {//Builder pattern class
        private String payrollId;
        private String employeeId;
        private double basicSalary;
        private double bonuses;
        private double deductions;
        private double netSalary;
        private LocalDate paymentDate;

        // Builder methods for each field
        public Builder setPayrollId(String payrollId) {
            this.payrollId = payrollId;
            return this;
        }

        public Builder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder setBasicSalary(double basicSalary) {
            this.basicSalary = basicSalary;
            return this;
        }

        public Builder setBonuses(double bonuses) {
            this.bonuses = bonuses;
            return this;
        }

        public Builder setDeductions(double deductions) {
            this.deductions = deductions;
            return this;
        }

        public Builder setNetSalary(double netSalary) {
            this.netSalary = netSalary;
            return this;
        }

        public Builder setPaymentDate(LocalDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Payroll build() {
            this.netSalary = this.basicSalary + this.bonuses - this.deductions;
            return new Payroll(this);
        }
    }
}//end of class
