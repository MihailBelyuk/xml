package com.belyuk.second_project.entity.impl;

import com.belyuk.second_project.entity.Medicine;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class VitaminsImpl implements Medicine {

  private String name;
  private String serial;
  private String manufacturer;
  private Date medCertificateIssueDate;
  private Date medCertificateExpiryDate;
  private String dosageForm;
  private int amount;
  private BigDecimal price;
  private String dosage;
  private String id;

  public VitaminsImpl() {
  }

  public void setSerial(String serial) {
    this.serial = serial;
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
    VitaminsImpl vitamins = (VitaminsImpl) o;
    return amount == vitamins.amount && Objects.equals(name, vitamins.name)
        && Objects.equals(serial, vitamins.serial) && Objects.equals(manufacturer,
        vitamins.manufacturer) && Objects.equals(medCertificateIssueDate,
        vitamins.medCertificateIssueDate) && Objects.equals(medCertificateExpiryDate,
        vitamins.medCertificateExpiryDate) && Objects.equals(dosageForm,
        vitamins.dosageForm) && Objects.equals(price, vitamins.price)
        && Objects.equals(dosage, vitamins.dosage) && Objects.equals(id,
        vitamins.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, serial, manufacturer, medCertificateIssueDate,
        medCertificateExpiryDate,
        dosageForm, amount, price, dosage, id);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Vitamins:\n");
    sb.append("name=").append(name).append(",\n");
    sb.append("serial=").append(serial).append(",\n");
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
