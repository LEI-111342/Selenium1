package com.example.selenium1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage {

    @FindBy(id = "file-upload")
    public WebElement uploadInput;

    @FindBy(id = "file-submit")
    public WebElement submitButton;

    @FindBy(id = "uploaded-files")
    public WebElement uploadedFileText;

    public FileUploadPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
