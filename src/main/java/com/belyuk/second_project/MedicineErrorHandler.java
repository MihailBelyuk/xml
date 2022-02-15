package com.belyuk.second_project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.ErrorHandler;
import org.apache.logging.log4j.core.LogEvent;
import org.xml.sax.SAXParseException;

public class MedicineErrorHandler implements ErrorHandler, org.xml.sax.ErrorHandler {

  private static final Logger logger = LogManager.getLogger();
  public void warning(SAXParseException e) {
    logger.warn(getLineColumnNumber(e) + "-" + e.getMessage());
  }

  public void error(SAXParseException e) {
    logger.error(getLineColumnNumber(e) + " - " + e.getMessage());
  }
  public void fatalError(SAXParseException e) {
    logger.fatal(getLineColumnNumber(e) + " - " + e.getMessage());
  }
  private String getLineColumnNumber(SAXParseException e) {
      return e.getLineNumber() + " : " + e.getColumnNumber();
  }

  public void error(String s) {

  }

  public void error(String s, Throwable throwable) {

  }

  public void error(String s, LogEvent logEvent, Throwable throwable) {

  }
}