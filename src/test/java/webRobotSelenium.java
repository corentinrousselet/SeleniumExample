import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class webRobotSelenium {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "/opt/geckodriver");
        driver = new FirefoxDriver();
        baseUrl = "https://disc.univ-fcomte.fr";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testRobot2Selenium() throws Exception {
        driver.get(baseUrl + "/m2gl-webRobot/Accueil.php?seed=13");
        driver.findElement(By.id("newCarte")).click();
        driver.findElement(By.linkText("Avancer")).click();
        driver.findElement(By.linkText("Avancer")).click();
        driver.findElement(By.linkText("Reculer")).click();
        driver.findElement(By.linkText("Tourner droite")).click();
        driver.findElement(By.linkText("Tourner gauche")).click();
        int val = Integer.valueOf(driver.findElement(By.id("xRobot")).getText());
        Assert.assertEquals(27,val);
        val = Integer.valueOf(driver.findElement(By.id("yRobot")).getText());
        Assert.assertEquals(-33,val);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            Assert.fail(verificationErrorString);
        }
    }
}