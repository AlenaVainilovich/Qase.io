package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class SelectTestCasesPage extends BasePage{
    public static final String CHECKBOX = ".suite-title";
    public static final String BUTTON_DONE = "//button[text()='Done']";
    private static final String SELECT_ALL_BUTTON = "//button[text()='Select all']";

    @Step("Verify that 'Select test case' page was opened")
    public SelectTestCasesPage isPageOpened() {
        $x(BUTTON_DONE).shouldBe(Condition.visible);
        return this;
    }

    @Step("Choose all test cases")
    public SelectTestCasesPage chooseCases() {
        log.info("Choose all cases by locator: " + SELECT_ALL_BUTTON);
        $(CHECKBOX).shouldBe(Condition.appear).click();
        $x(SELECT_ALL_BUTTON).shouldBe(Condition.appear).click();
        return this;
    }

    @Step("Click on the 'Done' button")
    public void clickOnTheDoneButton() {
        log.info("Click button 'Done' by locator: " + BUTTON_DONE);
        $x(BUTTON_DONE).shouldBe(Condition.appear).click();
    }


}
