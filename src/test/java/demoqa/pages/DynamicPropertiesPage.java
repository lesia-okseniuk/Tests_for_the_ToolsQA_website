package demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicPropertiesPage extends BasePage {
    @FindBy(className = "main-header")
    WebElement header;
    @FindBy(id = "enableAfter")
    WebElement button5seconds;
    @FindBy(id = "colorChange")
    WebElement colorChangeButton;
    @FindBy(id = "visibleAfter")
    WebElement visibleAfter5SecondsButton;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p")
    WebElement randomIdText;

    public void assertThatDynamicPropertiesHeaderExists() {
        assertThat(header.getText()).isEqualTo("Dynamic Properties");
    }
    public void assertThatButtonIsClickableAfter5Seconds() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(button5seconds));
        assertThat(button5seconds.isEnabled())
                .as("Verify that the element is clickable")
                .isTrue();
    }
    public void clickButton5Seconds() {
        button5seconds.click();
    }
    public String getInitialColor() {
        return colorChangeButton.getCssValue("color");
    }
    public String getNewColor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(colorChangeButton, "color", getInitialColor())));
        return colorChangeButton.getCssValue("color");
    }
    public void clickColorChangeButton() {
        colorChangeButton.click();
    }
    public void  assertThatButtonIsVisibleAfter5Seconds() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement visibleAfter5SecondsButton = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("visibleAfter"))));
        assertThat(visibleAfter5SecondsButton.isDisplayed())
                .as("Verify that the button is visible")
                .isTrue();
    }
    public void clickVisibleAfter5SecondsButton() {
        visibleAfter5SecondsButton.click();
    }
    public void verifyNumberOfButtons() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("visibleAfter"))));
        List<WebElement> buttons = driver.findElements(By.className("btn-primary"));
        assertThat(buttons.size()).isEqualTo(3);
    }
    public String getRandomIdText() {
        return randomIdText.getText();
    }
    public void assertThatTextIsAsExpected(String expectedText) {
        assertThat(getRandomIdText()).isEqualTo(expectedText);
    }
}
