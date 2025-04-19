package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_406_POM {
    WebDriver driver;

    public US_406_POM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "Inpatient Ward")
    WebElement inpatientWard;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    public void loginAsAdmin(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        inpatientWard.click();
        loginButton.click();
    }

    @FindBy(id = "coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")
    WebElement findPatientButton;

    public void clickFindPatientRecord() {
        findPatientButton.click();
    }
    @FindBy(id = "patient-search")
    WebElement searchBox;

    @FindBy(className = "dataTables_empty")
    WebElement noResultMessage;

    public void searchPatient(String keyword) {
        searchBox.clear();
        searchBox.sendKeys(keyword);
    }

    public boolean isResultVisible(String keyword) {
        return driver.getPageSource().contains(keyword);
    }

    public String getNoResultMessage() {
        return noResultMessage.getText();
    }

    public void clickOnPatientResult(String keyword) {
        WebElement result = driver.findElement(org.openqa.selenium.By.xpath("//td[contains(text(),'" + keyword + "')]"));
        result.click();
    }

}
