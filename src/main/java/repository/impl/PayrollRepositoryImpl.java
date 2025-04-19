package repository.impl;

import domain.Payroll;
import repository.PayrollRepository;
import java.util.HashMap;
import java.util.Map;

/**
 * PayrollRepository implementation
 * Author: [Hadley Booysen] (221447628
 * Date: [04-18-2025]
 *
 * Implementation of the payrollrepository functions
 */
public class PayrollRepositoryImpl implements PayrollRepository {
    private static PayrollRepositoryImpl instance = null;
    private Map<String, Payroll> payrolls;

    private PayrollRepositoryImpl() {
        this.payrolls = new HashMap<>();
    }

    public static synchronized PayrollRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new PayrollRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Payroll create(Payroll payroll) {
        payrolls.put(payroll.getPayrollId(), payroll);
        return payroll;
    }

    @Override
    public Payroll read(String payrollId) {
        return payrolls.get(payrollId);
    }

    @Override
    public Payroll update(Payroll payroll) {
        payrolls.put(payroll.getPayrollId(), payroll);
        return payroll;
    }

    @Override
    public boolean delete(String payrollId) {
        return payrolls.remove(payrollId) != null;
    }

    // Helper method for testing
    public void clearForTesting() {
        payrolls.clear();
    }
}//end class