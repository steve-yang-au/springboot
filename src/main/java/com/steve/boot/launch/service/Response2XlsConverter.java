package com.steve.boot.launch.service;

import com.steve.boot.launch.AjaxReponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Response2XlsConverter extends AbstractHttpMessageConverter<AjaxReponse> {

    private static final MediaType EXCEL_TYPE = MediaType.valueOf("application/vnd.ms-excel");

    @Override
    protected boolean supports(Class clazz) {
        return false;
        //return AjaxReponse.class == clazz;
    }

    public Response2XlsConverter() {
        super(EXCEL_TYPE);
    }

    @Override
    protected AjaxReponse readInternal(Class<? extends AjaxReponse> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(AjaxReponse ajaxReponse, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        final Workbook workbook = new HSSFWorkbook();
        final  Sheet sheet = workbook.createSheet();

        final Row row = sheet.createRow(0);
        row.createCell(0).setCellValue(ajaxReponse.getMessage());
        row.createCell(1).setCellValue(ajaxReponse.getData().toString());

        workbook.write(outputMessage.getBody());
    }
}
