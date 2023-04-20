@DeleteIssue
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
		And User creates an issue for delete with values "<category>" "<reproducibility>" "<severity>" "<priority>" "<summary>" "<description>"
		When User click on view issues button for delete
		And User clicks on a issue id for delete
		Then User should reach on a delete issue page and click on delete 
		Then go to the view issue page
		Then validate for issue deleted
		Then validate delete Issue on db
		


    Examples: 
      | category  	  					| reproducibility | severity | priority | summary 					| description |
      | [All Projects] Selenium | random 					| trivial  | low 		  | not able to login | description |
      | [All Projects] Selenium | random 					| trial 	 | low 		  | not able to login | description | 
        
