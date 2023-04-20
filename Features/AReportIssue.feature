@ReportIssue
Feature: Create a report Issue
  I want to use this template for my feature file

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
	

  @RI
  Scenario: Validate report issue
   	Given user is on homepage
		When user click on report issue button
		And user enter the issue details as "<category>" and "<reproducibility>" and "<severity>" and "<priority>" and "<summary>" and "<description>" click on Submit issue
		Then go to view issue page
		Then click on issue generated
		Then validate on issue page for values "<category>" and "<reproducibility>" and "<severity>" and "<priority>" and "<summary>" and "<description>"
		Then validate on db for values "<category>" and "<reproducibility>" and "<severity>" and "<priority>" and "<summary>" and "<description>"
		Then validate on summary page "<severity>" and "<category>"	
			
    Examples: 
      | category  	  					| reproducibility | severity | priority | summary 					| description |
      | [All Projects] Selenium | random 		 			| trivial  | low 			| not able to login | description |

