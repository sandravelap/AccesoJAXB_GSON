package code;

import com.google.gson.Gson;
import javaBeans.Alumno;
import javaBeans.Insti;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class leerJSON {
    public static void leer() {
        Path p = Path.of("src/main/resources/insti.json");
        //variable para almacenar el contenido del fichero
        Insti instiJson;
        //leemos el contenido del Json, que es un texto
        String txtJson;
        //leermos el contenido del archivo de texto
        try {
            txtJson = Files.readString(p);
            //creo el Gson que transforma de texto a objeto
            Gson gson = new Gson();
            instiJson = gson.fromJson(txtJson, Insti.class);
            //para comprobar
            System.out.println(instiJson.getNombre());
            for (Alumno a : instiJson.getAlumnos()){
                System.out.println(a.getNombre());
            }
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}
