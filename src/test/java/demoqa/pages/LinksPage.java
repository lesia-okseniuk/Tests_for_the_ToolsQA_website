package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LinksPage extends BasePage {
    @FindBy(className = "main-header")
    WebElement header;
    @FindBy(linkText = "Home")
    WebElement homeLink;
    @FindBy(xpath = "//*[@id=\"dynamicLink\"]")
    WebElement dynamicLink;
    @FindBy(linkText = "Created")
    WebElement createdLink;
    @FindBy(id = "linkResponse")
    WebElement linkResponse;
    @FindBy(linkText = "No Content")
    WebElement noContentLink;
    @FindBy(id = "moved")
    WebElement movedLink;
    @FindBy(partialLinkText = "Bad")
    WebElement badRequestLink;
    @FindBy(xpath = "//*[@id=\"unauthorized\"]")
    WebElement unauthorizedLink;
    @FindBy(xpath = "//p/a[text()=\"Forbidden\"]")
    WebElement forbiddenLink;
    @FindBy(id = "invalid-url")
    WebElement notFoundLink;

    public void assertThatLinksHeaderExists() {
        assertThat(header.getText()).isEqualTo("Links");
    }

    public void maximizeWindow() { driver.manage().window().maximize(); }
    public void refreshPage() {
        driver.navigate().refresh();
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public void assertHomeLink() {
        assertThat(homeLink).isNotNull();
        assertThat(homeLink.getAttribute("href"))
                .isEqualTo("https://demoqa.com/");
    }
    public void clickHomeLink() {
        homeLink.click();
    }
    public void switchToNewTab() {
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles) {
            if (!window.equals(currentWindowHandle)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }
    public void assertingHomeUrl(String expectedUrl, String homeUrl) {
        Assert.assertEquals(expectedUrl, homeUrl);
    }
    public void closeATab() { driver.close(); }
    public void switchToTab(String url) {
        driver.switchTo().window(url);
    }
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }
    public void assertDynamicLink() {
        assertThat(dynamicLink).isNotNull();
        assertThat(dynamicLink.getAttribute("href"))
                .isEqualTo("https://demoqa.com/");
    }
    public void clickDynamicLink() {
        dynamicLink.click();
    }
    public void assertThatLinkResponseContainsExpectedStatusCode(String expectedStatusCode) {
        assertThat(linkResponse.getText()).contains(expectedStatusCode);
    }
    public void clickCreatedLink() {
        createdLink.click();
    }
    public void clickNoContentLink() {
        noContentLink.click();
    }
    public void clickMovedLink() {
        movedLink.click();
    }
    public void clickBadRequestLink() {
        badRequestLink.click();
    }
    public void clickUnauthorizedLink() {
        unauthorizedLink.click();
    }
    public void clickForbiddenLink() {
        forbiddenLink.click();
    }
    public void clickNotFoundLink() {
        notFoundLink.click();
    }
}
