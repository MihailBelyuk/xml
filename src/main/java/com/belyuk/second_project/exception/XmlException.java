package com.belyuk.second_project.exception;

public class XmlException extends Exception{

  public XmlException() {
    super();
  }

  public XmlException(String message) {
    super(message);
  }

  public XmlException(String message, Throwable cause) {
    super(message, cause);
  }

  public XmlException(Throwable cause) {
    super(cause);
  }
}
