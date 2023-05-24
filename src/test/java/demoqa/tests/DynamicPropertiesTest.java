package demoqa.tests;

import demoqa.steps.DynamicPropertiesSteps;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class DynamicPropertiesTest extends BaseTest {
    @Test
    @SneakyThrows
    public void headerTest() {
        DynamicPropertiesSteps dynamicPropertiesSteps = new DynamicPropertiesSteps();
        visit("dynamic-properties");
        dynamicPropertiesSteps.verifyThatDynamicPropertiesHeaderMatches();
    }
    @Test
    @SneakyThrows
    public void buttonEnabledAfter5SecondsTest() {
        DynamicPropertiesSteps dynamicPropertiesSteps = new DynamicPropertiesSteps();
        visit("dynamic-properties");
        dynamicPropertiesSteps.verityWillEnable5SecondsButton();
    }
    @Test
    @SneakyThrows
    public void buttonChangesColorAfter5SecondsTest() {
        DynamicPropertiesSteps dynamicPropertiesSteps = new DynamicPropertiesSteps();
        visit("dynamic-properties");
        dynamicPropertiesSteps.verifyColorChange();
    }
    @Test
    @SneakyThrows
    public void visibleAfter5SecondsButtonTest() {
        DynamicPropertiesSteps dynamicPropertiesSteps = new DynamicPropertiesSteps();
        visit("dynamic-properties");
        dynamicPropertiesSteps.verifyVisibleAfter5SecondsButton();
    }
    @Test
    @SneakyThrows
    public void numberOfButtonsVisibleAfter5SecondsTest() {
        DynamicPropertiesSteps dynamicPropertiesSteps = new DynamicPropertiesSteps();
        visit("dynamic-properties");
        dynamicPropertiesSteps.numberOfButtons();
    }
    @Test
    @SneakyThrows
    public void randomIdTextTest() {
        DynamicPropertiesSteps dynamicPropertiesSteps = new DynamicPropertiesSteps();
        visit("dynamic-properties");
        dynamicPropertiesSteps.checkRandomIdText();
    }
}
