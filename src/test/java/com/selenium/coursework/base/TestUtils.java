package com.selenium.coursework.base;

import com.selenium.coursework.driver.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtils {

    public WebDriver driver;
    private String urlAddress;
    private int implWait;
    private String browser;

    @BeforeMethod
    public void setUp() {
        readConfigProperties();
        setUpBrowser();
        loadUrlAddress();

        System.out.println("Starting the driver and loading url address.");
    }


    private void readConfigProperties() {
        try (FileInputStream configFile = new
                FileInputStream("src/test/resources/config.properties")) {
            Properties config = new Properties();
            config.load(configFile);
            urlAddress = config.getProperty("urlAddress");
            implWait = Integer.parseInt(config.getProperty("implicitlyWait"));
            browser = config.getProperty("browser");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void setUpBrowser() {
        switch (browser) {
            case "chrome":
                driver = DriverSetUp.getChromeDriver(implWait);
                break;
            case "firefox":
                driver = DriverSetUp.getFirefoxDriver(implWait);
                break;
            default:
                throw new IllegalStateException("This browser is unsupported!");
        }
    }

    private void loadUrlAddress() {
        driver.get(urlAddress);
    }


    @AfterMethod
    public void tearOffBrowser() {
        driver.close(); //Closing the browser
        // driver.quit(); // Closing the browser and shutting down the driver.
        System.out.println("Closing the browser");
    }

}
