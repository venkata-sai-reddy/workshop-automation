package stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = DriverConfig.class)
public class LoginSteps {
	
	@Autowired
    private WebDriver driver;
	
	@Value("${host.url}")
	private String websiteUrl;

    @Given("Navigate to the website")
    public void navigateToWebsite() {
        driver.get(websiteUrl);
    }
    
    @When("I enter username {string}")
    public void enterUserName(String userName) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
        WebElement userNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='login_form_email_id']")));
        userNameField.sendKeys(userName);
    }

    @And("I enter password {string}")
    public void enterPassword(String password) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='login_form_password']")));
        passwordField.sendKeys(password);
    }

    @When("I click on login button")
    public void clickLoginButton() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='login_form_signin']")));
        loginButton.click();
    }

    @Then("Should get field error message for username")
    public void checkFieldErrors() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement emailError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_form_email-helper-text")));
        assertTrue(emailError.isDisplayed());
    }

    @Then("Should get error message for username as {string}")
    public void checkUserNameFieldErrorMessage(String errorMessage) throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement userNameError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_form_email-helper-text")));
        assertTrue(userNameError.isDisplayed());
        assertEquals(errorMessage, userNameError.getText());
    }

    @Then("Should get field error message for password")
    public void checkFieldErrorPassword() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement passwordError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_form_password-helper-text")));
        assertTrue(passwordError.isDisplayed());
    }

    @Then("Should get error message for password as {string}")
    public void checkPasswordFieldErrorMessage(String errorMessage) throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement passwordError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_form_password-helper-text")));
        assertTrue(passwordError.isDisplayed());
        assertEquals(errorMessage, passwordError.getText());
    }

    
    @Then("Should navigate to home page")
    public void checkHomePage() throws IOException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement homePage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='home']")));
        assertTrue(homePage.isDisplayed());
        String currentUrl = driver.getCurrentUrl();
    	assertTrue(currentUrl.endsWith("/home"));
    }
    
    @When("User avatar is clicked on home page")
    public void avatarClicked() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
    	WebElement avatarButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='home_user_avatar_button']")));
        avatarButton.click();
    }
    
    @Then("Logout is clicked on home page")
    public void logoutClicked() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement logoutButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='home_user_Logout']")));
        logoutButton.click();
        WebElement loginScreenCheck = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='login_form_email_id']")));
        assertTrue(loginScreenCheck.isDisplayed());
    }

    @When("I update url to {string}")
    public void updateUrl(String url) {
    	driver.navigate().to(websiteUrl+url);
    }

    @Then("Should be able to see landing page")
    public void checkLandingPage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement landingPage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='landing_page']")));
        assertTrue(landingPage.isDisplayed());
    }

    @Then("Should navigate to login page")
    public void checkLoginPage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement loginComponent = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[automationId='login_container']")));
        assertTrue(loginComponent.isDisplayed());
    }

    @Then("Should get login error message")
    public void checkLoginErrorMessage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );    	
        WebElement loginError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[automationId='login_container_errors']")));
        assertTrue(loginError.isDisplayed());
    }

    @When("Refresh page and check same page")
    public void refreshPage() {
    	String initialPage = driver.getCurrentUrl();
    	driver.navigate().refresh();
    	assertEquals(initialPage, driver.getCurrentUrl());
    }

}
