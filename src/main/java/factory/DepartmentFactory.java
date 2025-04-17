package factory;

import domain.Department;
/*
 * PositionRepositoryTest class
 * Author: (Ona-Odwa Faku) (222878746)
 */



/**
 * DepartmentFactory class
 * Author: [Chad Assur] ([222314834])
 */
public class DepartmentFactory {
    public static Department createDepartment(String departmentId, String name, String location) {
        return new Department.Builder()
                .departmentId(departmentId)
                .name(name)
                .location(location)
                .build();
    }
}

