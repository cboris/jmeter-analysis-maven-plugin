package com.lazerycode.jmeter.analyzer.writer;

import java.io.File;
import java.io.IOException;

import static com.lazerycode.jmeter.analyzer.config.Environment.ENVIRONMENT;
import static com.lazerycode.jmeter.analyzer.util.FileUtil.initializeFile;

/**
 * Abstract implementation of a writer providing convenience methods.
 * Custom {@link Writer} implementations should extend this class.
 */
public abstract class WriterBase implements Writer {

  protected static final String CSV_EXT = ".csv";
  protected static final String TXT_EXT = ".txt";
  protected static final String PNG_EXT = ".png";
  protected static final String JSON_EXT = ".json";
  protected static final String HTML_EXT = ".html";
  protected static final String DURATIONS = "-durations-";
  protected static final String SIZES = "-sizes-";
  protected String fileName = "summary";

  private String resultDataFileRelativePath;

  @Override
  public String getFileName() {
    return fileName;
  }

  @Override
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public String getResultDataFileRelativePath() {
    return resultDataFileRelativePath;
  }

  @Override
  public void setResultDataFileRelativePath(String resultDataFileRelativePath) {
    this.resultDataFileRelativePath = resultDataFileRelativePath;
  }

  //--------------------------------------------------------------------------------------------------------------------
  protected File getFile(String name) throws IOException {
    return initializeFile(ENVIRONMENT.getTargetDirectory(), name, resultDataFileRelativePath);
  }

}
