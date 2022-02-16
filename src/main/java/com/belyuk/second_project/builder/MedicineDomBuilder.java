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
    antibiotics.setName(getElementTextContent(antibioticsElement, "name"));
    antibiotics.setManufacturer(getElementTextContent(antibioticsElement, "manufacturer"));
    antibiotics.setDosageForm(getElementTextContent(antibioticsElement, "dosage_form"));
    antibiotics.setAmount(Integer.parseInt(getElementTextContent(antibioticsElement, "amount")));
    antibiotics.setId(antibioticsElement.getAttribute("id"));
    antibiotics.setDosage(getElementTextContent(antibioticsElement, "dosage"));
    antibiotics.setPrice(getElementBigDecimalContent(antibioticsElement, "price"));
    antibiotics.setMedCertificateIssueDate(getElementDateContent(antibioticsElement, "issue_date"));
    antibiotics.setMedCertificateExpiryDate(
        getElementDateContent(antibioticsElement, "expiry_date"));

    return antibiotics;
  }

  private Vitamins buildVitamins(Element vitaminsElement) {
    Vitamins vitamins = new Vitamins();
    vitamins.setName(getElementTextContent(vitaminsElement, "name"));
    vitamins.setManufacturer(getElementTextContent(vitaminsElement, "manufacturer"));
    vitamins.setDosageForm(getElementTextContent(vitaminsElement, "dosage_form"));
    vitamins.setAmount(Integer.parseInt(getElementTextContent(vitaminsElement, "amount")));
    vitamins.setId(vitaminsElement.getAttribute("id"));
    vitamins.setDosage(getElementTextContent(vitaminsElement, "dosage"));
    vitamins.setPrice(getElementBigDecimalContent(vitaminsElement, "price"));
    vitamins.setMedCertificateIssueDate(getElementDateContent(vitaminsElement, "issue_date"));
    vitamins.setMedCertificateExpiryDate(getElementDateContent(vitaminsElement, "expiry_date"));
    vitamins.setSolubility(getElementTextContent(vitaminsElement, "solubility"));
    vitamins.setSerial(vitaminsElement.getAttribute("serial"));
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
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
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
