package tests;

import io.qameta.allure.Feature;
import models.TestSuite;
import org.testng.annotations.Test;

@Feature("Suite Test")
public class SuiteTest extends BaseTest {

    public String projectName = faker.gameOfThrones().dragon();
    public String projectDescription = faker.hitchhikersGuideToTheGalaxy().marvinQuote();
    public String suiteName = faker.harryPotter().character();
    public String description = faker.hitchhikersGuideToTheGalaxy().planet();
    public String preCondition = faker.gameOfThrones().character();

    TestSuite testSuite = new TestSuite(suiteName, description, preCondition);

    @Test(description = "Create new suite in new project, than delete the suite")
    public void createAndDeleteSuite() {
        loginSteps
                .login(EMAIL, PASSWORD);
        projectSteps
                .createNewProject(projectName, projectDescription);
        projectsPage.chooseProjectByName(projectName);
        suiteSteps.createSuite(testSuite)
                .deleteSuite(suiteName);
    }
}
