package demoqa.tests;

import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class BaseTest {
    Properties properties;

    @Getter
    static WebDriver driver;

    @BeforeClass
    @SneakyThrows
    public void beforeClass() {
        properties = new Properties();
        try (BufferedReader reader = Files.newBufferedReader(Path.of("config.properties"))) {
            properties.load(reader);
            String driverName = properties.getProperty("driver");
            File file = Path.of(properties.getProperty("path")).toFile();
            System.setProperty(driverName, file.getAbsolutePath());
            if (driverName.contains("chrome")) {
                driver = new ChromeDriver();
            } else if (driverName.contains("firefox")) {
                driver = new FirefoxDriver();
            }
            assertThat(driver).isNotNull();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void visit(String path) {
        driver.navigate().to(properties.getProperty("url") + path);
    }

    @DataProvider(name = "validRegistrationData")
    public Object[][] validData() {
        return new Object[][] {
                {"Albus", "Dumbledore", "alby@gmail.com", "99", "777", "Education"},
                {"Hermione", "Granger", "monie@gmail.com", "17", "0", "Witchcraft and Wizardry"},
                {"Ronald", "Weasley", "ron@gmail.com", "12", "2000", "Lazing around"},
                {"Severus", "Snape", "halfbloodprince@gmail.com", "37", "4500", "Brooding"},
                {"Luna", "Lovegood", "loony@gmail.com", "0", "100000", "Fabulous"}
        };
    }

    @DataProvider(name = "invalidRegistrationData")
    public Object[][] invalidData() {
        return new Object[][] {
                {"Albus", "Dumbledore", "email", "99", "777", "Education"},
                {"Hermione", "Granger", "monie@gmail.com", "ti", "0", "Witchcraft and Wizardry"},
                {"Ronald", "Weasley", "ron@gmail.com", "12", "two thousand", ""},
                {"%¤&¤&", "%&¤&¤", "¤%&%", "¤%", "¤%#%", "¤%#%#%#%#"},
                {"6", "7", "8", "6", "7", "8"},
                {"Severus", "Snape", "%¤&¤&@gmail.com", "37", "4500", "Brooding"},
                {"Luna", "Lovegood", "loony@gmail.com\"", "", "100000", "    "}
        };
    }
}
