package testcases;

import pages.SignupPage;
import pages.ConfirmSignupPage;
import utility.Init;
import java.util.Random;
import org.testng.annotations.DataProvider;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static pages.SignupPage.MSG_SUCCESS;
import static org.testng.Assert.assertTrue;

public class TestSignup extends Init {

    @DataProvider
    public static Object[][] validCredentials() {
        int length = 7;
        String generatedString = RandomStringUtils.randomAlphabetic(length);
        String email = generatedString.concat("@test.com");
        return new Object[][]{{generatedString, email ,"SuperSecretPassword!"}};
    }


    @Test(dataProvider = "validCredentials")
    public void testSignup(String username, String email, String password) {
        SignupPage signupPage = new SignupPage(driver);
        signupPage.verifyLogin(username, email, password);

        ConfirmSignupPage confirmsignuppage = new ConfirmSignupPage(driver);
        confirmsignuppage.verifyConfirmSignupPageHeader();


        String actualMsg = confirmsignuppage.getMsgSuccess();
        assertTrue(actualMsg.contains(MSG_SUCCESS),
                "Actual '" + actualMsg + "' should be same as expected '" + MSG_SUCCESS + "'.");
    }

}
