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

public class Sort
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
        url ="https://www.lamoda.ru/c/4153/default-women/?is_new=1&sort=default";
    }


    private void Sort(WebDriver webDriver) throws Exception
    {
        driver = webDriver;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div[2]/div[2]/div/div/div[1]/div/span/span/span")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div[2]/div[2]/div/div/div[1]/div/span/span/ul/li[2]/span")).click();
        assertEquals("по возрастанию цены", driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div[2]/div[2]/div/div/div[1]/div/span/span/span")).getText());
    }



    @Test
    public void SortFirefox() throws Exception
    {
        Sort(new FirefoxDriver());
    }


    @Test
    public void SortChrome() throws Exception

    {
        Sort(new ChromeDriver());
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