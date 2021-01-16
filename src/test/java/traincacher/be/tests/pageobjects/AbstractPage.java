package traincacher.be.tests.pageobjects;

import org.openqa.selenium.WebDriver;

public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
    public AbstractPage navigateMainUrl(){
        //driver.navigate().to("http://localhost:4200/"); //
        driver.navigate().to("https://traincacher.online/");
        return this;
    }
}
