### File Attributes Listing
    This application provides following RESTful APIs to fetch file attributes.
    Max Depth of filesystem traversal is fixed to 20

#### Build and Run
```shell
$ git clone https://github.com/nvulane/FileSystemLister-REST.git
$ cd FileSystemLister-REST
$ gradle clean build # maven needs to be installed on the workstation

```

#### How to access RESTful service using Browser
```shell
#To get attributes of a file
http://localhost:8080/fileservice/filedetail?fileName=.

#To get attributes of ALL files in a directory recursively
http://localhost:8080/fileservice/dirdetail?dirName=.
http://localhost:8080/fileservice/dirdetail?dirName=C:/Program Files
```

#### How to access RESTful service using command line
```shell
$ curl -X GET http://localhost:8080/fileservice/filedetail?fileName=.  #To get attributes of a file
$ curl -X GET http://localhost:8080/fileservice/dirdetail?dirName=C:/Program%20Files  #To get attributes of ALL files in a directory recursively
```