package org.example.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageStepDf {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        driver= new ChromeDriver();

    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Given("I am on the OrangeHRM HRM Login Page")
    public void iAmOnTheOpencartLoginPage() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage=new LoginPage(driver);
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        System.out.println("Im on homePage");
    }


    @Given("I enter login credentials of the application")
    public void iNavigateToOpencartApplication() throws InterruptedException {

        loginPage.EnterUserName("Admin");
        Thread.sleep(2000);
        loginPage.EnterPassword("admin123");
        Thread.sleep(2000);
        System.out.println("I have entered valid credentials");
    }

    @When("I click on login btn")
    public void i_click_on_login_page() throws InterruptedException {
        loginPage.ValidateForgetPassowrdLink();
        loginPage.clickLoginBtn();
        Thread.sleep(3000);
    }

    @Then("I should be logged in successfully")
    public void iShouldBeAbleToEnterEmail() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("I have logged in successfully");
    }


    @Given("I enter invalid {string} and {string}")
    public void iEnterInvalidAnd(String User, String Pass) throws InterruptedException {
        loginPage.EnterUserName(User);
        Thread.sleep(2000);
        loginPage.EnterPassword(Pass);
        Thread.sleep(2000);
        System.out.println("I have entered invalid credentials");
        
    }

    @Then("I should see an ErrorMsg")
    public void iShouldSeeAn() {
        loginPage.ValidateInvalidCredentialsErrorMsg();
    }

    @Then("I should be able to validate Homepage Elements successfully")
    public void iShouldBeAbleToValidateHomepageElementsSuccessfully() {
        loginPage.ValidateHomePageElements();
    }
}
