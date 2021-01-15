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
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

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
        driver.navigate().to("http://localhost:4200/");
        searchPage.enterFromSearch("Zellik");
        searchPage.enterToSearch("Asse");
        searchPage.clickLike();
    }

    @Given("^ik ben offline op de traincacher homepagina$")
    public void ikBenOfflineOpDeTraincacherHomepagina() throws IOException {
        init();
        driver.navigate().to("http://localhost:4200/");
        disconnectInternet();
    }

    @When("^ik op de “favorite rides” knop klik$")
    public void ikOpDeFavoriteRidesKnopKlik() {
        searchPage.clickMenu();
    }

    @Then("^krijg ik een lijst van alle treintrajecten die gecached werden voor mij$")
    public void krijgIkEenLijstVanAlleTreintrajectenDieGecachedWerdenVoorMij() {
        Assert.assertTrue(searchPage.checkFavourite());
        driver.quit();
    }
}