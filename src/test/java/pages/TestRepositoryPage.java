package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import lombok.extern.log4j.Log4j2;
import models.TestCase;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class TestRepositoryPage extends BasePage {

    public static final String SETTINGS = "//span[text()='Settings']";
    public static final String PROJECT_NAME_LABEL = "header";
    public static final String CREATE_NEW_SUITE = "//*[contains(text(), 'Create new suite')]";
    public static final String EDIT_SUITE = "//a[text()='%s']/parent::span//i[contains(@class,'fa-pencil-alt')]";
    public static final String DELETE_SUITE = "//a[text()='%s']/parent::span//i[contains(@class,'fa-trash')]";
    public static final String CREATE_NEW_CASE = "#create-case-button";
    public static final String CREATE_NEW_CASE_VAR2 = "//*[contains(text(), 'Create new case')]";
    public static final String CASE_NAME = "//*[contains(@class,'case-row-title')]";
    public static final String DELETE_CASE_BUTTON = "//button[contains(text(),'Delete')]";
    public static final String EDIT_CASE_BUTTON = "//*[contains(@class,'far fa-pen')]";
    public static final String CREATE_NEW_CASE_WITHOUT_TEST_SUITE = "//a[contains(@class,'mr-2 btn-primary')]/child::i";
    public static final String SUITE_NAME = "suite-header";
    public static final String DESCRIPTION_NAME = "suite-description";
    public static final String TEST_PLAN = "//span[text()='Test Plans']";
    public static final String NUMBER_OF_CASES = "//*[contains(@class,'case-row-title')]";



    public TestRepositoryPage openTestRepositoryPage() {
        log.info("Open 'Login page' by link: " + URL + "/project");
        return this;
    }

    public TestRepositoryPage isPageOpened() {
        $x(CREATE_NEW_SUITE).shouldBe(Condition.visible);
        return this;
    }


    public SuitePage clickOnCreateSuiteButton() {
        log.info(String.format("Click button 'Create new suite' by locator: %s ", CREATE_NEW_SUITE));
        $x(CREATE_NEW_SUITE).shouldBe(Condition.appear).click();
        return new SuitePage();
    }


    public SuitePage editSuite(String suite) {
        log.info(String.format("Find element by locator: %s, move to element and press it", EDIT_SUITE));
        Selenide.actions().moveToElement($x(String.format(EDIT_SUITE, suite))).click().build().perform();
        return new SuitePage();
    }

    public DeletePage clickOnDeleteSuiteButton(String name) {
        log.info(String.format("Find element by locator: %s, move to element and press", DELETE_SUITE));
        Selenide.actions().moveToElement($x(String.format(DELETE_SUITE, name))).click().build().perform();
        sleep(3000);
        return new DeletePage();
    }

    public CreateNewProjectPage openSettings() {
        log.info(String.format("Open 'Settings' by locator: %s", SETTINGS));
        $x(SETTINGS).shouldBe(Condition.appear).click();
        return new CreateNewProjectPage();
    }

    public TestCasePage openTestCasePage() {
        //int amount = Selenide.$$x(CREATE_NEW_CASE).size();
        $(CREATE_NEW_CASE).click();
        /*if (amount != 0) {
            $x(CREATE_NEW_CASE).shouldBe(Condition.appear).click();
        } else {
            $x(CREATE_NEW_CASE_VAR2).shouldBe(Condition.appear).click();
        }*/
        return new TestCasePage();
    }

    public TestRepositoryPage chooseCase(String caseName) {
        log.info(String.format("Choose Case by name: %s", caseName));
        $x(String.format(CASE_NAME, caseName)).shouldBe(Condition.appear).click();
        return this;
    }

    public TestRepositoryPage deleteCase(String caseName) {
        log.info(String.format("Choose Case by name: %s", caseName));
        $x(String.format(DELETE_CASE_BUTTON, caseName)).shouldBe(Condition.appear).click();
        return this;
    }

    public TestRepositoryPage editCase(String caseName) {
        log.info(String.format("Choose Case by name: %s", caseName));
        $x(String.format(EDIT_CASE_BUTTON, caseName)).shouldBe(Condition.appear).click();
        return this;
    }


    public TestPlanPage openTestPlanPage() {
        log.info(String.format("Open 'Test Plan page' by locator: %s", TEST_PLAN));
        $x(SETTINGS).shouldBe(Condition.appear).click();
        return new TestPlanPage();
    }

    public boolean verifyCreatedTestCase(String testCaseName) {
        boolean isTestCaseWasCreated = false;
        ElementsCollection cases = $$x(NUMBER_OF_CASES);
        try {
            for (int i = 0; i < cases.size(); i++) {
                if (testCaseName.equals(cases.get(i).getText())) {
                    isTestCaseWasCreated = true;
                }
            }
        } catch (NullPointerException ex) {
            Assert.fail("Test Case not found");
        }
        return isTestCaseWasCreated;
    }
}






