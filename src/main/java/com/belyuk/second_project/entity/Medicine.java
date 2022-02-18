package com.belyuk.second_project.entity;

import java.math.BigDecimal;
import java.util.Date;

public interface Medicine {

  void setName(String name);

  void setId(String id);

  void setManufacturer(String manufacturer);

  void setMedCertificateIssueDate(Date medCertificateIssueDate);

  void setMedCertificateExpiryDate(Date medCertificateExpiryDate);

  void setDosageForm(String dosageForm);

  void setAmount(int amount);

  void setPrice(BigDecimal price);

  void setDosage(String dosage);


}
