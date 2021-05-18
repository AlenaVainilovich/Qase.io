package elements;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


@Log4j2
public class Input {
    String locator = "//*[contains(text(), '%s')]/following-sibling::input";
    String label;

    public Input(String label) {
        this.label = label;
    }

    public Input write(String text) {
        $(byXpath(String.format(locator, label))).shouldBe(Condition.visible).sendKeys(text);
        return this;
    }

    public Input clear() {
        $(byXpath(String.format(locator, label))).shouldBe(Condition.visible).clear();
        return this;
    }
}
