package com.github.jelf.xml;

/**
 * Created by jelf on 30.09.2014.
 */
public abstract class SimpleTagAcceptor implements TagAcceptor {
    /**
     * This function is called, when all parameters have been red
     * We can ignore paramsDone callback in simple tags
     */
    @Override
    public void paramsDone() {

    }
}
