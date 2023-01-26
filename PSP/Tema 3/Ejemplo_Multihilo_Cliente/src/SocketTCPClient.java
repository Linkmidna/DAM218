import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
public class SocketTCPClient {
        private String serverIP;
        private int serverPort;
        private Socket socket;
        private InputStream is;
        public SocketTCPClient(String serverIP, int serverPort){
            this.serverIP = serverIP;
            this.serverPort = serverPort;
        }
        public void start() throws UnknownHostException, IOException {
            System.out.println("(Cliente) Estableciendo conexión...");
            socket = new Socket(serverIP, serverPort);
            is = socket.getInputStream();
            System.out.println("(Cliente) Conexión establecida.");
        }
        public void stop() throws IOException {
            System.out.println("(Cliente) Cerrando conexión...");
            is.close();
            socket.close();
            System.out.println("(Cliente) Conexión cerrada.");
        }
        public static void main(String[] args) {
            SocketTCPClient cliente = new SocketTCPClient("localhost",49171);
            try{
                cliente.start() ;
                System.out.println("Mensaje del servidor: "+ cliente.is.read());
                cliente.stop();
            }catch(UnknownHostException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
    }
}
