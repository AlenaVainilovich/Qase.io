package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import elements.Input;
import elements.ProseMirror;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestPlan;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class TestPlanPage extends BasePage{
    public static final String TEST_PLANS_LABEL = "//*[contains(@class, 'project-content')]/descendant::h1[text()='Test plans']";
    public static final String BUTTON_CREATE_TEST_PLAN = "//a[text()='Create test plan']";
    public static final String ADD_CASES = "//button[contains(@class,'btn-invisible')]/child::i";
    public static final String CREATE_PLAN = ".save-button";
    public static final String DROPDOWN = "//a[text()='%s']/following::i[contains(@class,'fa-ellipsis-h')]";
    public static final String DROPDOWN_ITEM = "//a[text()='%s']";
    public static final String TEST_PLAN_NAME = ".defect-title";
    public static final String URL = "https://app.qase.io/plan/DEMO";

    @Step("Open 'Test Plans' page")
    public TestPlanPage openPage() {
        log.info("Open 'Test Plans' page by URL: " + URL);
        open(URL);
        return this;
    }

    @Step("Verify that 'Test Plan' page was opened")
    public TestPlanPage isPageOpened() {
        $x(TEST_PLANS_LABEL).shouldBe(Condition.visible);
        return this;
    }

    @Step("Click on the button 'Create new test plan'")
    public TestPlanPage clickOnTheButtonCreateTestPlan() {
        log.info("Click button 'Create new test plan' by locator: " + BUTTON_CREATE_TEST_PLAN);
        $x(BUTTON_CREATE_TEST_PLAN).shouldBe(Condition.appear).click();
        return this;
    }

    @Step("Create new 'Test plan' {testPlan.title}")
    public TestPlanPage createTestPlan(TestPlan testPlan) {
        log.info("Create new test plan with data: " + testPlan);
        new Input("Title").clear();
        new Input("Title").write(testPlan.getTitle());
        new ProseMirror("Description").clear();
        new ProseMirror("Description").write(testPlan.getDescription());
        return this;
    }

    @Step("Add cases for 'Test plan'")
    public SelectTestCasesPage addCases() {
        log.info("Add cases for 'Test plan' by locator: " + ADD_CASES);
        $x(ADD_CASES).shouldBe(Condition.appear).click();
        return new SelectTestCasesPage();
    }

    @Step("Click on the button 'Create plan'")
    public TestPlanPage clickOnTheCreatePlanButton() {
        log.info("Click button 'Save' by locator: " + CREATE_PLAN);
        $(CREATE_PLAN).shouldBe(Condition.appear).click();
        sleep(2000);
        return this;
    }

    @Step("Choose 'Test Plan' option")
    public TestPlanPage editTestPlan(String testPlanName, String option) {
        log.info(String.format("Choose 'Test plan' by name: %s, click on the dropdown menu and choose option %s", testPlanName, option));
        $x(String.format(DROPDOWN, testPlanName)).shouldBe(Condition.appear).click();
        $x(String.format(DROPDOWN_ITEM, option)).shouldBe(Condition.appear).click();
        return this;
    }

    @Step("Delete 'Test Plan'")
    public DeleteTestPlanPage deleteTestPlan(String testPlanName, String option) {
        log.info("Delete 'Test Plan' with name " + testPlanName);
        editTestPlan(testPlanName, option);
        return new DeleteTestPlanPage();
    }

    @Step("Verify that 'Test Plan' was created")
    public boolean getTestPlanName(String testPlanName) {
        log.info("Verify that 'Test plan' with name " + testPlanName + ", was created");
        boolean isTestPlanWasCreated = false;
        ElementsCollection list = $$(TEST_PLAN_NAME);
        for (int a = 0; a < list.size(); a++) {
            if (testPlanName.equals(list.get(a).getText())) {
                isTestPlanWasCreated = true;
            }
        }
        return isTestPlanWasCreated;
    }
}
