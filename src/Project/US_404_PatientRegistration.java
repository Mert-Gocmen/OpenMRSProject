package Project;

import Pages.US_404_POM;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class US_404_PatientRegistration extends BaseDriver {

    @Test
    public void test4() {

        US_404_POM elements = new US_404_POM();
        driver.get("https://o2.openmrs.org/openmrs/login.htm");

        elements.userName.sendKeys("admin");
        elements.password.sendKeys("Admin123");
        elements.locations.click();
        elements.loginBtn.click();
        elements.registerPatient.click();
        elements.given.sendKeys("Samantha");
        elements.familyName.sendKeys("Black");
        elements.gender.click();
        elements.femaleBtn.click();
        elements.birthDateBtn.click();
        elements.birthDay.sendKeys("8");
        elements.SelectMonth.sendKeys("Jun");
        elements.birthYear.sendKeys("1975");
        elements.addressBtn.click();
        elements.address.sendKeys("505 Maple St, Buffalo, NY");
        elements.phoneNumberBtn.click();
        elements.phoneNumber.sendKeys("(555) 890-1234");
        elements.Relatives.click();
        elements.SelectRelationship.sendKeys("Niece/Nephew");
        elements.nextBtn.click();
        elements.confirm.click();


        String actualMsg = elements.createdMsg.getAttribute("innerText");
        System.out.println("📢 Gelen mesaj: " + actualMsg);

        Assert.assertTrue(actualMsg.toLowerCase().contains("created"), "Mesaj 'Created' içermiyor!");

        TearDown();
    }
}
