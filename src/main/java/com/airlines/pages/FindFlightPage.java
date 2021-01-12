package com.airlines.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "reserveFlights")
    private WebElement firstSubmit_btn;
    @FindBy(id = "buyFlights")
    private WebElement secondSubmit_btn;

    public FindFlightPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void submitFindFlightPage() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.firstSubmit_btn));
        this.firstSubmit_btn.click();
    }

    public void SubmitBuyFlight() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.secondSubmit_btn));
        this.secondSubmit_btn.click();
    }

}
