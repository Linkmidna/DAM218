import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Main {
    public static void main(String[] args) {

        try{
            int puerto;
            InetAddress direccion;
            int numero;
            // Crea el socket
            DatagramSocket sSocket = new DatagramSocket(1234);
            // Crea el espacio para los mensajes
            byte [] cadena = new byte[1000] ;
            DatagramPacket mensaje = new DatagramPacket(cadena, cadena.length);
            System.out.println("Esperando mensajes..");

            // Recibe y muestra el mensaje
            sSocket.receive(mensaje);
            puerto=mensaje.getPort();
            direccion=mensaje.getAddress();
            String datos=new String(mensaje.getData(),0,mensaje.getLength());

            while(!datos.equalsIgnoreCase("fin")){
                System.out.println("\tMensaje Recibido: " +datos);

                datos="Recibido";
                cadena=datos.getBytes();
                mensaje=new DatagramPacket(cadena,cadena.length,direccion,puerto);
                sSocket.send(mensaje);
                cadena = new byte[1000] ;
                mensaje = new DatagramPacket(cadena, cadena.length);
                System.out.println("Esperando mensajes..");

                // Recibe y muestra el mensaje
                sSocket.receive(mensaje);
                datos=new String(mensaje.getData(),0,mensaje.getLength());
            }
            sSocket.close();

        } catch(SocketException e) {
            System.err.println("Socket: " + e.getMessage());
        } catch(IOException e) {
            System.err.println("E/S: " + e.getMessage()); }
    }


}


