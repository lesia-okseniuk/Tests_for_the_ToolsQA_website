package demoqa.tests;

import demoqa.steps.CheckBoxSteps;
import lombok.SneakyThrows;
import org.testng.annotations.Test;


public class CheckBoxTest extends BaseTest {
    @Test
    @SneakyThrows
    public void headerTest() {
        CheckBoxSteps checkBoxSteps = new CheckBoxSteps();
        visit("checkbox");
        checkBoxSteps.verifyThatCheckBoxHeaderMatches();
    }
    @Test
    @SneakyThrows
    public void checkNumberOfCheckBoxes() {
        CheckBoxSteps checkBoxSteps = new CheckBoxSteps();
        visit("checkbox");
        checkBoxSteps.numberOfCheckBoxes();
    }
    @Test
    @SneakyThrows
    public void checkBoxTest() {
        CheckBoxSteps checkBoxSteps = new CheckBoxSteps();
        visit("checkbox");
        checkBoxSteps.checksForCheckBoxes();
    }
}
