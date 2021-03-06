Java OpenCV from Maven
Add the following dependency in your POM file:
<!-- https://mvnrepository.com/artifact/org.openpnp/opencv -->
<dependency>
    <groupId>org.openpnp</groupId>
    <artifactId>opencv</artifactId>
    <version>4.3.0-0</version>
</dependency>

Create Database Mysql:

CREATE DATABASE everything_for_the_mountains;
USE everything_for_the_mountains;
CREATE TABLE inventory
(

name varchar(45),
photo longblob
);

"# ProjectFirst" 
