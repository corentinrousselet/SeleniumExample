import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class TestSeleium {
    WebDriver driver;
    File fileGeckodriver;
    String baseUrl;

    @Before
    public void setUp() throws FileNotFoundException {
        System.setProperty("webdriver.gecko.driver", "/opt/geckodriver");
        driver = new FirefoxDriver();
        baseUrl = "https://disc.univ-fcomte.fr";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void avancerRobot(){
        driver.get(baseUrl + "/m2gl-webRobot/Accueil.php?seed=13");
        driver.findElement(By.id("newCarte")).click();
        driver.findElement(By.linkText("Avancer")).click();
        int val = Integer.valueOf(driver.findElement(By.id("yRobot")).getText());
        Assert.assertEquals(-33,val);
    }

    @Test
    public void reculerRobot(){
        driver.get(baseUrl + "/m2gl-webRobot/Accueil.php?seed=13");
        driver.findElement(By.id("newCarte")).click();
        driver.findElement(By.linkText("Reculer")).click();
        int val = Integer.valueOf(driver.findElement(By.id("yRobot")).getText());
        Assert.assertEquals(-31,val);
    }

    @Test
    public void droiteRobot(){
        driver.get(baseUrl + "/m2gl-webRobot/Accueil.php?seed=13");
        driver.findElement(By.id("newCarte")).click();
        driver.findElement(By.linkText("Tourner droite")).click();
        String text = driver.findElement(By.xpath("//h3[2]")).getText();
        Assert.assertEquals(text,"Orientation du robot : est");
    }

    @Test
    public void gaucheRobot(){
        driver.get(baseUrl + "/m2gl-webRobot/Accueil.php?seed=13");
        driver.findElement(By.id("newCarte")).click();
        driver.findElement(By.linkText("Tourner gauche")).click();
        String text = driver.findElement(By.xpath("//h3[2]")).getText();
        Assert.assertEquals(text,"Orientation du robot : ouest");
    }

    @Test
    public void circuitEtRetourOrigine(){
        driver.get(baseUrl + "/m2gl-webRobot/Accueil.php?seed=13");
        driver.findElement(By.id("newCarte")).click();
        driver.findElement(By.linkText("Avancer")).click();
        driver.findElement(By.linkText("Tourner droite")).click();
        driver.findElement(By.linkText("Avancer")).click();
        driver.findElement(By.linkText("Tourner droite")).click();
        driver.findElement(By.linkText("Avancer")).click();
        driver.findElement(By.linkText("Tourner droite")).click();
        driver.findElement(By.linkText("Avancer")).click();
        int valx = Integer.valueOf(driver.findElement(By.id("xRobot")).getText());
        int valy = Integer.valueOf(driver.findElement(By.id("yRobot")).getText());
        Assert.assertEquals(27,valx);
        Assert.assertEquals(-33,valy);
    }

    @Test
    public void cinqDeplacementEtRetourInitial(){
        driver.get(baseUrl + "/m2gl-webRobot/Accueil.php?seed=13");
        driver.findElement(By.id("newCarte")).click();
        driver.findElement(By.linkText("Avancer")).click();
        driver.findElement(By.linkText("Tourner gauche")).click();
        driver.findElement(By.linkText("Avancer")).click();
        driver.findElement(By.linkText("Avancer")).click();
        driver.findElement(By.linkText("Avancer")).click();
        driver.findElement(By.linkText("Tourner droite")).click();
        driver.findElement(By.linkText("Tourner droite")).click();
        driver.findElement(By.id("newCarte")).click();
        int energy = Integer.parseInt(driver.findElement(By.id("energy")).getText());
        Assert.assertEquals(20,energy);
    }


    @After
    public void close(){
        driver.close();
    }
}
