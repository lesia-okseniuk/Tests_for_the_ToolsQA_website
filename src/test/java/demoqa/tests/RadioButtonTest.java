package demoqa.tests;

import demoqa.steps.RadioButtonSteps;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {
    @Test
    @SneakyThrows
    public void headerTest() {
        RadioButtonSteps radioButtonSteps = new RadioButtonSteps();
        visit("radio-button");
        radioButtonSteps.verifyThatRadioButtonHeaderMatches();
    }
    @Test
    @SneakyThrows
    public void numberOfRadioButtonsTest() {
        RadioButtonSteps radioButtonSteps = new RadioButtonSteps();
        visit("radio-button");
        radioButtonSteps.numberOfRadioButtons();
    }
    @Test
    @SneakyThrows
    public void testForEnabledAndDisabledRadioButtons () {
        RadioButtonSteps radioButtonSteps = new RadioButtonSteps();
        visit("radio-button");
        radioButtonSteps.verifyThatAtStartYesRadioAndImpressiveRadioAreEnabledAndNoRadioIsNot();
    }
    @Test
    @SneakyThrows
    public void selectYesRadioTest () {
        RadioButtonSteps radioButtonSteps = new RadioButtonSteps();
        visit("radio-button");
        radioButtonSteps.selectYesRadio();
    }
    @Test
    @SneakyThrows
    public void selectImpressiveRadioTest () {
        RadioButtonSteps radioButtonSteps = new RadioButtonSteps();
        visit("radio-button");
        radioButtonSteps.selectImpressiveRadio();
    }
    @Test
    @SneakyThrows
    public void selectNoRadioTest () {
        RadioButtonSteps radioButtonSteps = new RadioButtonSteps();
        visit("radio-button");
        radioButtonSteps.selectNoRadio();
    }
}
