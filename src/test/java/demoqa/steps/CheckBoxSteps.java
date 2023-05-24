package demoqa.steps;

import demoqa.pages.CheckBoxPage;

public class CheckBoxSteps {
    CheckBoxPage checkBoxPage = new CheckBoxPage();
    public void verifyThatCheckBoxHeaderMatches() {
        checkBoxPage.assertThatCheckBoxHeaderExists();
    }
    public void numberOfCheckBoxes() {
        checkBoxPage.verifyNumberOfCheckboxes();
    }
    public void checksForCheckBoxes () {
        checkBoxPage.maximizeWindow();
        checkBoxPage.checkHomeCheckbox();
        checkBoxPage.assertThatTextSuccessContainsHome();
        checkBoxPage.assertThatSecondElementInTextSuccessContainsDesktop();
        checkBoxPage.assertThatTenthElementInTextSuccessContainsOffice();
        checkBoxPage.clickToggleButton();
        checkBoxPage.uncheckDesktopCheckBox();
        checkBoxPage.uncheckDownloadsCheckBox();
        checkBoxPage.expandAll();
        checkBoxPage.uncheckOfficeCheckbox();
        checkBoxPage.uncheckVeuCheckbox();
        checkBoxPage.assertThatReactCheckboxIsSelected();
        checkBoxPage.assertThatAngularCheckboxIsSelected();
        checkBoxPage.assertThatVeuCheckboxIsNotSelected();
        checkBoxPage.collapseAll();
        checkBoxPage.uncheckHomeCheckbox();
    }
}
