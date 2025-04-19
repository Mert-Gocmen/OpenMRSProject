package Project;

import Pages.US_406_POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.testng.Assert.assertTrue;

public class US_406_SearchinPatientList {

    @DataProvider
    public static Object[][] patientData() {
        return new Object[][]{};
    }

    public static class PatientSearchTest {

        WebDriver driver;
        US_406_POM loginPage;
        US_406_POM homePage;
        US_406_POM findPatientPage;

        @BeforeClass
        public void setup() {
            driver = new ChromeDriver();
            driver.get("https://demo.openmrs.org/openmrs/login.htm");
            driver.manage().window().maximize();

            loginPage = new US_406_POM(driver);
            homePage = new US_406_POM(driver);
            findPatientPage = new US_406_POM(driver);

            loginPage.loginAsAdmin("admin", "Admin123");
        }

        @DataProvider(name = "patientData")
        public Object[][] patientData() {
            return new Object[][]{
                    {"Emma Hostert"},
                    {"100 HTR"},
                    {"NonExisting123"}
            };
        }

        @Test(dataProvider = "patientData", priority = 1)
        public void testPatientSearch(String keyword) {
            homePage.clickFindPatientRecord();
            findPatientPage.searchPatient(keyword);

            if (keyword.equals("NonExisting123")) {
                Assert.assertEquals(findPatientPage.getNoResultMessage(), "No matching records found");
            } else {
                Assert.assertTrue(findPatientPage.isResultVisible(keyword));
                findPatientPage.clickOnPatientResult(keyword);
                assertTrue(Objects.requireNonNull(driver.getPageSource()).contains("Patient"));
            }
        }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }

}
