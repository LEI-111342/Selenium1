package com.example.selenium1.sampler7.john.pages;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Condition.visible;

public class Sampler7DataPresentationPage {

    public Sampler7DataPresentationPage() {
        page(this); // Page Factory do Selenide
    }

    // Tile "User interface" no ecrã inicial azul
    @FindBy(xpath = "//*[@id='navigator']//div[contains(@class,'titlelabel') and normalize-space()='User interface']")
    private SelenideElement userInterfaceTile;

    // Tile "Data presentation" (segundo ecrã azul)
    @FindBy(xpath = "//*[@id='navigator']//div[contains(@class,'titlelabel') and normalize-space()='Data presentation']")
    private SelenideElement dataPresentationTile;

    // Tile "Label" dentro de Data presentation (o T Label)
    @FindBy(xpath = "//*[@id='navigator']//div[contains(@class,'titlelabel') and normalize-space()='Label']")
    private SelenideElement labelTile;

    // Título do exemplo aberto (no ecrã branco)
    @FindBy(id = "sampletitle")
    private SelenideElement sampleTitle;

    @Step("Abrir a secção User interface → Data presentation")
    public void openDataPresentationSection() {
        userInterfaceTile.shouldBe(visible).click();
        dataPresentationTile.shouldBe(visible).click();
    }

    @Step("Abrir o exemplo Label em Data presentation")
    public void openLabelSample() {
        openDataPresentationSection();
        labelTile.shouldBe(visible).click();
    }

    @Step("Obter o título do exemplo")
    public SelenideElement getSampleTitle() {
        return sampleTitle;
    }
}
