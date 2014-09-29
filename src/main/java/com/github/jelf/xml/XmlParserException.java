package com.github.jelf.xml;

/**
 * Created by jelf on 29.09.2014.
 */
public class XmlParserException extends Exception {
    private String tag;

    public XmlParserException(String message) {
        super(message);
    }

    public XmlParserException(String tag, String message) {
        super(message);
        this.tag=tag;
    }

    public String getTag() {
        return tag;
    }
}
