package stepdefinitions;

import static org.junit.Assert.assertEquals;
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
public class SignUpSteps {
	
	@Autowired
    private WebDriver driver;
	
	@Value("${host.url}")
	private String websiteUrl;
	
    @When("I click on Signup link")
    public void clickSignUpLink() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement signUpLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='sign_up_link']")));
        signUpLink.click();
    }

    @And("Fill first name {string} and last name {string}")
    public void enterUserName(String firstName, String lastName) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
        WebElement firstNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='sign_up_first_name']")));
        firstNameField.sendKeys(firstName);
        WebElement lastNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='sign_up_last_name']")));
        lastNameField.sendKeys(lastName);
    }

    @And("Fill email id {string}")
    public void enterEmailId(String emailId) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement emailIdField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='sign_up_email_id']")));
        emailIdField.sendKeys(emailId);
    }
    
    @And("Fill phone number {string}")
    public void enterPhoneNumber(String phoneNumber) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement phoneNumberField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='sign_up_phone_number']")));
        phoneNumberField.sendKeys(phoneNumber);
    }

    @And("Fill passwords {string}")
    public void enterPassword(String password) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='sign_up_create_password']")));
        passwordField.sendKeys(password);
        WebElement confirmPasswordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='sign_up_confirm_password']")));
        confirmPasswordField.sendKeys(password);
    }

    @And("Select skills")
    public void selectSkills() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement skillsField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='sign_up_skills']")));
        skillsField.click();
        skillsField.sendKeys(Keys.ARROW_DOWN);
        skillsField.sendKeys(Keys.ENTER);
    }

    @And("Select instructor")
    public void selectInstructor() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement instructor = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='sign_up_instructor']")));
        instructor.click();
    }

    @Then("I click on SignUp button")
    public void clickSignUpButton() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement signUpBttn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='sign_up_form_submit']")));
        signUpBttn.click();
    }

    @Then("Successfully should signup")
    public void checkSuccessMessage() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30) );    	
        WebElement successPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='sign_up_success_message']")));
        assertTrue(successPage.isDisplayed());
    }

    @Then("Get fields {string} required error {string}")
    public void checkUserNameFieldErrorMessage(String field, String errorMessage) throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement userNameError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(field)));
        assertTrue(userNameError.isDisplayed());
        assertEquals(errorMessage, userNameError.getText());
    }

    @Then("Get signup user exists error {string}")
    public void checkUserExistsError(String errorMessage) throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement signUpError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='sign_up_error_message']")));
        assertTrue(signUpError.isDisplayed());
        assertEquals(errorMessage, signUpError.getText());
    }

}
