import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class FrontEnd {
    public static void main(String[] args) throws IOException {
        Scanner escaner = new Scanner(System.in);
        int accion = 0;
        boolean continuar = true;

        System.out.printf("""
                Bienvenido a las herramientas utilitarias del sistema.\s
                Detectado sistema operativo: %s\s
                
                """, BackEnd.sistemaUtilizado);

        while (continuar) {
            System.out.print("""
                    ================================================================\s
                       Seleccione la operación que quiere realizar en su sistema:\s
                    ================================================================\s
                    1. Verificar espacio de archivos en el sistema\s
                    2. placeholder\s
                    3. placeholder\s
                    4. placeholder\s
                    5. placeholder\s
                    0. Salir del programa\s
                    
                    """);
            try {
                accion = escaner.nextInt();
                if (accion < 0 || accion > 5) {

                    /* No estoy seguro de que correcto es reusar esta excepción, ya que le pertenece a Scanner y no a
                       esto.*/
                    throw new InputMismatchException("Valor especificado fuera de valores permitidos.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Se ha especificado un valor no válido, por favor utilice únicamente números y " +
                        "sólo números dentro de los valores especificados.\n");

                /*Purgamos (flush) la entrada en caso de que se ponga un String para evitar la repetición en bucle del
                  while por el Scanner*/
                escaner.nextLine();
            }
            switch (accion) {
                case 1:
                    BackEnd.almacenamientoEnSistema();
                    break;
                case 2:
                    //placeholder;
                case 0:
                    System.out.println("¡Gracias por utilizar el programa en " + BackEnd.sistemaUtilizado + "!");
                    continuar = false;
                    break;
            }
        }
    }
}