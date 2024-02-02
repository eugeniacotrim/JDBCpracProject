I have created a database for a bakery with basic employee records and salaries. This database allows the admin to view the output on Eclipse and on the SQL server.

Under MySQL server, I created a database called bakeryEmp to be filled in with employee records and salary.

On Eclipse, I created a package with 3 classes:
- BakeryEmp class
The database columns were declared as global variables. A constructor was created for the variables to be accessed across the package. And Getter and Setter methods were created for each of the global variables in order for them to be initialized across the package.

- DB class
Different methods were created to: load the driver, create the connection, create employee records, display the result set, and to close the connection.

- Connection class
All the methods from the DB class were called here through a new instance of the class. The input data was provided for each employee one by one through a new instance of the BakeryEmp class, along with the Setter methods for each variable/column name.
