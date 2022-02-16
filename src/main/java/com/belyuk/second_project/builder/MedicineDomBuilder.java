package com.belyuk.second_project.builder;

import com.belyuk.second_project.entity.Antibiotics;
import com.belyuk.second_project.entity.Medicine;
import com.belyuk.second_project.entity.Vitamins;
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
        Element antibioticsElement = (Element) medicineList.item(i);
        Antibiotics antibiotics = buildAntibiotics(antibioticsElement);
        medicineSet.add(antibiotics);
      }
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private Antibiotics buildAntibiotics(Element antibioticsElement) {
    Antibiotics antibiotics = new Antibiotics();
    antibiotics.setName(getElementTextContent(antibioticsElement, NAME));
    antibiotics.setManufacturer(getElementTextContent(antibioticsElement, MANUFACTURER));
    antibiotics.setDosageForm(getElementTextContent(antibioticsElement, DOSAGE_FORM));
    antibiotics.setAmount(Integer.parseInt(getElementTextContent(antibioticsElement, AMOUNT)));
    antibiotics.setId(antibioticsElement.getAttribute(ID));
    antibiotics.setDosage(getElementTextContent(antibioticsElement, DOSAGE));
    antibiotics.setPrice(getElementBigDecimalContent(antibioticsElement, PRICE));
    antibiotics.setMedCertificateIssueDate(getElementDateContent(antibioticsElement, ISSUE_DATE));
    antibiotics.setMedCertificateExpiryDate(
        getElementDateContent(antibioticsElement, EXPIRY_DATE));

    return antibiotics;
  }

  private Vitamins buildVitamins(Element vitaminsElement) {
    Vitamins vitamins = new Vitamins();
    vitamins.setName(getElementTextContent(vitaminsElement, NAME));
    vitamins.setManufacturer(getElementTextContent(vitaminsElement, MANUFACTURER));
    vitamins.setDosageForm(getElementTextContent(vitaminsElement, DOSAGE_FORM));
    vitamins.setAmount(Integer.parseInt(getElementTextContent(vitaminsElement, AMOUNT)));
    vitamins.setId(vitaminsElement.getAttribute(ID));
    vitamins.setDosage(getElementTextContent(vitaminsElement, DOSAGE));
    vitamins.setPrice(getElementBigDecimalContent(vitaminsElement, PRICE));
    vitamins.setMedCertificateIssueDate(getElementDateContent(vitaminsElement, ISSUE_DATE);
    vitamins.setMedCertificateExpiryDate(getElementDateContent(vitaminsElement, EXPIRY_DATE));
    vitamins.setSolubility(getElementTextContent(vitaminsElement, SOLUBILITY));
    vitamins.setSerial(vitaminsElement.getAttribute(SERIAL));
    return vitamins;
  }

  private static String getElementTextContent(Element element, String elementName) {
    NodeList nList = element.getElementsByTagName(elementName);
    Node node = nList.item(0);
    String text = node.getTextContent();
    return text;
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
    BigDecimal bigDecimal = new BigDecimal(node.getTextContent());
    return bigDecimal;
  }
}
