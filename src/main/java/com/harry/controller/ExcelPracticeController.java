package com.harry.controller;

import com.harry.domain.ExcelPractice;
import com.harry.service.ExcelPracticeService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelPracticeController {

    @Resource
    private ExcelPracticeService excelPracticeService;

    @PostMapping({"import"})
    public ResponseEntity<List<ExcelPractice>> importFile() throws IOException, InvalidFormatException, SAXException {

        List<ExcelPractice> result = excelPracticeService.importExcel();
        if (result != null) {
            URI uri = URI.create("/excel/import/success");
            return ResponseEntity.created(uri).body(result);
        }
        return ResponseEntity.noContent().build();
    }
}
