package factory;
import domain.Department;
/*
 * PositionRepositoryTest class
 * Author: (Ona-Odwa Faku) (222878746)
 */



public class DepartmentFactory {

    public static Department createDepartment(String id, String name) {
        return new Department.Builder()
                .setId(id)
                .setName(name)
                .build();
    }

}
