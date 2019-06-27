import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        String user;
        String computer = null;
        StrategyGame game = new StrategyGame();

        user = game.validateInput();
        try {
            System.out.println("Preparando Conexión. Puerto 9999");
            System.out.println("Esperando respuesta de Maquina Cliente...");
            ServerSocket servidorSocket = new ServerSocket(9999);
            Socket socket = servidorSocket.accept();
            DataInputStream input = new DataInputStream(socket.getInputStream());
            computer = input.readUTF();
            socket.close();
            System.out.println("Respuesta recibida desde Maquina Cliente");
        }catch (IOException e) {
            e.printStackTrace();
        }
        game.logicGame(computer);
    }
}
