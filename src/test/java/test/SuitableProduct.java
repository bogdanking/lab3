package test;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SuitableProduct
{
    private WebDriver driver;
    private String url;

    @BeforeClass
    public static void init()
    {
        System.setProperty("webdriver.gecko.driver", "C:/WebDrivers/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:/WebDrivers/chromedriver.exe");
    }

    @Before
    public void setUp() throws Exception
    {
        url ="https://www.lamoda.ru/c/4153/default-women/?is_sale=1&display_locations=outlet&sitelink=topmenuW&l=10";
    }


    private void SuitableProduct(WebDriver webDriver) throws Exception
    {
        driver = webDriver;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div[3]/div[1]")));
        driver.findElement(By.xpath("/html/body/div[8]/div[1]/div/form/button[2]"));
        driver.navigate().to("https://www.lamoda.ru/help/article/snachala-primerte-potom-kupite-ru/");
        assertEquals("Сначала примерьте — потом купите", driver.findElement(By.xpath("/html/body/div[3]/div[3]/section/div[2]/article/h1")).getText());
    }



    @Test
    public void SuitableProductFirefox() throws Exception
    {
        SuitableProduct(new FirefoxDriver());
    }


    @Test
    public void SuitableProductChrome() throws Exception

    {
        SuitableProduct(new ChromeDriver());
    }

    @After
    public void tearDown() throws Exception
    {
        if (driver != null)
        {
            driver.quit();
        }
    }

}