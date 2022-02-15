package com.belyuk.second_project.entity;

public class Vitamins extends Medicine {

  private String solubility;
  private String serial;

  public Vitamins() {
  }

  public String getSolubility() {
    return solubility;
  }

  public void setSolubility(String solubility) {
    this.solubility = solubility;
  }

  public String getSerial() {
    return serial;
  }

  public void setSerial(String serial) {
    this.serial = serial;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Vitamins{");
    sb.append("solubility='").append(solubility).append('\'');
    sb.append(", serial='").append(serial).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
