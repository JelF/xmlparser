package com.github.jelf.xml;

import org.jetbrains.annotations.Nullable;

/**
 * Created by jelf on 29.09.2014.
 */
public class XmlParserException extends Exception {
    private String tag;

    /**
     * Creates new exception
     */
    public XmlParserException() {
        this(null,"");
    }

    /**
     * Creates new exception
     * @param message any message supplied
     */
    public XmlParserException(String message) {
        this(null, message);
    }

    /**
     * Creates new exception
     * @param tag tag in which exception was raised
     * @param message any message supplied
     */
    public XmlParserException(String tag, String message) {
        super(message);
        this.tag=tag;
    }

    /**
     * Returns tag if supplied and null if not
     * @return tag if supplied and null if not
     */
    public @Nullable String getTag() {
        return tag;
    }
}
