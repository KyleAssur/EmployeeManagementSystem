package factory;

import domain.Employee;
import java.time.LocalDate;

/*
 * EmployeeFactoryTest class
 * Author: [Kyle Assur] ([219070091])
 */

public class EmployeeFactory {
    public static Employee createEmployee(String employeeId, String firstName, String lastName,
                                          String email, LocalDate hireDate, String departmentId,
                                          String positionId) {
        return new Employee.Builder()
                .employeeId(employeeId)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .hireDate(hireDate)
                .departmentId(departmentId)
                .positionId(positionId)
                .build();
    }
}