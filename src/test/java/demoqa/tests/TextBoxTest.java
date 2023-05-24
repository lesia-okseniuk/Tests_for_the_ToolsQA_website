package demoqa.tests;

import demoqa.steps.TextBoxSteps;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {
    @Test
    @SneakyThrows
    public void headerTest() {
        TextBoxSteps textBoxSteps = new TextBoxSteps();
        visit("text-box");
        textBoxSteps.verifyThatHeaderMatches();
    }
    @Test
    @SneakyThrows
    public void testForTextBox() {
        TextBoxSteps textBoxSteps = new TextBoxSteps();
        visit("text-box");
        driver.manage().window().maximize();
        textBoxSteps.checkForm();
        }
}

