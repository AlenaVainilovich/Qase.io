package pages;

import lombok.extern.log4j.Log4j2;
import utils.ElementUtils;

@Log4j2
public abstract class BasePage {
    public static final String URL = "https://app.qase.io";

    public abstract BasePage isPageOpened();

    public boolean isElementDisplayed(String locator) {
        log.debug(String.format("Verifying is element with locator '%s' displayed", locator));
        boolean isElementDisplayed = new ElementUtils().findVisibleElement(locator).isDisplayed();
        log.debug(String.format("Is element displayed %s", isElementDisplayed));
        return isElementDisplayed;
    }


}
