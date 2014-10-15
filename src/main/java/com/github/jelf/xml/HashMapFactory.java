package com.github.jelf.xml;

import org.jetbrains.annotations.NotNull;

/**
 * Created by jelf on 29.09.2014.
 */
public class HashMapFactory implements TagAcceptorFactory {
    /**
     * Generates HashMapTag for any tag name
     * @param name name of tag
     * @return HashMapTag in any case
     */
    @Override
    public @NotNull HashMapTag getTagAcceptor(@NotNull String name) {
        return new HashMapTag(name);
    }
}
