import static libs.Leer.pedirCadena;

public class Menu {
    public static void main(String[] args) {
        boolean salir = false;
        String opcion = "";
        do {
            System.out.println("0. Salir");
            System.out.println("1. Leer fichero XML con JAXBinding");
            System.out.println("2. Escribir fichero con JAXB y JSON");
            System.out.println("3. Leer fichero JSON con GSON");
            opcion = pedirCadena("Introduce una opción");
            switch (opcion) {
                case "0" -> {salir = true;}
                case "1" -> code.leerJAXB.leer();
                case "2" -> code.escribirJAXB.escribir();
                case "3" -> code.leerJSON.leer();
                default -> {System.out.println("Opción incorrecta");}
            }
        }while (!salir);
    }
}
