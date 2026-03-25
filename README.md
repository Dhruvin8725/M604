***

### **Setup and Execution Guide: Car Rental Management System**

**1. System Prerequisites**
Ensure the following software is installed and properly configured on the host machine before proceeding:
* **Java Development Kit (JDK):** Version 17 or higher.
* **PostgreSQL:** Installed and running locally on the default port (5432).
* **Apache Maven:** For resolving project dependencies and building the application.
* **Web Browser:** A modern browser (e.g., Chrome, Firefox, Edge) to interact with the frontend interface.

**2. Database Initialization**
The application utilizes Hibernate to automatically generate its database schema (tables and columns). However, a blank database must be created manually first.
1. Open the PostgreSQL command line interface (`psql`) or a graphical administration tool such as pgAdmin.
2. Execute the following SQL command to provision the required database: 
   `CREATE DATABASE car_rental_db;`
3. Verify that the database has been created successfully. 

**3. Application Configuration**
Before compiling and running the project, the application must be configured with the correct local database credentials.
1. Navigate to the project directory and locate the configuration file at: `src/main/resources/application.properties`.
2. Open the file in a text editor and locate the data source configuration block.
3. Update the `spring.datasource.password` property to match the password of your local PostgreSQL `postgres` user. 
   *(Example: `spring.datasource.password=admin123`)*
4. Save the changes and close the file.

**4. Project Execution**
The application can be launched either through an Integrated Development Environment (IDE) or directly via the command line.
* **Method A (Command Line / Terminal):** Open a terminal, navigate to the root folder of the project (where the `pom.xml` file is located), and execute the following Maven command: 
    `mvn spring-boot:run`
* **Method B (IDE):** Import the folder as a standard Maven project into your preferred IDE (such as IntelliJ IDEA or Eclipse). Locate the main executable class at `src/main/java/com/carrental/system/SystemApplication.java`, right-click the file, and select "Run".

**5. Verification and Usage**
The Spring Boot application includes an embedded Apache Tomcat server that handles backend routing and serves the frontend static files.
1. Monitor the execution terminal. The application is ready when the console outputs a message similar to: *"Started SystemApplication in [X] seconds"*.
2. Upon its initial execution, a custom `CommandLineRunner` script will automatically detect the empty database and populate it with default vehicle records for immediate testing.
3. Open your web browser and navigate to the application dashboard at: **`http://localhost:8080`**
4. From this interface, you may fully test the Create, Read, Update, and Delete (CRUD) operations, which will actively persist data to the underlying PostgreSQL database.

***
