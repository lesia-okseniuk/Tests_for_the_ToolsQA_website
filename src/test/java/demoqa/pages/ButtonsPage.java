package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ButtonsPage extends BasePage {
    @FindBy(className = "main-header")
    WebElement header;
    @FindBy(className = "btn-primary")
    List<WebElement> buttons;
    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickButton;
    @FindBy(id = "doubleClickMessage")
    WebElement doubleClickMessage;
    @FindBy(id = "rightClickBtn")
    WebElement rightClickButton;
    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button")
    WebElement dynamicClickButton;
    @FindBy(xpath = "//*[@id=\"dynamicClickMessage\"]")
    WebElement dynamicClickMessage;

    public void assertThatButtonsHeaderExists() {
            assertThat(header.getText()).isEqualTo("Buttons");
         }
    public void checkNumberOfButtons() {
        assertThat(buttons.size()).isEqualTo(3);
    }
    public void doubleClick() {
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();
    }
    public void assertThatDoubleClickMessageMatches() {
        assertThat(doubleClickMessage.getText()).isEqualTo("You have done a double click");
    }
    public void rightClick() {
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickButton).perform();
    }
    public void assertThatRightClickMessageMatches() {
        assertThat(rightClickMessage.getText()).isEqualTo("You have done a right click");
    }
    public void dynamicClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement dynamicButton = wait.until(ExpectedConditions.elementToBeClickable(dynamicClickButton));
        dynamicButton.click();
    }
    public void assertThatDynamicClickMessageMatches() {
        assertThat(dynamicClickMessage.getText()).isEqualTo("You have done a dynamic click");
    }

}

