package com.syd.selenideintro.xpathhelpers;

public class Xpath {

    public static String filterBy(String predicate) {
        return "[" + predicate + "]";
    }

    public static String not(String predicate) {
        return "not(" + predicate + ")";
    }

    public static String hasCssClass(String name) {
        return "contains(concat(' ', normalize-space(@class), ' '), " +
                "' " + name + "' " + ")";
    }

    public static String hasNoCssClass(String name) {
        return not(hasCssClass(name));
    }

    public static class FilterBy {
        public static String noCssClass(String name) {
            return filterBy(not(hasCssClass(name)));
        }

        public static String cssClass(String name) {
            return filterBy(hasCssClass(name));
        }
    }
}
