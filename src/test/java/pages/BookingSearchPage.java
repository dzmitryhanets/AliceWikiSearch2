package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class BookingSearchPage extends BasePage {

    public BookingSearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class, 'sr-hotel__name')]")
    private List<WebElement> resultsLinks;

    @FindBy(xpath = "//*[contains(@class, 'bui-review-score__badge')]")
    private List<WebElement> rate;

    public List<String> getResultLinks() {
        return resultsLinks.stream().map(result->result.getAttribute("innerText"))
                .filter(result-> !result.isEmpty()).collect(Collectors.toList());
    }

    public List<String> getHotelsRate() {
        return rate.stream().map(result -> result.getAttribute("innerText"))
                .filter(result -> !result.isEmpty()).collect(Collectors.toList());
    }
}
