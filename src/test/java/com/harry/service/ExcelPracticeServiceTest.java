package com.harry.service;

import com.harry.domain.ExcelPractice;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;
import org.xml.sax.SAXException;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class ExcelPracticeServiceTest {

    @Resource
    private ExcelPracticeService service;

    @Test
    public void testImportExcel() throws IOException, InvalidFormatException, SAXException {
        List<ExcelPractice> practices =  service.importExcel();
        Assertions.assertNotNull(practices);
    }


}
