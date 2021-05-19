package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class EditCasePage extends TestRepositoryPage {

    public static final String BUTTON_DELETE_CASE = "//button[@title='Delete case']";
    public static final String BUTTON_EDIT_CASE = ".save-case";

    @Step("Click on the 'Delete' button")
    public DeletePage clickOnTheDeleteButton() {
        $x(BUTTON_DELETE_CASE).shouldBe(Condition.appear).click();
        return new DeletePage();
    }

    @Step("Click button 'Edit' case")
    public TestCasePage clickOnTheEditButton() {
        $(BUTTON_EDIT_CASE).shouldBe(Condition.appear).click();
        return new TestCasePage();
    }


}
