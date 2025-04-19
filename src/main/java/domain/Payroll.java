package domain;
import java.time.LocalDate;

/**
 * Payroll model class
 * Author: [Hadley Booysem] (221447628)
 * Date: [04-18-2025]
 */
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

    public double getBonuses() {
        return bonuses;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getDeductions() {
        return deductions;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }
//implementation of the builder pattern.
    //return an instance of an payroll entity
    public static class Builder {
        private String payrollId;
        private String employeeId;
        private double basicSalary;
        private double bonuses;
        private double deductions;
        private double netSalary;
        private LocalDate paymentDate;

        public Builder setPayrollId(String payrollId) {
            this.payrollId = payrollId;
            return this;
        }

        public Builder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder setBonuses(double bonuses) {
            this.bonuses = bonuses;
            return this;
        }

        public Builder setBasicSalary(double basicSalary) {
            this.basicSalary = basicSalary;
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
}//end class
