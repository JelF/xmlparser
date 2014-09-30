package com.github.jelf.xml;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jelf on 29.09.2014.
 */
public class HashMapTag extends SimpleTagAcceptor {

    public String name;
    public HashMap<String,String> params;
    public ArrayList<HashMapTag> nested;
    public String value;

    private static HashMapFactory factory = new HashMapFactory();
    public static HashMapFactory getFactory() {
        return factory;
    }

    public HashMapTag(String name) {
        this.name = name;
        params = new HashMap<String, String>();
        nested = new ArrayList<HashMapTag>();
        value = null;
    }

    @Override
    public void addParam(String name, String value) {
        params.put(name,value);
    }

    @Override
    public void setValue(String value) {
        this.value=value;
    }

    @Override
    public void addNested(TagAcceptor nested) {
        this.nested.add((HashMapTag) nested);
    }
}
