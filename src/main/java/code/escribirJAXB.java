package code;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import javaBeans.Alumno;
import javaBeans.Insti;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class escribirJAXB {
    public static void escribir() {
        //creamos los objetos a escribiren el XML
        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
        Insti miInsti = new Insti();
        Alumno a1 = new Alumno("Lola", 16, "SMR1");
        listaAlumnos.add(a1);
        Alumno a2 = new Alumno("Juan", 20, "DAM1");
        listaAlumnos.add(a2);
        Alumno a3 = new Alumno("Sofía", 21, "DAM2");
        listaAlumnos.add(a3);
        miInsti.setNombre("IES San Alberto Magno");
        miInsti.setAlumnos(listaAlumnos);
        //Archivo donde queremos guardar la info
        Path p = Path.of("target/instiCreado.xml");
        Path pJ = Path.of("target/insti.json");
        //creamos el contexto de JAXBinding
        try {
            JAXBContext contexto = JAXBContext.newInstance(Insti.class, Alumno.class);
            //para pasar de código a XML -- marshall
            Marshaller marshaller  = contexto.createMarshaller();
            //configuramos el formato de salida
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
            //escribimos el archivo:
            if (libs.CheckFiles.ficheroEscribible(p)) {
                marshaller.marshal(miInsti, p.toFile());
            }
            //con la API Gson creo mi json:
            GsonBuilder gsonBuilder = new GsonBuilder();
            //creamos el parseador con formato bonito
            Gson gson = gsonBuilder.setPrettyPrinting().create();
            //creo el texto del json
            String jsonInsti = gson.toJson(miInsti);
            //System.out.println(jsonInsti);
            try {
                Files.writeString(pJ,jsonInsti);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
