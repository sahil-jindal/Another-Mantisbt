
@OpenIssue
Feature: Login 
  I want to use this template for my feature file

  
  #Background: Valid Login
    #Given user is on the login page
    #And user enter username as "<username>" and click on login
    #And user enter password as "<password>" and click on login
    #Then user should be able to login successfully
    #And user should be able to navigate to home page
    #
    #Examples: 
      #| username  	  | password |
      #| administrator | root 		 |
      
    @OI 
    Scenario: 
    	Given user is on the home page
    	Then navigate to view issue page
    	Then apply priority filter as "<priority>"
    	And apply severity filter as "<severity>"
    	And apply reporter filter as "<reporter>"
    	Then validate all filters 
    	
   	 Examples: 
      | priority  	  | severity | reporter | 
      | any						| any	 		 | any			|

 
