import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.DatagramPacket;
import java.io.IOException;
import java.net.InetAddress;
public class Servidor {
 static int porta = 9999;
 private static byte[] mensagem = "Resposta...".getBytes();
 public static void main(String a[]){
 try{
 DatagramSocket soquete = new DatagramSocket(porta);

 byte buffer[] = new byte[65536];
 DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
 System.out.println("Aguardando solicitacoes...");
 soquete.receive(dp);
 System.out.println(new String(dp.getData()).trim());
 System.out.println("ofst: "+dp.getOffset());
 System.out.println("lgt: "+dp.getLength());
 System.out.println("porta: "+dp.getPort());
 System.out.println("endereco: "+dp.getAddress());
 System.out.println("endereco socket: "+dp.getSocketAddress());
 dp = new DatagramPacket(mensagem, mensagem.length,dp.getAddress(), dp.getPort());
 soquete.send(dp);
 soquete.close();
 }catch(SocketException se){
 se.printStackTrace();
 }catch(IOException ioe){
 ioe.printStackTrace();
 }
 }
}
