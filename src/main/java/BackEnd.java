public class BackEnd {
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

    public static String almacenamientoEnSistema(String sistemaUtilizado){return "hola";};
}