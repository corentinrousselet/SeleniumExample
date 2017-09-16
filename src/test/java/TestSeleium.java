import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileNotFoundException;

public class TestSeleium {
    WebDriver driver;

    @Before
    public void setUp() throws FileNotFoundException {
        File fileGeckodriver = new File("/tmp/geckodriver");
        if (fileGeckodriver.exists()){
            System.setProperty("webdriver.gecko.driver", fileGeckodriver.getAbsolutePath());
        }else {
            throw new  FileNotFoundException("File : "+fileGeckodriver.getAbsolutePath()+ " not found");
        }
        driver = new FirefoxDriver();
    }

    @Test
    public void searchOnGoogleWithSelenium(){
        driver.get("https://www.google.fr/");
        driver.findElement(By.id("lst-ib")).sendKeys("coucou");
        driver.findElement(By.name("btnK")).click();
    }

    @After
    public void close(){
//        driver.close();
    }
}
