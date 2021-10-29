package com.google.generarPdf.utils;

import java.io.File;

public class SistemaArchivo {

    public static void crearDirectorio(String dir) {
        File  D = new File(dir);
        boolean D1 = D.mkdir();

        if(D1){
            System.out.println("Directorio: "+ dir +" creado con exito");
        }else{
            System.out.println(Mensajes.ERROR_FILE_SYSTEM);
        }
    }

    public static void validarDirectorioTrabajo(String ruta) {
        File directorioTrabajo = new File(ruta);
        if(directorioTrabajo.isDirectory()){
            System.out.println("Directorio: "+ directorioTrabajo +" encontrado");
        }else{
            System.out.println("Directorio: "+ directorioTrabajo +" no encontrado");
            crearDirectorio(ruta);
        }
    }

    public static void borrarDirectorioDescargas(){
        File directorioSolicitud = new File(PATH.DIRECTORIO_DESCARGAS);
        try {
            final File[] files = directorioSolicitud.listFiles();
            for (File f: files) f.delete();
            //directorioSolicitud.delete();
        }catch (Exception e){
            validarDirectorioTrabajo(PATH.DIRECTORIO_DESCARGAS);
            System.out.println(e);
        }


    }
}
