package demoqa.steps;

import demoqa.pages.DynamicPropertiesPage;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicPropertiesSteps {
    DynamicPropertiesPage dynamicPropertiesPage = new DynamicPropertiesPage();
    public void verifyThatDynamicPropertiesHeaderMatches() {
        dynamicPropertiesPage.assertThatDynamicPropertiesHeaderExists();
    }
    public void verityWillEnable5SecondsButton() {
        dynamicPropertiesPage.assertThatButtonIsClickableAfter5Seconds();
        dynamicPropertiesPage.clickButton5Seconds();
    }
    public void verifyColorChange() {
        String initialColor = dynamicPropertiesPage.getInitialColor();
        System.out.println(initialColor);
        String newColor = dynamicPropertiesPage.getNewColor();
        System.out.println(newColor);
        assertThat(initialColor).isNotEqualTo(newColor);
        if (!initialColor.equals(newColor)) {
            System.out.println("Button text color changed successfully.");
        } else {
            System.out.println("Button text color did not change.");
        }
        dynamicPropertiesPage.clickColorChangeButton();
    }
    public void verifyVisibleAfter5SecondsButton() {
        dynamicPropertiesPage.assertThatButtonIsVisibleAfter5Seconds();
        dynamicPropertiesPage.clickVisibleAfter5SecondsButton();
    }
    public void numberOfButtons() {
        dynamicPropertiesPage.verifyNumberOfButtons();
    }
    public void checkRandomIdText() {
        dynamicPropertiesPage.assertThatTextIsAsExpected("This text has random Id");
    }
}
