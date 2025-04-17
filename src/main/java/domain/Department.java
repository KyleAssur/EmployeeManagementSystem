package domain;

/**
 * Department model class
 * Author: [Chad Assur] ([222314834])
 */
public class Department {
    private String departmentId;
    private String name;
    private String location;

    private Department(Builder builder) {
        this.departmentId = builder.departmentId;
        this.name = builder.name;
        this.location = builder.location;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public static class Builder {
        private String departmentId;
        private String name;
        private String location;

        public Builder departmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Department build() {
            return new Department(this);
        }
    }
}


