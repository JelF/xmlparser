package com.github.jelf.xml;

import java.util.ArrayList;

/**
 * Created by jelf on 29.09.2014.
 */
public class HashMapFactory implements TagAcceptorFactory {
    @Override
    public HashMapTag getTagAcceptor(String name) {
        return new HashMapTag(name);
    }
}
