package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    private By UserNameLocator=By.xpath("//input[@placeholder='Username']");
    private By PasswordLocator=By.name("password");
    private By LoginBtnLocator=By.xpath("//button[@type='submit']");
    private By ForgotPasswordLocator=By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']");
    private By ErrorMsgLocator=By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p");
    private By AccountDDLocator =By.xpath("//*[@class=\"oxd-userdropdown-name\"]");

//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2) );

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void EnterUserName(String UserName){
        WebElement Username=driver.findElement(UserNameLocator);
        Username.sendKeys(UserName);
    }
    public void EnterPassword(String Password){
        WebElement EnterPassword=driver.findElement(PasswordLocator);
        EnterPassword.sendKeys(Password);
    }

    public void clickLoginBtn(){
//        wait.until(ExpectedConditions.elementToBeClickable(LoginBtnLocator)).click();
        WebElement ClickLoginBtn=driver.findElement(LoginBtnLocator);
        ClickLoginBtn.click();

    }
    public void ValidateForgetPassowrdLink(){
        WebElement ForgetPasswordLink=driver.findElement(ForgotPasswordLocator);
        ForgetPasswordLink.isDisplayed();

    }
    public void ValidateInvalidCredentialsErrorMsg(){
        WebElement ErrorMsg= driver.findElement(ErrorMsgLocator);
        ErrorMsg.isDisplayed();
        Assert.assertEquals(driver.findElement(ErrorMsgLocator).getText(),"Invalid credentials");
    }

    public void ValidateHomePageElements(){
        WebElement HomePageElements= driver.findElement(AccountDDLocator);
        HomePageElements.isDisplayed();

    }

}
