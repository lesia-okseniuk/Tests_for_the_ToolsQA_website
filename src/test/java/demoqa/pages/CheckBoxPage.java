package demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckBoxPage extends BasePage {
    @FindBy(className = "main-header")
    WebElement header;
    @FindBy(className = "rct-checkbox")
    WebElement homeCheckbox;
    @FindBy(className = "text-success")
    WebElement textSuccess;
    @FindBy(xpath = "//*[@id=\"result\"]/span[3]")
    WebElement secondElementInTextSuccess;
    @FindBy(xpath = "//*[@id=\"result\"]/span[11]")
    WebElement tenthElementInTextSuccess;
    @FindBy(xpath = "//button[@type='button' and @title='Toggle']")
    WebElement toggleButton;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/label/span[3]")
    WebElement desktopCheckBox;
    @FindBy(xpath= "//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/label/span[3]")
    WebElement downloadsCheckBox;
    @FindBy(xpath = "//button[@type='button' and @title='Collapse all']")
    WebElement collapseAllButton;
    @FindBy(id = "tree-node-react")
    WebElement reactCheckbox;
    @FindBy(id = "tree-node-angular")
    WebElement angularCheckbox;
    @FindBy(id = "tree-node-veu")
    WebElement veuCheckbox;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[3]/span/label/span[1]")
    WebElement veuCheckBox;
    @FindBy(xpath = "//button[@type='button' and @title='Expand all']")
    WebElement expandAllButton;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/label/span[1]")
    WebElement officeCheckBox;

    public void assertThatCheckBoxHeaderExists() {
        assertThat(header.getText()).isEqualTo("Check Box");
    }

    public void maximizeWindow() { driver.manage().window().maximize(); }
    public void checkHomeCheckbox() {
            homeCheckbox.click();
        }
    public String textSuccessText() {
            return textSuccess.getText();
        }
    public String getSecondElementInTextSuccessText() {
            return secondElementInTextSuccess.getText();
        }
    public String getTenthElementInTextSuccessText() {
            return tenthElementInTextSuccess.getText();
        }
    public void clickToggleButton() {
            toggleButton.click();
        }
    public void uncheckDesktopCheckBox() {
        if (desktopCheckBox.isSelected()) {
            desktopCheckBox.click();
        }
    }
    public void uncheckDownloadsCheckBox() {
        if (desktopCheckBox.isSelected()) {
            downloadsCheckBox.click();
        }
    }
    public void collapseAll() {
            collapseAllButton.click();
        }
    public void expandAll() {
            expandAllButton.click();
        }
    public void uncheckOfficeCheckbox(){
        if (officeCheckBox.isSelected()) {
            officeCheckBox.click();
        }
    }
    public void uncheckVeuCheckbox() {
        if (veuCheckbox.isSelected()) {
            veuCheckBox.click();
        }
    }
    public boolean isReactCheckboxSelected() {
            return reactCheckbox.isSelected();
        }
    public boolean isAngularCheckboxSelected() {
            return angularCheckbox.isSelected();
        }
    public boolean isVeuCheckboxSelected() {
            return veuCheckbox.isSelected();
        }
    public void uncheckHomeCheckbox(){
        if (homeCheckbox.isSelected()) {
            homeCheckbox.click();
        }
    }
    public void assertThatReactCheckboxIsSelected() {
            assertTrue(isReactCheckboxSelected());
        }
    public void assertThatAngularCheckboxIsSelected() {
            assertTrue(isAngularCheckboxSelected());
        }
    public void assertThatVeuCheckboxIsNotSelected() {
            assertFalse(isVeuCheckboxSelected());
        }
    public void assertThatTextSuccessContainsHome () {
            assertThat(textSuccessText()).contains("home");
        }
    public void assertThatSecondElementInTextSuccessContainsDesktop () {
            assertThat(getSecondElementInTextSuccessText()).contains("desktop");
    }
    public void assertThatTenthElementInTextSuccessContainsOffice () {
        assertThat(getTenthElementInTextSuccessText()).contains("office");
    }
    public void verifyNumberOfCheckboxes() {
        expandAll();
        List<WebElement> checkboxes = driver.findElements(By.className("rct-checkbox"));
        assertThat(checkboxes.size()).isEqualTo(17);
    }
}
