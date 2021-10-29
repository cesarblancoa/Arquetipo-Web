package com.google.generarPdf.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;

public class Excel {

    public static Sheet obtenerHojaExcel(String logPath) {
        try {
            File archivo = new File(PATH.ARCHIVO_ENTRADA);
            // FileInputStream inputStream= (InputStream) ValidacionesUtils.validarArchivo(rutaExcel, "InputStream");
            FileInputStream contenidoArchivo = new FileInputStream(archivo);

            XSSFWorkbook libroExcel = new XSSFWorkbook(contenidoArchivo);

            Sheet sheet = Validaciones.validarHojaExcel(libroExcel, 0);
            return sheet;
        } catch (IOException e) {
            //log.fatal(e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public static int getNumeroColumnaPorNombre(Sheet hojaExcel, String colName) throws IOException, ParseException {
        //Sheet hoja = obtenerHojaExcel(hojaExcel);
        Row row = hojaExcel.getRow(0);
        int col_Num = 0;
        for (int i = 0; i < row.getLastCellNum(); i++) {
            if (row.getCell(i).getStringCellValue().trim().equals(colName))
            {
                col_Num = i;
            }
        }
        return col_Num;
    }
}
