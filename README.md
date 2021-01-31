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
