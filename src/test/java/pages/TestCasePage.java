package pages;

import com.codeborne.selenide.Condition;
import elements.Input;
import elements.ProseMirror;
import elements.Select;
import models.TestCase;
import models.TestSuite;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class TestCasePage extends BasePage {
    public static final String BUTTON_SAVE = "//button[text()='Save']";

    public TestCasePage createNewCase(TestCase testCase, TestSuite suite) {
        new Input("Title").clear();
        new Input("Title").write(testCase.getTitle());
        new Select("Status").select(testCase.getStatus());
        new ProseMirror("Description").clear();
        new ProseMirror("Description").write(testCase.getDescription());
        new Select("Suite").select(suite.getSuiteName());
        new Select("Severity").select(testCase.getSeverity());
        new Select("Priority").select(testCase.getPriority());
        new Select("Type").select(testCase.getType());
        new Select("Behavior").select(testCase.getBehavior());
        new Select("Automation status").select(testCase.getAutomationStatus());
        new ProseMirror("Pre-conditions").clear();
        new ProseMirror("Pre-conditions").write(testCase.getPreConditions());
        new ProseMirror("Post-conditions").clear();
        new ProseMirror("Post-conditions").write(testCase.getPostConditions());
        return this;
    }

    public TestRepositoryPage clickOnSaveNewCaseButton() {
        $x(BUTTON_SAVE).shouldBe(Condition.appear).click();
        sleep(2000);
        return new TestRepositoryPage();
    }

    public TestCasePage isPageOpened() {
        $x(BUTTON_SAVE).shouldBe(Condition.visible);
        return this;
    }
}
