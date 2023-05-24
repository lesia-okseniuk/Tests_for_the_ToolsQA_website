package demoqa.tests;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

import demoqa.steps.ElementsSteps;

public class ElementsTest extends BaseTest {
    @Test
    @SneakyThrows
    public void headerTest() {
        ElementsSteps elementsSteps = new ElementsSteps();
        visit("elements");
        elementsSteps.verifyThatElementsHeaderMatches();
    }
    @Test
    @SneakyThrows
    public void bodyTextTest() {
        ElementsSteps elementsSteps = new ElementsSteps();
        visit("elements");
        elementsSteps.assertText();
    }
    @Test
    @SneakyThrows
    public void numberOfSideMenuMainItemsTest() {
        ElementsSteps elementsSteps = new ElementsSteps();
        visit("elements");
        elementsSteps.checkNumberOfSideMenuMainItems();
    }
    @Test
    @SneakyThrows
    public void numberOfSideMenuSecondaryItemsTest() {
        ElementsSteps elementsSteps = new ElementsSteps();
        visit("elements");
        elementsSteps.checkNumberOfSideMenuSecondaryItems();
    }
    @Test
    @SneakyThrows
    public void textOfSideMenuMainItemsTest() {
        ElementsSteps elementsSteps = new ElementsSteps();
        visit("elements");
        elementsSteps.checkSideMenuMainItemsText();
    }
    @Test
    @SneakyThrows
    public void textBoxButtonTest() {
        ElementsSteps elementsSteps = new ElementsSteps();
        visit("elements");
        elementsSteps.checkTextBoxButton();
    }
    @Test
    @SneakyThrows
    public void bookStoreAPIButtonTest() {
        ElementsSteps elementsSteps = new ElementsSteps();
        visit("elements");
        elementsSteps.checkBookStoreAPIButton();
    }
}
