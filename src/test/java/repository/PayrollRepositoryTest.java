package repository;

import domain.Payroll;
import factory.PayrollFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.impl.PayrollRepositoryImpl;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PayrollRepositoryTest class
 * Author: [Hadley Booysen] (221447628
 * Date: [04-18-2925]
 */
class PayrollRepositoryTest {//start class
    private PayrollRepository repository;
    private LocalDate testDate = LocalDate.of(2025, 3, 31);

    @BeforeEach
    void setUp() {
        repository = PayrollRepositoryImpl.getInstance();

        ((PayrollRepositoryImpl) repository).clearForTesting();
    }

    @Test
    void createAndReadPayroll() {
        Payroll payroll = PayrollFactory.createPayroll(
                "PY002",
                "E002",
                30000.00,
                2000.00,
                1500.00,
                testDate
        );

        Payroll created = repository.create(payroll);
        Payroll found = repository.read("PY002");

        assertNotNull(created);
        assertNotNull(found);
        assertEquals(payroll.getPayrollId(), found.getPayrollId());
        assertEquals(30500.00, found.getNetSalary(), 0.001); // 30000 + 2000 - 1500
    }

    @Test
    void updatePayroll() {
        Payroll payroll = PayrollFactory.createPayroll(
                "PY003",
                "E003",
                20000.00,
                1000.00,
                500.00,
                testDate
        );

        repository.create(payroll);

        Payroll updated = new Payroll.Builder()
                .setPayrollId("PY003")
                .setEmployeeId("E003")
                .setBasicSalary(22000.00)
                .setBonuses(1500.00)
                .setDeductions(800.00)
                .build();


        repository.update(updated);

        Payroll found = repository.read("PY003");
        assertEquals(22000.00, found.getBasicSalary(), 0.001);
        assertEquals(22700.00, found.getNetSalary(), 0.001); // 22000 + 1500 - 800
    }

    @Test
    void deletePayroll() {
        Payroll payroll = PayrollFactory.createPayroll(
                "PY004",
                "E004",
                18000.00,
                0.00,
                200.00,
                testDate
        );

        repository.create(payroll);
        assertTrue(repository.delete("PY004"));
        assertNull(repository.read("PY004"));
    }
}//edn class
