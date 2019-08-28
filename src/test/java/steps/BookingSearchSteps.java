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

import static com.sun.jmx.snmp.ThreadContext.contains;

public class BookingSearchSteps {

    private static final String BOOKING_URL = "https://www.booking.com/searchresults.en-gb.html";
    private BookingSearchPage searchPage;
    private WebDriver driver;
    private SearchItem searchItem;
    private BookingMainPage bookingMainPage;
    String searchString;
    
    @Given("I want to search for {string}")
    public void iWantToSearchFor(String hotelName) {
        searchString = hotelName;
        driver = new ChromeDriver();
        bookingMainPage = new BookingMainPage(driver);
    }

    @When("I do search")
    public void iDoSearch() {
        driver.get(BOOKING_URL);
        bookingMainPage.searchByKeyword("Europe Minsk");
    }

    @Then("Results page should contain {string}")
    public void resultsPageShouldContain(String arg0) {
        BookingSearchPage resultPage = new BookingSearchPage(driver);
        resultPage.isPageOpened();
        List<String> hotels = resultPage.getResults();
        assertThat(horels, contains(arg0));
    }

    @And("rating should be {string}")
    public void ratingShouldBe(String arg0) {

        BookingResultsPage page = new BookingResultsPage(driver);
        String rating = page.getRatingFor(hotelName);
        assertEquals(rating, arg0);
    }

    @And("Rate is {string}")
    public void rateIs(String arg0) {
    }
}
