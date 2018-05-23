# upday_challenge

We are a publishing company that created an app for reading news articles.

To serve data to the app we need a backend to provide RESTful APIs for the following use cases:

* allow an editor to create/update/delete an article
* display one article
* list all articles for a given author
* list all articles for a given period
* find all articles for a specific keyword

Each API should only return the data that is really needed to fulfill the use case.

## USING TOOLS
* JDK 10.0.1
* Spring Tool Suits 3.9.3
* Postman 6.1.2
* MacOS Terminal

## RESTful APIs

### Append article (POST METHOD)
* http://localhost:8080/article

Request Header : { "Content-Type":"application/json" }

Request Body : 
{
	"header":"test1",
	"shortDescription":"test1 short",
	"text":"test1 text",
	"authors":[ "hong" ],
	"keywords":[ "test", "news" ]
}

### Display one article (GET METHOD)
* http://localhost:8080/article/1

### Display all articles (GET METHOD)
* http://localhost:8080/article/list

### Modify specific article (PUT METHOD)
* http://localhost:3000/article/1

Request Header : { "Content-Type":"application/json" }

Request Body :
{
	"header":"test3",
	"shortDescription":"test3 short",
	"text":"test3 text",
	"authors":["park"]
}

### Delete specific article (DELETE METHOD)
* http://localhost:3000/article/1

## RUNNIG PROGRAM

* git clone this project
* open the Backend project in the STS.
* select "Spring Boot App" from the "Run As" menu and run it.
* connect to http://localhost:8080 in webbrowser
