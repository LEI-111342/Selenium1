package com.example.selenium1.tests;;
import com.example.selenium1.pages.CheckboxesPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxesTest {

    private WebDriver driver;
    private CheckboxesPage page;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        page = new CheckboxesPage(driver);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testCheckboxes() throws InterruptedException {
        Thread.sleep(1000);

        // Click checkbox 1 if not selected
        if (!page.checkbox1.isSelected()) {
            page.checkbox1.click();
        }

        // Uncheck checkbox 2 if selected
        if (page.checkbox2.isSelected()) {
            page.checkbox2.click();
        }

        Assertions.assertTrue(page.checkbox1.isSelected());
        Assertions.assertFalse(page.checkbox2.isSelected());
    }
}
