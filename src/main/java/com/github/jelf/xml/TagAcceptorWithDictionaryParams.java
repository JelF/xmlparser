package com.github.jelf.xml;

import java.util.HashMap;

/**
 * Created by jelf on 30.09.2014.
 */
public abstract class TagAcceptorWithDictionaryParams implements TagAcceptor {
    abstract protected void withParams(HashMap<String,String> params) throws XmlParserException;
    private HashMap<String,String> params = new HashMap<String, String>();

    @Override
    public final void addParam(String name, String value) {
        params.put(name,value);
    }

    @Override
    public void paramsDone() throws XmlParserException {
        withParams(params);
    }
}
