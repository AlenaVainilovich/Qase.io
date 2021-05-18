package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CreateNewProjectPage extends BasePage {
    public static final String PROJECT_NAME = "input#inputTitle";
    public static final String PROJECT_NAME_LABEL = "[for='inputTitle']";
    public static final String DESCRIPTION = "textarea#inputDescription";
    public static final String BUTTON_CREATE_NEW_PROJECT = "//button[text()='Create project']";

    @Override
    public CreateNewProjectPage isPageOpened() {
        $(byXpath(BUTTON_CREATE_NEW_PROJECT)).shouldBe(Condition.visible);
        return this;
    }

    public TestRepositoryPage createNewProject(String projectName, String description) {
        $(PROJECT_NAME).sendKeys(projectName);
        $(DESCRIPTION).sendKeys(description);
        $(byXpath(BUTTON_CREATE_NEW_PROJECT)).shouldHave(Condition.appear).click();
        return new TestRepositoryPage();
    }


}
