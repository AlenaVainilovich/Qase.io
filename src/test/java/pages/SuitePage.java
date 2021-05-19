package pages;

import com.codeborne.selenide.Condition;
import elements.Input;
import elements.ProseMirror;
import models.TestSuite;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class SuitePage extends BasePage {
    public static final String SUITE_NAME_LABEL = "label[for='name']";
    public static final String BUTTON_CREATE_SUITE = "button#save-suite-button";
    public static final String SUITE_NAME = "input#inputTitle";

    @Override
    public SuitePage isPageOpened() {
        $(SUITE_NAME_LABEL).shouldBe(Condition.visible);
        return this;
    }

    public SuitePage createNewSuite(TestSuite suite) {
        new Input("Suite name").write(suite.getSuiteName());
        new ProseMirror("Description").write(suite.getDescription());
        new ProseMirror("Preconditions").write(suite.getPreCondition());
        return this;
    }

    public TestRepositoryPage clickOnCreateButton() {
        $(BUTTON_CREATE_SUITE).click();
        sleep(2000);
        return new TestRepositoryPage();
    }

    public SuitePage clearSuiteName(String suiteName) {
        $(SUITE_NAME).clear();
        $(SUITE_NAME).sendKeys(suiteName);
        return this;
    }
}