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
        switch (sistemaUtilizado) {
            case "Windows":
                comando = "Get-PSDrive";
                argumentosComando = "-PSProvider FileSystem";
                System.out.println(ejecutarComandoYDevolverResultado());
                break;
            case "MacOS", "Linux":
                comando = "df";
                argumentosComando = "-h";
                System.out.println(ejecutarComandoYDevolverResultado());
                break;
        }
    }

// TODO: REFORMATEAR ESTO DE NUEVO PARA VER SI POWERSHELL PUEDE IR SIN ESPECIFICAR TANTO
    public static String ejecutarComandoYDevolverResultado() throws IOException {
        String resultado = "";
        if (sistemaUtilizado.equals("MacOS") || sistemaUtilizado.equals("Linux")) {
            ProcessBuilder processBuilder = new ProcessBuilder(comando, argumentosComando);
            Process process = processBuilder.start();
            resultado = new String(process.getInputStream().readAllBytes());
        } else if (sistemaUtilizado.equals("Windows")) {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "powershell.exe",
                    "-NoProfile",
                    "-NonInteractive",
                    "-Command", comando + " " + argumentosComando
            );
            Process process = processBuilder.start();
            resultado = new String(process.getInputStream().readAllBytes());
        }
        return resultado;
    }

    public static void limpiarPantalla() throws IOException {
        switch (sistemaUtilizado) {
            case "Windows":
                comando = "cls";
                argumentosComando = "";
                System.out.println(ejecutarComandoYDevolverResultado());
                break;
            case "MacOS", "Linux":
                comando = "clear";
                argumentosComando = "";
                System.out.println(ejecutarComandoYDevolverResultado());
                break;
        }
    }
}