Take a picture from a Cam or Disk,can convert size,can make it black and white, write to a database, write from a database to a disk.
Java OpenCV from Maven

Add the following dependency in your POM file:
 https://mvnrepository.com/artifact/org.openpnp/opencv 
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
