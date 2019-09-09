package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.SearchItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BookingMainPage;
import pages.BookingSearchPage;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsIterableContaining.hasItem;
import static org.testng.AssertJUnit.assertEquals;

public class BookingSearchSteps {

    private static final String BOOKING_URL = "https://www.booking.com/searchresults.en-gb.html";
    private BookingSearchPage searchPage;
    private WebDriver driver;
    private SearchItem searchItem;
    private BookingMainPage bookingMainPage;
    private int hotelIndex;
    
    @Given("I want to search for {string}")
    public void iWantToSearchFor(String hotelName) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        searchItem = new SearchItem(hotelName);
    }

    @When("I do search")
    public void iDoSearch() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BOOKING_URL);
        bookingMainPage = new BookingMainPage(driver);
        bookingMainPage.searchByKeyword(searchItem.getSearchString());
        searchPage = new BookingSearchPage(driver);
    }

    @Then("Results page should contain {string}")
    public void resultsPageShouldContain(String arg0) {
        BookingSearchPage resultPage = new BookingSearchPage(driver);
        List<String> hotels = resultPage.getResultLinks();
        hotelIndex = hotels.indexOf(arg0);
        assertThat(hotels, hasItem(arg0));
    }

    @And("Rate is {string}")
    public void rateIs(String arg0) {
        BookingSearchPage page = new BookingSearchPage(driver);
        List<String> rate = page.getHotelsRate();
        assertEquals(rate.get(hotelIndex), arg0);
        driver.quit();
    }
}
