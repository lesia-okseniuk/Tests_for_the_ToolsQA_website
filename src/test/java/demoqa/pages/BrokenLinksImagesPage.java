package demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class BrokenLinksImagesPage extends BasePage {
        @FindBy(className = "main-header")
        WebElement header;
        @FindBy(xpath = "//img[@src='/images/Toolsqa.jpg']")
        WebElement validImage;
        @FindBy(xpath = "//img[@src='/images/Toolsqa_1.jpg']")
        WebElement brokenImage;
        @FindBy(linkText = "Click Here for Valid Link")
        WebElement validLink;
        @FindBy(linkText = "Click Here for Broken Link")
        WebElement brokenLink;
        @FindBy(tagName = "body")
        WebElement body;

        public void assertThatBrokenLinksImagesHeaderExists() {
            assertThat(header.getText()).isEqualTo("Broken Links - Images");
        }
        public void verifyValidImage() {
            String validImageUrl = validImage.getAttribute("src");

            if (!validImageUrl.isEmpty()) {
                boolean isImageDisplayed = validImage.isDisplayed();
                Boolean isImageLoaded = (Boolean) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].naturalWidth > 0;", validImage);
                    if (isImageDisplayed && isImageLoaded) {
                        System.out.println("Image is not broken and is displayed correctly.");
                    } else if (!isImageLoaded) {
                        System.out.println("Image is not displayed correctly.");
                    }
            } else {
                System.out.println("Image URL is empty. The image may be broken.");
            }
        }
        public void verifyBrokenImage() {
            Boolean isImageLoaded = (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].naturalWidth > 0;", brokenImage);
            if (isImageLoaded) {
                System.out.println("Image is not broken and is displayed correctly.");
            } else {
                System.out.println("Image is broken.");
            }
        }
        public void clickValidLink() {
                validLink.click();
        }
        public String currentUrl () {
                String currentUrl = driver.getCurrentUrl();
                System.out.println(currentUrl);
                return currentUrl;
        }
        public void navigateBack() {
                driver.navigate().back();
        }
        public void clickBrokenLink() {
                brokenLink.click();
        }
        public String getPageText() {
                return body.getText();
        }
        public void verifyPageText(String expectedText) {
                assertTrue(getPageText().contains(expectedText));
        }
        public void verifyLinkUrl(String expectedUrl) {
                assertEquals(expectedUrl, currentUrl());
        }
}
