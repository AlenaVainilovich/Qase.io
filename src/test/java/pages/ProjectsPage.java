package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsPage extends BasePage{
    public static final String PROJECTS_URL = "https://app.qase.io/projects";
    public static final String CREATE_NEW_PROJECT_BUTTON = "#createButton";
    public static final String PROJECT_NAME_LINK = ".defect-title";
    public static final String CHOOSE_PROJECT_BY_NAME = "//a[contains(text(),'%s')]";

    @Step("Open 'Project Page'")
    public ProjectsPage openProjectPage() {
        log.info("Open project page by URL: " + PROJECTS_URL);
        open(PROJECTS_URL);
        return this;
    }

    @Override
    @Step("Validate that 'Project page' was opened")
    public ProjectsPage isPageOpened() {
        $(CREATE_NEW_PROJECT_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    @Step("Get list of all projects")
    public boolean getNamesOfAllProjects(String projectName) {
        boolean name = false;
        ElementsCollection allProjects = $$(PROJECT_NAME_LINK);
        log.info("Get list of all project " + allProjects.size());
        for (int index = 0; index < allProjects.size(); index++) {
            allProjects.get(index).getText().contains(projectName);
            name = true;
        }
        return name;
    }


}
