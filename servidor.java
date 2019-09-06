import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.DatagramPacket;
import java.io.IOException;

class Servidor {

    static int porta = 9999;
    private static byte[] mensagem = "Resposta...".getBytes();

    public static void main(String a[]) {
        try (DatagramSocket soquete = new DatagramSocket(porta)) {
            byte buffer[] = new byte[65536];
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            System.out.println("Aguardando solicitacoes...");
            soquete.receive(dp);
            soquete.setSoTimeout(porta);
            System.out.println(new String(dp.getData()).trim());
            soquete.setSoTimeout(1);
            /*System.out.println("OffSet: " + dp.getOffset());
            System.out.println("lgt: " + dp.getLength());
            System.out.println("porta: " + dp.getPort());
            System.out.println("endereco: " + dp.getAddress());
            System.out.println("endereco socket: " + dp.getSocketAddress());*/
            dp = new DatagramPacket(mensagem, mensagem.length, dp.getAddress(), dp.getPort());
            soquete.send(dp);
        } catch (SocketException se) {
        } catch (IOException ioe) {
        }
    }
}
