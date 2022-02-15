package com.belyuk.second_project.builder;

import com.belyuk.second_project.entity.Antibiotics;
import com.belyuk.second_project.entity.Medicine;
import com.belyuk.second_project.enums.MedicinesXmlTag;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class MedicineStaxBuilder {

  private final Set<Medicine> medicineSet;
  private final XMLInputFactory inputFactory;

  public MedicineStaxBuilder() {
    inputFactory = XMLInputFactory.newInstance();
    medicineSet = new HashSet<Medicine>();
  }

  public Set<Medicine> getMedicineSet() {
    return medicineSet;
  }

  public void buildSetMedicines(String filename, MedicinesXmlTag) {
    XMLStreamReader reader;
    String name;
    try (FileInputStream inputStream = new FileInputStream(filename)) {
      reader = inputFactory.createXMLStreamReader(inputStream);
      while (reader.hasNext()) {
        int type = reader.next();
        if (type == XMLStreamConstants.START_ELEMENT) {
          name = reader.getLocalName();
          if (name.equals(MedicinesXmlTag.ANTIBIOTICS.getValue())) {
            Medicine medicine = buildMedicine(reader);
            medicineSet.add(medicine);
          }
        }
      }
    } catch (XMLStreamException | FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private Medicine buildMedicine(XMLStreamReader reader)
      throws XMLStreamException {
    Antibiotics antibiotics = new Antibiotics();

    antibiotics.setId(reader.getAttributeValue(null, MedicinesXmlTag.ID.getValue()));
    antibiotics.setName(reader.getAttributeValue(null,
        MedicinesXmlTag.NAME.getValue()));

    String name;
    while (reader.hasNext()) {
      int type = reader.next();
      switch (type) {
        case XMLStreamConstants.START_ELEMENT:
          name = reader.getLocalName();
          switch (MedicinesXmlTag.valueOf(name.toUpperCase())) {
            case NAME -> antibiotics.setName(getXMLText(reader));
            case MANUFACTURER -> antibiotics.setManufacturer(getXMLText(reader));
            case DOSAGE_FORM -> antibiotics.setDosageForm(getXMLText(reader));
            case ISSUE_DATE -> antibiotics.setMedCertificateIssueDate(getXMLDate(reader));
            case EXPIRY_DATE -> antibiotics.setMedCertificateExpiryDate(getXMLDate(reader));
            case DOSAGE -> antibiotics.setDosage(getXMLText(reader));
            case AMOUNT -> antibiotics.setAmount(Integer.parseInt(getXMLText(reader)));
            case ID -> antibiotics.setId(getXMLText(reader));
//            case PRICE -> antibiotics.setPrice(getBigDecimalValue(reader)); //TODO
          }
          break;
        case XMLStreamConstants.END_ELEMENT:
          name = reader.getLocalName();
          if (MedicinesXmlTag.valueOf(name.toUpperCase()) == MedicinesXmlTag.ANTIBIOTICS) {
            return antibiotics;
          }
      }
    }
    throw new XMLStreamException("Unknown element in tag <antibiotics>");
  }

  private String getXMLText(XMLStreamReader reader) {
    String text = null;
    try {
      if (reader.hasNext()) {
        reader.next();
        text = reader.getText();
      }
    } catch (XMLStreamException e) {
      e.printStackTrace();
    }
    return text;
  }

  private Date getXMLDate(XMLStreamReader reader) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    Date date = null;
    try {
      if (reader.hasNext()) {
        reader.next();
        date = simpleDateFormat.parse(reader.getText());
      }
    } catch (XMLStreamException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }
}
