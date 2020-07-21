package com.syd.selenideintro.dsl;

public class Path {
    public static Path any() {
        return new Path("//*");
    }

    private String selector;

    public Path(String selector) {
        this.selector = selector;
    }

    public Path by(String predicate) {
        this.selector += "[" + predicate + "]";
        return this;
    }

    public Path byNot(String predicate) {
        return this.by(Its.not(predicate));
    }

    public Path child(String tag) {
        this.selector += "/" + tag;
        return this;
    }

    public Path child() {
        return this.child("*");
    }

    public Path descendant(String tag) {
        this.selector += "//" + tag;
        return this;
    }

    public Path descendant() {
        return this.descendant("*");
    }

    public String x() {
        return this.selector;
    }
}
