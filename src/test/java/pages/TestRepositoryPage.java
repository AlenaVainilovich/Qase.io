package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class TestRepositoryPage extends BasePage {

    public static final String SETTINGS = "//span[text()='Settings']";
    public static final String PROJECT_NAME_LABEL = "header";
    public static final String CREATE_NEW_SUITE = "//*[contains(text(), 'Create new suite')]";
    public static final String EDIT_SUITE = "//a[text()='%s']/parent::span//i[contains(@class,'fa-pencil-alt')]";
    public static final String DELETE_SUITE = "//a[text()='%s']/parent::span//i[contains(@class,'fa-trash')]";
    public static final String CREATE_NEW_CASE = "#create-case-button";
    public static final String CASE_NAME = "//*[contains(@class,'case-row-title') and text()='%s']";
    public static final String DELETE_CASE_BUTTON = "//button[contains(text(),'Delete')]";
    public static final String CREATE_NEW_CASE_WITHOUT_TEST_SUITE = "//*[contains(text(), 'Create new case')]";
    public static final String SUITE_NAME = "suite-header";
    public static final String DESCRIPTION_NAME = "suite-description";


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
        return new DeletePage();
    }

    public CreateNewProjectPage openSettings() {
        log.info(String.format("Open 'Settings' by locator: %s", SETTINGS));
        $x(SETTINGS).shouldBe(Condition.appear).click();
        return new CreateNewProjectPage();
    }

    public TestCasePage openTestCasePage() {
        $(CREATE_NEW_CASE).click();
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


}






