package demoqa.steps;

import demoqa.pages.RadioButtonPage;

public class RadioButtonSteps {
    RadioButtonPage radioButtonPage = new RadioButtonPage();
    public void verifyThatRadioButtonHeaderMatches() {
        radioButtonPage.assertThatRadioButtonHeaderExists();
    }
    public void numberOfRadioButtons() {
        radioButtonPage.verifyNumberOfRadioButtons();
    }
    public void verifyThatAtStartYesRadioAndImpressiveRadioAreEnabledAndNoRadioIsNot() {
        radioButtonPage.assertThatYesRadioIsEnabled();
        radioButtonPage.assertThatImpressiveRadioIsEnabled();
        radioButtonPage.assertThatNoRadioIsNotEnabled();
    }
    public void selectYesRadio() {
        radioButtonPage.selectYesRadio();
        radioButtonPage.assertThatYesRadioIsSelected();
        radioButtonPage.assertThatImpressiveRadioIsNotSelected();
        radioButtonPage.assertThatNoRadioIsNotSelected();
    }
    public void selectImpressiveRadio() {
        radioButtonPage.selectImpressiveRadio();
        radioButtonPage.assertThatImpressiveRadioIsSelected();
        radioButtonPage.assertThatYesRadioIsNotSelected();
        radioButtonPage.assertThatNoRadioIsNotSelected();
    }
    public void selectNoRadio() {
        radioButtonPage.enableNoRadio();
        radioButtonPage.assertThatNoRadioIsEnabled();
        radioButtonPage.selectNoRadio();
        radioButtonPage.assertThatNoRadioIsSelected();
        radioButtonPage.assertThatImpressiveRadioIsNotSelected();
        radioButtonPage.assertThatYesRadioIsNotSelected();
    }
}
