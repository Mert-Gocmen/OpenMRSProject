package Project;

import Pages.US_401_POM;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class US_401_CheckingLoginErrors extends BaseDriver {

    @Test
    @Parameters({"username","password"})
    public void Test1(String username, String password){
        Actions actions=new Actions(driver);
        US_401_POM pom=new US_401_POM();
        driver.get("https://openmrs.org/tr/");
        pom.demo.click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.openMrs2));
        actions.scrollToElement(pom.openMrs2).pause(Duration.ofMillis(3)).click(pom.openMrs2).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(pom.navigateToLogin));
        actions.scrollToElement(pom.navigateToLogin).pause(Duration.ofMillis(3)).click(pom.navigateToLogin).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(pom.usernameInput));
        pom.usernameInput.sendKeys(username);
        pom.passwordInput.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(pom.loginButton));
        pom.loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(pom.errorMessage));
        Assert.assertTrue(pom.errorMessage.getText().contains("You must choose a location!"));
        pom.usernameInput.clear();
        pom.usernameInput.sendKeys(username);
        pom.passwordInput.clear();
        pom.passwordInput.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(pom.InpatientWard));
        actions.click(pom.InpatientWard).pause(Duration.ofMillis(3)).perform();
        actions.click(pom.loginButton).pause(Duration.ofMillis(3)).perform();
        wait.until(ExpectedConditions.visibilityOf(pom.invalidUsername));
        Assert.assertTrue(pom.invalidUsername.getText().contains("Invalid username/password. Please try again."));
        MyFunc.wait(5);

    }

}
