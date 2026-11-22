
import java.util.Scanner;


public class FrontEnd {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        String sistemaUtilizado = BackEnd.conseguirSistemaOperativo();
        System.out.println("Bienvenido a la herramientas utilitarias del sistema.");
        System.out.println(sistemaUtilizado);
        System.out.println(System.getProperty("os.name"));
    }
}