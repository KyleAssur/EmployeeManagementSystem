package domain;

public class Department {
    private final String id;
    private final String name;

    private Department(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    public static class Builder {
        private String id, name;

        public Builder setId(String id) { this.id = id; return this; }
        public Builder setName(String name) { this.name = name; return this; }

        public Department build() { return new Department(this); }
    }
}

