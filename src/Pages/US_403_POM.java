package Pages;


import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_403_POM  {

    public US_403_POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }
    @FindBy(xpath = "//input[@name='username']")
    public WebElement Username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//ul[@class='select']/li[1]")
    public WebElement inpatient;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement Loginbtn;

    @FindBy(xpath = "//a[@href='/openmrs/appui/header/logout.action?successUrl=openmrs']")
    public WebElement exit;
    }
