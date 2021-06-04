package pages;

import utility.Services;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.testng.Assert.assertEquals;

public class SignupPage extends Services {

    private static Logger logger = getLogger(SignupPage.class.getName());

    private final static String HEADING = "Get started free today";
    public static final String MSG_SUCCESS = "Check your email";
    private String xpathHeading = "//h1";
    private String xpathName = "//input[@data-autotest-id='mr-form-signup-name-1']";
    private String xpathEmail = "//input[@data-autotest-id='mr-form-signup-email-1']";
    private String xpathPassword = "//input[@data-autotest-id='mr-form-signup-password-1']";
    private String xpathTC = "//label[@class='mr-checkbox-1__check'][@for='signup-terms']";
    private String xpathGetStartedButton = "//button[@data-autotest-id='mr-form-signup-btn-start-1']";
    private String xpathMsg = "//h1";

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public void verifySignupPageHeader() {
        waitForElement(xpathHeading);
        WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
        String actualHeading = headerEle.getText();
        logger.info("# Actual Heading: " + actualHeading);
        assertEquals(actualHeading, HEADING,
                "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
    }

    public void EnterName(String username) {
        getWebElement(xpathName).click();
        type(xpathName, username);
    }

    public void EnterEmail(String email) {
        getWebElement(xpathEmail).click();
        type(xpathEmail, email);
    }

    public void EnterPassword(String password) {
        getWebElement(xpathPassword).click();
        type(xpathPassword, password);
    }

    public void AcceptTC() {
        getWebElement(xpathTC).click();
    }

    public void ClickGetStartedButton() {
        getWebElement(xpathGetStartedButton).click();
    }

    public void verifyLogin(String username, String email, String password) {
        EnterName(username);
        EnterEmail(email);
        EnterPassword(password);
        AcceptTC();
        ClickGetStartedButton();
        waitForElementVisible(xpathMsg);
        String actualMsg = driver.findElement(By.xpath(xpathMsg)).getText().trim();
        assertTrue(actualMsg.contains(MSG_SUCCESS),
                "Actual '" + actualMsg + "' should be same as expected '" + MSG_SUCCESS + "'.");
    }

}
