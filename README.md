# JSQL
## Universal Database Manager
### Description
JSQL is a Java GUI app allowing user to establish connection with and manage MS SQL and MySQL database engines. It was created in Java 8 and JavaFX technologies and uses SQLjdbc library for DB communication. It creates a dynamic view of the selected table and provides a simple CRUD interface. JSQL requires user to have an existing account in the target database with proper privileges. In overall, it is a lightweight, intuitive environment, available to everyone.

### Authors
1. Jakub Sarnowski (https://github.com/jsarnowski96)
2. Damian Szymański

### Licence
JSQL is being distributed under MIT licence.
https://opensource.org/licenses/mit-license.php

### Requirements
- Existing account on either MS SQL or MySQL server instance
- (for MS SQL) enabled Windows SQL Server Authentication mode
- Java software

#### Applicative requirements
1. User authentication module<br />
   a) User must select DB engine and insert DB user credentials. After successfull authentication user is moved to Table Selection module.<br />
   b) Input - DB engine selection, DB user credentials (username/password)<br />
   c) Output - Table Selection view<br />
2. DB/Table selection<br />
   a) After selecting database, target table and pressing "Select" button, user is forwarded to Table Overview presenting the information from the specified table which allows for full CRUD operations<br />
   b) Input - DB/Table selection<br />
   c) Output - View with contents of the selected table<br />
3. Deleting row<br />
   a) User clicks specific cell within the table which he wants to delete and after loading the initial data from the selected row clicks "Delete" button. If operation finished successfully, he is presented with popup success window. In case of failure and/or empty row selected, the popup displays proper error message.<br />
   b) Input - selecting row for deletion and pressing "Delete" button<br />
   c) Output - success/error popup message box<br />
4.  Updating row<br />
   a) User clicks specific cell within the table which he wants to update and after loading the initial data and replacing specified text fields with new values clicks "Update" button. If operation finished successfully, he is presented with popup confirmation window. In case of failure and/or empty row selected, the popup displays proper error message.<br />
   b) Input - wybór pola warunkującego i kliknięcie przycisku, aktualizacja danych i wciśnięcie przycisku "Save" 
   c) Output - success/error popup message box<br />
5.  Inserting row<br />
   a) From the dropdown menu "Actions" user clicks "Add new row". After that, a set of text fields will appear in the bottom part of the window - its structure depends on target table's columns. In order to add a new row to the table, user must click "Insert row" button. If operation finished successfully, he is presented with popup confirmation window. In case of failure and/or empty fields, the popup displays proper error message.<br />
   b) Input - navigating to Actions -> Add new row, inserting data into newly rendered text fields and clicking "Insert row" button<br />
   c) Output - success/error popup message box<br />
6. Logging out<br />
   a) In order to logout, user must navigate to File -> Logout menu item. After pressing it the current DB session will be closed and user will be redirected back to Login screen.<br />
   b) Input - navigating to File -> Logout and pressing button<br />
   c) Output - Login screen<br />
7. "About" view<br />
   a) From Table Selection view user can navigate to File -> About. After clicking the menu item the new window will show up, displaying details about project authors/repository<br />
   b) Input - navigating to File -> About<br />
   c) Output - "About" view<br />
   
#### Non-applicative requirements
1. Application is designed for a single user session<br />
2. JSQL is a lightweight GUI application which consumes a minor amount of system resources<br />
3. Application is free to use and its source code is open to public. Distributed under MIT licence conditions.<br />
4. Windows 10 or older required.<br />
5. Official app's launch date is set to June 2nd 2020<br />
6. Simple and intuitive interface available to everyone - no special skills required in order to use JSQL.<br />

## Core components
- Views:<br />
   - `LoginFrame` - intercepts user input and invokes proper DB connection methods dependant on the selected DB engine<br />
   - `TableSelectFrame` - allows user to select database and table he wants to display<br />
   - `TableOverviewFrame` - main view for logged user allowing him to perform various CRUD operations<br />
   - `AboutFrame` - displays basic information about project's authors and repository<br />
- Classes:<br />
   - `AppInit` - core class which stores some of the DB connection's data globally, as well as all the view instances<br />
   - `DataBaseSelectModel` - stores information about user selection in `TableSelectFrame` which are externally used later on by `TableOverviewFrame`<br />
   - `MSSQLConnection` - contains methods used to establish a connection with MS SQL server instance<br />
   - `MSSQLTransactions` - contains declarations of methods performing MS SQL CRUD operations<br />
   - `MySQLConnection` - contains methods used to establish a connection with MySQL server instance<br />
   - `MySQLTransactions` - contains declarations of methods performing MySQL CRUD operations<br />
- Models:<br />
   - `DbInfo` - for future use<br />
   - `EnginesEnum` - used in major part of methods executing CRUD operations - it determines whether JSQL should use libraries for MS SQL or MySQL engine<br />
   - `TableInfo` - for future use<br />
   

## Tests
-

### Test scenarios
1. User authentication:<br />
   - MS SQL:<br />
      a) `LoginFrame` -> enter correct username and password -> enter correct server name/address -> select MS SQL engine -> press "Login" button<br />
      b) `LoginFrame` -> enter correct username and password -> enter incorrect server name/address -> select MS SQL engine -> press "Login" button<br />
      c) `LoginFrame` -> enter incorrect username and password -> enter correct server name/address -> select MS SQL engine -> press "Login" button<br />
      d) `LoginFrame` -> enter incorrect username and password -> enter incorrect server name/address -> select MS SQL engine -> press "Login" button<br />
   - MySQL:<br />
      a) `LoginFrame` -> enter correct username and password -> enter correct server name/address -> select MySQL engine -> press "Login" button<br />
      b) `LoginFrame` -> enter correct username and password -> enter incorrect server name/address -> select MySQL engine -> press "Login" button<br />
      c) `LoginFrame` -> enter incorrect username and password -> enter correct server name/address -> select MySQL engine -> press "Login" button<br />
      d) `LoginFrame` -> enter incorrect username and password -> enter incorrect server name/address -> select MS SQL engine -> press "Login" button<br />      
2. Database/Table selection:<br/ >
   - MS SQL:<br />
      a) `TableSelectFrame` -> select database -> select table -> press "Select" button<br />
      b) `TableSelectFrame` -> select database -> skip table selection -> press "Select" button<br />
   - MySQL:<br />
      a) `TableSelectFrame` -> select database -> select table -> press "Select" button<br />
      b) `TableSelectFrame` -> select database -> skip table selection -> press "Select" button<br />   
      d) `LoginFrame` -> enter incorrect username and password -> enter incorrect server name/address -> select MySQL engine -> press "Login" button<br />   

### Test summary

