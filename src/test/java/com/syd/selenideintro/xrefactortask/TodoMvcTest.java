package com.syd.selenideintro.xrefactortask;

import com.syd.selenideintro.xpathhelpers.X;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest {
    @Test
    void completeTask() {
        open("http://todomvc.com/examples/emberjs/");

        $x(X.hasId("new-todo")).setValue("a").pressEnter();
        $x(X.hasId("new-todo")).setValue("b").pressEnter();
        $x(X.hasId("new-todo")).setValue("c").pressEnter();
        $$x(X.hasId("todo-list")+ X.hasChild("li")).shouldHave(exactTexts("a", "b", "c"));

        $x(X.hasId("todo-list")+
                X.hasChild("li") +
                X.hasDescendantWithText("b") +
                X.hasDescendant() +
                X.hasCssClass("toggle"))
                .click();
        $$x(X.hasId("todo-list") +
                X.hasChild("li") +
                X.hasCssClass("completed"))
                .shouldHave(exactTexts("b"));
        $$x(X.hasId("todo-list") +
                X.hasChild("li") +
                X.hasNotCssClass("completed"))
                .shouldHave(exactTexts("a","c"));
    }
}
