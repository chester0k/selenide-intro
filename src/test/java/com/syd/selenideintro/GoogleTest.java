package com.syd.selenideintro;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

import org.junit.jupiter.api.Test;
public class GoogleTest {
    @Test
    void shouldSearch() {
        open("https://google.com/ncr");

        element(byName("q")).setValue("selenide").pressEnter();

        ElementsCollection results = elements("#search .g");
        results.shouldHave(sizeGreaterThanOrEqual(6)).first().shouldHave(text("Selenide: concise UI tests in Java"));
        results.shouldHave(sizeGreaterThanOrEqual(6))
                .first().shouldHave(text("Selenide: concise UI tests in Java"));
        results.first().find(".r>a").click();

        Wait().until(titleIs("Selenide: concise UI tests in Java"));
    }
}

