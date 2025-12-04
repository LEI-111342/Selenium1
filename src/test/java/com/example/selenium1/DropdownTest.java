package com.example.selenium1;

import com.example.selenium1.pages_111641.DropdownPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownTest {

    WebDriver driver;
    DropdownPage page;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        page = new DropdownPage(driver);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testDropdown() throws InterruptedException {
        Thread.sleep(1000);

        Select select = new Select(page.dropdown);
        select.selectByValue("2");

        Assertions.assertEquals("Option 2", select.getFirstSelectedOption().getText());
    }
}
