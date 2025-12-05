package database;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.CollectionCondition.size;

public class DatabaseTest {

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        // ALLURE LISTENER → REQUIRED TO GENERATE REPORT FILES
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true)
        );
    }

    @Test
    public void verifyMovieInformationIsDisplayedCorrectly() {

        DatabasePage page = new DatabasePage().openPage();

        page.pageRoot.shouldHave(
                text("Law Abiding Citizen"),
                text("2009"),
                text("F. Gardy Gray"),

                text("Knives Out"),
                text("2019"),
                text("Rian Johnson"),

                text("The Last Jedi"),
                text("2017"),
                text("Rian Johnson")
        );

        page.links.filterBy(text("IMBD")).shouldHave(size(3));
    }
}
