package Project;

import Pages.US_409_POM;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utility.BaseDriver.driver;
import static Utility.BaseDriver.wait;

public class US_409_MergePatientRecord {


    @Test
    public void mergeTwoPatientsTest() {
        String ID1 = "100GF"; // Örnek hasta ID - US_404'ten alınmalı
        String ID2 = "101GH";

        US_409_POM pom = new US_409_POM();
        driver.get("https://demo.openmrs.org/openmrs/referenceapplication/home.page");

        wait.until(ExpectedConditions.elementToBeClickable(pom.dataManagementLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.mergePatientRecordsButton)).click();

        wait.until(ExpectedConditions.visibilityOf(pom.patientIdField1)).sendKeys(ID1);
        pom.patientIdField2.sendKeys(ID2);

        pom.continueButton.click();

        wait.until(ExpectedConditions.visibilityOf(pom.mergeWarningMessage));
        Assert.assertTrue(pom.mergeWarningMessage.getText().contains("Merging cannot be undone"),
                "Uyarı mesajı görünmedi!");

        wait.until(ExpectedConditions.elementToBeClickable(pom.selectMergeTargetRadioButton)).click();
        pom.yesContinueButton.click();

        wait.until(ExpectedConditions.visibilityOf(pom.mergedPatientIdInfo));
        String infoText = pom.mergedPatientIdInfo.getText();

        Assert.assertTrue(infoText.contains(ID1) || infoText.contains(ID2));
    }

}
