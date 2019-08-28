package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingMainPage extends BasePage {
    @FindBy(id = "//input[@id='ss']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    public BookingMainPage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(String keyword){
        searchField.sendKeys(keyword);
        searchButton.click();
    }
}
