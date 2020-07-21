package com.syd.selenideintro.dsltask;

import com.syd.selenideintro.dsl.Its;
import com.syd.selenideintro.dsl.Path;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest {
    @Test
    void completeTask() {
        open("http://todomvc.com/examples/emberjs/");

        $x(Path.any().by(Its.id("new-todo")).x()).setValue("a").pressEnter();
        $x(Path.any().by(Its.id("new-todo")).x()).setValue("b").pressEnter();
        $x(Path.any().by(Its.id("new-todo")).x()).setValue("c").pressEnter();
        $$x(Path.any().by(Its.id("todo-list")).child("li").x())
                .shouldHave(exactTexts("a", "b", "c"));

        $x(Path.any().by(Its.id("todo-list")).child("li")
                .by(Its.descendantText("b"))
                .descendant()
                .by(Its.cssClass("toggle")).x())
                .click();
        $$x(Path.any().by(Its.id("todo-list")).child("li")
                .by(Its.cssClass("completed")).x())
                .shouldHave(exactTexts("b"));
        $$x(Path.any().by(Its.id("todo-list")).child("li")
                .byNot(Its.cssClass("completed")).x())
                .shouldHave(exactTexts("a", "c"));
    }
}
