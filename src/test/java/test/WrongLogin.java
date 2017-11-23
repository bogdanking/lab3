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

public class WrongLogin
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
        url = "https://accounts.google.com/signin";
    }


    private void WrongLogin(WebDriver webDriver) throws Exception
    {
        driver = webDriver;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(By.xpath("//*[@class = \"whsOnd zHQkBf\"]")).sendKeys("xoasfhoasy");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class =\"RveJvd snByac\"]")).click();
        Thread.sleep(2000);
        assertEquals("Не удалось найти аккаунт Google", driver.findElement(By.xpath("//*[@class = \"dEOOab RxsGPe\"]")).getText());
    }



    @Test
    public void WrongLoginFirefox() throws Exception
    {
        WrongLogin(new FirefoxDriver());
    }


    @Test
    public void WrongLoginChrome() throws Exception

    {
        WrongLogin(new ChromeDriver());
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