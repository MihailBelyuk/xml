package com.belyuk.second_project.handler;

import com.belyuk.second_project.entity.Antibiotics;
import com.belyuk.second_project.entity.Medicine;
import com.belyuk.second_project.enums.MedicinesXmlTag;
import java.util.HashSet;
import java.util.Set;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MedicineHandler extends DefaultHandler {

  private Set<Medicine> medicines;
  private Medicine current;
  private MedicinesXmlTag currentXmlTag;
//  private EnumSet<MedicinesXmlTag> withText;
  private static final String ELEMENT_ANTIBIOTICS = "antibiotics";

  public MedicineHandler() {
    medicines = new HashSet<Medicine>();
//    withText = EnumSet.range(MedicinesXmlTag.NAME, MedicinesXmlTag.MANUFACTURER);
  }

  public Set<Medicine> getMedicines() {
    return medicines;
  }

  public void startElement(String uri, String localName, String qName, Attributes attrs) {
    if (ELEMENT_ANTIBIOTICS.equals(qName)) {
      current = new Antibiotics();
      current.setId(attrs.getValue(0));
//      if (attrs.getLength() == 2) { // warning!!!!
//        current.setFaculty(attrs.getValue(1));
//      }
//    } else {
//      MedicinesXmlTag temp = MedicinesXmlTag.valueOf(qName.toUpperCase());
//      if (withText.contains(temp)) {
//        currentXmlTag = temp;
//      }
    }
  }

  public void endElement(String uri, String localName, String qName) {
    if (ELEMENT_ANTIBIOTICS.equals(qName)) {
      medicines.add(current);
    }
  }

  public void characters(char[] ch, int start, int length) {
    String data = new String(ch, start, length).strip();
//    BigDecimal price = new BigDecimal(data);
    if (currentXmlTag != null) {
      switch (currentXmlTag) {
        case NAME -> current.setName(data);
        case MANUFACTURER -> current.setManufacturer(data);
//        case ISSUE_DATE -> current.setMedCertificateIssueDate(data);
//        case EXPIRY_DATE -> current.setMedCertificateExpiryDate(data);
        case DOSAGE_FORM -> current.setDosageForm(data);
        case DOSAGE -> current.setDosage(data);
        case AMOUNT -> current.setAmount(Integer.parseInt(data));
//        case PRICE -> current.setPrice(price);
        default -> throw new EnumConstantNotPresentException(
            currentXmlTag.getDeclaringClass(), currentXmlTag.name());
      }
    }
    currentXmlTag = null;
  }
}
