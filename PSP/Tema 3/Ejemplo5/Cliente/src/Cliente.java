import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    public static void main(String[] args) {

        DatagramSocket clientSocket;
        Scanner sc =new Scanner(System.in);
        try {
            clientSocket = new DatagramSocket(); // socket cliente
            // DATOS DEL SERVIDOR al que enviar mensaje
            InetAddress IPServidor = InetAddress.getLocalHost();// localhost
            int puerto = 12345; // puerto por el que escucha

            // INTRODUCIR DATOS POR TECLADO
            System.out.print("Introduce mensaje: ");
            String cadena = sc.nextLine();

            byte[] enviados = new byte[1024];
            enviados = cadena.getBytes();

            // ENVIANDO DATAGRAMA AL SERVIDOR
            DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
            clientSocket.send(envio);

            // RECIBIENDO DATAGRAMA DEL SERVIDOR
            byte[] recibidos = new byte[10];
            DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
            System.out.println("Esperando datagrama....");
            clientSocket.receive(recibo);

            // Obtener el número e caracteres
            byte[] hh = recibo.getData();
            int numero = hh[0];

            System.out.println("Recibo Nº de caracteres que son a=> " + numero);

            clientSocket.close();// cerrar socket
        } catch (SocketException ex) {
            System.out.println("Error al crear el socket");
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

}
