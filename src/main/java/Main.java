import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        String serverResp;
        String clientResp = null;
        boolean i;
        StrategyGame game = new StrategyGame();
        do {
            serverResp = game.readData();
            i = game.validateInput();
        } while (i == false);

        try {
            System.out.println("Preparando Conexión. Puerto 9999");
            System.out.println("Esperando respuesta de Maquina Cliente...");
            /**Establishing connection..**/
            ServerSocket servSocket = new ServerSocket(9999); //Creamos socket servidor y abrimos puerta enlace 9999
            Socket socket = servSocket.accept();                    //escucha una conexión al socket y la acepta
            /**Receive package information..**/
            DataInputStream input = new DataInputStream(socket.getInputStream()); //Devuelve un flujo de entrara al socket
            clientResp = input.readUTF();             //lee caracteres y los almacena en String ClientResponse.
            /**Send package information..**/
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF(serverResp);
            socket.close();                                 //Cierra la conexión del socket
            /**finished connection **/
            System.out.println("Respuesta recibida desde Maquina Cliente");
        } catch (IOException e) {
            e.printStackTrace();
        }
        game.logicGame(clientResp);
    }
}
