@ReportIssue
Feature: Create a report Issue
  I want to use this template for my feature file

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
      | [All Projects] Selenium | random 					| trivial  | low 			| not able to login | description |
      | [All Projects] Selenium | random 					| trivial  | no value | not able to login | description |
      | [All Projects] Selenium | random 					| trivial  | high 		| not able to login | description |
