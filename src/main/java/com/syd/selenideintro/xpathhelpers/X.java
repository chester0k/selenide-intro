package com.syd.selenideintro.xpathhelpers;

public class X {
    private String fullXpath;

    public X(String startPath) {
        fullXpath = startPath;
    }

    public X by(String predicate) {
        this.fullXpath += "[" + predicate + "]";
        return this;
    }

    public X not(String predicate) {
        this.fullXpath += "not(" + predicate + ")";
        return this;
    }

    public X child(String value) {
        this.fullXpath += "/" + value;
        return this;
    }

    public static X all() {
        return new X("//*");
    }

    public X descendant() {
        this.fullXpath += "//*";
        return this;
    }

    public String x() {
        return this.fullXpath;
    }

}
