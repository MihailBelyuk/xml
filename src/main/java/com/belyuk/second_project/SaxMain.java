package com.belyuk.second_project;

import com.belyuk.second_project.builder.MedicineSaxBuilder;

public class SaxMain {

  public static void main(String[] args) {
//    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
//    try {
//      SAXParser saxParser = saxParserFactory.newSAXParser();
//      XMLReader xmlReader = saxParser.getXMLReader();
//      xmlReader.setContentHandler(new ConsoleMedicineHandler());
//      xmlReader.parse("files/medicines.xml");
//    } catch (ParserConfigurationException e) {
//      e.printStackTrace();
//    } catch (SAXException | IOException e) {
//      e.printStackTrace();
//    }
    MedicineSaxBuilder medicineSaxBuilder = new MedicineSaxBuilder();
    medicineSaxBuilder.buildSetMedicines("files/medicines.xml");
    System.out.println(medicineSaxBuilder.getMedicine());
  }

//
//    MedicineDomBuilder domBuilder = new MedicineDomBuilder();
//    domBuilder.buildSetMedicine("files/medicines.xml");
//    for (Medicine meds: domBuilder.getMedicineSet()) {
//      System.out.println(meds);

//    MedicineStaxBuilder staxBuilder = new MedicineStaxBuilder();
//    staxBuilder.buildSetMedicines("files/medicines.xml");
//    for (Medicine meds : staxBuilder.getMedicineSet()) {
//      System.out.println(meds);
//    }
  }



