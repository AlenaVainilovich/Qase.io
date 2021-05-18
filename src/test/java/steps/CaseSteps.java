package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestCase;
import models.TestSuite;
import pages.DeletePage;
import pages.TestCasePage;
import pages.TestRepositoryPage;

@Log4j2
public class CaseSteps {
    TestRepositoryPage testRepositoryPage;
    TestCasePage testCasePage;
    DeletePage deletePage;

    public CaseSteps() {
        testRepositoryPage = new TestRepositoryPage();
        testCasePage = new TestCasePage();
        deletePage = new DeletePage();
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
