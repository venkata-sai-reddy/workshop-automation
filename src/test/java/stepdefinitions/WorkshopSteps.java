package stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.clarku.workshop.config.DriverConfig;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@SpringBootTest(classes = DriverConfig.class)
public class WorkshopSteps {
	
	@Autowired
    private WebDriver driver;
	
	@Value("${host.url}")
	private String websiteUrl;
	
    @When("I click on workshop")
    public void clickWorkshop() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement workshopLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='home_nav_menu_lis_Workshop']")));
        workshopLink.click();
    }

    @And("I click on view")
    public void clickViewWorkshop() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
        WebElement viewWorkshop = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='home_nav_lis_btn_View']")));
        viewWorkshop.click();
    }

    @And("I click on request workshop")
    public void clickRequestWorkshop() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement clickRequestWorkshop = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='home_nav_lis_btn_Request_Workshop']")));
        clickRequestWorkshop.click();
    }
    
    @Then("Request workshop page should pop up")
    public void requestWorkshopPage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement requestPageTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='wrkshp_req_title']")));
        assertTrue(requestPageTitle.isDisplayed());
    }

    @And("I enter request skills {string}")
    public void enterRequestSkills(String skills) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement skillsField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='req_wrkshp_skills_field']")));
        skillsField.sendKeys(skills);
        skillsField.sendKeys(Keys.ENTER);
    }

    @And("I click on request")
    public void clickRequest() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement requestSkills = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='req_wrkshp_request_btn']")));
        requestSkills.click();
    }

    @When("I click on activity")
    public void clickActivity() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) ); 
    	WebElement activityBttn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[automationId='home_nav_menu_lis_Activity']")));
        activityBttn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='home_nav_menu_lis_Activity']")));
        activityBttn.click();
    }
    
    @Then("Request should successful")
    public void checkRequestSuccess() {
    	driver.navigate().refresh();
    }

    @And("I click on requested skills")
    public void clickRequestSkills() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement requestSkillsBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='home_nav_lis_btn_Requested_Skills']")));
        requestSkillsBtn.click();
    }

    @Then("I should able to see the requested skills {string}")
    public void checkSkills(String skills) throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30) );    	
        WebElement skillsGlobalFilter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='global_search_content']")));
        skillsGlobalFilter.sendKeys(skills);
        WebElement isFieldAvailable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='table_row_data_skillName_0'")));
        assertTrue(isFieldAvailable.isDisplayed());
    }

    @And("I click on enrolled skills")
    public void clickEnrolledSkills() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement enrolledSkillBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='home_nav_lis_btn_Enrolled_Workshops'")));
        enrolledSkillBtn.click();
    }

    @Then("I should able to see the enrolled skills")
    public void checkEnrolledSkillsPage() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement enrolledskillsPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='enrolled_wrkshp_title']")));
        assertTrue(enrolledskillsPageTitle.isDisplayed());
    }
    
    @And("I click on unenroll icon")
    public void clickUnEnrollIcon() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement unenrollWorkshopBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='user_unenroll_btn']")));
        unenrollWorkshopBtn.click();
    }

    @When("I click on first enrolled workshop")
    public void clickOnFirstWorkshop() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30) );    	
        WebElement firstWorkshop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='table_row_data_workshopName_0']")));
        firstWorkshop.click();
    }

    @Then("Should be unenrolled successfully with icon")
    public void checkUnEnrolledSuccess() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement enrolledSkillBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='user_enroll_btn'")));
        assertTrue(enrolledSkillBtn.isDisplayed());
    }    
    
    @And("I click on create")
    public void clickCreateWorkshop() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement createWorkshopBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='home_nav_lis_btn_Create']")));
        createWorkshopBtn.click();
    }

    @Then("Should navigate to create workshops page")
    public void checkCreateWorkshopPage() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30) );    	
        WebElement checkCreatePage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='create_workshop_title_page']")));
        assertTrue(checkCreatePage.isDisplayed());
    }

    @When("I fill workshop name {string}")
    public void fillWorkshopName(String workshopName) throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement workshopNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='create_wrkshp_title_field'")));
        workshopNameField.sendKeys(workshopName);
    }

    @And("I fill workshop description {string}")
    public void fillWorkshopDescription(String description) throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='create_wrkshp_desc_field'")));
        descriptionField.sendKeys(description);
    }
    
    @And("I select workshop skills")
    public void selectWorkshopSkills() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement selectWorkshopField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='create_wrkshp_skills_field'")));
        selectWorkshopField.click();
        selectWorkshopField.sendKeys(Keys.ARROW_DOWN);
        selectWorkshopField.sendKeys(Keys.ENTER);
    }
    
    @And("I select venue")
    public void selectVenue() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement venueField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='create_wrkshp_location_field'")));
        venueField.click();
        venueField.sendKeys(Keys.ARROW_DOWN);
        venueField.sendKeys(Keys.ENTER);
    }

    @And("I fill workshop date")
    public void fillWorkshopDate() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement workshopDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='create_wrkshp_date_field'")));
        workshopDateField.click();
        workshopDateField.sendKeys("01");
        workshopDateField.sendKeys("30");
        workshopDateField.sendKeys("2025");
    }

    @And("I fill workshop start time")
    public void fillWorkshopStartTime() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement workshopStartTimeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='create_wrkshp_start_time_field'")));
        workshopStartTimeField.click();
        workshopStartTimeField.sendKeys("10");
        workshopStartTimeField.sendKeys("30");
        workshopStartTimeField.sendKeys("AM");
    }
    
    @And("I fill workshop end time")
    public void fillWorkshopEndtime() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement workshopEndTimeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='create_wrkshp_end_time_field'")));
        workshopEndTimeField.click();
        workshopEndTimeField.sendKeys("12");
        workshopEndTimeField.sendKeys("00");
        workshopEndTimeField.sendKeys("PM");
    }
    
    @And("I click on create workshop")
    public void clickOnCreateWorkshop() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement createWorkshopBttn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='create_wrkshp_create_button'")));
        createWorkshopBttn.click();
    }
    
    @When("I click on first workshop")
    public void clickOnfirstWorkshop() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement firstWorkshop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='table_row_data_workshopName_0'")));
        firstWorkshop.click();
    }

    @And("I should able to see the edit icon")
    public void checkEditWorkshopPage() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement editIconWorkshop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='admin_edit_wrkshp']")));
        assertTrue(editIconWorkshop.isDisplayed());
    }

}
