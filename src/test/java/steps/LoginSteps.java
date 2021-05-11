package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertEquals;

@Log4j2
public class LoginSteps {
    LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage();
    }

    @Step("Log in")
    public LoginSteps login(String username, String password) {
        log.info("Edit Email: " + username + ", and Password: " + password);
        loginPage
                .openLoginPage()
                .isPageOpened()
                .login(username, password);
        return this;
    }

    @Step("Invalid data")
    public LoginSteps invalidLogin(String username, String password) {
        log.info("Edit Email: " + username + ", and Password: " + password);
        loginPage
                .openLoginPage()
                .isPageOpened()
                .invalidLogin(username, password);
        return this;
    }

    @Step("Validate error message")
    public LoginSteps validateErrorMessage(String errorMessage) {
        log.info("Validate error message: " + errorMessage);
        assertEquals(loginPage.getErrorMessage(), errorMessage);
        return this;
    }

}
