package pages;

import utility.Services;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.testng.Assert.assertEquals;

public class ConfirmSignupPage extends Services {

    private static Logger logger = getLogger(ConfirmSignupPage.class.getName());

    public static final String HEADING = "Check your email";
    private String xpathMsg = "//h1";

    public ConfirmSignupPage(WebDriver driver) {
        super(driver);
    }

    public void verifyConfirmSignupPageHeader() {
        waitForElement(xpathMsg);
        WebElement headerEle = driver.findElement(By.xpath(xpathMsg));
        String actualHeading = headerEle.getText();
        logger.info("# Actual Heading: " + actualHeading);
        assertEquals(actualHeading, HEADING,
                "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
    }

    public String getMsgSuccess() {
        waitForElementVisible(xpathMsg);
        return driver.findElement(By.xpath(xpathMsg)).getText().trim();
    }

}
