package domain;

public class Employee {
    private final String id;
    private final String name;
    private final String position;
    private final double salary;

    private Employee(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.position = builder.position;
        this.salary = builder.salary;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }

    public static class Builder {
        private String id, name, position;
        private double salary;

        public Builder setId(String id) { this.id = id; return this; }
        public Builder setName(String name) { this.name = name; return this; }
        public Builder setPosition(String position) { this.position = position; return this; }
        public Builder setSalary(double salary) { this.salary = salary; return this; }

        public Employee build() { return new Employee(this); }
    }
}
