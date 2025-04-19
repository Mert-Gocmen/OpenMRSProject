package Project;

import Pages.US_402_POM;
import Utility.BaseDriver;
import Utility.MyFunc;

import java.time.Duration;

public class US_402_LogintotheSystem extends BaseDriver {

    @Test(dataProvider = "invalidCredentials")
    public void invalidLoginTest(String username, String password, boolean selectLocation) {
        US_402_POM pom = new US_402_POM();
        Actions actions = new Actions(driver);
        driver.get("https://openmrs.org/tr/");

        pom.demo.click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.exploreOpenMrs2));
        actions.scrollToElement(pom.exploreOpenMrs2).pause(Duration.ofMillis(300)).click(pom.exploreOpenMrs2).build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(pom.enterOpenMrs2));
        actions.scrollToElement(pom.enterOpenMrs2).pause(Duration.ofMillis(300)).click(pom.enterOpenMrs2).build().perform();

        wait.until(ExpectedConditions.visibilityOf(pom.usernameInput));
        pom.usernameInput.clear();
        pom.usernameInput.sendKeys(username);
        pom.passwordInput.clear();
        pom.passwordInput.sendKeys(password);

        if (selectLocation) {
            wait.until(ExpectedConditions.elementToBeClickable(pom.locationInpatientWard));
            pom.locationInpatientWard.click();
        }

        wait.until(ExpectedConditions.elementToBeClickable(pom.loginButton));
        pom.loginButton.click();

        MyFunc.wait(2);

        if (!selectLocation) {
            Assert.assertTrue(pom.locationError.getText().contains("You must choose a location!"), "Location hatası bekleniyordu.");
        } else {
            Assert.assertTrue(pom.loginError.getText().contains("Invalid username/password"), "Geçersiz giriş mesajı bekleniyordu.");
        }
    }

    @Test
    public void validLoginTest() {
        US_402_POM pom = new US_402_POM();
        Actions actions = new Actions(driver);
        driver.get("https://openmrs.org/tr/");

        pom.demo.click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.exploreOpenMrs2));
        actions.scrollToElement(pom.exploreOpenMrs2).pause(Duration.ofMillis(300)).click(pom.exploreOpenMrs2).build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(pom.enterOpenMrs2));
        actions.scrollToElement(pom.enterOpenMrs2).pause(Duration.ofMillis(300)).click(pom.enterOpenMrs2).build().perform();

        wait.until(ExpectedConditions.visibilityOf(pom.usernameInput));
        pom.usernameInput.sendKeys("Admin");
        pom.passwordInput.sendKeys("Admin123");

        wait.until(ExpectedConditions.elementToBeClickable(pom.locationInpatientWard));
        pom.locationInpatientWard.click();
        pom.loginButton.click();

        MyFunc.wait(2);

        Assert.assertFalse(driver.getCurrentUrl().contains("login.htm"), "Login başarısız görünüyor.");
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] getInvalidData() {
        return new Object[][]{{"Admin", "wrongpass", true}, {"wronguser", "Admin123", true}, {"", "Admin123", true}, {"Admin", "", true}, {"Admin", "Admin123", false}, {"", "", false}}
    }
}