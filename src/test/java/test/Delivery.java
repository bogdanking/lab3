package test;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Delivery
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
        url ="https://www.lamoda.ru/";
    }


    private void Delivery(WebDriver webDriver) throws Exception
    {
        driver = webDriver;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(By.xpath("/html/body/div[8]/div[2]/div[1]/div[6]/a")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[3]/div[1]/dl/dd/ul/li[1]/span[1]")).click();
        assertEquals("Способы доставки", driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[3]/div[1]/dl/dt")).getText());
    }



    @Test
    public void DeliveryFirefox() throws Exception
    {
        Delivery(new FirefoxDriver());
    }


    @Test
    public void DeliveryChrome() throws Exception

    {
        Delivery(new ChromeDriver());
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