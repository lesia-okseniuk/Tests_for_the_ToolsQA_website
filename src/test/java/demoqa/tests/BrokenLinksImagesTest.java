package demoqa.tests;

import demoqa.steps.BrokenLinksImagesSteps;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class BrokenLinksImagesTest extends BaseTest {
    @Test
    @SneakyThrows
    public void headerTest() {
        BrokenLinksImagesSteps brokenLinksImagesSteps = new BrokenLinksImagesSteps();
        visit("broken");
        brokenLinksImagesSteps.verifyThatTextBrokenLinksImagesHeaderMatches();
    }
    @Test
    @SneakyThrows
    public void validImageTest() {
        BrokenLinksImagesSteps brokenLinksImagesSteps = new BrokenLinksImagesSteps();
        visit("broken");
        brokenLinksImagesSteps.verifyValidImage();
    }
    @Test
    @SneakyThrows
    public void brokenImageTest() {
        BrokenLinksImagesSteps brokenLinksImagesSteps = new BrokenLinksImagesSteps();
        visit("broken");
        brokenLinksImagesSteps.verifyBrokenImage();
    }
    @Test
    @SneakyThrows
    public void validLinkTest() {
        BrokenLinksImagesSteps brokenLinksImagesSteps = new BrokenLinksImagesSteps();
        visit("broken");
        brokenLinksImagesSteps.verifyValidLink();
    }
    @Test
    @SneakyThrows
    public void brokenLinkTest() {
        BrokenLinksImagesSteps brokenLinksImagesSteps = new BrokenLinksImagesSteps();
        visit("broken");
        brokenLinksImagesSteps.verifyBrokenLink();
    }
}
