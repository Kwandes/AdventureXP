/*
    Functional frontend tests based of selenium
    These tests require the main app to be running before they can be run. Therefore, they are excluded from normal testing runs.
    In order to run them, you must use `mvn -Dtest=dev.hotdeals.adventurexp.functional_tests.** test`
 */

package dev.hotdeals.adventurexp.functional_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class ActivityListTests {

    private static WebDriver webDriver;
    private final static int port = 8080;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        webDriver = new ChromeDriver(options);
        webDriver.get("http://localhost:" + port);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void getDefaultTitleTest() {
        webDriver.get("http://localhost:" + port);
        assertThat(webDriver.getTitle()).isEqualTo("Activities");
    }

    @Test
    public void getIndexTitleTest() {
        webDriver.get("http://localhost:" + port + "/index");
        assertThat(webDriver.getTitle()).isEqualTo("Activities");
    }

    @Test
    public void getActivitiesTitleTest() {
        webDriver.get("http://localhost:" + port + "/activities");
        assertThat(webDriver.getTitle()).isEqualTo("Activities");
    }

    @Test
    @DisplayName("Does header image exist")
    public void DoesHeaderImageExistTest() {
        webDriver.get("http://localhost:" + port + "/activities");
        WebElement headerImage = webDriver.findElement(By.id("title-container")).findElement(By.tagName("img"));
        assertThat(headerImage.isDisplayed()).isTrue();
    }

    @Test
    @DisplayName("Is header image valid/loaded")
    public void isHeaderImageValidTest() throws IOException {
        webDriver.get("http://localhost:" + port + "/activities");
        WebElement headerImage = webDriver.findElement(By.id("title-container")).findElement(By.tagName("img"));
        String Source = headerImage.getAttribute("src");
        BufferedImage img = ImageIO.read(new URL(Source));
    }

    @AfterAll
    public static void cleanup() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}