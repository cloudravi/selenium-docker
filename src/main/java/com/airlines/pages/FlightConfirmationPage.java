package com.airlines.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(),'Flight Confirmation')]")
    private WebElement flightConfirmationHeader_lbl;
    @FindBy(xpath = "(//font[contains(text(),'USD')])[2]")
    private WebElement price_lbl;
    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOff_lnk;

    public FlightConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public String printConfirmation() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationHeader_lbl));
        System.out.println(this.flightConfirmationHeader_lbl.getText());
        System.out.println(this.price_lbl.getText());
        String price = this.price_lbl.getText();
        this.signOff_lnk.click();
        return price;
    }
}
