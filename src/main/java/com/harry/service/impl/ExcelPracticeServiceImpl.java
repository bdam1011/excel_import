package com.harry.service.impl;

import com.harry.bean.ExcelBean;
import com.harry.domain.ExcelPractice;
import com.harry.repository.ExcelPracticeRepository;
import com.harry.service.ExcelPracticeService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.ReaderConfig;
import org.jxls.reader.XLSReader;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ExcelPracticeServiceImpl implements ExcelPracticeService {


    @Resource
    private ExcelPracticeRepository repository;

    @Override
    public List<ExcelPractice> importExcel() throws IOException, SAXException, InvalidFormatException {
        InputStream configInput = getClass()
                .getResourceAsStream("/jxls/excel_import.xml");

        InputStream xlsInput = getClass().getResourceAsStream("/jxls/hospitalExample.xlsx");
        XLSReader mainReader = ReaderBuilder.buildFromXML(configInput);
        Map<String, Object> beans = new HashMap<>();
        List<ExcelBean> excelBeans = new ArrayList<>();
        beans.put("excelBeans",excelBeans);
        ReaderConfig.getInstance().setSkipErrors(true);
        mainReader.read(xlsInput, beans);
        List<ExcelPractice> practices = new ArrayList<>();
        excelBeans.forEach(excelBean -> {
            ExcelPractice excelPractice = new ExcelPractice();
            excelPractice.setHospitalId(excelBean.getHospitalId());
            excelPractice.setHospitalName(excelBean.getHospitalName());
            practices.add(excelPractice);
        });
        return repository.saveAll(practices);
    }

}
