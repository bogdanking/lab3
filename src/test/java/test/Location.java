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


public class Location
{
    public WebDriver driver;
    public String url ="https://www.lamoda.ru/";

    @BeforeClass
    public static void init()
    {
        System.setProperty("webdriver.gecko.driver", "C:/WebDrivers/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:/WebDrivers/chromedriver.exe");
    }

    @Before
    public void setUp() throws Exception
    {

    }


    private void Location (WebDriver webDriver) throws Exception {
        driver = webDriver;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/div[2]")).click();
        Thread.sleep(1000);
        assertEquals("Укажите ваш регион доставки:", driver.findElement(By.xpath("/html/body/div[10]/div/div/div/div[2]/form/h3")).getText());


    }
    @Test
    public void LocationFirefox() throws Exception
    {
        Location(new FirefoxDriver());
    }


    @Test
    public void LocationChrome() throws Exception

    {
        Location(new ChromeDriver());
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