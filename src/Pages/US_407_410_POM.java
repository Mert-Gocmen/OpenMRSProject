package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_407_410_POM {

    public US_407_410_POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "(//div[@id='apps']/a)[1]")
    public WebElement findPatientRecordButton;

    @FindBy(xpath = "//input[@id='patient-search']")
    public WebElement searchInput;

    @FindBy(xpath = "//table[@id='patient-search-results-table']/tbody/tr")
    public WebElement patientRow;

    @FindBy(xpath = "(//div[@class='row'])[9]")
    public WebElement deletePatient;

    @FindBy(xpath = "//input[@id='delete-reason']")
    public WebElement deleteReasonInput;

    @FindBy(xpath = "(//button[@class='confirm right'])[6]")
    public WebElement confirmButton;

    @FindBy(xpath = "//*[contains(text(), 'deleted')]")
    public WebElement deleteSuccessMessage;

    @FindBy(xpath = "(//div[@id='apps']/a)[5]")
    public WebElement appointmentScheduling;

    @FindBy(xpath = "(//div[@id='apps']/div)[3]")
    public WebElement manageAppointments;

    @FindBy(xpath = "//div[@id='time-zone-warning']//p")
    public WebElement timeZoneErrorMessage;
}
