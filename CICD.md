This is the document on how we can use Github, Travis CI and Heroku for Continuous Integration and Continuous Deployment (CI/CD) of this project.

It will execute a simple pipeline that:

* Compiles source code.
* Executes Unit tests.
* Deploying artifacts.

#### Step 1. Prepare Github repo

Push weather-web to Github repository.

#### Step 2. Set up Travis CI

As Travis CI integrates with Github, we can use GitHub credentials to log in.

1. Go to the Travis CI website and click Sign in with Github.
2. Turn on Travis CI for weather-web repo.

![sc1](https://user-images.githubusercontent.com/42803676/59861902-43a82480-93b4-11e9-92b2-d5fa79aa5f9f.png)

#### Step 3. Create the Travis Configuration

Create .travis.yml file in the project root folder with following content:

**.travis.yml**
```
language: java
jdk:
 - oraclejdk8
 ```
 
By default, Travis will run ```mvn test -B``` for building and testing the project. If Travis finds mvnw wrapper then it will run ```./mvnw test -B```.
 
We also can use ```script``` block to customize it to run different command. Eg:
 
**.travis.yml**
```
language: java
jdk:
 - oraclejdk8

script:
- ./mvnw clean install -B
```

As it uses the Travis CI default, the maven wrapper will be used. You may see this error while Travis CI builds the project: ```./mvnw: Permission denied.``` It is due to ```./mvnw``` is not executable. One of the solutions to work around this issue is let Travis turn on the execute bit by adding ```before_install``` like this:
```
before_install:
- chmod +x mvnw
```
 
#### Step 4. Configure Maven to download Webapp Runner
 
Webapp runner is designed to allow us to launch an exploded or compressed war that is on our filesystem into a tomcat container with a simple ```java -jar``` command.

Add the following plugin configuration to **pom.xml**:

```
<build>
    ...
    <plugins>
        ...
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-dependency-plugin</artifactId>
            <executions>
                <execution>
                    <phase>package</phase>
                    <goals><goal>copy</goal></goals>
                    <configuration>
                        <artifactItems>
                            <artifactItem>
                                <groupId>com.github.jsimone</groupId>
                                <artifactId>webapp-runner</artifactId>
                                <version>9.0.20.0</version>
                                <destFileName>webapp-runner.jar</destFileName>
                            </artifactItem>
                        </artifactItems>
                    </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

#### Step 5. Set up Heroku

Before deploying our application to Heroku, we need to login to Heroku and create an application.

![sc2](https://user-images.githubusercontent.com/42803676/59865966-f5e3ea00-93bc-11e9-959b-3e7ca579dcfc.png)

Adding ```deploy``` section to the Travis configuration file:

```
deploy:
   provider: heroku
   api-key: 
      secure: $HEROKU_API_KEY
   app: e-weather-web-demo
```

Declare how we want our application executed in **Procfile** in the project root::

```
web: java $JAVA_OPTS -jar target/dependency/webapp-runner.jar --port $PORT target/*.war
```

Commit and push our modified files to GitHub. Once the build is successful and deployed on Heroku, we should be able to access our application at:

https://e-weather-web-demo.herokuapp.com/

Visit [here](https://travis-ci.org/ethanbui/weather-web) to view build history.

**It’s done!**
