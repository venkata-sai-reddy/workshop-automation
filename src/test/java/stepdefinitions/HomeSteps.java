package stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
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
public class HomeSteps {
	
	@Autowired
    private WebDriver driver;
	
	@Value("${host.url}")
	private String websiteUrl;

    @And("Check welcome message displayed")
    public void checkWelcomeMssg() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
        WebElement homeWelcomeMssg = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='home_page_wlcm_msg']")));
        homeWelcomeMssg.isDisplayed();
    }

    @And("Check create workshop displayed")
    public void checkCreateWorkshop() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement workshopNav = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='home_nav_menu_lis_Workshop']")));
        workshopNav.click();
        WebElement workshopCreateNav = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='home_nav_lis_btn_Create']")));
        assertTrue(workshopCreateNav.isDisplayed());
        workshopCreateNav.click();
    }
    
    @And("Check admin features displayed")
    public void checkAdminFeatures() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement usersNav = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='home_nav_menu_lis_Users']")));
        usersNav.isDisplayed();
        WebElement skillsNav = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='home_nav_menu_lis_Skills']")));
        assertTrue(skillsNav.isDisplayed());
    }

    @When("I click on view workshops")
    public void clickViewWorkshop() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement viewWorkshopBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='home_page_view_wkshop_btn']")));
        viewWorkshopBtn.click();
    }

    @Then("Should navigate to workshops page")
    public void checkWorkshopsPage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement workshopsPage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='wrkshp_title_page']")));
        assertTrue(workshopsPage.isDisplayed());
    }

    @When("Upcoming workshops displayed")
    public void checkUpcomingWorkshopDisplayed() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement upcomingWorkshopTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='home_page_upcmg_wrkshp_title']")));
        upcomingWorkshopTitle.isDisplayed();
    }

    @And("I click on first upcoming workshop")
    public void clickFirstUpcomingWorkshop() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement firstUpcomingWorkshop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='home_upcmg_wrkshp_0']")));
        firstUpcomingWorkshop.click();
    }

    @Then("Should navigate to workshop page")
    public void checkWorkshopPageDisplayed() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30) );    	
        WebElement workshopTitleField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='wrkshp_title_field']")));
        assertTrue(workshopTitleField.isDisplayed());
    }

    @Then("Workshop contains workshop name")
    public void checkWorkshopConatinsWorkshopName() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement workshopName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='home_upcmg_wrkshp_name_0']")));
        assertTrue(workshopName.isDisplayed());
    }
    
    @Then("Workshop contains workshop date")
    public void checkWorkshopConatinsWorkshopDate() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement workshopName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='home_upcmg_wrkshp_time_0']")));
        assertTrue(workshopName.isDisplayed());
    }
    
    @Then("Workshop contains workshop location")
    public void checkWorkshopConatinsWorkshopLocation() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement workshopName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='home_upcmg_wrkshp_venue_0']")));
        assertTrue(workshopName.isDisplayed());
    }
    
    @Then("Workshop contains capacity")
    public void checkWorkshopConatinsWorkshopCapacity() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement workshopName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='home_upcmg_wrkshp_cap_0']")));
        assertTrue(workshopName.isDisplayed());
    }

    @When("I click on enroll button")
    public void checkUserExistsError() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement enrollBttn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='user_enroll_btn']")));
        enrollBttn.click();
    }

    @Then("Should enroll successfully")
    public void checkEnrolledOrNot() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
    	WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='wrkshp_title_field']")));
        pageTitle.click();
    	WebElement unenrollBttn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='user_unenroll_btn']")));
        assertTrue(unenrollBttn.isDisplayed());
    }

    @When("I navigate to Home page")
    public void navigateToHomePage() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement homeBttn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='home_nav_menu_Home']")));
        homeBttn.click();
    }
    
    @When("Upcoming workshop should have user enroll status")
    public void checkEnrollStatus() throws IOException, InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement enrollStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='home_upcmg_wrkshp_enrl_0']")));
        assertTrue(enrollStatus.isDisplayed());
    }

}
