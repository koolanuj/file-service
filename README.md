### File Attributes Listing
    This application provides following RESTful APIs to fetch file attributes.
    Max Depth of filesystem traversal is fixed to 20

#### Build and Run
```shell
Use Gradle 6.5.1
Create a new directory where you want to create this project and cd into that
$ git clone https://github.com/koolanuj/file-service.git
$ cd file-service
$ gradle clean build

java  -Dspring.profiles.active=local -jar build\libs\file-service-1.0-SNAPSHOT.jar 
```

#### How to access RESTful service using Browser
```shell
#Swagger/OpenAPI documentation link
http://localhost:8080/fileservice/doc/swagger-ui-custom.html
http://localhost:8080/fileservice/doc/api-docs

#To get attributes of a file from local filesystem
http://localhost:8080/fileservice/filedetail?fileName=.

#To get attributes of ALL files in a directory recursively from local filesystem
http://localhost:8080/fileservice/dirdetail?dirName=.
http://localhost:8080/fileservice/dirdetail?dirName=C:/Program Files


#DB - get all files from AZ MySql DB
http://localhost:8080/db/allfiledetail

#DB - get a specific file details from DB based on file ID
http://localhost:8080/db/getallfiledetail

```

#### How to access RESTful service using command line
```shell
$ curl -X GET http://localhost:8080/fileservice/filedetail?fileName=.  #To get attributes of a file
$ curl -X GET http://localhost:8080/fileservice/dirdetail?dirName=C:/Program%20Files  #To get attributes of ALL files in a directory recursively
```