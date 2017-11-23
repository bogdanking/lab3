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

public class ForgetPasswd
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


    private void ForgetPasswd(WebDriver webDriver) throws Exception
    {
        driver = webDriver;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(By.xpath("//*[@class = \"whsOnd zHQkBf\"]")).sendKeys("x");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class =\"RveJvd snByac\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@jscontroller = \"cUYNmd\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class = \"whsOnd zHQkBf\"]")).sendKeys("get_passwd");
        Thread.sleep(1000);
        assertEquals("Добро пожаловать!", driver.findElement(By.xpath("//*[@class = \"sfYUmb\"]")).getText());
    }



    @Test
    public void ForgetPasswdFirefox() throws Exception
    {
        ForgetPasswd(new FirefoxDriver());
    }


    @Test
    public void ForgetPasswdChrome() throws Exception

    {
        ForgetPasswd(new ChromeDriver());
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