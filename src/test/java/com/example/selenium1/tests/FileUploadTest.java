package com.example.selenium1.tests;

import com.example.selenium1.pages.FileUploadPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileUploadTest {

    @Test
    public void uploadFileSuccessfully() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");

        FileUploadPage page = new FileUploadPage(driver);

        // Resolve correct absolute path
        String filePath = Paths.get("src/test/resources/sample.txt")
                .toAbsolutePath()
                .toString();

        // Upload
        page.uploadInput.sendKeys(filePath);
        page.submitButton.click();

        // Assert file name appears
        assertTrue(page.uploadedFileText.getText().contains("sample.txt"));

        driver.quit();
    }
}
