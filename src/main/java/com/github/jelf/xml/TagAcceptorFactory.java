package com.github.jelf.xml;

/**
 * Created by jelf on 29.09.2014.
 */
public interface TagAcceptorFactory {
    public TagAcceptor getTagAcceptor(String name) throws XmlParserException;
}
