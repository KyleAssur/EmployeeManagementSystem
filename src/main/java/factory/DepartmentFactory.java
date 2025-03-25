package factory;
import domain.Department;

public class DepartmentFactory {

    public static Department createDepartment(String id, String name) {
        return new Department.Builder()
                .setId(id)
                .setName(name)
                .build();
    }

}
