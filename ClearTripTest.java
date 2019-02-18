package SeleniumTest;

import java.time.Duration;
import java.time.Instant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ClearTripTest {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.gecko.driver", "C:\\Sergey\\Java\\Tools\\FirefoxDriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

//        Get the website loaded
        driver.get("https://www.cleartrip.com/");

//        Type in the form "From"
        driver.findElement(By.cssSelector("#FromTag")).sendKeys("New");
        Thread.sleep(4000);

//        Choose the first available option
        driver.findElement(By.cssSelector("#FromTag")).sendKeys(Keys.ENTER);

//        Type in the form "To"
        driver.findElement(By.cssSelector("#ToTag")).sendKeys("Asw");
        Thread.sleep(5000);

//        Choose the first available option
        driver.findElement(By.cssSelector("#ToTag")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);

//        Click on today's date
        driver.findElement(By.className("ui-state-highlight")).click();

//        Create select objects
        Select adults = new Select(driver.findElement(By.xpath("//select[@id='Adults']")));
        Select children = new Select(driver.findElement(By.xpath("//select[@id='Childrens']")));
        Select infants = new Select(driver.findElement(By.xpath("//select[@id='Infants']")));
        Select flightClass = new Select(driver.findElement(By.xpath("//select[@id='Class']")));

//        Select quantity from "Adults", "Children" and "Infants"
        adults.selectByIndex(3);
        children.selectByIndex(1);
        infants.selectByIndex(2);

//        Click on "More Options"
        driver.findElement(By.id("MoreOptionsLink"))
                .click();

//        Select "First" from "Class of travel"
        flightClass.selectByVisibleText("First");

//        Type in the text box "Preferred Airline"
        driver.findElement(By.id("AirlineAutocomplete"))
                .sendKeys("S7");

//        Click on "Search Flights" button
        driver.findElement(By.xpath("//input[@id='SearchBtn']"))
                .click();

        Thread.sleep(20000);

//        Get the error message printed
        System.out.println(driver.findElement(By.xpath("/html/body/section[3]/div[2]/div[2]/div/h2")).getText());



    }
}
