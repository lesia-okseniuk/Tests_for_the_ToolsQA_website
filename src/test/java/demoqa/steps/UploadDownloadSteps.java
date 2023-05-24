package demoqa.steps;

import demoqa.pages.UploadDownloadPage;

import java.time.Duration;

public class UploadDownloadSteps {
    UploadDownloadPage uploadDownloadPage = new UploadDownloadPage();
    public void maximize() {
        uploadDownloadPage.maximizeWindow();
    }
    public void implicitlyWait() {
      uploadDownloadPage.setImplicitWait(Duration.ofSeconds(30));
    }
    public void verifyThatHeaderMatches() {
        uploadDownloadPage.assertThatUploadDownloadHeaderExists();
    }
    public void verityFileDownload() {
        uploadDownloadPage.clickDownloadButton();
        uploadDownloadPage.verifyThatFileWasDownloaded("/home/hymerka/Завантаження", "sampleFile.jpeg");
    }
    public void verifyFileUpload() {
        uploadDownloadPage.uploadFile("/home/hymerka/IdeaProjects/ToolsQA/testUpload.jpeg");
        uploadDownloadPage.verityUploadedFileName("testUpload.jpeg");
    }
}
