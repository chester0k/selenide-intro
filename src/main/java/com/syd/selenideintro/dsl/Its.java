package com.syd.selenideintro.dsl;


public class Its {
    public static String cssClass(String name) {
        return "contains(concat(' ', normalize-space(@class), ' '), " +
                "' " + name + "' " + ")";
    }

    public static String descendantText(String value) {
        return ".//text()=" + "'" + value + "'";
    }

    public static String id(String value) {
        return "@id=" + "'" + value + "'";
    }

    public static String not(String predicate) {
        return "not(" + predicate + ")";
    }
}



