package com.example.selenium1.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.selenium1.pages.DynamicControlsPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class DynamicControlsTest {

    DynamicControlsPage page = new DynamicControlsPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test
    public void shouldRemoveAndAddCheckbox() {
        // Garante que o checkbox existe no início
        page.checkbox.should(exist);

        // Remove checkbox
        page.removeCheckbox();
        page.checkbox.shouldNot(exist);
        page.message.shouldHave(text("It's gone!"));

        // Adiciona novamente
        page.addCheckbox();
        page.checkbox.should(exist);
        page.message.shouldHave(text("It's back!"));
    }

    @Test
    public void shouldEnableAndDisableInput() {
        // No início o input está desativado
        page.inputField.shouldBe(disabled);

        // Ativa input
        page.enableInput();
        page.inputField.shouldBe(enabled);
        page.message.shouldHave(text("It's enabled!"));

        // Desativa input
        page.disableInput();
        page.inputField.shouldBe(disabled);
        page.message.shouldHave(text("It's disabled!"));
    }
}
