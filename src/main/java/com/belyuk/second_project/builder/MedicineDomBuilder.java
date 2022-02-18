package com.belyuk.second_project.builder;

import com.belyuk.second_project.entity.impl.AntibioticsImpl;
import com.belyuk.second_project.entity.Medicine;
import com.belyuk.second_project.entity.impl.VitaminsImpl;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MedicineDomBuilder {

  private Set<Medicine> medicineSet;
  private DocumentBuilder documentBuilder;
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
  private static final String ANTIBIOTICS = "antibiotics";

  public MedicineDomBuilder() {
    medicineSet = new HashSet<Medicine>();
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    try {
      documentBuilder = documentBuilderFactory.newDocumentBuilder();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }
  }

  public Set<Medicine> getMedicineSet() {
    return medicineSet;
  }

  public void buildSetMedicine(String filename, String elementName) {
    Document document;
    try {
      document = documentBuilder.parse(filename);
      Element root = document.getDocumentElement();
      NodeList medicineList = root.getElementsByTagName(elementName);
      for (int i = 0; i < medicineList.getLength(); i++) {
        Element medicineElement = (Element) medicineList.item(i);
        if (medicineElement.getTagName().equals(VITAMINS)) {
          Medicine medicine = buildVitamins(medicineElement);
          medicineSet.add(medicine);
        }
        if (medicineElement.getTagName().equals(ANTIBIOTICS)) {
          Medicine medicine = buildAntibiotics(medicineElement);
          medicineSet.add(medicine);
        }
      }
    } catch (SAXException | IOException e) {
      e.printStackTrace();
    }

  }

  private Medicine buildVitamins(Element medicineElement) {
    VitaminsImpl vitamins = new VitaminsImpl();
    vitamins.setName(getElementTextContent(medicineElement, NAME));
    vitamins.setManufacturer(getElementTextContent(medicineElement, MANUFACTURER));
    vitamins.setDosageForm(getElementTextContent(medicineElement, DOSAGE_FORM));
    vitamins.setAmount(Integer.parseInt(getElementTextContent(medicineElement, AMOUNT)));
    vitamins.setId(medicineElement.getAttribute(ID));
    vitamins.setDosage(getElementTextContent(medicineElement, DOSAGE));
    vitamins.setPrice(getElementBigDecimalContent(medicineElement, PRICE));
    vitamins.setMedCertificateIssueDate(getElementDateContent(medicineElement, ISSUE_DATE));
    vitamins.setMedCertificateExpiryDate(
        getElementDateContent(medicineElement, EXPIRY_DATE));
    vitamins.setSerial(medicineElement.getAttribute(SERIAL));
    return vitamins;
  }

  private Medicine buildAntibiotics(Element medicineElement) {
    AntibioticsImpl antibiotics = new AntibioticsImpl();
    antibiotics.setName(getElementTextContent(medicineElement, NAME));
    antibiotics.setManufacturer(getElementTextContent(medicineElement, MANUFACTURER));
    antibiotics.setDosageForm(getElementTextContent(medicineElement, DOSAGE_FORM));
    antibiotics.setAmount(Integer.parseInt(getElementTextContent(medicineElement, AMOUNT)));
    antibiotics.setId(medicineElement.getAttribute(ID));
    antibiotics.setDosage(getElementTextContent(medicineElement, DOSAGE));
    antibiotics.setPrice(getElementBigDecimalContent(medicineElement, PRICE));
    antibiotics.setMedCertificateIssueDate(getElementDateContent(medicineElement, ISSUE_DATE));
    antibiotics.setMedCertificateExpiryDate(
        getElementDateContent(medicineElement, EXPIRY_DATE));
    return antibiotics;
  }

  private static String getElementTextContent(Element element, String elementName) {
    NodeList nList = element.getElementsByTagName(elementName);
    Node node = nList.item(0);
    return node.getTextContent();
  }

  private static Date getElementDateContent(Element element, String elementName) {
    NodeList nList = element.getElementsByTagName(elementName);
    Node node = nList.item(0);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
    Date date = null;
    try {
      date = simpleDateFormat.parse(node.getTextContent());
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }

  private static BigDecimal getElementBigDecimalContent(Element element, String elementName) {
    NodeList nList = element.getElementsByTagName(elementName);
    Node node = nList.item(0);
    return new BigDecimal(node.getTextContent());
  }
}
