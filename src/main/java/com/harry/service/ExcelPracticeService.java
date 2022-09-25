package com.harry.service;

import com.harry.domain.ExcelPractice;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

public interface ExcelPracticeService {


    List<ExcelPractice> importExcel() throws IOException, SAXException, InvalidFormatException;
}
