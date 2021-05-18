package elements;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class Select {
    String labelLocator = "//*[text()='%s']/parent::div//div[contains(@class, 'container')]";
    String optionLocator = "//*[contains(@id, 'react-select') and contains(text(),'%s')]";
    String label;

    public Select(String label) {
        this.label = label;
    }

    public void select(String option) {
        $x(String.format(labelLocator, label)).shouldBe(Condition.visible).click();
        $x(String.format(optionLocator, option)).shouldBe(Condition.visible).click();
    }
}
