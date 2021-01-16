package traincacher.be.tests.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import traincacher.be.tests.pageobjects.FavouritePage;
import traincacher.be.tests.pageobjects.SearchPage;

import java.util.concurrent.TimeUnit;

public class GecachedTreintrajectVerwijderenSteps {

    WebDriver driver;
    SearchPage searchPage;
    FavouritePage favouritePage;

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
        favouritePage = new FavouritePage(driver);

        //add cached traject
        driver.navigate().to("http://localhost:4200/");
        searchPage.enterFromSearch("Zellik");
        searchPage.enterToSearch("Asse");
        searchPage.clickLike();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchPage.clearFromSearch();
        searchPage.clearToSearch();
        searchPage.enterFromSearch("Edingen");
        searchPage.enterToSearch("Asse");
        searchPage.clickLike();
    }

    @Given("^ik sta op de “favorite rides” pagina$")
    public void ikStaOpDeFavoriteRidesPagina() {
        init();
        searchPage.clickMenu();
    }

    @When("^ik offline een treintraject op de knop “X” klik$")
    public void ikOfflineEenTreintrajectOpDeKnopXKlik() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        favouritePage.clickDeleteFavourite("Zellik", "Asse");
    }

    @Then("^wordt de treintraject offline verwijdert uit de lijst$")
    public void wordtDeTreintrajectOfflineVerwijdertUitDeLijst() {
        boolean notContainsTreintraject = favouritePage.findFavourite("Zellik", "Asse");
        Assert.assertTrue(notContainsTreintraject);
        driver.quit();
    }
}