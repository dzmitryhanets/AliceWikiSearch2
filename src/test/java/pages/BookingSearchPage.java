package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class BookingSearchPage extends BasePage {
    WebDriverWait wait;

    @FindBy(xpath = "//*[contains(@class, 'sr-hotel__name')]")
    private List<WebElement> resultsLinks;

    @FindBy(xpath = "//*[contains(@class, 'bui-review-score__badge')]")
    private List<WebElement> rate;

    @FindBy(xpath = "//i[@class='c2-calendar-close-button-icon']")
    private WebElement closeCalendarBtn;

    public BookingSearchPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    public List<String> getResultLinks() {
        wait.until(ExpectedConditions.visibilityOf(closeCalendarBtn));
        closeCalendarBtn.click();
        return resultsLinks.stream().map(result->result.getAttribute("innerText"))
                .filter(result-> !result.isEmpty()).collect(Collectors.toList());
    }

    public List<String> getHotelsRate() {
        return rate.stream().map(result -> result.getAttribute("innerText"))
                .filter(result -> !result.isEmpty()).collect(Collectors.toList());
    }
}
