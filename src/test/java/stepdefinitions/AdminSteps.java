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
public class AdminSteps {
	
	@Autowired
    private WebDriver driver;
	
	@Value("${host.url}")
	private String websiteUrl;
	
    @When("I click on Users")
    public void clickUsersLink() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement usersLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='home_nav_menu_lis_Users']")));
        usersLink.click();
    }

    @And("I click on All Users")
    public void clickAllUsers() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
        WebElement allUsersLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='home_nav_lis_btn_View_Users']")));
        allUsersLink.click();
    }

    @Then("Should able to see all the users")
    public void checkAllUsers() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
    	WebElement allUserTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='admin_all_user_title_page']")));
    	allUserTitle.isDisplayed();
    	WebElement userList = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='table_row_data_firstName_0']")));
        assertTrue(userList.isDisplayed());
    }
    
    @And("I click on create user")
    public void clickCreateUser() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement createUserLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='home_nav_lis_btn_Create_Users']")));
        createUserLink.click();
    }

    @Then("Should able to see create user page")
    public void checkCreateUserPage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement createUserPageTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='admin_create_user_header']")));
        assertTrue(createUserPageTitle.isDisplayed());
    }

    @When("I click on Skills")
    public void selectSkills() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement skillsLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='home_nav_menu_lis_Skills']")));
        skillsLink.click();
    }

    @And("I click on All Skills")
    public void selectAllSkills() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement allSkillsLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='home_nav_lis_btn_All_Skills']")));
        allSkillsLink.click();
    }

    @Then("Should able to see all the skills")
    public void checkAllSkillsPage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement allSkillsPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='admin_skills_page_title']")));
        assertTrue(allSkillsPageTitle.isDisplayed());
    }

    @Then("I click on All Requested Skills")
    public void clickRequestedSkills() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30) );    	
        WebElement requestedSkillsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='home_nav_lis_btn_Approve_Skills']")));
        requestedSkillsLink.click();
    }

    @Then("Should able to see all the requested skills")
    public void checkUserNameFieldErrorMessage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30) );    	
        WebElement requestedSkillsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='admin_skill_approve_page_title']")));
        assertTrue(requestedSkillsTitle.isDisplayed());
    }

}
