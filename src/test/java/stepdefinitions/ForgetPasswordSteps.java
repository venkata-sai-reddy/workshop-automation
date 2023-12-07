package stepdefinitions;

import static org.junit.Assert.assertEquals;
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
public class ForgetPasswordSteps {
	
	@Autowired
    private WebDriver driver;
	
	@Value("${host.url}")
	private String websiteUrl;
	
    @When("I click on forget password link")
    public void clickForgetPassLink() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement forgetPassLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='forget_pass_link']")));
        forgetPassLink.click();
    }

    @And("I enter emailid {string}")
    public void enterEmailId(String emailId) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
        WebElement emailIdField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='forget_pass_form_email_id']")));
        emailIdField.sendKeys(emailId);
    }

    @And("I click on forget password button")
    public void clickForgetPassBtn() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement forgetPassBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='forget_pass_form_submit']")));
        forgetPassBtn.click();
    }
    
    @Then("Should display success message")
    public void checkSuccessMessage() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30) );    	
        WebElement successPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='forget_pass_form_success']")));
        assertTrue(successPage.isDisplayed());
    }

    @Then("Should display field error message {string}")
    public void checkUserNameFieldErrorMessage( String errorMessage) throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement emailIdError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("forget_pass_form_email-helper-text")));
        assertTrue(emailIdError.isDisplayed());
        assertEquals(errorMessage, emailIdError.getText());
    }

    @Then("Gets user exists error {string}")
    public void checkUserExistsError(String errorMessage) throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement forgetPassError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='forget_pass_form_error']")));
        assertTrue(forgetPassError.isDisplayed());
        assertEquals(errorMessage, forgetPassError.getText());
    }

    @Then("Should display error message {string}")
    public void checkErrorMessage(String message) throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30) );    	
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='forget_pass_form_error']")));
        assertTrue(errorMessage.isDisplayed());
        assertEquals(message, errorMessage.getText());
    }
}
