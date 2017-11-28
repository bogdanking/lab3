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
import static org.junit.Assert.assertTrue;

public class Novelties
{
    private WebDriver driver;
    private String url;
    private boolean a;

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


    private void Novelties(WebDriver webDriver) throws Exception
    {
        driver = webDriver;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(By.xpath("//*[@id=\"menu-wrapper\"]/div/div[2]/div[1]/a")).click();
        Thread.sleep(2000);

        try

        {
            driver.get("https://www.lamoda.ru/c/4153/default-women/?is_new=1&is_sale=0&is_crossborder=0&sitelink=topmenuW&l=1");
            a = true;

        }
        catch (Exception e)
        {
            System.err.print("Error");
            a = false;
        }

        assertTrue(a);
    }



    @Test
    public void NoveltiesFirefox() throws Exception
    {
        Novelties(new FirefoxDriver());
    }


    @Test
    public void NoveltiesChrome() throws Exception

    {
        Novelties(new ChromeDriver());
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