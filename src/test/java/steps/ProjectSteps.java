package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.*;

import static org.testng.Assert.assertTrue;

@Log4j2
public class ProjectSteps {
    ProjectsPage projectsPage;
    TestRepositoryPage testRepositoryPage;
    CreateNewProjectPage createNewProjectPage;
    DeleteProjectPage deleteProjectPage;
    SettingsPage settingsPage;

    public ProjectSteps() {
        projectsPage = new ProjectsPage();
        testRepositoryPage = new TestRepositoryPage();
        createNewProjectPage = new CreateNewProjectPage();
        deleteProjectPage = new DeleteProjectPage();
        settingsPage = new SettingsPage();

    }

    @Step("Create new project")
    public ProjectSteps createNewProject(String projectName, String description) {
        log.info("Project " + projectName + ", with description: " + description + ", will be create");
        projectsPage
                .isPageOpened()
                .clickOnCreateNewProjectButton();
        createNewProjectPage.isPageOpened()
                .createNewProject(projectName, description);
        return this;
    }

    public void verifyProjectNameIsDisplayed(boolean verifyIsProjectExist) {
        assertTrue(verifyIsProjectExist, "Project name is not displayed");
    }

    public ProjectSteps deleteProject(String projectName) {
        log.info("Project with name: " + projectName + ", will delete");
        projectsPage
                .openProjectPage()
                .isPageOpened()
                .chooseProjectByName(projectName);
        testRepositoryPage
                .isPageOpened()
                .openSettings();
        settingsPage
                .isPageOpened()
                .pressOnDeleteProjectButton();
        deleteProjectPage
                .isPageOpened()
                .clickOnDeleteProjectButton();
        projectsPage.isPageOpened();
        return this;
    }

    public ProjectSteps chooseProjectByName(String projectName) {
        log.info("Project with name: " + projectName + ", will delete");
        projectsPage
                .openProjectPage()
                .isPageOpened()
                .chooseProjectByName(projectName);
        testRepositoryPage
                .isPageOpened();
        return this;
    }


}
