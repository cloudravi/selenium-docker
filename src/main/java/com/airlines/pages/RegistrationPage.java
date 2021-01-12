package com.airlines.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "REGISTER")
    private WebElement register_lnk;
    @FindBy(name = "firstName")
    private WebElement firtName_txt;
    @FindBy(name = "lastName")
    private WebElement lastName_txt;
    @FindBy(id = "email")
    private WebElement userName_txt;
    @FindBy(name = "password")
    private WebElement password_txt;
    @FindBy(name = "confirmPassword")
    private WebElement confirmPassword_txt;
    @FindBy(id = "register-btn")
    private WebElement submit_btn;


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void launchURL() {
        driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");
    }

    public void clickRegisterLink() {
        this.register_lnk.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.firtName_txt));
    }

    public void enterUserDetails(String firstName, String lastName) {
        this.firtName_txt.sendKeys(firstName);
        this.lastName_txt.sendKeys(lastName);
    }

    public void enterCredentials(String userName, String password) {
        this.userName_txt.sendKeys(userName);
        this.password_txt.sendKeys(password);
        this.confirmPassword_txt.sendKeys(password);
    }

    public void clickSubmit() {
        this.submit_btn.click();
    }

}
