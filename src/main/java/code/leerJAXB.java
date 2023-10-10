package code;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import javaBeans.Insti;

import java.nio.file.Path;

public class leerJAXB {
    public static void leer(){
        //archivo a leer
        Path p = Path.of("src/main/resources/insti.xml");
        //creo las variables donde almacenar en mi código la información
        if (libs.CheckFiles.ficheroLegible(p)) {
            Insti miInsti = new Insti();
            //un contexto se utiliza cuando en nuestro código hemos cargado algo persistente
            JAXBContext contexto = null;
            try {
                contexto = JAXBContext.newInstance(Insti.class);
                Unmarshaller unmarshaller = contexto.createUnmarshaller();
                miInsti = (Insti) unmarshaller.unmarshal(p.toFile());
                System.out.println(miInsti.getNombre());
                System.out.println(miInsti.getAlumnos());
            } catch (JAXBException e) {
                System.out.println("El javaBean no vale para este XML." + e);
            }
        }else{
            System.out.println("No se encuentra el fichero");
        }
    }
}
