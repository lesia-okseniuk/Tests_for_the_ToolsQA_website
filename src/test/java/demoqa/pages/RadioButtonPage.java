package demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RadioButtonPage extends BasePage {
    @FindBy(className = "main-header")
    WebElement header;
    @FindBy(id = "yesRadio")
    WebElement yesRadio;
    @FindBy(id = "impressiveRadio")
    WebElement impressiveRadio;
    @FindBy(id = "noRadio")
    WebElement noRadio;
    @FindBy(className = "text-success")
    WebElement textSuccess;
    @FindBy(name = "like")
    List<WebElement> radioButtons;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label")
    WebElement yesRadioSelector;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label")
    WebElement impressiveRadioSelector;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[4]/label")
    WebElement noRadioSelector;

    public void assertThatRadioButtonHeaderExists() {
        assertThat(header.getText()).isEqualTo("Radio Button");
    }
    public void verifyNumberOfRadioButtons() {
        assertThat(radioButtons.size()).isEqualTo(3);
    }
    public void assertThatYesRadioIsEnabled() {
        assertThat(yesRadio.isEnabled())
                .isTrue();
    }
    public void assertThatImpressiveRadioIsEnabled() {
        assertThat(impressiveRadio.isEnabled())
                .isTrue();
    }
    public void assertThatNoRadioIsEnabled() {
        assertThat(noRadio.isEnabled())
                .isTrue();
    }
    public void assertThatNoRadioIsNotEnabled() {
        assertThat(noRadio.isEnabled())
                .isFalse();
    }
    public String getSuccessMessage() {
        return textSuccess.getText();
    }
    public void selectYesRadio() {
        yesRadioSelector.click();
        assertThat(getSuccessMessage()).isEqualTo("Yes");
    }
    public void assertThatYesRadioIsSelected() {
        assertThat(yesRadio.isSelected())
                .isTrue();
    }
    public void assertThatImpressiveRadioIsSelected() {
        assertThat(impressiveRadio.isSelected())
                .isTrue();
    }
    public void assertThatNoRadioIsSelected() {
        assertThat(noRadio.isEnabled())
                .isTrue();
    }
    public void assertThatYesRadioIsNotSelected() {
        assertThat(yesRadio.isSelected())
                .isFalse();
    }
    public void assertThatImpressiveRadioIsNotSelected() {
        assertThat(impressiveRadio.isSelected())
                .isFalse();
    }
    public void assertThatNoRadioIsNotSelected() {
        assertThat(noRadio.isEnabled())
                .isFalse();
    }
    public void selectImpressiveRadio() {
        impressiveRadioSelector.click();
        assertThat(getSuccessMessage()).isEqualTo("Impressive");
    }

    public void enableNoRadio() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('disabled')", noRadio);
    }
    public void selectNoRadio() {
        noRadioSelector.click();
    }
}

