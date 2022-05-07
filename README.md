#Job Search Headless Application

This is a headless application for Job Searching using Spring Boot, Spring Data JPA using Eclipselink, 
Spring JMS and Spring AOP. <br/>
It has a REST API for all CRUD operations on all entities and sub entities, which can be started on the controllers.</br>
**Note: There is no getAll for application as it's a one-to-one relationship with job, and no post and update for parent class Interview as it's an abstract class.</br></br>


The URLs to get to the query APIs are as follows:

1. /jobs/applications
2. /jobs/interviews?startDate={insertStartDate}&endDate={insertEndDate}
3. /jobs/companies?state={insertStateHere}
4. /jobs/skills?salary={salary}&state={state}
5. /recruiters?salary={salary}
6. /jobs/interviews

Swagger URL is: localhost:8080/swagger-ui.html#/

