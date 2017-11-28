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

public class ShortPassword
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


    private void ShortPassword(WebDriver webDriver) throws Exception {
        driver = webDriver;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[1]/span[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/form[1]/div[3]/div/input")).sendKeys(".....");
        Thread.sleep(2000);
        assertEquals("Пожалуйста, введите 6 или более символов.", driver.findElement(By.xpath("/html/body/div[4]/div/div/div/form[1]/div[3]/div/div")).getText());
    }



    @Test
    public void ChangeLangFirefox() throws Exception
    {
        ShortPassword(new FirefoxDriver());
    }


    @Test
    public void ChangeLangChrome() throws Exception

    {
        ShortPassword(new ChromeDriver());
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