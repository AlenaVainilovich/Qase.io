package elements;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProseMirror {
    public String label;
    String locator_empty = "//*[contains(text(), '%s')]/parent::div/descendant::p[@class='empty-node']";
    String parent = "//*[contains(text(), '%s')]/following-sibling::input/preceding-sibling::div";
    public static final String TEXT_IN_FIELD = "//*[text()='%s']/parent::div//p";

    public ProseMirror(String label) {
        this.label = label;
    }

    public void setFocus() {
        $(byXpath(String.format(parent, label))).click();
    }

    public void write(String text) {
        setFocus();
        $(byXpath(String.format(locator_empty, label))).shouldBe(Condition.visible).sendKeys(text);
    }

    public void clear() {
        setFocus();
        $x(String.format(TEXT_IN_FIELD, label)).shouldBe(Condition.visible).clear();
    }
}
