# DmoneyRestAssuredAPITesting

## For Serialization: Take Jackson Datamind from mnvrepository
- implementation group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.14.2'

## Lombok Gradle: 
	- testCompileOnly 'org.projectlombok:lombok:1.18.26'
	       
	- testAnnotationProcessor 'org.projectlombok:lombok:1.18.26'

## Allure Report Generation: 
	- allure generate allure-results --clean -output allure-report
	- allure serve allure-results
  
  
## Senarios: 
1. Call login API
2. Create  a new customer and an agent
3. Search by the customer phone number
4. Deposit 5000 tk to the Agent from system
5. Deposit 2000 tk by agent to customer 
6. Check balance of customer
7. Check statement by trnxId 
8. Withdraw 1000 tk by customer and assert expected balance
9. Send 500 tk to another customer and assert expected balance
10. Check customer statement
