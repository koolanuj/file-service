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

#GET attributes of a file from local filesystem
http://localhost:8080/fileservice/filedetail?fileName=.

#GET attributes of ALL files in a directory recursively from local filesystem
http://localhost:8080/fileservice/dirdetail?dirName=.
http://localhost:8080/fileservice/dirdetail?dirName=C:/Program Files


#DB - get details of ALL files from AZ MySql DB
http://localhost:8080/db/filedetail/all

#DB - get details of specific file from MySQL DB based on file ID provided in query string
http://localhost:8080/db/filedetail?fileId=2

```

#### How to access RESTful service using command line
```shell
$ curl -X GET http://localhost:8080/fileservice/filedetail?fileName=.  #To get attributes of a file
$ curl -X GET http://localhost:8080/fileservice/dirdetail?dirName=C:/Program%20Files  #To get attributes of ALL files in a directory recursively
```

#### How to build/run using docker
##### Build
- Need docker daemon running
- docker build –t file-service:nodb  .
##### Run
- docker run –d –p 8080:8080  file-service:nodb
- docker logs –f <cdf>   ##to tail logs
##### Push to repo
- docker tag file-service:nodb anukumar/file-service:nodb   ##tag it as repo-name
- docker images	## check
- docker push anukumar/file-service:nodb		##save in dockerhub.com
