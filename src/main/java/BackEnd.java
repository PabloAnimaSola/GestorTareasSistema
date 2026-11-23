import java.io.IOException;

public class BackEnd {
    private static String comando, argumentosComando;

    public static final String sistemaUtilizado = conseguirSistemaOperativo();

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

    public static void almacenamientoEnSistema() throws IOException {
        switch (sistemaUtilizado.toLowerCase()) {
            case "windows":
                comando = "Get-PSDrive";
                argumentosComando = "-PSProvider FileSystem";
                System.out.println(ejecutarComandoYDevolverResultado());
                break;
            case "macos", "linux":
                comando = "df";
                argumentosComando = "-h";
                System.out.println(ejecutarComandoYDevolverResultado());
                break;
        }
    }


    public static String ejecutarComandoYDevolverResultado() throws IOException {
        String resultado = "";
        if (sistemaUtilizado.equals("macos") || sistemaUtilizado.equals("linux")) {
            ProcessBuilder processBuilder = new ProcessBuilder(comando, argumentosComando);
            Process process = processBuilder.start();
            resultado = new String(process.getInputStream().readAllBytes());
        } /*else if (sistemaUtilizado.equals("windows")) {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "powershell.exe",
                    "-NoProfile",
                    "-NonInteractive",
                    "-Command", comando + " " + argumentosComando
            );
            Process process = processBuilder.start();
            resultado = new String(process.getInputStream().readAllBytes());
        }*/
        return resultado;
    }
}