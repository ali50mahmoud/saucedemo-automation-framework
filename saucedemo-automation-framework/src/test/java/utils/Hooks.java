package utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.time.Duration;

public class Hooks {
    
    public static WebDriver driver;
    public static WebDriverWait wait;
    
    @Before
    public static void open_browser() {
        String browser = ConfigReader.getProperty("browser").toLowerCase();
        
        switch (browser) {
            case "firefox":
                setupFirefoxDriver();
                break;
            case "chrome":
            default:
                setupChromeDriver();
                break;
        }
        
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    
    private static void setupChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        if (ConfigReader.getProperty("headless").equals("true")) {
            options.addArguments("--headless");
        }
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        driver = new ChromeDriver(options);
    }
    
    private static void setupFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        if (ConfigReader.getProperty("headless").equals("true")) {
            options.addArguments("--headless");
        }
        
        driver = new FirefoxDriver(options);
    }
    
    @After
    public static void quit_browser() {
        new WebDriverWait(driver, Duration.ofSeconds(30));
        if (driver != null) {
            driver.quit();
        }
    }
    
    public static WebDriver getDriver() {
        return driver;
    }
    
    public static WebDriverWait getWait() {
        return wait;
    }
}