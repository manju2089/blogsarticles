# blogsarticles
Maintain blogs and articles using spring boot / microsesrvices
mvn clean install - to clean the application and install the dependencies

mvn spring-boot:run - start up the application

Get Blog -
Access the http://localhost:8080/blogs -GET request to fetch all blog information

Create Blog -
Access /blogs - POST with body 
{
"blogName":"blog1"
}

Update Blog -
Access /blogs/{id} - PUT with updated blogName  
{
"blogName":"blog2"
}

Delete Blog -
Access /blogs/{id} - Delete request with no body  


Create Articles -
Access /blogs/{id}/articles- POST to create article for a blogId
{
"articleName":"article1"
}

Fetch Articles for a Blog - 
Access /blogs/{id}/articles - GET to see all the articles of a blog

Update Article -
Access /blogs/{id}/articles/{articleId} - PUT request with updated JSON body

Delete Article -
Access /blogs/{id}/articles/{articleId} - Delete request with no body
The article linked to a blog is removed and no more seen in fetch request
