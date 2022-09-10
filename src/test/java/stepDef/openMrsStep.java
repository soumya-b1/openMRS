package stepDef;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class openMrsStep {

	static WebDriver driver = null;
	static String pageTitle = null;
	static WebElement we = null;
	static WebElement we2 = null;
	static String val = null;

	@BeforeAll
	public static void navigateToGMO() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://demo.openmrs.org/openmrs/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		pageTitle = driver.getTitle();
	}

	@AfterAll
	public static void close_Browser() {
		driver.quit();
	}

	// ----------------------------------------------
	// Login to Application
	// ----------------------------------------------

	@Given("I am on MRS Login Page")
	public void i_am_on_mrs_login_page() {
		pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle,"Login","Login Successful");
	}

	@When("I enter {string} and {string} for username and Password")
	public void i_enter_and_for_username_and_password(String uname, String pwd) {
		we = driver.findElement(By.id("username"));
		we.sendKeys(uname);
		we2 = driver.findElement(By.id("password"));
		we2.sendKeys(pwd);
	}

	@When("Select any Location for the session")
	public void select_any_location_for_the_session() {
		driver.findElement(By.id("Inpatient Ward")).click();
	}

	@When("Click on Login")
	public void click_on_login() {
		driver.findElement(By.id("loginButton")).click();
	}

	@Then("Login should be successful")
	public void login_should_be_successful() {
		pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle,"Home");
	}

	// -------------------------------------
	// Register Patient
	// -------------------------------------

	@Given("I am on MRS Home Page")
	public void i_am_on_mrs_home_page() {
		pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle,"Home");
	}

	@When("I click on Register for a patient")
	public void i_click_on_register_for_a_patient() {
		we = driver.findElement(By.id(
				"referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension"));
		we.click();
	}

	@Then("Register Patient Page must be displayed")
	public void register_patient_page_must_be_displayed() {
		pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle,"OpenMRS Electronic Medical Record");
	}

	// ---------------------------------------------
	// Register Patient - Provide Demographics
	// ---------------------------------------------

	@Given("I am on Register a patient Page")
	public void i_am_on_register_a_patient_page() {
		pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle,"OpenMRS Electronic Medical Record");
	}

	@When("I give the patients name")
	public void i_give_the_patients_name() {
		we = driver.findElement(By.xpath("/html/body/div/div[3]/form/section[1]/div/fieldset[1]/div[1]/p[1]/input"));
		we.sendKeys("Anonymous");
		we2 = driver.findElement(By.xpath("/html/body/div/div[3]/form/section[1]/div/fieldset[1]/div[1]/p[3]/input"));
		we2.sendKeys("User");
	}

	@When("Click on Next")
	public void click_on_next() {
		we = driver.findElement(By.cssSelector("button[id='next-button']"));
		we.click();
	}

	@Then("Gender Screen Must be displayed")
	public void gender_screen_must_be_displayed() {
		we = driver.findElement(By.cssSelector("span[id='genderLabel']"));
		val = we.getText();
		Assert.assertEquals(val,"Gender");
	}

	// -----------------------------------------
	// Register Patient - Gender
	// -----------------------------------------

	@Given("I am on Gender Screen")
	public void i_am_on_gender_screen() {
		we = driver.findElement(By.cssSelector("span[id='genderLabel']"));
		val = we.getText();
		Assert.assertEquals(val,"Gender");

	}

	@When("I select Gender")
	public void i_select_gender() {
		we = driver.findElement(By.cssSelector("option[value='M']"));
		we.click();

	}

	@Then("Birthdate Screen must be displayed")
	public void birthdate_screen_must_be_displayed() {
		we = driver.findElement(By.cssSelector("span[id='birthdateLabel']"));
		val = we.getText();
		Assert.assertEquals(val,"Birthdate");
	}

	// ---------------------------------------------
	// Register Patient -BirthDate
	// ---------------------------------------------

	@Given("I am on BirthDate Screen")
	public void i_am_on_birth_date_screen() {
		we = driver.findElement(By.cssSelector("span[id='birthdateLabel']"));
		val = we.getText();
		Assert.assertEquals(val,"Birthdate");
	}

	@When("I give the Birth date")
	public void i_give_the_birth_date() {
		driver.findElement(By.id(("birthdateDay-field"))).sendKeys("12");
		we2 = driver.findElement(By.id("birthdateMonth-field"));
		we2.sendKeys("mar");
		we2.click();
		driver.findElement(By.id(("birthdateYear-field"))).sendKeys("1994");
	}

	@Then("Address Screen must be displayed")
	public void address_screen_must_be_displayed() {
		we = driver.findElement(By.cssSelector("li[class='question-legend focused']"));
		val = we.getText();
		Assert.assertEquals(val, "Address");

	}

	// ---------------------------------------------
	// Register Patient - Address
	// ---------------------------------------------

	@Given("I am on Address Screen")
	public void i_am_on_address_screen() {
		we = driver.findElement(By.xpath("//*[@id='formBreadcrumb']/li[2]/ul/li[1]"));
		val = we.getText();
		Assert.assertEquals(val,"Address");

	}

	@When("I give the address of the patient")
	public void i_give_the_address_of_the_patient() {
		driver.findElement(By.id("address1")).sendKeys("ABC");
		driver.findElement(By.id("address2")).sendKeys("DEF");
		driver.findElement(By.id("cityVillage")).sendKeys("gh");
		driver.findElement(By.id("stateProvince")).sendKeys("ij");
		driver.findElement(By.id("country")).sendKeys("kl");
		driver.findElement(By.id("postalCode")).sendKeys("12345");
	}

	@Then("Phone Number Screen must be displayed")
	public void phone_number_screen_must_be_displayed() {
		we = driver.findElement(By.xpath("//*[@id='formBreadcrumb']/li[2]/ul/li[2]"));
		val = we.getText();
		Assert.assertEquals(val, "Phone Number");

	}

	// ---------------------------------------------------
	// Register Patient - Phone number
	// ---------------------------------------------------

	@Given("I am on Phone Number Screen")
	public void i_am_on_phone_number_screen() {
		we = driver.findElement(By.xpath("//*[@id='formBreadcrumb']/li[2]/ul/li[2]"));
		val = we.getText();
		Assert.assertEquals(val, "Phone Number");

	}

	@When("I give the Phone number")
	public void i_give_the_phone_number() {
		driver.findElement(By.xpath("/html/body/div/div[3]/form/section[2]/div/fieldset[2]/p/input"))
				.sendKeys("9876543210");

	}

	@Then("Relatives Screen must be displayed")
	public void relatives_screen_must_be_displayed() {
		we = driver.findElement(By.xpath("//*[@id='formBreadcrumb']/li[3]/ul/li"));
		val = we.getText();
		Assert.assertEquals(val,"Relatives");
	}

	// -----------------------------------------
	// Register Patient - Relatives
	// -----------------------------------------

	@Given("I am on Relatives Screen")
	public void i_am_on_relatives_screen() {
		we = driver.findElement(By.xpath("//*[@id='formBreadcrumb']/li[3]/ul/li"));
		val = we.getText();
		Assert.assertEquals(val, "Relatives");
	}

	@When("I give the Relatives info")
	public void i_give_the_relatives_info() {
		we = driver.findElement(By.id("relationship_type"));
		we.click();
		we.sendKeys("sup");
		we2 = driver.findElement(By.cssSelector("input[placeholder='Person Name']"));
		we2.sendKeys("Anonymous2");
	}

	@When("Click on Confirm")
	public void click_on_confirm() {
		driver.findElement(By.id("submit")).click();

	}

	@Then("Patients Dashboard Page must be displayed")
	public void patients_dashboard_page_must_be_displayed() {
		we = driver.findElement(By.cssSelector("span[class='PersonName-givenName']"));
		val = we.getText();
		Assert.assertEquals(val,"Anonymous");

	}

	// ---------------------------------------------
	// Find Patient
	// ---------------------------------------------

	@Given("I am on Home Page")
	public void i_am_on_home_page() {
		we = driver.findElement(By.cssSelector("span[class='PersonName-givenName']"));
		val = we.getText();
		Assert.assertEquals(val,"Anonymous");
		we2 = driver.findElement(By.cssSelector("a[href='/openmrs/index.htm']"));
		we2.click();

	}

	@When("I click on Find Patient Record")
	public void i_click_on_find_patient_record() {
		we = driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension"));
		we.click();

	}

	@Then("Find Patient Record Page must be displayed")
	public void find_patient_record_page_must_be_displayed() {
		we = driver.findElement(By.xpath("/html/body/div/div[3]/h2"));
		val = we.getText();
		Assert.assertEquals(val,"Find Patient Record");
	}

	// --------------------------------------------
	// View Patient
	// --------------------------------------------

	@Given("I am on Find Patient Record Page")
	public void i_am_on_find_patient_record_page() {
		we = driver.findElement(By.xpath("/html/body/div/div[3]/h2"));
		val = we.getText();
		Assert.assertEquals(val,"Find Patient Record");
	}

	@When("I Search by Name")
	public void i_search_by_name() {
		we = driver.findElement(By.id("patient-search"));
		we.sendKeys("anonym");

	}

	@Then("Patients record should be displayed with correct info")
	public void patients_record_should_be_displayed_with_correct_info() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement we3 = driver.findElement(By.xpath("//*[@id='patient-search-results-table']/tbody/tr/td[3]"));
		String val2 = we3.getText();
		Assert.assertEquals(val2,"M");

		WebElement we4 = driver.findElement(By.xpath("//*[@id='patient-search-results-table']/tbody/tr/td[4]"));
		String val3 = we4.getText();
		Assert.assertEquals(val3,"28");

		WebElement we5 = driver.findElement(By.xpath("//*[@id='patient-search-results-table']/tbody/tr/td[5]"));
		String val4 = we5.getText();
		//Assert.assertEquals(val4," 12 Apr 1994");

		
		String element="/html/body/div/div[3]/div[2]/div/div/div/table/tbody/tr/td[2]";
		new WebDriverWait(driver, Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
		we2 =driver.findElement(By.xpath(element));
		val = we2.getText();
		Assert.assertEquals(val,"Anonymous User");
		we2.click();
	}

	// -------------------------------------------
	// Appointment
	// -------------------------------------------

	@Given("I am on Patients Dashboard Page")
	public void i_am_on_patients_dashboard_page() {
		we = driver.findElement(By.cssSelector("span[class='PersonName-givenName']"));
		val = we.getText();
		Assert.assertEquals(val,"Anonymous");

	}

	/*@When("I Click on Schedule Appointment")
	public void i_click_on_schedule_appointment() {
		we = driver.findElement(By.xpath("//*[@id='appointmentschedulingui.schedulingAppointmentDashboardLink']/div/div[2]"));
		we.click();
	}

	@Then("Manage Appointments Page must be displayed")
	public void manage_appointments_page_must_be_displayed() {
		we = driver.findElement(By.xpath("//*[@id='breadcrumbs']/li[3]"));
		val = we.getText();
		//Assert.assertEquals(val,"Manage Appointments");
		 
	}*/

	// --------------------------------------------------
	// Attachments
	// --------------------------------------------------

	
	  @When("I Click on Attachments") public void i_click_on_attachments() {
		  we = driver.findElement(By.xpath("//*[@id='attachments.attachments.overallActions.default']/div/div[2]"));
		  we.click();
	  
	  }
	  
	  @Then("Attachments Screen must be displayed") 
	  public void attachments_screen_must_be_displayed() {
		  we = driver.findElement(By.xpath("//*[@id='breadcrumbs']/li[3]"));
		  val = we.getText();
		  Assert.assertEquals(val,"Attachments");
	  
	  }
	  
	  //--------------------------------------------------- 
	  //Add attachment
	  //---------------------------------------------------
	  
	  
	  @Given("I am on Attachments Page") 
	  public void i_am_on_attachments_page() {
		  we = driver.findElement(By.xpath("//*[@id='breadcrumbs']/li[3]"));
		  val = we.getText();
		  Assert.assertEquals(val,"Attachments");
	  
	  }
	  
	  @When("I type for the attachment") 
	  public void i_type_for_the_attachment() {
		  we=driver.findElement(By.cssSelector("i[class='icon-sticky-note']"));
		  we.click();
		  
		  
		  new WebDriverWait(driver, Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeSelected(By.cssSelector("textarea[placeholder='Enter a note']")));
		  we2=driver.findElement(By.cssSelector("textarea[placeholder='Enter a note']"));
		  we2.sendKeys("OPD Patient");
		  
		  WebElement we3=driver.findElement(By.xpath("//*[@id='coreapps-fragment-stickyNote']/coreapps-click-to-edit-obs/div/div/div[1]/span[1]/form/div/span/button[1]/span"));
		  we3.click();
	  }
	  
	  @Then("File must be attached") 
	  public void file_must_be_attached() {
		  we=driver.findElement(By.xpath("//*[@id='TextField']/pre"));
		  val=we.getText();
		  Assert.assertEquals(val,"OPD Patient");
	  
	  }
	  
	  //-------------------------------------------------- 
	  //Delete Patient
	  //--------------------------------------------------
	  
	  
	  @Given("I am on Patients Dashboard Screen") 
	  public void i_am_on_patients_dashboard_screen() {
		  we=driver.findElement(By.cssSelector("a[href^='/openmrs/coreapps/clinicianfacing/patient.page?patientId=']"));
		  we.click();
	  
	  }
	  
	  @When("I click on Delete Patient") 
	  public void i_click_on_delete_patient() {
		  we = driver.findElement(By.xpath("//*[@id='org.openmrs.module.coreapps.deletePatient']/div/div[2]"));
		  we.click();
	  }
	  
	  @When("I give the Reason and Submit")
	  public void i_give_the_reason_and_submit() {
		  we=driver.findElement(By.id("delete-reason"));
		  we.sendKeys("Recovered");
		  
		  we2=driver.findElement(By.xpath("//*[@id='delete-patient-creation-dialog']/div[2]/button[1]"));
		  we2.click();
	  }
	
	  
	  @Then("Patient must be Deleted Successfully") 
	  public void patient_must_be_deleted_successfully() {
		  we = driver.findElement(By.id("patient-search"));
		  we.sendKeys("anonym");
		 new WebDriverWait(driver, Duration.ofSeconds(7)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='patient-search-results-table']/tbody/tr/td"),"No matching records found"));
			
		  /*we2=driver.findElement(By.xpath("//*[@class='dataTables_empty']/tbody/tr/td"));
		  val=we2.getText();
		  Assert.assertEquals(val,"No matching records found");*/
	  
	  }
	  
	  //-------------------------------------------------------- 
	  //Logout of the application 
	  //--------------------------------------------------------
	  
	  
	  @When("I click on Logout") 
	  public void i_click_on_logout() {
		  we=driver.findElement(By.cssSelector("a[href='/openmrs/appui/header/logout.action?successUrl=openmrs']"));
		  we.click();
	  
	  }
	  
	  @Then("I should be logged out of the application successfully") 
	  public void i_should_be_logged_out_of_the_application_successfully() {
		pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Login", "Logout Successful" );
	  
	  }
	 

}
