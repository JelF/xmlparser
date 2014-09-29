package com.github.jelf.xml;

import android.test.AndroidTestCase;

public class XmlParserTest extends AndroidTestCase {

    public void testRead() throws Exception {
        XmlParser parser = new XmlParser(getContext(),R.xml.test,new HashMapFactory());
        HashMapTag root = (HashMapTag) parser.read();
        HashMapTag t,t1,t2;


        //Tabs matching xml structure, not code conventions
        assertEquals("root",root.name);
        assertEquals(0,root.params.size());
        assertEquals(3,root.nested.size());
            t = root.nested.get(0);
            assertEquals("level1",t.name);
            assertEquals(2,t.params.size());
                assertEquals("123",t.params.get("id"));
                assertEquals("blah blah blah",t.params.get("name"));
            assertEquals(1,t.nested.size());
                t1=t.nested.get(0);
                assertEquals("nested",t1.name);
                assertEquals(1,t1.params.size());
                    assertEquals("2",t1.params.get("level"));
                assertEquals(0,t1.nested.size());
                assertNull(t1.value);
            assertEquals("Some Text",t.value);

            t=root.nested.get(1);
            assertEquals("level1",t.name);
            assertEquals(1,t.params.size());
                assertEquals("456",t.params.get("id"));
            assertEquals(0,t.nested.size());
            assertNull(t.value);

            t=root.nested.get(2);
            assertEquals("level1_extra",t.name);
            assertEquals(0,t.params.size());
            assertEquals(1,t.nested.size());
                t1=t.nested.get(0);
                assertEquals("level2",t1.name);
                assertEquals(0,t1.params.size());
                assertEquals(1,t1.nested.size());
                    t2=t1.nested.get(0);
                    assertEquals("level3",t2.name);
                    assertEquals(0,t2.params.size());
                    assertEquals(0,t2.nested.size());
                    assertEquals("We must go deeper!",t2.value);
                assertNull(t1.value);
            assertNull(t.value);
        assertNull(root.value);


    }
}