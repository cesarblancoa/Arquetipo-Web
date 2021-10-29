package com.google.generarPdf.test;

import com.google.generarPdf.bc.GestionarImagenBC;
import com.google.generarPdf.dal.ObtenerDatosDAL;
import com.google.generarPdf.dal.dto.DatosDTO;
import com.google.generarPdf.utils.Configuracion;
import org.junit.Test;

import java.util.ArrayList;

public class ConstruirPdf {

    ArrayList<DatosDTO> dataPool = new ArrayList<DatosDTO>();

    @Test
    public void before() throws Exception {
        Configuracion.iniciarConfiguracion();
        try {

            this.dataPool = ObtenerDatosDAL.obtenerItems();
            System.out.println(dataPool.size());
            for (int fila = 0; fila < dataPool.size(); fila++) {
                //System.out.println(dataPool.get(fila).getItem());
//
                System.out.println(dataPool.get(fila).getItem());
                GestionarImagenBC.buscarDocumento(dataPool.get(fila));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
