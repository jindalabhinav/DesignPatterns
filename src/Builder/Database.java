package Builder;

import lombok.Getter;

@Getter
public class Database {
    private String name;
    private String username;
    private String password;
    private Integer port;
    private DatabaseType type;
    private Boolean isCompressed;

    // Step 1 - Hide the constructor
    private Database() {}

    // To avoid using the new keyword, static initializer of Database.Builder object
    public static Builder builder() {
        return new Builder();
    }

    // Step 2 - Create a static inner class with the same fields as outer class
    // These fields will be used to set the Outer class private fields, and is used for Immutability
    public static class Builder {
        private String name;
        private String username;
        private String password;
        private Integer port;
        private DatabaseType type;
        private Boolean isCompressed;

        // Step 3 - Create fluent interfaces for setter
        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCredentials(String username, String password) {
            this.username = username;
            this.password = password;
            return this;
        }

        public Builder port(Integer port) {
            this.port = port;
            return this;
        }

        public Builder mySql() {
            this.type = DatabaseType.MY_SQL;
            return this;
        }

        public Builder postgres() {
            this.type = DatabaseType.POSTGRES;
            return this;
        }

        public Builder isCompressed(Boolean isCompressed) {
            this.isCompressed = isCompressed;
            return this;
        }

        // Step 4 - Create a build method to build and return an object of the outer class
        public Database build() {
            if (!isValid()) {
                throw new IllegalArgumentException("Invalid Database Configuration");
            }

            Database db = new Database();
            db.name = name;
            db.username = username;
            db.password = password;
            db.port = port;
            db.type = type;
            db.isCompressed = isCompressed;

            return db;
        }

        // Any validation needed while setting up the Outer Class Object
        private boolean isValid() {
            if (type == DatabaseType.MY_SQL && port != 3306) {
                return false;
            }
            if (type == DatabaseType.POSTGRES && port != 5432) {
                return false;
            }
            return true;
        }
    }
}
