package traincacher.be.tests.steps;

import com.google.common.collect.ImmutableMap;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.Response;
import traincacher.be.tests.pageobjects.SearchPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GecachedTreintrajectKijkenSteps {

    WebDriver driver;
    SearchPage searchPage;

    protected void disconnectInternet() throws IOException {
        Map map = new HashMap();
        map.put("offline", true);
        map.put("latency", 5);
        map.put("download_throughput", 500);
        map.put("upload_throughput", 1024);

        CommandExecutor executor = ((ChromeDriver)driver).getCommandExecutor();
        Response response = executor.execute(
                new Command(((ChromeDriver)driver).getSessionId(), "setNetworkConditions", ImmutableMap.of("network_conditions", ImmutableMap.copyOf(map))));
    }

    @BeforeClass
    public void init() {
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

        //add cached traject
        searchPage.navigateMainUrl();
        searchPage.enterFromSearch("Zellik");
        searchPage.enterToSearch("Asse");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        searchPage.clickLike();
    }

    @Given("^ik ben offline op de traincacher homepagina$")
    public void ikBenOfflineOpDeTraincacherHomepagina() throws IOException {
        init();
        //searchPage.navigateMainUrl();
        disconnectInternet();
    }

    @When("^ik op de favorite rides knop klik$")
    public void ikOpDeFavoriteRidesKnopKlik() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        searchPage.clickMenu();
    }

    @Then("^krijg ik een lijst van alle treintrajecten die gecached werden voor mij$")
    public void krijgIkEenLijstVanAlleTreintrajectenDieGecachedWerdenVoorMij() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(searchPage.checkFavourite());
        driver.quit();
    }
}