package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingMainPage extends BasePage {
    WebDriverWait wait;

    @FindBy(xpath = "//input[@id='ss']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    public BookingMainPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    public void searchByKeyword(String keyword){
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.click();
        searchField.sendKeys(keyword);
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
    }
}
