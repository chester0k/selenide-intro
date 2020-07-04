package com.syd.selenideintro;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class TodoMvcTest {
    @Test
    void completeTask() {
        // open TodoMVC page
        open("http://todomvc.com/examples/emberjs/");
        // add tasks: "a", "b", "c"
        // add task "a":
//   1) find "new task" edit field 2) set value to "a" 3) press Enter
        $("#new-todo").setValue("a").pressEnter();
        $("#new-todo").setValue("b").pressEnter();
        $("#new-todo").setValue("c").pressEnter();


        // tasks should be "a", "b", "c"
        $$("#todo-list>li").shouldHave(exactTexts("a", "b", "c"));
        $$("#todo-list>li").findBy(exactText("b")).find(".toggle").click();
        $$("#todo-list>li").filterBy(cssClass("completed")).shouldHave(exactTexts("b"));
        $$("#todo-list>li").filterBy(not(cssClass("completed"))).shouldHave(exactTexts("a", "c"));
        // toggle "b"
        // completed tasks should be "b"
        // active tasks should be "a", "c"
    }

}

