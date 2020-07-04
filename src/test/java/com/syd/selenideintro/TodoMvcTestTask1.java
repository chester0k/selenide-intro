package com.syd.selenideintro;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.CollectionCondition.noneMatch;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTestTask1 {
    @Test
    void completeTask() {
        open("http://todomvc.com/examples/emberjs/");

        element("#new-todo").setValue("a").pressEnter();
        element("#new-todo").setValue("b").pressEnter();
        element("#new-todo").setValue("c").pressEnter();


        elements("#todo-list>li").shouldHave(exactTexts("a", "b", "c"));
        element("#ember11>div>.toggle").click();
        element("#ember11").shouldHave(cssClass("completed")).shouldHave(exactText("b"));
        element("#ember6").shouldHave(not(cssClass("completed"))).shouldHave(exactText("a"));
        element("#ember13").shouldHave(not(cssClass("completed"))).shouldHave(exactText("c"));

    }

}

