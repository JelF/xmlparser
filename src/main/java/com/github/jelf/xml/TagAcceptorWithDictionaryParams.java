package com.github.jelf.xml;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

/**
 * Created by jelf on 30.09.2014.
 */
public abstract class TagAcceptorWithDictionaryParams implements TagAcceptor {
    /**
     * This method can be used as a constructor. It always would be called first, even if no tags supplied (in this case it would be called with empty HashMap)
     * @param params Map with all supplied parameters as keys and their values as values
     * @throws XmlParserException on fatal errors. Should not be thrown on extra parameters in most cases, because odd parameters should better could be supplied
     */
    abstract protected void withParams(@NotNull HashMap<String,String> params) throws XmlParserException;
    private HashMap<String,String> params = new HashMap<String, String>();

    /**
     * Stores any param in nested map
     * @param name parameter name
     * @param value parameter value
     */
    @Override
    public final void addParam(@NotNull String name, @Nullable String value) {
        params.put(name,value);
    }

    /**
     * Calls withParams after all params would be supplied. It is always before anything else would be supplied
     * @throws XmlParserException on fatal errors in withParams
     */
    @Override
    public void paramsDone() throws XmlParserException {
        withParams(params);
    }
}
