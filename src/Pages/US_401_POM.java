package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_401_POM {
    public US_401_POM() {
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(css = "[href='https://openmrs.org/tr/g%C3%B6steri/']")
    public WebElement demo;

    @FindBy(css = "[href='#openmrs2']")
    public WebElement openMrs2;

    @FindBy(css ="[href='https://demo.openmrs.org/openmrs/login.htm']" )
    public WebElement navigateToLogin;

    @FindBy(css = "[id='username']")
    public WebElement usernameInput;

    @FindBy(css = "[id='password']")
    public WebElement passwordInput;

    @FindBy(css = "[id='loginButton']")
    public WebElement loginButton;

    @FindBy(css = "[id='Inpatient Ward']")
    public WebElement InpatientWard;

    @FindBy(css = "[id='sessionLocationError']")
    public WebElement errorMessage;

    @FindBy(css = "[id='error-message']")
    public WebElement invalidUsername;
}
