package com.airlines.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "passCount")
    private WebElement noPassenger;
    @FindBy(id = "findFlights")
    private WebElement continue_btn;

    public FlightDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void SelectPassenger(String noOfPassenger) {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.noPassenger));
        Select si = new Select(noPassenger);
        si.selectByValue(noOfPassenger);
    }

    public void clickCoutinueButton() {
        this.continue_btn.click();
    }


}
