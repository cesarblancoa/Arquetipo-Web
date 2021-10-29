package com.google.generarPdf.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

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

    public static void moverArchivosDescargados( String destino ) throws IOException, IOException {
        String[] pathnames;

        File directorioSolicitud = new File(PATH.DIRECTORIO_DESCARGAS);

        pathnames = directorioSolicitud.list();
        for (int i = 0; i < pathnames.length; i++) {
            System.out.println(pathnames[i]);
            try {
                Path source = Paths.get(PATH.DIRECTORIO_DESCARGAS+"\\"+ pathnames[i]);
                Path target = Paths.get(PATH.DIRECTORIO_TRABAJO+"\\"+destino+"\\"+ pathnames[i]);
                Files.move(source, target);
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

}
