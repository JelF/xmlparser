package com.github.jelf.xml;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by jelf on 29.09.2014.
 */
public class XmlParser {
    private XmlPullParser parser;
    private TagAcceptorFactory factory;

    XmlParser(XmlPullParser parent, TagAcceptorFactory factory) {
        this.parser = parent;
        this.factory = factory;
    }
    XmlParser(Context context, int id, TagAcceptorFactory factory) {
        parser = context.getResources().getXml(id);
        this.factory = factory;
    }

    public TagAcceptor read() throws IOException, XmlPullParserException, XmlParserException {
        return this.parse(null);
    }

    private TagAcceptor parse(TagAcceptor tag) throws IOException, XmlPullParserException, XmlParserException {

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
                    return tag;
                case XmlPullParser.TEXT:
                    tag.setValue(parser.getText().replaceFirst("^\\s*","").replaceFirst("\\s*$",""));
            }

        } while(event != XmlPullParser.END_DOCUMENT);

        return tag;
    }

    private TagAcceptor parseTag() throws IOException, XmlPullParserException, XmlParserException {
        TagAcceptor tag = factory.getTagAcceptor(parser.getName());
        for(int i=0;i<parser.getAttributeCount();i++) {
            tag.addParam(parser.getAttributeName(i),parser.getAttributeValue(i));
        }
        return parse(tag);
    }
}
