# E_COMMERCE

**E_commerce** is a RESTful API. Some actions that can be done are:
- CRUD operations for products - create, update and delete.
- The products can be sorted  by id, name, quantity, createdDate or lastModifiedDate ASC and DESC. When a get request GET/products?orderBy=name&direction=DESC&page=0&pageSize=10 is made, the response is like:
  { products: [{...}, {...}], totalRecords: 1100}.
- When ordering a product - for a given product id, the service orders  the given quantity. 
For example: POST /products/1001/order/3.
- When requesting a list with the existing categories GET /categories, the request returns the following
 information: [ {category: “Laptop”, productsAvailable: 1}, {category: Monitor, productsAvailable: 2}]

**In order to set up the application,**
- First import the maven dependencies;
- Then build and run the EcommerceApplication;
- The database console can be accessed on the following link: http://localhost:8080/h2-console with the credentials 
shown in application.properties.

**Technical details of the application:**
- Database Embedded H2 and Liquibase
- JDK version 11
- Maven
- SpringBoot framework
- JPA repository in the persistence layer
- JUnit