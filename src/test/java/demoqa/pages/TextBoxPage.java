package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static org.assertj.core.api.Assertions.assertThat;

public class TextBoxPage extends BasePage {
    @FindBy(className = "main-header")
    WebElement header;
    @FindBy(id = "userName")
    WebElement fullNameField;
    @FindBy(id = "userEmail")
    WebElement emailField;
    @FindBy(id = "currentAddress")
    WebElement currentAddressField;
    @FindBy(id = "permanentAddress")
    WebElement permanentAddressField;
    @FindBy(id = "submit")
    WebElement submitButton;
    @FindBy(id = "name")
    WebElement name;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "currentAddress")
    WebElement currentAddress;
    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;
    public void assertThatTextBoxHeaderExists() {
        assertThat(header.getText()).isEqualTo("Text Box");
    }
    public void fillForm(String fullName, String email, String currentAddress, String permanentAddress) {
        fullNameField.clear();
        emailField.clear();
        currentAddressField.clear();
        permanentAddressField.clear();
        fullNameField.sendKeys(fullName);
        emailField.sendKeys(email);
        currentAddressField.sendKeys(currentAddress);
        permanentAddressField.sendKeys(permanentAddress);
    }
    public void submitForm() {
            submitButton.click();
        }
    public String getName() {
            return name.getText();
        }
    public String getEmail() {
            return email.getText();
        }
    public String getCurrentAddress(String attributeName) {
            return currentAddress.getAttribute(attributeName);
        }
    public String getPermanentAddress(String attributeName) {
            return permanentAddress.getAttribute(attributeName);
        }
}

