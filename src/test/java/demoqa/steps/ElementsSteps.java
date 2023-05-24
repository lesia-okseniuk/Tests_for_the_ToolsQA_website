package demoqa.steps;

import demoqa.pages.ElementsPage;

public class ElementsSteps {
    ElementsPage elementsPage = new ElementsPage();
    public void verifyThatElementsHeaderMatches() {
        elementsPage.assertThatElementsHeaderExists();
    }
    public void assertText() {
        String actualText = elementsPage.getText();
        elementsPage.assertPresenceOfTheText(actualText, "Please select an item from left to start practice.");
    }
    public void checkNumberOfSideMenuMainItems() {
        elementsPage.verifyNumberOfSideMenuMainItems();
    }
    public void checkNumberOfSideMenuSecondaryItems() {
        elementsPage.verifyNumberOfSideMenuSecondaryItems();
    }
    public void checkSideMenuMainItemsText() {
        String[] mainItems = {"Elements", "Forms", "Alerts, Frame & Windows", "Widgets", "Interactions", "Book Store Application"};
        elementsPage.assertTextOfSideMenuMainItems(mainItems);
    }
    public void checkTextBoxButton() {
        elementsPage.maximizeWindow();
        String actualText = elementsPage.getTextBoxButtonText();
        elementsPage.assertPresenceOfTheText(actualText, "Text Box");
        elementsPage.assertThatTextBoxButtonIsVisible();
        elementsPage.assertThatTextBoxButtonIsClickable();
        elementsPage.clickTextBoxButton();
        String currentUrl = elementsPage.getCurrentUrl();
        String expectedUrl = "https://demoqa.com/text-box";
        elementsPage.assertUrl(currentUrl, expectedUrl);
        elementsPage.navigateBack();
        currentUrl = elementsPage.getCurrentUrl();
        String elementsUrl = "https://demoqa.com/elements";
        elementsPage.assertUrl(currentUrl, elementsUrl);
    }
    public void checkBookStoreAPIButton() {
        elementsPage.maximizeWindow();
        elementsPage.clickBookStoreApplicationButton();
        elementsPage.clickBookStoreAPIButton();
        String currentUrl = elementsPage.getCurrentUrl();
        String expectedUrl = "https://demoqa.com/swagger/";
        elementsPage.assertUrl(currentUrl, expectedUrl);
        elementsPage.navigateBack();
        currentUrl = elementsPage.getCurrentUrl();
        String elementsUrl = "https://demoqa.com/elements";
        elementsPage.assertUrl(currentUrl, elementsUrl);
    }
}
