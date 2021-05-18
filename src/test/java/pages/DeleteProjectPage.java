package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class DeleteProjectPage extends BasePage {
    public static final String DELETE_PROJECT_BUTTON = ".btn-cancel";

    @Override
    public DeleteProjectPage isPageOpened() {
        $(DELETE_PROJECT_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    public ProjectsPage clickOnDeleteProjectButton() {
        log.info("Click button 'Delete project' by locator: " + DELETE_PROJECT_BUTTON);
        $(DELETE_PROJECT_BUTTON).click();
        return new ProjectsPage();
    }
}
