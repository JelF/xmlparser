package com.github.jelf.xml;

import android.content.Context;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by jelf on 29.09.2014.
 */
public class XmlParser {
    private XmlPullParser parser;
    private TagAcceptorFactory factory;

    /**
     * Creates XmlParser from XmlPullParser and tag factory
     * @param parent XmlPullParser (possibly XmlResourceParser), set up to the beginning of document
     * @param factory XmlTagFactory, which will generate tags
     */
    public XmlParser(@NotNull XmlPullParser parent, @NotNull TagAcceptorFactory factory) {
        this.parser = parent;
        this.factory = factory;
    }

    /**
     * Creates XmlParser from context, resource id and tag factory
     * @param context context, from which we can read document
     * @param id xml resource id
     * @param factory  XmlTagFactory, which will generate tags
     */
    public XmlParser(@NotNull  Context context, int id, @NotNull TagAcceptorFactory factory) {
        parser = context.getResources().getXml(id);
        this.factory = factory;
    }

    /**
     * Reads whole xml document and stores it in a new root tag
     * @return Tag in the root of xml document. It could be only one
     * @throws IOException see XmlPullParser doc
     * @throws XmlPullParserException see XmlPullParser doc
     * @throws XmlParserException in any error building tags
     */
    public @NotNull TagAcceptor read() throws IOException, XmlPullParserException, XmlParserException {
        return this.parse(null);
    }

    /**
     * Reads xml document until current tag ends and stores it in supplied tag.
     * If no tag supplied, calls itself for a first tag found
     * @param tag which should be populated during the document parsing
     * @return tag, which always will be the same object, that @NotNull argument
     * @throws IOException see XmlPullParser doc
     * @throws XmlPullParserException see XmlPullParser doc
     * @throws XmlParserException on any error building tags
     */
    private @NotNull TagAcceptor parse(@Nullable TagAcceptor tag) throws IOException, XmlPullParserException, XmlParserException {

        int event;
        do {
            parser.next();
            event=parser.getEventType();
            switch(event) {
                case XmlPullParser.START_TAG:
                    if(tag==null) return parseTag();
                    else tag.addNested(parseTag());
                    break;
                case XmlPullParser.END_TAG:
                    assert tag != null;
                    return tag;
                case XmlPullParser.TEXT:
                    assert tag != null;
                    tag.setValue(parser.getText().replaceFirst("^\\s*","").replaceFirst("\\s*$",""));
            }

        } while(event != XmlPullParser.END_DOCUMENT);

        assert tag != null;
        return tag;
    }

    /**
     * Parses the tag head and invokes parse process on it's body
     * @return tag object, generated for this tag name
     * @throws IOException see XmlPullParser doc
     * @throws XmlPullParserException see XmlPullParser doc
     * @throws XmlParserException on any errors building tags or when tag name not found in library
     */
    private @NotNull TagAcceptor parseTag() throws IOException, XmlPullParserException, XmlParserException {
        TagAcceptor tag = factory.getTagAcceptor(parser.getName());
        if(tag==null) {
            throw new XmlParserException("tag '"+parser.getName()+"' not found in factory");
        }
        for(int i=0;i<parser.getAttributeCount();i++) {
            tag.addParam(parser.getAttributeName(i),parser.getAttributeValue(i));
        }
        tag.paramsDone();
        return parse(tag);
    }
}
