package Builder.BuilderEnhanced;

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
        // Enhancement! Now we don't have to replicate the Main Class attributes again which could've allowed data inconsistency.
        // Using 'final' because we don't want to allow database getting initialized again
        private final Database database;

        public Builder() {
            database = new Database();
        }

        // Step 3 - Create fluent interfaces for setter
        public Builder withName(String name) {
            this.database.name = name;
            return this;
        }

        public Builder withCredentials(String username, String password) {
            this.database.username = username;
            this.database.password = password;
            return this;
        }

        public Builder port(Integer port) {
            this.database.port = port;
            return this;
        }

        public Builder mySql() {
            this.database.type = DatabaseType.MY_SQL;
            return this;
        }

        public Builder postgres() {
            this.database.type = DatabaseType.POSTGRES;
            return this;
        }

        public Builder isCompressed(Boolean isCompressed) {
            this.database.isCompressed = isCompressed;
            return this;
        }

        // Step 4 - Create a build method to build and return an object of the outer class
        public Database build() {
            if (!isValid()) {
                throw new IllegalArgumentException("Invalid Database Configuration");
            }

            /*
                The code snippet below is still necessary because it ensures that a new, separate instance of the Database class is created each time the build method is called. Here's why this is important:
                Immutability: By returning a new object each time from the build method, you ensure that the constructed Database object cannot be modified externally once it's created. This is crucial for maintaining data integrity and preventing unexpected changes to the object's state.
                Thread Safety: If multiple threads are concurrently calling the build method, each thread gets its own separate instance of the Database object, avoiding potential race conditions or shared state issues.
                Clear Intent: Returning a fresh object from the build method clearly communicates that the purpose of the method is to create a new object, not modify an existing one.
                Validation: In this example, we have a validation check in the isValid method. By creating a new object in the build method, we ensure that the object is only constructed if it meets the specified validation criteria.
             */
            Database db = new Database();
            db.name = database.name;
            db.username = database.username;
            db.password = database.password;
            db.port = database.port;
            db.type = database.type;
            db.isCompressed = database.isCompressed;

            return db;
        }

        // Any validation needed while setting up the Outer Class Object
        private boolean isValid() {
            if (database.type == DatabaseType.MY_SQL && database.port != 3306) {
                return false;
            }
            if (database.type == DatabaseType.POSTGRES && database.port != 5432) {
                return false;
            }
            return true;
        }
    }
}
