Feature: Facebook Login

Scenario: User should be able to login to Facebook
 Given  I open browser
  When  I launch facebook URL
   And  I enter username and password
   And  I click on sign-in button
  Then  I should be able to see user profile name
