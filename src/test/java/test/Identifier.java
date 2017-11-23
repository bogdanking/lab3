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

public class Identifier {
    public WebDriver driver;
    public String url;

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


    private void Identifier(WebDriver webDriver) throws Exception {
        driver = webDriver;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(By.xpath("//*[@class = \"whsOnd zHQkBf\"]"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class =\"RveJvd snByac\"]")).click();
        Thread.sleep(2000);
        assertEquals("Введите адрес электронной почты или номер телефона", driver.findElement(By.xpath("//*[@jsname = \"B34EJ\"]")).getText());
    }



    @Test
    public void IdentifierFirefox() throws Exception
    {
        Identifier(new FirefoxDriver());
    }


    @Test
    public void IdentifierChrome() throws Exception

    {
        Identifier(new ChromeDriver());
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