package traincacher.be.tests.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailsPage extends AbstractPage{
    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    public String findFrom(){
        String fromText = driver.findElement(By.id("idfromdetails")).getText();
        return fromText;
    }

    public String findTo(){
        String toText = driver.findElement(By.id("idtodetails")).getText();
        return toText;
    }
}
