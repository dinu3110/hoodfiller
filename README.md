# hoodfiller
This program defines a prepareHood method that takes in a list of present weights and a hood capacity, and returns a list of present weights that minimizes the number of items needed to fill the hood. It first sorts the present weights in descending order using the Collections.sort method, which allows us to add the heaviest present weights to the hood first. It then initializes an empty list to hold the present weights for the hood, and iterates through the sorted present weights. For each weight, the method checks if adding it to the hood would exceed the capacity. If it wouldn't, the weight is added to the list of present weights for the hood. Once the method has iterated through all the present weights, it returns the list of present weights for the hood. Present weight is taken into consideration by adding few examples to H2 in memory database and update once added to the hood so that particular present is next excluded from being added.
Can be enhanced further by adding same present multiple time with the quantity factor being added to make it more robust and realistic with the example.

TechStack:

Java 1.8, 
SpringBoot 2.7.8,
Spring Boot H2 DB - in memory database
spring-boot-starter-web,
spring-boot-starter-data-jpa,
spring-boot-starter-test,
Junit for testcases,
