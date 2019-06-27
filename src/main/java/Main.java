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
            ServerSocket servidorSocket = new ServerSocket(9999);
            Socket socket = servidorSocket.accept();
            DataInputStream input = new DataInputStream(socket.getInputStream());
            computer = input.readUTF();
            socket.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        game.logicGame(computer);
    }
}
