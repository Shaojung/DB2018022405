package com.example.student.db2018022405;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by student on 2018/2/24.
 */

public class MyDataHandler extends DefaultHandler {
    boolean isTitle = false;
    StringBuilder sb;
    public ArrayList<String> titles = new ArrayList();
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("title"))
        {
            isTitle = true;
            sb = new StringBuilder();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("title"))
        {
            isTitle = false;
            Log.d("NET", sb.toString());
            titles.add(sb.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (isTitle)
        {
            // Log.d("NET", new String(ch, start, length));
            sb.append(new String(ch, start, length));
        }

    }
}
