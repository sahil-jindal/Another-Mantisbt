
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
	    Given User is on curretly on homepage
	    When click on view issues button
	    And User clicks on a issue id  "<issueId>"
	    And User clicks on edit button
	    And User sets status as "<status>" and resolution as "<resolution>"
	    And Click on update information
			Then Issue should be updated
			Then go to view issue page for update
			Then click on issue updated
			Then validate update issue on issue page
			Then validate update issue on db
				
			
    Examples: 
      | issueId | status 	 | resolution |
      | 0000049 | resolved | fixed 			|
