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

## Test Cases: 
https://docs.google.com/spreadsheets/d/1KDKj3h965oHfH_y_S9EiQtPmotLYbWV8/edit?usp=sharing&ouid=114771656978469807735&rtpof=true&sd=true



## Reports:

![Capture](https://user-images.githubusercontent.com/83439797/225512827-c88624f1-b905-4d6e-9c62-e1ee01327b88.PNG)


![Capture2](https://user-images.githubusercontent.com/83439797/225512838-fcf9561d-f1ce-403a-9dda-e5cc452aaef0.PNG)


[screen-capture (50).webm](https://user-images.githubusercontent.com/83439797/225514001-126a7978-2100-4992-ad15-2d3411d4147b.webm)

