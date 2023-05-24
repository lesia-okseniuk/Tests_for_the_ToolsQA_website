package demoqa.tests;

import demoqa.steps.LinksSteps;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class LinksTest extends BaseTest {
    @Test
    @SneakyThrows
    public void headerTest() {
        LinksSteps linksSteps = new LinksSteps();
        visit("links");
        linksSteps.verifyThatLinksHeaderMatches();
    }
    @Test
    @SneakyThrows
    public void homeLinkTest() {
        LinksSteps linksSteps = new LinksSteps();
        visit("links");
        linksSteps.checkHomeLink();
    }
    @Test
    @SneakyThrows
    public void dynamicLinkTest() {
        LinksSteps linksSteps = new LinksSteps();
        visit("links");
        linksSteps.checkDynamicLink();
    }
    @Test
    @SneakyThrows
    public void apiCallLinksTest() {
        LinksSteps linksSteps = new LinksSteps();
        visit("links");
        linksSteps.checkApiCallLinks();
    }
}
