@deleteIssue
Feature: Delete Feature
  I want to use this to check my delete feature 

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

 @DI
	Scenario: Validate delete issue
		Given User is on now on homepage
		When User click on view issues button
		And User clicks on a issue id  "<issueId>" and click on delete button
		Then User should reach on a delete issue page and click on delete 
		And Issue has been deleted
		Then go to the view issue page
		Then check for issue
		Then validate delete Issue on db
		


    Examples: 
      | issueId |
      | 0000083 | 
        
