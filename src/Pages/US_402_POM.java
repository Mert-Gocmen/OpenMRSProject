package Pages;

import Utility.BaseDriver;

@FindBy(css = "[href='https://openmrs.org/tr/g%C3%B6steri/']")
public WebElement demo;
@FindBy(css = "[href='#openmrs2']")
public WebElement exploreOpenMrs2;
@FindBy(css = "[href='https://demo.openmrs.org/openmrs/login.htm']")
public WebElement enterOpenMrs2;
@FindBy(id = "username")
public WebElement usernameInput;
@FindBy(id = "password")
public WebElement passwordInput;
@FindBy(id = "Inpatient Ward")
public WebElement locationInpatientWard;
@FindBy(id = "loginButton")
public WebElement loginButton;
@FindBy(id = "error-message")
public WebElement loginError;
@FindBy(id = "sessionLocationError")
public WebElement locationError;

public US_402_POM() {
    PageFactory.initElements(BaseDriver.driver, this);
}
