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

public class Search
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


    private void Search(WebDriver webDriver) throws Exception
    {
        driver = webDriver;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(By.xpath("//*[@id=\"menu-wrapper\"]/div/div[1]/input")).sendKeys("etew");
        driver.findElement(By.xpath("//*[@id=\"menu-wrapper\"]/div/div[1]/div[2]/div")).click();
        assertEquals("Товары по запросу «etew»", driver.findElement(By.xpath("/html/body/div[3]/div[5]/div[1]/h2")).getText());
    }



    @Test
    public void SearchFirefox() throws Exception
    {
        Search(new FirefoxDriver());
    }


    @Test
    public void SearchChrome() throws Exception

    {
        Search(new ChromeDriver());
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