package com.belyuk.second_project.handler;

import com.belyuk.second_project.entity.Medicine;
import com.belyuk.second_project.entity.impl.AntibioticsImpl;
import com.belyuk.second_project.enums.MedicinesXmlTag;
import java.util.HashSet;
import java.util.Set;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MedicineHandler extends DefaultHandler {

  private Set<Medicine> medicines;
  private Medicine current;
  private MedicinesXmlTag currentXmlTag;
  private static final String ELEMENT_MEDICINES = "medicines";
  private static final String ANTIBIOTICS = "antibiotics";
  private static final String NAME = "name";
  private static final String MANUFACTURER = "manufacturer";
  private static final String DOSAGE_FORM = "dosage_form";
  private static final String AMOUNT = "amount";
  private static final String ID = "id";
  private static final String DOSAGE = "dosage";
  private static final String PRICE = "price";
  private static final String ISSUE_DATE = "issue_date";
  private static final String EXPIRY_DATE = "expiry_date";
  private static final String SOLUBILITY = "solubility";
  private static final String SERIAL = "serial";
  private static final String DATE_PATTERN = "dd.MM.yyyy";
  private static final String VITAMINS = "vitamins";


  public MedicineHandler() {
    medicines = new HashSet<>();
  }

  public Set<Medicine> getMedicines() {
    return medicines;
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attrs) {
    if (ANTIBIOTICS.equals(qName)) {
      current = new AntibioticsImpl();
      current.setId(attrs.getValue(ID));

    }
  }

  @Override
  public void endElement(String uri, String localName, String qName) {
    if (ELEMENT_MEDICINES.equals(qName)) {
      medicines.add(current);
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) {
    String data = new String(ch, start, length).strip();
    if (currentXmlTag != null) {
      switch (currentXmlTag) {
        case NAME -> current.setName(data);
        case MANUFACTURER -> current.setManufacturer(data);
//        case ISSUE_DATE -> current.setMedCertificateIssueDate(data); //TODO
//        case EXPIRY_DATE -> current.setMedCertificateExpiryDate(data); //TODO
        case DOSAGE_FORM -> current.setDosageForm(data);
        case DOSAGE -> current.setDosage(data);
        case AMOUNT -> current.setAmount(Integer.parseInt(data));
//        case PRICE -> current.setPrice(price); //TODO
        default -> throw new EnumConstantNotPresentException(
            currentXmlTag.getDeclaringClass(), currentXmlTag.name());
      }
    }
    currentXmlTag = null;
  }
}
