package com.google.generarPdf.bc;

import com.google.generarPdf.dal.dto.DatosDTO;
import com.google.generarPdf.dal.dto.RespuestaDTO;
import com.google.generarPdf.po.InicioPO;
import com.google.generarPdf.utils.CrearPdf;
import com.google.generarPdf.utils.PATH;
import com.google.generarPdf.utils.SistemaArchivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.google.generarPdf.utils.SistemaArchivo.listarContenidoDir;

public class GestionarImagenBC {

    public static RespuestaDTO buscarDocumento(DatosDTO item) throws InterruptedException {
        try {

            InicioPO home = new InicioPO();
            boolean descargado = true;

            List<String> tipoDocumento = new ArrayList<>();
            tipoDocumento.add("1");
            //tipoDocumento.add("2");
            //tipoDocumento.add("3");

            // Leer listado de tipo documentos for
//            for (int tipoDoc = 0; tipoDoc < tipoDocumento.size(); tipoDoc++) {
//                descargado = home.buscarImagen(item).descargarImagen();
//
//                // actualizar log (nombre columna, fila, valor) si no exite agregar a la derecha
//                if (descargado != true) {
//                    break;
//                }
//            }
            if (descargado == true) {
                // mover las descargas a la carpeta de la solicitud
                //SistemaArchivo.crearDirectorio(PATH.DIRECTORIO_TRABAJO+"\\"+item.getItem());
               //SistemaArchivo.moverArchivosDescargados(item.getItem());
                CrearPdf.combineImagesIntoPDF(PATH.DIRECTORIO_TRABAJO+"\\"+item.getItem()+"\\"+item.getItem()+".pdf",
                                "C:\\Demo\\Robot1\\sonia.tiff",
                                "C:\\Demo\\Robot1\\Cat03.jpg"
                               );

            }else{
                //SistemaArchivo.borrarDirectorioDescargas();
            }

            return new RespuestaDTO(true, "OK");
        } catch (Exception e) {
            return new RespuestaDTO(false,e.getMessage());

        }
    }
}
