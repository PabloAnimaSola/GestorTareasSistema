
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        String sistemaUtilizado = BackEnd.conseguirSistemaOperativo();

        System.out.println("Bienvenido a la herramientas utilitarias del sistema.");
        System.out.println("Detectado sistema operativo: " + sistemaUtilizado);

        System.out.println(System.getenv("SHELL"));

    }
}