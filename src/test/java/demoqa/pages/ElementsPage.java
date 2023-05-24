package demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ElementsPage extends BasePage {
    @FindBy(className = "main-header")
    WebElement header;
    @FindBy(className = "col-md-6")
    WebElement txt;
    @FindBy(className = "header-text")
    List<WebElement> sideMenuMainItems;
    @FindBy(className = "btn-light")
    List<WebElement> sideMenuSecondaryItems;
    @FindBy(xpath = "//*[@id=\"item-0\"]")
    WebElement textBoxButton;
    @FindBy(className = "header-text")
    WebElement elementsButton;
    @FindBy(xpath = "//*[@id=\"app\"]/footer")
    WebElement footer;

    public void assertThatElementsHeaderExists() { assertThat(header.getText()).isEqualTo("Elements"); }

    public void maximizeWindow() { driver.manage().window().maximize(); }

    public String getText() { return txt.getText(); }
    public void assertPresenceOfTheText(String actualText, String expectedText) {
        assertThat(actualText).contains(expectedText);
    }
    public void verifyNumberOfSideMenuMainItems() {
        assertThat(sideMenuMainItems.size()).isEqualTo(6);
    }
    public void verifyNumberOfSideMenuSecondaryItems() {
        assertThat(sideMenuSecondaryItems.size()).isEqualTo(33);
    }
    public void assertTextOfSideMenuMainItems(String[] mainItems) {
        for (int i = 0; i < sideMenuMainItems.size(); i++) {
            assertThat(sideMenuMainItems.get(i).getText()).isEqualTo(mainItems[i]);
        }
    }
    public String getTextBoxButtonText() {
        return textBoxButton.getText();
    }
    public void assertThatTextBoxButtonIsVisible() {
        assertThat(textBoxButton.isDisplayed()).isTrue();
    }
    public void assertThatTextBoxButtonIsClickable() {
        assertThat(textBoxButton.isEnabled()).isTrue();
    }
    public void clickTextBoxButton() {
        textBoxButton.click();
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public void assertUrl(String currentUrl, String expectedUrl) {
        Assert.assertEquals(currentUrl, expectedUrl);
    }
    public void navigateBack() { driver.navigate().back(); }
    public void clickBookStoreApplicationButton() {
        WebElement bookStoreApplicationButton = driver.findElements(By.className("header-text")).get(5);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String script = "arguments[0].style.height = '30px';";
        jsExecutor.executeScript(script, footer); // Decreasing the height of the footer as it obscures the button
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", bookStoreApplicationButton);
        bookStoreApplicationButton.click();
    }
    public void clickBookStoreAPIButton() {
        WebElement bookStoreAPIButton = driver.findElements(By.className("btn-light")).get(32);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", bookStoreAPIButton);
        assertThat(bookStoreAPIButton.isDisplayed()).isTrue();
        assertThat(bookStoreAPIButton.isEnabled()).isTrue();
        bookStoreAPIButton.click();
    }
}
