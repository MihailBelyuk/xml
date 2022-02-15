package com.belyuk.second_project;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ConsoleMedicineHandler extends DefaultHandler{

  @Override
  public void startDocument() {
    System.out.print("Parsing started");
  }

  @Override
  public void endDocument(){
    System.out.print("\n Parsing ended.");
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes){
   String tagData=qName + " ";
    for (int i = 0; i < attributes.getLength(); i++) {
      tagData += " " + attributes.getQName(i) + "=" + attributes.getValue(i);
    }
    System.out.print(tagData);
  }

  @Override
  public void endElement(String uri, String localName, String qName){
    System.out.print(" " + qName);
  }

  @Override
  public void characters(char[] ch, int start, int length){
    System.out.print(new String(ch,start,length));
  }
}
