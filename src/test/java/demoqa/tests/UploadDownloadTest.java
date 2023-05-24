package demoqa.tests;

import demoqa.steps.UploadDownloadSteps;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class UploadDownloadTest extends BaseTest {
    @Test
    @SneakyThrows
    public void headerTest() {
        UploadDownloadSteps uploadDownloadSteps = new UploadDownloadSteps();
        visit("upload-download");
        uploadDownloadSteps.maximize();
        uploadDownloadSteps.verifyThatHeaderMatches();
    }
    @Test
    @SneakyThrows
    public void downloadTest() {
        UploadDownloadSteps uploadDownloadSteps = new UploadDownloadSteps();
        visit("upload-download");
        uploadDownloadSteps.maximize();
        uploadDownloadSteps.implicitlyWait();
        uploadDownloadSteps.verityFileDownload();
    }
    @Test
    @SneakyThrows
    public void uploadTest() {
        UploadDownloadSteps uploadDownloadSteps = new UploadDownloadSteps();
        visit("upload-download");
        uploadDownloadSteps.maximize();
        uploadDownloadSteps.implicitlyWait();
        uploadDownloadSteps.verifyFileUpload();
    }
}
