package demoqa.steps;

import demoqa.pages.BrokenLinksImagesPage;


public class BrokenLinksImagesSteps {
    BrokenLinksImagesPage brokenLinksImagesPage = new BrokenLinksImagesPage();
    public void verifyThatTextBrokenLinksImagesHeaderMatches() {
        brokenLinksImagesPage.assertThatBrokenLinksImagesHeaderExists();
    }
    public void verifyValidImage() {
        brokenLinksImagesPage.verifyValidImage();
    }
    public void verifyBrokenImage() {
        brokenLinksImagesPage.verifyBrokenImage();
    }
    public void verifyValidLink() {
        brokenLinksImagesPage.clickValidLink();
        brokenLinksImagesPage.verifyLinkUrl("https://demoqa.com/");
        brokenLinksImagesPage.navigateBack();
    }
    public void verifyBrokenLink() {
        brokenLinksImagesPage.clickBrokenLink();
        brokenLinksImagesPage.verifyLinkUrl("http://the-internet.herokuapp.com/status_codes/500");
        brokenLinksImagesPage.verifyPageText("This page returned a 500 status code.");
    }
}
