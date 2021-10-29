package com.google.generarPdf.dal;

import com.google.generarPdf.dal.dto.DatosDTO;
import com.google.generarPdf.utils.Excel;
import com.google.generarPdf.utils.PATH;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;

/**
 *
 * Obtener información de cada item
 *
 * @version 1.0
 * @category DAL
 * **/

public class ObtenerDatosDAL {
    /**
     * @return Lista de Items
     *
     * **/

    public static  ArrayList<DatosDTO> obtenerItems(){
        ArrayList<DatosDTO> listDatosDTO = new ArrayList<DatosDTO>();
        try {
            Sheet hojaExcel = Excel.obtenerHojaExcel();

            for (int fila = 1; fila <= hojaExcel.getLastRowNum(); fila++) {
                DatosDTO  item = new DatosDTO();
                item.setItem(validarDato(hojaExcel	,"Items" ,fila));
                if (!"".equals(item)){
                    System.out.println("Item a buscar: " + item.getItem());
                    listDatosDTO.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDatosDTO;
    }

    /**
     * Valida que si hay un elemento en la celda, sino retorna vacio.
     *
     * @return Elemento encontrado en la celda
     *
     * **/

    public static String validarDato(Sheet hojaExcelDataPool,String campo,int fila){
        try {
            String valor = hojaExcelDataPool.
                    getRow(fila).
                    getCell(Excel.
                            getNumeroColumnaPorNombre(hojaExcelDataPool, campo)
                    ).
                    getStringCellValue();
            return valor;
        } catch (Exception e) {
            return "";
        }
    }

}
