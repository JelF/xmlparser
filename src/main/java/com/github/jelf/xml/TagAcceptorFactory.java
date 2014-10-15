package com.github.jelf.xml;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by jelf on 29.09.2014.
 */
public interface TagAcceptorFactory {
    /**
     * The only method of factory, that would be called by engine. Generates java object matching tag name.
     * @param name name of tag
     * @return new tag or null if tag not found (it would be used in inheritance)
     * @throws XmlParserException on fatal errors
     */
    public @Nullable TagAcceptor getTagAcceptor(@NotNull String name) throws XmlParserException;
}
