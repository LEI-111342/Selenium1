package database;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DatabasePage {

    // Root of the page (we’ll assert text on this)
    public SelenideElement pageRoot = $("body");

    // All links on the page (we’ll filter later for IMDB links)
    public ElementsCollection links = $$("a");

    // Open the Database example
    public DatabasePage openPage() {
        open("https://vaadin-database-example.demo.vaadin.com/");
        return this;
    }
}
