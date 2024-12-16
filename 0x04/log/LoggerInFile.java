import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerInFile {

    public static void main(String[] args) {
        try {
            Logger logger = Logger.getLogger("MyLog");

            // Cria o FileHandler para gravar no arquivo logs.txt
            FileHandler fileHandler = new FileHandler("logs.txt", true);

            // Adiciona o FileHandler ao logger
            logger.addHandler(fileHandler);

            // Configura o formato simples para o log
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);

            // Registra mensagens de log
            logger.info("Log test");
            logger.info("Hi In the main class test");

        } catch (IOException e) {
            System.err.println("Erro ao configurar o logger: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
