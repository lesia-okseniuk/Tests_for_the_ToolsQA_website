package demoqa.steps;

import demoqa.pages.LinksPage;

public class LinksSteps {
    LinksPage linksPage = new LinksPage();
    public void verifyThatLinksHeaderMatches() {
        linksPage.assertThatLinksHeaderExists();
    }
    public void checkHomeLink() {
        linksPage.maximizeWindow();
        String currentWindowHandle = linksPage.getWindowHandle();
        linksPage.assertHomeLink();
        linksPage.clickHomeLink();
        linksPage.switchToNewTab();
        String homeUrl = linksPage.getCurrentUrl();
        String expectedUrl = "https://demoqa.com/";
        linksPage.assertingHomeUrl(expectedUrl, homeUrl);
        linksPage.closeATab();
        linksPage.switchToTab(currentWindowHandle);
        linksPage.assertThatLinksHeaderExists();
    }
    public void checkDynamicLink() {
        linksPage.maximizeWindow();
        String currentWindowHandle = linksPage.getWindowHandle();
        linksPage.assertDynamicLink();
        linksPage.clickDynamicLink();
        linksPage.switchToNewTab();
        String homeUrl = linksPage.getCurrentUrl();
        String expectedUrl = "https://demoqa.com/";
        linksPage.assertingHomeUrl(expectedUrl, homeUrl);
        linksPage.closeATab();
        linksPage.switchToTab(currentWindowHandle);
        linksPage.assertThatLinksHeaderExists();
    }

    public void checkApiCallLinks() {
        linksPage.maximizeWindow();
        linksPage.clickCreatedLink();
        linksPage.assertThatLinkResponseContainsExpectedStatusCode("201");
        linksPage.refreshPage();

        linksPage.clickNoContentLink();
        linksPage.assertThatLinkResponseContainsExpectedStatusCode("204");
        linksPage.refreshPage();

        linksPage.clickMovedLink();
        linksPage.assertThatLinkResponseContainsExpectedStatusCode("301");
        linksPage.refreshPage();

        linksPage.clickBadRequestLink();
        linksPage.assertThatLinkResponseContainsExpectedStatusCode("400");
        linksPage.refreshPage();

        linksPage.clickUnauthorizedLink();
        linksPage.assertThatLinkResponseContainsExpectedStatusCode("401");
        linksPage.refreshPage();

        linksPage.clickForbiddenLink();
        linksPage.assertThatLinkResponseContainsExpectedStatusCode("403");
        linksPage.refreshPage();

        linksPage.clickNotFoundLink();
        linksPage.assertThatLinkResponseContainsExpectedStatusCode("404");
    }

}
