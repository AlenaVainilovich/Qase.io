package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestPlan;
import pages.SelectTestCasesPage;
import pages.TestPlanPage;

import static org.testng.Assert.assertTrue;

@Log4j2
public class TestPlanSteps {
    TestPlanPage testPlanPage;
    SelectTestCasesPage selectTestCasesPage;

    public TestPlanSteps() {
        testPlanPage = new TestPlanPage();
        selectTestCasesPage = new SelectTestCasesPage();
    }

    @Step("Create test plan")
    public TestPlanSteps createTestPlan(TestPlan testPlan) {
        log.info(String.format("Create new 'Test Plan' %s", testPlan));
        testPlanPage
                .openPage()
                .isPageOpened()
                .clickOnTheButtonCreateTestPlan()
                .createTestPlan(testPlan)
                .addCases();
        selectTestCasesPage
                .isPageOpened()
                .chooseCases()
                .clickOnTheDoneButton();
        testPlanPage
                .clickOnTheCreatePlanButton();
        return this;
    }

    @Step("Verify that 'Test plan' was created")
    public TestPlanSteps verifyThatTestPlanWasCreated(String testPlanName) {
        log.info(String.format("Verify that 'Test Plan' %s was created", testPlanName));
        assertTrue(testPlanPage.getTestPlanName(testPlanName));
        return this;
    }

    @Step("Edit 'Test Plan'")
    public TestPlanSteps editTestPlan(String testPlanName, String option, TestPlan editTestPlan) {
        log.info(String.format("Edit existing 'Test Plan' with name %s ,and data: %s", testPlanName, editTestPlan));
        testPlanPage
                .editTestPlan(testPlanName, option)
                .createTestPlan(editTestPlan)
                .clickOnTheCreatePlanButton();
        return this;
    }

    @Step("Verify that 'Test Plan' was edited")
    public TestPlanSteps validateThatTestPlanWasEdited(String editTestPlanName) {
        log.info(String.format("Verify that 'Test Plan %s was edited", editTestPlanName));
        verifyThatTestPlanWasCreated(editTestPlanName);
        return this;
    }

    @Step("Delete 'Test Plan'")
    public TestPlanSteps deleteTestPlan(String editTestPlanName, String option) {
        log.info(String.format("Delete 'Test Plan' by name: %s", editTestPlanName));
        testPlanPage
                .deleteTestPlan(editTestPlanName, option)
                .isPageOpened()
                .deleteTestPlan();
        return this;
    }
}
