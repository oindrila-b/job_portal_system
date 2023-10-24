Data Source -  [Linkedin Job Opening Analysis](https://www.kaggle.com/datasets/shashankshukla123123/linkedin-job-data). 


There are two databases : 
1. One for the job having pre-filled data, which doesn't have write permission and only read permission. 
2. The other one is a User Database which consists of the basic user information and the job-id to which the users have applied.

This project uses MySQL as the backend layer. And Spring Boot as the server side layer. The project has the functionality to can add a new job, and the user can then apply to that job through the job portal.
The client side of the project can be found [here.](https://github.com/oindrila-b/job-portal-system-clientSide)

To run the project,
1. Create a maven jar:
   1. `mvn clean install`
2. This jar file can be found in the target folder.
   1. Run the jar file using the command :
      1. `java -jar target/jar-fileName.jar`
3. Once this is done the server would be up and running in the tomcat default port `8080`
4. To access the job list navigate to `localhost:8080/api/v1/jobs`
5. The client side would ideally send the requests but this can also be tested using postman.

The Java Docs can be found in [target/docs](https://github.com/oindrila-b/job_portal_system/tree/master/target/docs/com/example/jobportal)  folder.