# Building REST APIS with Java and Spring Boot

Here, in this project I have built following sample REST APIs using Spring Boot
        A.    Create Account
        B.    Get Account
        C.    Update Account
        D.    Delete Account

Here, I have also used Swagger to bulid the API Documentation and used Junit for Unit Testing.

## Run the Application

### To run this project please follow the path as shown below,

Clone this code to your local using the following link

```bash
git clone https://github.com/HimanshuThakkar/REST-API-using-Springboot
```

Or you can import the project into an IDE of your choice. I used ``` IntelliJ``` to design this project.

After successful import of project into your preferred IDE,

The application can be run using the following command

```bash
mvn spring-boot:run
```

By default the local server host will be 8080, 
local server host can be changed at ```application.properties``` file. 

The Junit test cases can be run using the following command

```bash
mvn clean install
```

To see API Document in ```Swagger```, use the following url in your broweser 

```bash
http://localhost:8070/swagger-ui.html
```

To Run ```Postman``` test cases 

Please import the collection using following link, and run the test cases 

```bash
https://www.getpostman.com/collections/1eb83fe5790da3505ef7
```

