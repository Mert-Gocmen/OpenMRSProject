package Project;

import Pages.US_403_POM;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;


public class US_403_LoggingOutoftheSystem extends BaseDriver{
    @Test
    public void test3(){
        US_403_POM elements=new US_403_POM();
        driver.get("https://o2.openmrs.org/openmrs/login.htm");
        elements.Username.sendKeys("admin");
        elements.password.sendKeys("Admin123");

        wait.until(ExpectedConditions.elementToBeClickable(elements.inpatient)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.Loginbtn)).click();

        wait.until(ExpectedConditions.urlContains("openmrs.org"));
        Assert.assertTrue(driver.getCurrentUrl().contains("openmrs.org"));
        elements.exit.click();

        TearDown();
    }

    }

