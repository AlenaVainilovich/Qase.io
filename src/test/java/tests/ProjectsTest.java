package tests;

import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static pages.ProjectsPage.PROJECT_NAME_LINK;


@Feature("Projects")
public class ProjectsTest extends BaseTest {

    String projectName = faker.name().title();
    String description = faker.backToTheFuture().character();

    @Test(description = "Verify that new project is created")
    public void newProjectShouldBeOpened() {
        loginSteps.login(EMAIL, PASSWORD);
        projectSteps
                .createNewProject(projectName, description);
    }

    @Test(description = "Delete project")
    public void deleteProject() {
        loginSteps.login(EMAIL, PASSWORD);
        projectSteps
                .createNewProject(projectName, description)
                .deleteProject(projectName);
    }
}

