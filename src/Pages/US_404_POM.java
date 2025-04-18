package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class US_404_POM {
    public US_404_POM() { PageFactory.initElements(BaseDriver.driver, this); }

    @FindBy(id="username")
    public WebElement userName;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id="Inpatient Ward")
    public WebElement locations;

    @FindBy(id="loginButton")
    public WebElement loginBtn;

    @FindBy(xpath = "//a[@type='button'][4]")
    public WebElement registerPatient;

    @FindBy(name = "givenName")
    public WebElement given;

    @FindBy(name = "familyName")
    public WebElement familyName;

    @FindBy(xpath = "//span[@id='genderLabel']")
    public WebElement gender;

    @FindBy(xpath = "//*[text()='Female']")
    public WebElement femaleBtn;

    @FindBy(xpath = "//span[@id='birthdateLabel']")
    public WebElement birthDateBtn;

    @FindBy(id = "birthdateDay-field")
    public WebElement birthDay;

    @FindBy(id = "birthdateMonth-field")
    public WebElement SelectMonth;

    @FindBy(id = "birthdateYear-field")
    public WebElement birthYear;

    @FindBy(xpath = "//span[text()='Address']")
    public WebElement addressBtn;

    @FindBy(id="address1")
    public WebElement address;

    @FindBy(xpath = "//span[text()='Phone Number']")
    public WebElement phoneNumberBtn;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//span[text()='Relatives']")
    public WebElement Relatives;

    @FindBy(id = "relationship_type")
    public WebElement SelectRelationship;

    @FindBy(id = "next-button")
    public WebElement nextBtn;

    @FindBy(id = "submit")
    public WebElement confirm;

    @FindBy(css= "[class='icon-ok medium']+p")
    public WebElement createdMsg;

}
