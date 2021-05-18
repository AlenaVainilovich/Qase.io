package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SettingsPage extends BasePage {
    public static final String SETTINGS_LABEL = "//*[contains(@class, 'project-settings-tab')]/descendant::h1[text()='Settings']";
    public static final String DELETE_PROJECT_BUTTON = ".btn-cancel";

    @Override
    public SettingsPage isPageOpened() {
        $x(SETTINGS_LABEL).shouldBe(Condition.visible);
        return this;
    }

    public DeleteProjectPage pressOnDeleteProjectButton() {
        $(DELETE_PROJECT_BUTTON).click();
        return new DeleteProjectPage();
    }


}
