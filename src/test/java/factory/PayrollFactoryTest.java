package factory;

import domain.Payroll;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * PayrollFactoryTest class
 * Author: [Hadley Booysen] (221447628)
 * Date: [04-18-2025]
 */
class PayrollFactoryTest {//start class
    @Test
    void createPayroll() {
        LocalDate paymentDate = LocalDate.of(2025, 3, 31);
        Payroll payroll = PayrollFactory.createPayroll(
                "PY001",
                "E001",
                25000.00,
                5000.00,
                3000.00,
                paymentDate
        );

        assertNotNull(payroll);
        assertEquals("PY001", payroll.getPayrollId());
        assertEquals("E001", payroll.getEmployeeId());
        assertEquals(25000.00, payroll.getBasicSalary(), 0.001);
        assertEquals(5000.00, payroll.getBonuses(), 0.001);
        assertEquals(3000.00, payroll.getDeductions(), 0.001);
        assertEquals(27000.00, payroll.getNetSalary(), 0.001); // 25000 + 5000 - 3000
        assertEquals(paymentDate, payroll.getPaymentDate());
    }
}//end class
