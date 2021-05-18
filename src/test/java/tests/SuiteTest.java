package tests;

import models.TestSuite;
import org.testng.annotations.Test;

public class SuiteTest extends BaseTest {

    public String projectName = faker.gameOfThrones().dragon();
    public String projectDescription = faker.hitchhikersGuideToTheGalaxy().marvinQuote();
    public String suiteName = faker.harryPotter().character();
    public String description = faker.hitchhikersGuideToTheGalaxy().planet();
    public String preCondition = faker.gameOfThrones().character();
    public String editSuiteName = faker.harryPotter().character();
    //public String editDescription = faker.hitchhikersGuideToTheGalaxy().planet();
    //public String editPreCondition = faker.backToTheFuture().character();

    TestSuite testSuite = new TestSuite(suiteName, description, preCondition);
    //TestSuite editTestSuite = new TestSuite(editSuiteName, editDescription, editPreCondition);

    @Test(description = "Create new suite, verify that suite was created. Edit existing suite, and verify that suite was edited. Delete suite and verify that suite was deleted")
    public void createAndDeleteSuite() {
        loginSteps
                .login(EMAIL, PASSWORD);
        projectSteps
                .createNewProject(projectName, projectDescription);
        projectsPage.chooseProjectByName(projectName);
        suiteSteps.createSuite(testSuite)
                .deleteSuite(editSuiteName);
    }
}
