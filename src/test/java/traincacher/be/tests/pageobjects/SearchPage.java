package traincacher.be.tests.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends AbstractPage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage enterFromSearch(String from){
        driver.findElement(By.id("idfrom")).sendKeys(from);
        return this;
    }

    public SearchPage enterToSearch(String to){
        driver.findElement(By.id("idto")).sendKeys(to);
        return this;
    }

    public SearchPage clearFromSearch(){
        driver.findElement(By.id("idfrom")).clear();
        return this;
    }

    public SearchPage clearToSearch(){
        driver.findElement(By.id("idto")).clear();
        return this;
    }

    public SearchPage clickSearch(){
        driver.findElement(By.id("idsearch")).click();
        return this;
    }

    public SearchPage clickMenu() {
        driver.findElement(By.id("idmenu")).click();
        return this;
    }

    public SearchPage clickLike() {
        driver.findElement(By.id("idlike")).click();
        return this;
    }

    public boolean checkFavourite() {
        boolean containsFavourite = false;

        List<WebElement> listOfElements = driver.findElements(By.id("idfavouriteride"));

        if (!listOfElements.isEmpty())
        {
            containsFavourite = true;
        }

        return containsFavourite;
    }
}

