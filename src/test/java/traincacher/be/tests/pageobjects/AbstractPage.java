package traincacher.be.tests.pageobjects;

import org.openqa.selenium.WebDriver;

public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

//    public traincacher.be.tests.pageojects.homepage navigateToHomePage() {
//        driver.navigate().to("http://localhost:4200/");
//        return new traincacher.be.tests.pageojects.homepage(driver);
//    }

}
