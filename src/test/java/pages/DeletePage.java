package pages;


import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class DeletePage extends BasePage {

    public static final String BUTTON_DELETE_SUITE_AND_CASE = ".btn-danger";
    public static final String BUTTON_CANCEL_SUITE_AND_CASE = ".btn-invisible-danger";

    @Override
    public DeletePage isPageOpened() {
        $(BUTTON_CANCEL_SUITE_AND_CASE).shouldBe(Condition.visible);
        return this;
    }

    public TestRepositoryPage pressOnDeleteButton() {
        log.info("Click button 'Delete' by locator: " + BUTTON_DELETE_SUITE_AND_CASE);
        $(BUTTON_DELETE_SUITE_AND_CASE).shouldBe(Condition.appear).click();
        return new TestRepositoryPage();
    }
}
