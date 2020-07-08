package com.syd.selenideintro.xpathhelpers;

public class X {
    public static String hasCssClass(String className) {
        return String.format("[contains(concat(' ', normalize-space(@class), ' '), ' %s ')]", className);
    }

    public static String hasNotCssClass(String className) {
        return String.format("[not(contains(concat(' ', normalize-space(@class), ' '), ' %s '))]", className);
    }

    public static String hasId(String id) {
        return String.format("//*[@id='%s']", id);
    }
    public static String hasChild(String child) {
        return String.format("/%s", child);
    }

    public static String hasDescendantWithText(String text) {
        return String.format("[.//text()='%s']", text);
    }

    public static String hasDescendant() {
        return "//*";
    }
}

