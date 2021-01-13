package traincacher.be.tests.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import traincacher.be.tests.pageobjects.DetailsPage;
import traincacher.be.tests.pageobjects.SearchPage;

import java.util.concurrent.TimeUnit;

public class GecachedTreintrajectKijkenSteps {

    WebDriver driver;
    SearchPage searchPage;
    DetailsPage detailsPage;

    @BeforeClass
    public void init(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        detailsPage = new DetailsPage(driver);
    }

    /* @Given("^ik ben offline op de traincacher homepagina$")
    public void ikBenOfflineOpDeTraincacherHomepagina() {
        init();
        driver.navigate().to("http://localhost:4200/");
    }

    @When("^ik op de “favorite rides” knop klik$")
    public void ikOpDeFavoriteRidesKnopKlik() {
    }

    @Then("^krijg ik een lijst van alle treintrajecten die gecached werden voor mij$")
    public void krijgIkEenLijstVanAlleTreintrajectenDieGecachedWerdenVoorMij() {
    } */
}