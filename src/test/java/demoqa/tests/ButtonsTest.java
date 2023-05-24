package demoqa.tests;

import demoqa.steps.ButtonsSteps;
import lombok.SneakyThrows;
import org.testng.annotations.Test;


public class ButtonsTest extends BaseTest {
    @Test
    @SneakyThrows
    public void headerTest() {
        ButtonsSteps buttonsSteps = new ButtonsSteps();
        visit("buttons");
        buttonsSteps.verifyThatButtonsHeaderMatches();
    }
    @Test
    @SneakyThrows
    public void testButtonsExistOnThePage(){
        ButtonsSteps buttonsSteps = new ButtonsSteps();
        visit("buttons");
        buttonsSteps.verifyNumberOfButtons();
    }
    @Test
    @SneakyThrows
    public void doubleClickButtonTest() {
        ButtonsSteps buttonsSteps = new ButtonsSteps();
        visit("buttons");
        buttonsSteps.verifyDoubleClickButton();
    }
    @Test
    @SneakyThrows
    public void rightClickButtonTest() {
        ButtonsSteps buttonsSteps = new ButtonsSteps();
        visit("buttons");
        buttonsSteps.verifyRightClickButton();
    }
    @Test
    @SneakyThrows
    public void dynamicButtonTest() {
        ButtonsSteps buttonsSteps = new ButtonsSteps();
        visit("buttons");
        buttonsSteps.verifyDynamicClickButton();
    }
}


