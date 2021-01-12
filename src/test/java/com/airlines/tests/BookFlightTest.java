package com.airlines.tests;

import BasePackage.BaseTest;
import com.airlines.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {

    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers", "expectedPrice"})
    public void setupParameter(String noOfPassengers, String expectedPrice) {
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;

    }

    @Test
    public void RegistrationPageTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.launchURL();
        registrationPage.clickRegisterLink();
        registrationPage.enterUserDetails("selenium", "docker");
        registrationPage.enterCredentials("selenium", "docker");
        registrationPage.clickSubmit();
    }

    @Test(dependsOnMethods = "RegistrationPageTest")
    public void RegistrationConfirmationPageTest() {
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.clickFlightLink();
    }

    @Test(dependsOnMethods = "RegistrationConfirmationPageTest")
    public void FlightDetailsPageTest() {
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.SelectPassenger(noOfPassengers);
        flightDetailsPage.clickCoutinueButton();
    }

    @Test(dependsOnMethods = "FlightDetailsPageTest")
    public void FindFlightPageTest() {
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.submitFindFlightPage();
        findFlightPage.SubmitBuyFlight();
    }

    @Test(dependsOnMethods = "FindFlightPageTest")
    public void FlightConfirmationPageTest() {
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actualPrice = flightConfirmationPage.printConfirmation();
        Assert.assertEquals(expectedPrice, actualPrice);
    }


}
