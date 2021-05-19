package tests;

import models.TestPlan;
import org.testng.annotations.Test;
import utils.Retry;

public class TestPlanTest extends BaseTest {
    String title = faker.leagueOfLegends().champion();
    String description = faker.leagueOfLegends().location();
    String editTitle = faker.lordOfTheRings().character();
    String editDescription = faker.lordOfTheRings().location();

    TestPlan testPlan = TestPlan.builder()
            .title(title)
            .description(description)
            .build();

    TestPlan editTestPlan = TestPlan.builder()
            .title(editTitle)
            .description(editDescription)
            .build();

    @Test(retryAnalyzer = Retry.class, description = "Create 'Test plan' in existing project. Verify that Test Plan was created. Edit existing Test Plan." +
            " Verify that test plan was edited. Delete 'Test Plan'")
    public void createEditDeleteTestPlan() {
        loginSteps
                .login(EMAIL, PASSWORD);
        testPlanSteps
                .createTestPlan(testPlan)
                .verifyThatTestPlanWasCreated(title);
        testPlanSteps
                .editTestPlan(title, "Edit", editTestPlan)
                .validateThatTestPlanWasEdited(editTitle);
        testPlanSteps
                .deleteTestPlan(editTitle, "Delete");
    }
}
