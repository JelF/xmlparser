XmlParser v0.999
================
XmlParser is a wrapper for _org.xmlpull.v1.XmlPullParser_, which allows to load structured data from XML.


Usage
----------------
`XmlParser parser = new XmlParser(getResources().getXML(R.xml.something), factory)` <br/>
`XmlParser parser = new XmlParser(this, R.xml.something, factory)` <br/><br/>
`factory` here is an object, that implements `TagAcceptorFactory` interface. You can use `HashMapFactory`,
 which generates HashMapTags with public `name`, `params`, `nested` tags and `value` (see `XmlParserTest` for examples).
<br/><br/>
`HashMapFactory` is easy in use, but don't do any real work for you. The better idea is to use your common tag acceptors, generated by your own factory.
 To make a tag acceptor, you should inherit `TagAcceptor` and implement it's methods `addParam`, `addNested` and `setValue`. Examples would be added later