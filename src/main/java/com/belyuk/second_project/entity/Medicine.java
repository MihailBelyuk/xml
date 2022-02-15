package com.belyuk.second_project.entity;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public abstract class Medicine {

  private String name;
  private String manufacturer;
  private Date medCertificateIssueDate;
  private Date medCertificateExpiryDate;
  private String dosageForm;
  private int amount;
  private BigDecimal price;
  private String dosage;
  private String id;

  public String getName() {
    return name;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public Date getMedCertificateIssueDate() {
    return medCertificateIssueDate;
  }

  public Date getMedCertificateExpiryDate() {
    return medCertificateExpiryDate;
  }

  public String getDosageForm() {
    return dosageForm;
  }

  public int getAmount() {
    return amount;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public String getDosage() {
    return dosage;
  }

  public String getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public void setMedCertificateIssueDate(Date medCertificateIssueDate) {
    this.medCertificateIssueDate = medCertificateIssueDate;
  }

  public void setMedCertificateExpiryDate(Date medCertificateExpiryDate) {
    this.medCertificateExpiryDate = medCertificateExpiryDate;
  }

  public void setDosageForm(String dosageForm) {
    this.dosageForm = dosageForm;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setDosage(String dosage) {
    this.dosage = dosage;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Medicine medicine = (Medicine) o;
    return amount == medicine.amount && Objects.equals(name, medicine.name)
        && Objects.equals(manufacturer, medicine.manufacturer) && Objects.equals(
        medCertificateIssueDate, medicine.medCertificateIssueDate) && Objects.equals(
        medCertificateExpiryDate, medicine.medCertificateExpiryDate) && Objects.equals(
        dosageForm, medicine.dosageForm) && Objects.equals(price, medicine.price)
        && Objects.equals(dosage, medicine.dosage) && Objects.equals(id,
        medicine.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, manufacturer, medCertificateIssueDate, medCertificateExpiryDate,
        dosageForm, amount, price, dosage, id);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Medicine{");
    sb.append("name='").append(name).append('\'');
    sb.append(", manufacturer='").append(manufacturer).append('\'');
    sb.append(", medCertificateIssueDate=").append(medCertificateIssueDate);
    sb.append(", medCertificateExpiryDate=").append(medCertificateExpiryDate);
    sb.append(", dosageForm='").append(dosageForm).append('\'');
    sb.append(", amount=").append(amount);
    sb.append(", price=").append(price);
    sb.append(", dosage='").append(dosage).append('\'');
    sb.append(", id='").append(id).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
