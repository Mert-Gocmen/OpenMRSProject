package Project;

import Pages.US_407_410_POM;
import Utility.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_410_WrongSystemTimeZoneWhenBookingAPatientAppointment extends BaseDriver {

    @Test(dataProvider = "patientInformation")
    public void appointment(String patient) {

        US_407_410_POM elements = new US_407_410_POM();

        elements.appointmentScheduling.click();
        elements.manageAppointments.click();
        elements.searchInput.sendKeys(patient);

        wait.until(ExpectedConditions.elementToBeClickable(elements.patientRow));
        elements.patientRow.click();

        Assert.assertTrue(elements.timeZoneErrorMessage.getText().contains("time zone"));
    }

    @DataProvider
    Object[] patientInformation() {
        return new Object[]{"100KNW"};
    }
}
