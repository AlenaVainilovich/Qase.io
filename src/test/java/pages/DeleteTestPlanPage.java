package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class DeleteTestPlanPage extends BasePage {
    public static final String DELETE_BUTTON = ".btn-cancel";

    @Step("Verify that 'Delete test plan' page was opened")
    public DeleteTestPlanPage isPageOpened() {
        $(DELETE_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    @Step("Confirm that Test Plan will be deleted")
    public TestPlanPage deleteTestPlan() {
        log.info("Confirm deleting test plan by locator: " + DELETE_BUTTON);
        $(DELETE_BUTTON).shouldBe(Condition.appear).click();
        return new TestPlanPage();
    }
}
