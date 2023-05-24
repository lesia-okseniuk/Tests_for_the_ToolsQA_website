package demoqa.steps;

import demoqa.pages.TextBoxPage;

import static org.assertj.core.api.Assertions.assertThat;

public class TextBoxSteps {
    TextBoxPage textBoxPage = new TextBoxPage();
    public void verifyThatHeaderMatches() {
        textBoxPage.assertThatTextBoxHeaderExists();
    }
    public void checkForm() {
    String fullName = "Hermione Granger";
    String email = "crookshanks@gmail.com";
    String currentAddress = "London, Diagon Alley";
    String permanentAddress = "London, Penny Lane";
    textBoxPage.fillForm(fullName, email, currentAddress, permanentAddress);
    textBoxPage.submitForm();
    assertThat(textBoxPage.getName()).contains(fullName);
    assertThat(textBoxPage.getEmail()).contains(email);
    assertThat(textBoxPage.getCurrentAddress("value")).contains(currentAddress);
    assertThat(textBoxPage.getPermanentAddress("value")).contains(permanentAddress);
    }
}


