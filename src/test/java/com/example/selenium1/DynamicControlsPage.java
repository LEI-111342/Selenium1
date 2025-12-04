package com.example.selenium1;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class DynamicControlsPage {

    // Checkbox e botão que remove/adiciona
    public SelenideElement checkbox = $("input[type='checkbox']");
    public SelenideElement toggleCheckboxButton = $("#checkbox-example button");

    // Input e botão que ativa/desativa
    public SelenideElement inputField = $("#input-example input[type='text']");
    public SelenideElement toggleInputButton = $("#input-example button");

    // Mensagem de feedback
    public SelenideElement message = $("#message");

    public void removeCheckbox() {
        toggleCheckboxButton.click();
        checkbox.shouldNot(exist);
        message.shouldBe(visible);
    }

    public void addCheckbox() {
        toggleCheckboxButton.click();
        checkbox.should(exist);
        message.shouldBe(visible);
    }

    public void enableInput() {
        toggleInputButton.click();
        inputField.shouldBe(enabled);
        message.shouldBe(visible);
    }

    public void disableInput() {
        toggleInputButton.click();
        inputField.shouldBe(disabled);
        message.shouldBe(visible);
    }
}
