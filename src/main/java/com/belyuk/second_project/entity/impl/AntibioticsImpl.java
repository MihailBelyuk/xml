package com.belyuk.second_project.entity.impl;

import com.belyuk.second_project.entity.Medicine;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class AntibioticsImpl implements Medicine {

  private String name;
  private String manufacturer;
  private Date medCertificateIssueDate;
  private Date medCertificateExpiryDate;
  private String dosageForm;
  private int amount;
  private BigDecimal price;
  private String dosage;
  private String id;

  public AntibioticsImpl() {
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void setId(String id) {
    this.id = id;
  }

  @Override
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  @Override
  public void setMedCertificateIssueDate(Date medCertificateIssueDate) {
    this.medCertificateIssueDate = medCertificateIssueDate;
  }

  @Override
  public void setMedCertificateExpiryDate(Date medCertificateExpiryDate) {
    this.medCertificateExpiryDate = medCertificateExpiryDate;
  }

  @Override
  public void setDosageForm(String dosageForm) {
    this.dosageForm = dosageForm;
  }

  @Override
  public void setAmount(int amount) {
    this.amount = amount;
  }

  @Override
  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override
  public void setDosage(String dosage) {
    this.dosage = dosage;

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AntibioticsImpl that = (AntibioticsImpl) o;
    return amount == that.amount && Objects.equals(name, that.name)
        && Objects.equals(manufacturer, that.manufacturer) && Objects.equals(
        medCertificateIssueDate, that.medCertificateIssueDate) && Objects.equals(
        medCertificateExpiryDate, that.medCertificateExpiryDate) && Objects.equals(
        dosageForm, that.dosageForm) && Objects.equals(price, that.price)
        && Objects.equals(dosage, that.dosage) && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, manufacturer, medCertificateIssueDate, medCertificateExpiryDate,
        dosageForm, amount, price, dosage, id);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Antibiotics:\n");
    sb.append("name=").append(name).append(",\n");
    sb.append("manufacturer=").append(manufacturer).append(",\n");
    sb.append("medCertificateIssueDate=").append(medCertificateIssueDate).append(",\n");
    sb.append("medCertificateExpiryDate=").append(medCertificateExpiryDate).append(",\n");
    sb.append("dosageForm=").append(dosageForm).append(",\n");
    sb.append("amount=").append(amount).append(",\n");
    sb.append("price=").append(price).append(",\n");
    sb.append("dosage=").append(dosage).append(",\n");
    sb.append("id=").append(id).append(".\n");
    return sb.toString();
  }
}

