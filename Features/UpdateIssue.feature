
@UpdateIssue
Feature: Update Issue
  I want to use this to check my update feature 

#	Background: User is Logged In
#		Given user is on the login page
#	  And user enter username as "<username>" and click on login
#	  And user enter password as "<password>" and click on login
#	  Then user should be able to login successfully
#	  And user should be able to navigate to home page
  #
    #Examples: 
      #| username  	  | password |
      #| administrator | root 		 |
      
      
  @UI 
	Scenario: Validate update issue
	    Given User is on currently on homepage
	    And User creates an issue with values "<category>" "<reproducibility>" "<severity>" "<priority>" "<summary>" "<description>"
	    When User click on view issues button
	    Then User clicks on a issue id
	    And User clicks on edit button
	    And User updates status as "<status>" and resolution as "<resolution>"
			Then go to view issue page for updateIssue
			Then click on issue updated
			Then validate update issue on issue page with "<status>" and "<resolution>"
			Then validate update issue on db with "<status>" and "<resolution>"
				
			
    Examples: 
      | category  	  					| reproducibility | severity | priority | summary 					| description |status 	 | resolution |
      | [All Projects] Selenium | random 		 			| trivial  | low 			| not able to login | description |resolved  | fixed 			|
     
      
