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

public class ControlerenOnlineSteps {

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
    }

    @Given("^ik sta op de offline traincacher pagina$")
    public void ikStaOpDeOfflineTraincacherPagina() throws IOException {
        init();
        driver.navigate().to("http://localhost:4200/");
        disconnectInternet();
    }

    @Given("^ik sta op de online traincacher pagina$")
    public void ikStaOpDeOnlineTraincacherHomepagina() {
        init();
        driver.navigate().to("http://localhost:4200/");
    }

    @When("^ik geen cloud logo zie$")
    public void ikGeenCloudLogoZie() {
        boolean online = searchPage.checkOnline();

        Assert.assertTrue(online);
    }

    @When("^ik een cloud logo zie$")
    public void ikEenCloudLogoZie() {
        boolean offline = searchPage.checkOnline();

        Assert.assertFalse(offline);
    }

    @Then("^weet de user dat hij online is$")
    public void weetDeUserDatHijOnlineIs() {
        driver.quit();
    }

    @Then("^weet de user dat hij offline is$")
    public void weetDeUserDatHijOfflineIs() {
        driver.quit();
    }
}