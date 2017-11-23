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

public class NewAccount
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


    private void NewAccount(WebDriver webDriver) throws Exception
    {
        driver = webDriver;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(By.xpath("//*[@class = \"IMH1vc lUHSR Hj2jlf\"]")).click();
        Thread.sleep(2000);
        driver.get("https://accounts.google.com/SignUpExpress?service=analytics&continue=https%3A%2F%2Fanalytics.google.com%2Fanalytics%2Fweb%2F%23&hl=ru");
        Thread.sleep(3000);
        assertEquals("Зарегистрируйтесь в Google", driver.findElement(By.xpath("//h1")).getText());
    }



    @Test
    public void NewAccountFirefox() throws Exception
    {
        NewAccount(new FirefoxDriver());
    }


    @Test
    public void NewAccountChrome() throws Exception

    {
        NewAccount(new ChromeDriver());
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