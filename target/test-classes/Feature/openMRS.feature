#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Scenarios for open MRS application

@Login
Scenario: Login to Application
	Given I am on MRS Login Page
	When I enter "Admin" and "Admin123" for username and Password
	And Select any Location for the session
	And Click on Login
	Then Login should be successful
	
@Register
Scenario: Register Patient
	Given I am on MRS Home Page
	When I click on Register for a patient
	Then Register Patient Page must be displayed

@Register	
Scenario: Provide Demographics of the patient
	Given I am on Register a patient Page
	When I give the patients name
	And Click on Next
	Then Gender Screen Must be displayed

@Register	
Scenario: Provide Gender of the Patient
	Given I am on Gender Screen
	When I select Gender
	And Click on Next
	Then Birthdate Screen must be displayed

@Register	
Scenario: Provide Birthdate of the Patient
	Given I am on BirthDate Screen
	When I give the Birth date
	And Click on Next
	Then Address Screen must be displayed

@Register	
Scenario: Provide address of the patient
	Given I am on Address Screen
	When I give the address of the patient
	And Click on Next
	Then Phone Number Screen must be displayed

@Register	
Scenario: Provide Phone number of the patient
	Given I am on Phone Number Screen
	When I give the Phone number
	And Click on Next
	Then Relatives Screen must be displayed

@Register	
Scenario: Provide Relatives info
	Given I am on Relatives Screen
	When I give the Relatives info
	And Click on Next
	And Click on Confirm
	Then Patients Dashboard Page must be displayed

@Find
Scenario: Find Patient
	Given I am on Home Page
	When I click on Find Patient Record
	Then Find Patient Record Page must be displayed

@View	
Scenario: View Patient
	Given I am on Find Patient Record Page
	When I Search by Name
	Then Patients record should be displayed with correct info

@Appointment	
Scenario: Book an Appointment for the patient
	Given I am on Patients Dashboard Page
	When I Click on Schedule Appointment
	Then Manage Appointments Page must be displayed
	

@Attachment	
Scenario: Add an attachment to the patient
	Given I am on Patients Dashboard Page
	When I Click on Attachments
	Then Attachments Screen must be displayed
	
@Attachment	
Scenario: Add the attachment
	Given I am on Attachments Page
	When I type for the attachment
	Then File must be attached

@Delete	
Scenario: Delete a Patient
	Given I am on Patients Dashboard Screen
	When I click on Delete Patient
	And I give the Reason and Submit
	Then Patient must be Deleted Successfully

@Logout	
Scenario: Logout of the application
	Given I am on Home Page
	When I click on Logout
	Then I should be logged out of the application successfully

#############################################

