package pages;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage extends BasePage {
    public static final String EMAIL = "inputEmail";
    public static final String PASSWORD = "inputPassword";
    public static final String LOGIN_BUTTON = "btnLogin";
    public static final String ERROR_MESSAGE = "form-control-feedback";
    public static final String URL = "https://app.qase.io/login";


    @Step("Open Login page")
    public LoginPage openLoginPage() {
        log.info("Open 'Login page' by link: " + URL);
        open(URL);
        return this;
    }

    @Override
    @Step("Login page should be opened")
    public LoginPage isPageOpened() {
        $(By.id(LOGIN_BUTTON)).shouldBe(Condition.visible);
        return this;
    }

    @Step("Edit login page with invalid data")
    public LoginPage invalidLogin(String username, String password) {
        log.info("Edit Email" + username + ", edit 'Password'" + password);
        $(EMAIL).sendKeys(username);
        $(PASSWORD).sendKeys(password);
        $(By.id(LOGIN_BUTTON)).shouldHave(Condition.appear).click();
        return this;
    }

    @Step("Get error message")
    public String getErrorMessage() {
        String errorMessage = $(ERROR_MESSAGE).getText();
        log.info("Get error message: " + errorMessage);
        return errorMessage;
    }

    @Step("Redirect on ProjectsPage after log in")
    public ProjectsPage login(String username, String password) {
        invalidLogin(username, password);
        return new ProjectsPage();
    }
}
