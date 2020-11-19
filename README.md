Coverage: 87.3%
# IMS Project

This IMS (inventory management system) software is used to create a database to store customers, items and customers' orders of those items. Customers are stored in the database with their first and last names. Items are stored with their name and cost. Orders are stored with a key referencing a customer. The links between orders and items are stored in a separate table, named orders_items, which references keys in the orders and items tables. Customers, orders and items can be created, read, updated and deleted through the software.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

In order to get a copy of the project running on your local machine, you must have the following prerequisites.

1. An IDE. It is strongly recommended that you use [Eclipse](https://www.eclipse.org/downloads/), as it comes with Maven.
2. [JDK version 8](https://www.oracle.com/uk/java/technologies/javase/javase-jdk8-downloads.html). You may need to [set up environment variables](https://docs.oracle.com/javase/7/docs/webnotes/install/windows/jdk-installation-windows.html#path).
3. A MySQL Database running on localhost. It is recommended that you use [MySQL Workbench](https://www.mysql.com/products/workbench/) to do this, but a guide on how to do it without MySQL Workbench can be found [here](https://dev.mysql.com/doc/mysql-getting-started/en/).
4. If you did not choose to use Eclipse, you will need to use [Maven 3.6.3](http://maven.apache.org/) for dependency management. This was also used to construct the jar with dependencies. You may need to [set up environment variables](https://maven.apache.org/install.html).
5. In order to clone the repository, you will need [Git](https://git-scm.com/downloads).

### Installing

This is a step by step guide how to get a development environment running after you have all of the prerequisites.

1. Navigate to the folder in which you would like to set up the project, in either Command Line or Git Bash.
2. Clone the repository using the following command.

```
git clone https://github.com/sgoddardqa/IMS.git
```

3. Import the project into your IDE. In order to do this in Eclipse:
    1. Select *File*, then *Import* in the top left corner.
    2. When the **Import** window appears, select *Maven*, then *Existing Maven Projects*.
    3. In the next window, seelct *Browse...*, and navigate to the folder you cloned the repository to.
    4. Select *Finish* to import the project.

### Project Functionality

This section gives an overview of the project's functionality, and how to use it.

When the program is started, it will first ask the user for a username and password. The user should enter the username and password for their MySQL database running on their localhost.

```
What is your username
> root
What is your password
> root
```

After a username and password have been entered, the main menu will load up. This will offer four options: `CUSTOMER`, `ITEM`, `ORDER` and `STOP`. The user can select one of these options by typing them in. The first three options will open up the customer, item and order menus respectively, and `STOP` will exit the program.

```
Which entity would you like to use?
CUSTOMER: Information about customers
ITEM: Individual Items
ORDER: Purchases of items
STOP: To close the application
```

The customer, item and order menus are all similar, as they share the same options: `CREATE`, `READ`, `UPDATE`, `DELETE` and `RETURN`. The user can select one of these options by typing them in. The first four options will allow for the user to create, read, update or delete entries from the database respectively, and `RETURN` will return the user to the main menu.

```
What would you like to do with customer:
CREATE: To save a new entity into the database
READ: To read an entity from the database
UPDATE: To change an entity already in the database
DELETE: To remove an entity from the database
RETURN: To return to domain selection
```

If the user selects `CREATE` on one of these menus, they will be prompted to enter information about the entry they would like to add to the database. For a customer, this is a first and last name. For an item, this is the item's name and cost. For an order, this is the ID of the customer associated with that order, and the IDs of the items in that order. After the user enters this information, the entry will be added to the database and the user will be returned to the menu they were previously on.

```
> CREATE
Please enter a first name
> Elton
Please enter a surname
> John
Customer created
```

If the user selects `READ` on one of these menus, they will be shown a list of all entries in the database of that type. For customers, this is an ID, a first name and a surname. For items, this is an ID, an item name and a cost. For orders, this is an ID, the ID of the associated customer, a list of the IDs of the items in the order, and the total cost of items in that order. The user will then be returned to the menu they were previously on.

```
> READ
id:1, first name:Elton, surname:John
```

If the user selects `UPDATE` on one of these menus, they will be prompted to enter an ID for the entry in the database which they want to update. They will then be prompted to enter the information they want to update for that entry. For a customer, this is a first and last name. For an item, this is the item's name and cost. For an order, this is the ID of the customer associated with that order, the IDs of any items they want to remove from that order, and the IDs of any items they want to add to that order. After the user enters this information, the entry will be updated in the database, and the user will be returned to the menu they were previously on.

```
> UPDATE
Please enter the id of the customer you would like to update
> 1
Please enter a first name
> Henry
Please enter a surname
> Tudor
Customer Updated
```

If the user selects `DELETE` on one of these menus, they will be prompted to enter the ID of the entry in the database which they want to delete. The entry with that ID will then be deleted from the database, and the user will be returned to the menu they were previously on.

```
> DELETE
Please enter the id of the customer you would like to delete
> 1
```

## Running the tests

This project comes with a collection of automated tests, which make use of JUnit and Mockito. Tests are organised into test classes, and each test class is responsible for testing the functionality of one class in the project. These test classes can easily be run in Eclipse by right clicking on them and selecting *Run As*, and then *JUnit Test*. To view the coverage of the tests, select *Coverage As* instead, and then *JUnit Test*. You can run all of the tests at once by right clicking on the `src/test/java` file instead of an individual test class.

### Unit Tests 

Unit tests, making use of JUnit, are used to test the functionality of the `Customer`, `Item` and `Order` classes, as well as some of the functionality of the `CustomerDAO`, `ItemDAO` and `OrderDAO` classes.

For the `Customer`, `Item` and `Order` classes, unit tests were used because these classes are relatively low-level, and do not use other classes in the project. They can be tested by running the `CustomerTest`, `ItemTest` and `OrderTest` test classes.

The following is an example of one of these unit tests, in `CustomerTest`, to test the functionality of the `setFirstName()` function in `Customer`:

```
	@Test
	public void setFirstNameTest() {
		Customer customer = new Customer("James", "May");
		customer.setFirstName("Theresa");
		assertTrue(customer.getFirstName().equals("Theresa"));
	}
```

For the `CustomerDAO`, `ItemDAO` and `OrderDAO` classes, unit tests were also used, as these classes are also relatively low level, only using the fairly simple `Customer`, `Item` and `Order` classes respectively, and the `DBUtils` class. Most of the functionality of these classes can be tested by running the `CustomerDAOTest`, `ItemDAOTest` and `OrderDAOTest` test classes, however, not all of it can. Integration tests were needed to test the functionality of the exception handling in these classes.

The following is an example of another unit test, in `CustomerDAOTest`, to test the functionality of the `create()` function in `CustomerDAO`.

```
	@Test
	public void testCreate() {
		final Customer created = new Customer(2L, "chris", "perrins");
		assertEquals(created, DAO.create(created));
	}
```

### Integration Tests 
Integration tests, making use of Mockito, are used to test some of the functionality of the `CustomerDAO`, `ItemDAO` and `OrderDAO` classes, as well as the functionality of the `CustomerController`, `ItemController` and `OrderController` classes, and the functionality of the `Domain` and `Action` enums.

For the `CustomerDAO`, `ItemDAO` and `OrderDAO` classes, integration tests were used to test the functionality of the error handing. This was done by mocking the DBUtils class to intentionally throw exceptions. These particular tests can be run by running the `CustomerDAOExceptionsTest`, `ItemDAOExceptionsTest` and `OrderDAOExceptionsTest` test classes.

The following is an example of an integration test, in `CustomerDAOExceptionsTest`, being used to test the exception handling of the function `create()` in `CustomerDAO`. `customerDao` is an instance of the class `CustomerDAO`, into which a mock of the `DBUtils` class has been injected:

```
@Test
	public void createExceptionTest() {
		Customer customer = new Customer("Stephen", "Fry");
		assertNull(customerDao.create(customer));
	}
```

For the `CustomerController`, `ItemController` and `OrderController` classes, integration tests were used, as these classes are relatively high-level, and use multiple other classes in the project. The functionality of these classes can be tested by running the `CustomerControllerTest`, `ItemControllerTest` and `OrderControllerTest` test classes.

The following is another example of an integration test, in `CustomerControllerTest`, to test the functionality of the `create()` method in `CustomerController`:

```
	@Test
	public void testCreate() {
		final String F_NAME = "barry", L_NAME = "scott";
		final Customer created = new Customer(F_NAME, L_NAME);

		Mockito.when(utils.getString()).thenReturn(F_NAME, L_NAME);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
```

For the `Domain` and `Action` enums, integration tests were used to test some of their functionality. This is done by mocking the `Utils` class, and using that mock in the tests of these enums. The functionality of these enums can be tested by running the `DomainTest` and `ActionTest` test classes.

## Deployment

To deploy this project on a live system, you can simply use the `ims-0.0.1-jar-with-dependencies.jar` file. To run this file, navigate to the folder which contains the file in either Command Line or Git Bash, and run the following command:

```
java -jar ims-0.0.1-jar-with-dependencies.jar
```

In the event that you want to generate your own jar with dependencies file, then instead navigate to the folder containing the project in either Command Line or Git Bash, and run the following command. Note that to do this, you must have Maven correctly installed:

```
mvn clean package
```

**Important note:** By default, the project completely deletes and recreates the database each time it is run. If you want to use the project without this happening, then you must navigate into `src/main/resources`, open the file `sql-schema.sql` and delete the first line, which reads:

```
DROP SCHEMA IF EXISTS ims;
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Stephen Goddard** - *Project completion* - [sgoddardqa](https://github.com/sgoddardqa)
* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Piers and Aswene for being wonderful trainers and helping throughout the process of finishing this project
* The other QA trainers who helped teach all of the parts of the course needed to complete the project
