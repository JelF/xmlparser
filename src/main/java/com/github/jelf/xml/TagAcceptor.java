package com.github.jelf.xml;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by jelf on 29.09.2014.
 */
public interface TagAcceptor {

    /**
     * Adds parameter to a tag
     * @param name parameter name
     * @param value parameter value
     * @throws XmlParserException on fatal errors
     */
    public void addParam(@NotNull String name, @Nullable String value) throws XmlParserException;

    /**
     * Adds nested tag.
     * @param nested the tag, generated by a TagAcceptorFactory
     * @throws XmlParserException on fatal errors or if nested tag of this type not supported
     */
    public void addNested(@NotNull TagAcceptor nested) throws XmlParserException;

    /**
     * Sets the value of tag to string
     * @param value tag body without any spaces in start or end
     * @throws XmlParserException on fatal errors
     */
    public void setValue(@Nullable String value) throws XmlParserException;

    /**
     * This function is called, when all parameters have been red
     * @throws XmlParserException on fatal errors
     */
    public void paramsDone() throws XmlParserException;
}
