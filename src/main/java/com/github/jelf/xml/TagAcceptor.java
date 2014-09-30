package com.github.jelf.xml;

/**
 * Created by jelf on 29.09.2014.
 */
public interface TagAcceptor {
    public void addParam(String name, String value) throws XmlParserException;
    public void addNested(TagAcceptor nested) throws XmlParserException;
    public void setValue(String name) throws XmlParserException;

    public void paramsDone() throws XmlParserException;
}
