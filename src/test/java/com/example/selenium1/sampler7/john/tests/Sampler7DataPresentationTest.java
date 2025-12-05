package com.example.selenium1.sampler7.john.tests;
import com.example.selenium1.sampler7.john.pages.Sampler7DataPresentationPage;



import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

@Epic("Sampler 7")
@Feature("User interface → Data presentation → Label")
public class Sampler7DataPresentationTest {

    private Sampler7DataPresentationPage samplerPage;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://demo.vaadin.com/sampler/");
        samplerPage = page(Sampler7DataPresentationPage.class);
    }

    @Test
    @Story("Aceder ao componente do tipo Data presentation (Label)")
    public void shouldOpenLabelInDataPresentation() {
        samplerPage.openLabelSample();

        // Apenas verifica que o elemento do título existe
        samplerPage.getSampleTitle().exists();
    }
}
