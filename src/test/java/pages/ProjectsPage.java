package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestProject;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsPage extends BasePage {
    public static final String CREATE_NEW_PROJECT_BUTTON = "#createButton";
    public static final String PROJECT_NAME_LINK = ".defect-title";
    public static final String CHOOSE_PROJECT_BY_NAME = "//a[contains(text(),'%s')]";
    public static final String PROJECT_NAME_LABEL = "//table[contains(@class,'table')]//*[contains(text(), '%s')]";

    @Step("Open 'Project Page'")
    public ProjectsPage openProjectPage() {
        log.info("Open project page by URL: " + "/projects");
        open(URL + "/projects");
        return this;
    }

    @Override
    @Step("Validate that 'Project page' was opened")
    public ProjectsPage isPageOpened() {
        $(CREATE_NEW_PROJECT_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    public CreateNewProjectPage clickOnCreateNewProjectButton() {
        log.info("Click button 'Create new project' by locator: " + CREATE_NEW_PROJECT_BUTTON);
        $(CREATE_NEW_PROJECT_BUTTON).shouldBe(Condition.appear).click();
        return new CreateNewProjectPage();
    }

    public ProjectsPage verifyIsProjectExist(TestProject project) {
        $(String.format(PROJECT_NAME_LINK, project.getName())).shouldBe(Condition.visible);
        return this;
    }

    public TestRepositoryPage chooseProjectByName(String projectName) {
        log.info("Project with name: " + projectName + ", will be delete");
        $x(String.format(CHOOSE_PROJECT_BY_NAME, projectName)).shouldBe(Condition.appear).click();
        return new TestRepositoryPage();
    }


}



