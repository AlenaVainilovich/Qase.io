package elements;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ProseMirror {
    public String label;
    String locator = "//*[contains(text(), '%s')]/parent::div/descendant::p[@class='empty-node']";
    String parent = "//*[contains(text(), '%s')]/following-sibling::input/preceding-sibling::div";

    public ProseMirror(String label) {
        this.label = label;
    }

    public void setFocus() {
        $(byXpath(String.format(parent, label))).click();
    }

    public void write(String text) {
        setFocus();
        $(byXpath(String.format(locator, label))).shouldBe(Condition.visible).sendKeys(text);
    }
}
