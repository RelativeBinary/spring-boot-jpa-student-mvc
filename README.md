# spring-boot-jpa-student-mvc

barebones spring boot CRUD application involving basic student data

# setup

after downloading the repository I recommend opening it in you're chosen development environment
my development environment uses postman and intelliJ IDEA

## postgresql db setup

this program uses postgres for data storage

### creating the db

in postgres CLI run the following commands to set up the db

- create database student
- grant all privileges on database "student" to [username]

  where [username] is the user that is being used on postgres

- \c student

  to connect to the student db

- \d

  to check that the database is empty

## setting up your application.properties file

in the repository under src/main/resources/application.properties. I have already setup the program to work with the student db. Although the username and password must be changed to contain the appropriate credentials based on the user you are logged in as in postgres.

those credentials will not work as the password is not going to be the same (the one in the file is a dummy password)

# How it Works

## Domain Class (Student.java)
This contains a student class
the @Entity & @Table annotation indicates that the class can be mapped to a table

The id column being indicated by the @Id annotation which is configured with the @SquenceGenerator and @GeneratedValue annotations on the Id variable of type Long.

The @Transient annotation indicates the following variable to be stored in memory and not at a column in the table.
In this case age is not stored but calculated based on the period of time between the dob and the current time.

## Repository Interface (StudentRepository.java)
This indicates that the class being extended is capable of having storage, retrieval, search, update and delete operations performed.
The interface method in this repository is what will allow use to manipulate or interact with the data in the database.

## Service Class (Student.java)
This contains a majority of the logic behind the API endpoints and communicates between the repository interface and the controller class.
The @Component annotation tells spring that only a single instance of the class will be made.

The @Autowired annotation indicates a dependency to the student repository that needs to be resolved before being used

The @Transactional annotation wraps the following method as a transaction that will be linked to the class that is being annotated.

## Controller Class (StudentController.java)
This will be the class which will be handling requests to the server. 
This is indicated by the @RestController annotation, with the @RequestMapping annotation indicating what url path the requests are linked to.

The @Autowired annotaion here indicates that the controller has a dependency to the StudentService class.

Each of the annotated mapping methods take some http request with either a GET, POST, DELETE or PUT method.

### GetMapping
Accepts GET requests to the server

### PostMapping
Accepts POST requests to the server 

### DeleteMapping
Accepts DELETE requests to the server

### PutMapping
Accepts PUT requests to the server 