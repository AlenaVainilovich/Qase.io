package tests;

import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import utils.Retry;

import static pages.ProjectsPage.PROJECT_NAME_LINK;

@Feature("Login")
public class LoginTest extends BaseTest {

    String invalidUsername = faker.bool().toString();
    String invalidPassword = faker.name().lastName();

    @Test(description = "Verify that the project page is displayed after logging in with valid data")
    public void login() {
        loginSteps.login(EMAIL, PASSWORD);
    }

    @Test(description = "Verify error message with invalid data", retryAnalyzer = Retry.class)
    public void checkInvalidLogin() {
        loginSteps
                .invalidLogin(invalidUsername, invalidPassword)
                .validateErrorMessage("These credentials do not match our records.");
    }
}
