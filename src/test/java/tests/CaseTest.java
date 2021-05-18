package tests;

import models.TestCase;
import models.TestSuite;
import org.testng.annotations.Test;

public class CaseTest extends BaseTest {
    public String projectName = faker.howIMetYourMother().catchPhrase();
    public String description = faker.backToTheFuture().character();
    public String title = faker.gameOfThrones().dragon();
    public String caseDescription = faker.hitchhikersGuideToTheGalaxy().marvinQuote();
    public String postCondition = faker.harryPotter().character();
    public String preCondition = faker.cat().name();
    public String editTitle = faker.name().username();
    public String editDescription = faker.name().username();
    public String editPreCondition = faker.name().username();
    public String editPostCondition = faker.name().username();
    public String suiteName = faker.harryPotter().character();
    public String suiteDescription = faker.hitchhikersGuideToTheGalaxy().planet();
    public String suitePreCondition = faker.gameOfThrones().character();

    TestSuite testSuite = new TestSuite(suiteName, suiteDescription, suitePreCondition);

    TestCase newCase = TestCase.builder()
            .title(title)
            .status("Actual")
            .description(caseDescription)
            .suite(testSuite.getSuiteName())
            .severity("Major")
            .priority("High")
            .type("Smoke")
            .behavior("Positive")
            .automationStatus("Automated")
            .preConditions(preCondition)
            .postConditions(postCondition)
            .build();

    TestCase editCase = TestCase.builder()
            .title(editTitle)
            .status("Actual")
            .description(editDescription)
            .suite(testSuite.getSuiteName())
            .severity("Major")
            .priority("High")
            .type("Smoke")
            .behavior("Positive")
            .automationStatus("Automated")
            .preConditions(editPreCondition)
            .postConditions(editPostCondition)
            .build();

    @Test(description = "Create new 'Case' and validate that case was created, edit existing 'Case',validate that case was edited, and delete 'Case'")
    public void createEditAndDeleteCase() {
        loginSteps
                .login(EMAIL, PASSWORD);
        projectSteps
                .createNewProject(projectName, description);
        suiteSteps
                .createSuite(testSuite);
        caseSteps
                .createNewCase(newCase, testSuite)
                .deleteCase(title);


    }
}
