import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class FrontEnd {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        Map<Integer, String> sistemaOperativo = new HashMap<>(Map.of(
                1, "Windows",
                2, "MacOS",
                3, "Linux"
        ));
        String sistemaUtilizado = BackEnd.conseguirSistemaOperativo(sistemaOperativo);
        System.out.println("Bienvenido a la herramientas utilitarias del sistema.");
    }
}