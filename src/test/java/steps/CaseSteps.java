package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestCase;
import models.TestSuite;
import pages.DeletePage;
import pages.EditCasePage;
import pages.TestCasePage;
import pages.TestRepositoryPage;

import static org.testng.Assert.assertTrue;

@Log4j2
public class CaseSteps {
    TestRepositoryPage testRepositoryPage;
    TestCasePage testCasePage;
    DeletePage deletePage;
    EditCasePage editCasePage;

    public CaseSteps() {
        testRepositoryPage = new TestRepositoryPage();
        testCasePage = new TestCasePage();
        deletePage = new DeletePage();
        editCasePage = new EditCasePage();
    }

    @Step("Create new Case")
    public CaseSteps createNewCase(TestCase testcase, TestSuite suite) {
        log.info("Create new Case with data: " + testcase);
        testRepositoryPage
                .openTestCasePage();
        testCasePage
                .isPageOpened()
                .createNewCase(testcase, suite)
                .clickOnSaveNewCaseButton();

        return this;
    }

    @Step("Verify that 'Test case' was created")
    public CaseSteps verifyThatTestCaseWasCreated(String testCaseName) {
        assertTrue(testRepositoryPage.verifyCreatedTestCase(testCaseName));
        return this;
    }

    @Step("Edit 'Test Case'")
    public CaseSteps editTestCase(TestCase editCase, TestSuite suite, String caseName) {
        log.info(String.format("Edit existing case with data: %s by case name %s", editCase, caseName));
        testRepositoryPage
                .chooseCase(caseName)
                .editCase(caseName);
        testCasePage
                .isPageOpened()
                .createNewCase(editCase, suite)
                .clickOnSaveNewCaseButton();
        return this;
    }

    @Step("Delete 'Test Case'")
    public CaseSteps deleteCase(String caseName) {
        log.info("Delete Case by name: " + caseName);
        testRepositoryPage
                .chooseCase(caseName)
                .deleteCase(caseName);
        deletePage
                .isPageOpened()
                .pressOnDeleteButton();
        return this;
    }
}
