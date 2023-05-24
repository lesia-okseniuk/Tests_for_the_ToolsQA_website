package demoqa.steps;

import demoqa.pages.ButtonsPage;

public class ButtonsSteps {
    ButtonsPage buttonsPage = new ButtonsPage();
    public void verifyThatButtonsHeaderMatches() {
        buttonsPage.assertThatButtonsHeaderExists();
    }
    public void verifyNumberOfButtons() {
        buttonsPage.checkNumberOfButtons();;
    }
    public void verifyDoubleClickButton() {
        buttonsPage.doubleClick();
        buttonsPage.assertThatDoubleClickMessageMatches();
    }
    public void verifyRightClickButton() {
        buttonsPage.rightClick();
        buttonsPage.assertThatRightClickMessageMatches();
    }
    public void verifyDynamicClickButton() {
        buttonsPage.dynamicClick();
        buttonsPage.assertThatDynamicClickMessageMatches();
    }
}


