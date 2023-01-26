import java.io.IOException;
import java.net.*;

public class Main {
    public static void main(String[] args) {

        InetAddress destino;
        try {
            destino = InetAddress.getLocalHost();
            int port = 12345; //puerto al que envio el datagrama
            byte[] mensaje = new byte[1024];
            DatagramSocket socket;

            socket = new DatagramSocket(34567); //Puerto local
            String Saludo = "Enviando Saludos !!";
            mensaje = Saludo.getBytes();  //codifico String a bytes

            //CONSTRUYO EL DATAGRAMA A ENVIAR
            DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);


            System.out.println("Enviando Datagrama de longitud: "
                    + mensaje.length);
            System.out.println("Host destino : " + destino.getHostName());
            System.out.println("IP Destino   : " + destino.getHostAddress());
            System.out.println("Puerto local del socket: "
                    + socket.getLocalPort());
            System.out.println("Puerto al que envio: " + envio.getPort());

            //ENVIO DATAGRAMA
            socket.send(envio);

            socket.close(); //cierro el socket

        } catch (UnknownHostException ex) {
            System.out.println("No es conocido el destino");
        } catch (SocketException ex) {
            System.out.println("Error al crear el socket");
        } catch (IOException ex) {
            System.out.println("Error al enviar el socket");
        }

    }

}
