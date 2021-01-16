package traincacher.be.tests.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import traincacher.be.tests.pageobjects.DetailsPage;
import traincacher.be.tests.pageobjects.SearchPage;

import java.util.concurrent.TimeUnit;

public class TreinritZoekenSteps {

    WebDriver driver;
    SearchPage searchPage;
    DetailsPage detailsPage;

    @BeforeClass
    public void init(){
        if (System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        else
        {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("--disable-gpu");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("window-size=1200x600");
        options.addArguments("--no-sandbox");

        driver = new ChromeDriver(options);
        searchPage = new SearchPage(driver);
        detailsPage = new DetailsPage(driver);
    }

    @Given("^ik sta op de Traincacher homepagina$")
    public void ikStaOpDeTraincacherHomepagina() {
        init();
        driver.navigate().to("http://localhost:4200/");
    }

    @When("^ik \"([^\"]*)\" in het From veld ingeef$")
    public void ikInHetFromVeldIngeef(String from) throws Throwable {
        searchPage.enterFromSearch(from);
    }

    @When("^ik \"([^\"]*)\" in het To veld ingeef$")
    public void ikInHetToVeldIngeef(String to) throws Throwable {
        searchPage.enterToSearch(to);
    }

    @When("^ik op de Search-knop druk$")
    public void ikOpDeSearchKnopDruk() {
        searchPage.clickSearch();
    }

    @Then("^zie ik de mogelijke treintrajecten tussen \"([^\"]*)\" en \"([^\"]*)\"$")
    public void zieIkDeMogelijkeTreintrajectenTussenEn(String from, String to) throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(detailsPage.findFrom().contains(from));
        Assert.assertTrue(detailsPage.findTo().contains(to));
        driver.quit();
    }

    @Then("^krijg ik geen mogelijke treintrajecten$")
    public void krijgIkGeenMogelijkeTreintrajecten() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(detailsPage.findErrorResult().contains("Geen ritten gevonden"));
        driver.quit();
    }
}