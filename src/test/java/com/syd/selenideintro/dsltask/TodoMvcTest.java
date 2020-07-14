package com.syd.selenideintro.dsltask;

import com.syd.selenideintro.xpathhelpers.Its;
import com.syd.selenideintro.xpathhelpers.X;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest {
    @Test
    void completeTask() {
        open("http://todomvc.com/examples/emberjs/");

        $x(X.all().by(Its.id("new-todo")).x()).setValue("a").pressEnter();
        $x(X.all().by(Its.id("new-todo")).x()).setValue("b").pressEnter();
        $x(X.all().by(Its.id("new-todo")).x()).setValue("c").pressEnter();
        $$x(X.all().by(Its.id("todo-list")).child("li").x())
                .shouldHave(exactTexts("a", "b", "c"));

        $x(X.all().by(Its.id("todo-list")).child("li")
                .by(Its.descendantWithText("b"))
                .descendant()
                .by(Its.cssClass("toggle")).x())
                .click();
        $$x(X.all().by(Its.id("todo-list")).child("li")
                .by(Its.cssClass("completed")).x())
                .shouldHave(exactTexts("b"));
        $$x(X.all().by(Its.id("todo-list")).child("li")
                .by(Its.not(Its.cssClass("completed"))).x())
                .shouldHave(exactTexts("a", "c"));
    }
}
