Feature: To validate the login functionality of flipkart application

Scenario: To validate login with valid number and valid password
Given To launch the chrome browser and maximize the window
When To launch the url of flipkart application
And To click the login button in homepage
And To pass valid number in number field
And To pass valid password in password field
And To click the login button
Then To close the browser
