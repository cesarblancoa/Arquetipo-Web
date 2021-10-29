package com.google.generarPdf.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Validaciones {

    public static Sheet validarHojaExcel(XSSFWorkbook libroExcel, int hojaExcel) {
        try {
            //Se valida que se pueda instanciar el objeto.
            Sheet hoja = libroExcel.getSheetAt(hojaExcel);
            hoja.getHeader();
            return hoja;
        } catch (Exception e) {
            System.out.println(Mensajes.ERROR_EXCEL_1+" "+hojaExcel);
            System.exit(0);
        }
        return null;

    }
}
