package traincacher.be.tests.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FavouritePage extends AbstractPage {
    public FavouritePage(WebDriver driver) {
        super(driver);
    }

    public FavouritePage clickDeleteFavourite(String from, String to) {
        WebElement cachedTreintraject = driver.findElement(By.xpath("//*[text()='" + from + " - " + to +"']"));
        WebElement parent = cachedTreintraject.findElement(By.xpath("//parent::div"));
        WebElement deleteButton = parent.findElement(By.xpath("//div//button"));
        deleteButton.click();
        return this;
    }

    public boolean findFavourite(String from, String to) {
        boolean cachedTreintraject = driver.findElements(By.xpath("//*[text()='" + from + " - " + to + "']")).isEmpty();
        return cachedTreintraject;
    }
}

