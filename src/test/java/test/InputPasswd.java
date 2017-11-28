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

public class InputPasswd
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
        url = "https://www.lamoda.ru/";
    }


    private void Inputpasswd(WebDriver webDriver) throws Exception
    {
        driver = webDriver;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[1]/span[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/form[1]/div[2]/div/input")).sendKeys("xxx@mail.ru");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/form[1]/div[5]/button")).click();
        assertEquals("Это поле обязательно для заполнения", driver.findElement(By.xpath("/html/body/div[4]/div/div/div/form[1]/div[3]/div/div")).getText());

    }



    @Test
    public void InputpasswdFirefox() throws Exception
    {
        Inputpasswd(new FirefoxDriver());
    }


    @Test
    public void InputpasswdChrome() throws Exception

    {
        Inputpasswd(new ChromeDriver());
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