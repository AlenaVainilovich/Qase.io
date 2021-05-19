package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.*;
import utils.TestListener;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    public static final String EMAIL = "vainilovich@gmail.com";
    public static final String PASSWORD = "00tut0r00";

    Faker faker = new Faker();

    ProjectsPage projectsPage;
    CreateNewProjectPage createNewProjectPage;
    LoginSteps loginSteps;
    ProjectSteps projectSteps;
    SuiteSteps suiteSteps;
    CaseSteps caseSteps;
    TestPlanSteps testPlanSteps;
    TestRunSteps testRunSteps;
    SuiteAdapter suiteAdapter;
    TestRepositoryPage testRepositoryPage;
    DeletePage deletePage;
    DeleteProjectPage deleteProjectPage;
    SuitePage suitePage;

    @BeforeMethod(description = "Initialize object and configuration settings")
    public void beforeTest() {
        loginSteps = new LoginSteps();
        projectSteps = new ProjectSteps();
        suiteSteps = new SuiteSteps();
        caseSteps = new CaseSteps();
        testPlanSteps = new TestPlanSteps();
        testRunSteps = new TestRunSteps();
        suiteAdapter = new SuiteAdapter();
        projectsPage = new ProjectsPage();
        suitePage = new SuitePage();
        testRepositoryPage = new TestRepositoryPage();
        deletePage = new DeletePage();
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        Configuration.clickViaJs = false;
        Configuration.headless = false;
        Configuration.startMaximized = true;
    }

    @AfterMethod(alwaysRun = true, description = "Close browser")
    public void close() {
        try {
            getWebDriver().quit();
        } catch (IllegalStateException ex) {
            log.warn("WebDriver is not opened on attempt to close it");
            log.warn(ex.getLocalizedMessage());
        }
    }

}
