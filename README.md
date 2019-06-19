Get Current Weather
===
This is a web application built with Spring Boot to display current weather for 3 Australian cities: Sydney, Melbourne and Wollongong.
There will be a dropdown list on the web page for city selection, when city is changed, corresponding real-time weather information will be displayed.
Currently it only supports Openweathermap.

Technology stack:

* Spring Boot
* Spring MVC
* Spring Test/JUnit/Mockito
* jQuery
* Bootstrap

## Requirements

* JDK 8

  Oracle Java 8 is required, go to [Oracle Java website](http://java.oracle.com) to download it and install into your system. 
 
  Optionally, you can set **JAVA\_HOME** environment variable and add *&lt;JDK installation dir>/bin* in your **PATH** environment variable.

* Apache Maven

  Download the latest Apache Maven from [http://maven.apache.org](http://maven.apache.org), and uncompress it into your local system. 

  Optionally, you can set **M2\_HOME** environment varible, and also do not forget to append *&lt;Maven Installation dir>/bin* your **PATH** environment variable.
  
## Get the source codes

Get a copy of the source codes into your local system.

```
git clone https://github.com/ethanbui/weather-web.git
```

## Run the project

You can use following approaches to run this project.

1. Run server via Spring Boot.

   ```
   mvn spring-boot:run
   ```
   or
   ```
   mvnw spring-boot:run
   ```
  The server will run on port 9999.

2. Go to [http://localhost:9999](http://localhost:9999) to test it.

Screenshot
-----
![Weather](https://raw.github.com/ethanbui/weather-web/master/Screenshot.png) 

Developed By
------------
* Ethan Bui - <vietbh198@gmail.com>
