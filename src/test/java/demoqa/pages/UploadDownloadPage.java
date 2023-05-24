package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class UploadDownloadPage extends BasePage {
    @FindBy(className = "main-header")
    WebElement header;
    @FindBy(id = "downloadButton")
    WebElement downloadButton;
    @FindBy(id = "uploadFile")
    WebElement uploadFileInput;
    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public void assertThatUploadDownloadHeaderExists() {
        assertThat(header.getText()).isEqualTo("Upload and Download");
    }
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
    public void setImplicitWait(Duration duration) {
        driver.manage().timeouts().implicitlyWait(duration);
    }
    public void clickDownloadButton() {
        downloadButton.click();
    }
    public void verifyThatFileWasDownloaded(String downloadDir, String expectedFileName) {
        String filePath = downloadDir + File.separator + expectedFileName;
        File downloadedFile = new File(filePath);
        assertTrue(downloadedFile.exists(), "Downloaded file does not exist");
    }
    public void uploadFile(String filePath) {
        uploadFileInput.sendKeys(filePath);
    }
    public String getUploadedFilePath() {
        return uploadedFilePath.getText();
    }
    public void verityUploadedFileName(String uploadedFileName) {
        assertThat(getUploadedFilePath()).contains(uploadedFileName);
    }
}
