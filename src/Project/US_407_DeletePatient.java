package Project;

import Pages.US_407_410_POM;
import Utility.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_407_DeletePatient extends BaseDriver {

    @Test(dataProvider = "patientInformation")
    public void deletePatient(String patient) {

        US_407_410_POM elements = new US_407_410_POM();

        elements.findPatientRecordButton.click();
        elements.searchInput.sendKeys(patient);

        wait.until(ExpectedConditions.elementToBeClickable(elements.patientRow));
        elements.patientRow.click();

        elements.deletePatient.click();
        elements.deleteReasonInput.sendKeys("Incorrect information");

        wait.until(ExpectedConditions.elementToBeClickable(elements.confirmButton));
        elements.confirmButton.click();

        Assert.assertTrue(elements.deleteSuccessMessage.getText().contains("deleted"));
    }

    @DataProvider
    Object[] patientInformation() {
        return new Object[]{"1007P6"};
    }
}
