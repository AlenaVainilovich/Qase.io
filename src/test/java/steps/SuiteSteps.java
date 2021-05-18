package steps;

import io.qameta.allure.Step;
import models.TestSuite;
import pages.DeletePage;
import pages.SuitePage;
import pages.TestRepositoryPage;

public class SuiteSteps {
    TestRepositoryPage testRepositoryPage;
    SuitePage suitePage;
    DeletePage deletePage;

    public SuiteSteps() {
        testRepositoryPage = new TestRepositoryPage();
        suitePage = new SuitePage();
        deletePage = new DeletePage();
    }

    @Step("Create suite {suite}")
    public SuiteSteps createSuite(TestSuite suite) {
        testRepositoryPage
                .clickOnCreateSuiteButton();
        suitePage
                .createNewSuite(suite)
                .clickOnCreateButton();
        return this;
    }

    public SuiteSteps deleteSuite(String suiteName) {
        testRepositoryPage.clickOnDeleteSuiteButton(suiteName);
        deletePage
                .isPageOpened()
                .pressOnDeleteButton();
        return this;
    }


}

