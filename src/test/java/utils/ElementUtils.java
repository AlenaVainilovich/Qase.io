package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ElementUtils {
    public SelenideElement findVisibleElement(String locator) {
        log.debug(String.format("Waiting for element with locator '%s' is visible", locator));
        return $(locator).shouldBe(Condition.visible);
    }

    public SelenideElement findElement(String locator) {
        log.debug(String.format("Waiting for element with locator '%s' is existed in DOM", locator));
        return $(locator).shouldBe(Condition.exist);
    }
}
