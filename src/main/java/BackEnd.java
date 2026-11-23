import java.io.IOException;

public class BackEnd {
    private static String comando;
    private static String argumentosComando;
    public static String conseguirSistemaOperativo() {
        String OSDetectado = System.getProperty("os.name").toLowerCase();
        if (OSDetectado.strip().contains("windows")) {
            OSDetectado = "Windows";
        } else if (OSDetectado.strip().contains("mac")) {
            OSDetectado = "MacOS";
        } else if (OSDetectado.strip().contains("linux")) {
            OSDetectado = "Linux";
        } else {
            System.out.println("ERROR INTENTANDO CONSEGUIR EL SISTEMA OPERATIVO, SE DETENDRÁ EL PROGRAMA.");
            System.exit(1);
        }

        return OSDetectado;
    }

    public static void almacenamientoEnSistema(String sistemaUtilizado) throws IOException {
        String comandoParaEjecutar = "";
        switch (sistemaUtilizado.toLowerCase()) {
            case "windows":
                comandoParaEjecutar = "comando en windows";
                break;
            case "macos":
                comandoParaEjecutar = "comando en macos";
                break;
            case "linux":
                comando = "df";
                argumentosComando = "-h";
                System.out.println(ejecutarComandoYDevolverResultado());
                break;
        }
    }


    public static String ejecutarComandoYDevolverResultado() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(comando, argumentosComando);
        Process process = processBuilder.start();
        return new String(process.getInputStream().readAllBytes());
    }
}