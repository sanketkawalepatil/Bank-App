# Bank-App
A Bank App using the Spring Boot framework and microservices architecture. The Bank App allows users to create multiple accounts and perform credit and debit transactions on those accounts.

The app is divided into two microservices: the Account microservice and the Transaction microservice.The Account microservice is responsible for managing user accounts, while the Transaction microservice handles credit and debit transactions.

We used a service registry called Eureka to register and discover services. Eureka allows the microservices to communicate with each other by discovering the location of other microservices using the service name instead of the actual URL.

To secure the API endpoints, we implemented security and authentication measures. We used Spring Security and JWT tokens for authentication and authorization.

For data storage, we used a MySQL database. We created a user repository in the Account microservice to manage user data and an account repository in the Transaction microservice to manage account data.

Overall, our implementation of the Bank App provides a scalable and secure solution for managing user accounts and transactions.

