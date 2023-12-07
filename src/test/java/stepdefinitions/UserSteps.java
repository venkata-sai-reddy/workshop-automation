package stepdefinitions;

import static org.junit.Assert.assertTrue;

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

@SpringBootTest(classes = DriverConfig.class)
public class UserSteps {
	
	@Autowired
    private WebDriver driver;
	
	@Value("${host.url}")
	private String websiteUrl;
	
    @And("Profile is clicked on home page")
    public void clickUserProfile() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement profileBttn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='home_user_Profile']")));
        profileBttn.click();
    }

    @Then("User Profile should display")
    public void checkUserProfileDisplayed() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement userProfileAvatar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='user_prof_avatar']")));
        assertTrue(userProfileAvatar.isDisplayed());
        WebElement userProfileType = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='user_prof_type']")));
        assertTrue(userProfileType.isDisplayed());
        WebElement userProfileName = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='user_prof_name']")));
        assertTrue(userProfileName.isDisplayed());
        WebElement userProfileEmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='user_prof_email_id']")));
        assertTrue(userProfileEmail.isDisplayed());
        WebElement userProfileChangePass = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='user_prof_change_pass_btn']")));
        assertTrue(userProfileChangePass.isDisplayed());
    }
    
}
