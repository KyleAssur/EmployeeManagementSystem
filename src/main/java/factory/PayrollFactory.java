package factory;

import domain.Payroll;

import java.time.LocalDate;

/**
 * PayrollFactory class
 * Author: [Hadley Booysen] ([221447628])
 * Date: [04-18-2025]
 */
public class PayrollFactory {//factory pattern to create a payroll object using builder pattern

    public static Payroll createPayroll(String payrollId, String employeeId,
                                        double basicSalary, double bonuses,
                                        double deductions, LocalDate paymentDate) {
        return new Payroll.Builder().setPayrollId(payrollId)
                .setEmployeeId(employeeId)
                .setBasicSalary(basicSalary).setBonuses(bonuses)
                .setDeductions(deductions)
                .setPaymentDate(paymentDate).build();


    }
}
