package com.belyuk.second_project.builder;

import com.belyuk.second_project.entity.Medicine;
import com.belyuk.second_project.handler.MedicineErrorHandler;
import com.belyuk.second_project.handler.MedicineHandler;
import java.io.IOException;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class MedicineSaxBuilder {

  private Set<Medicine> medicine;
  private MedicineHandler handler = new MedicineHandler();
  private XMLReader reader;


  public MedicineSaxBuilder() {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    try {
      SAXParser saxParser = factory.newSAXParser();
      reader = saxParser.getXMLReader();
    } catch (ParserConfigurationException | SAXException e) {
      e.printStackTrace();
    }
    reader.setErrorHandler(new MedicineErrorHandler());
    reader.setContentHandler(handler);
  }

  public Set<Medicine> getMedicine() {
    return medicine;
  }

  public void buildSetMedicines(String filename) {
    try {
      reader.parse(filename);
    } catch (IOException | SAXException e) {
      e.printStackTrace();
    }
    medicine = handler.getMedicines();
  }
}
