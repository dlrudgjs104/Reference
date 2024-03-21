package socket_practice;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ex01 {
    public static void main(String[] args) {
        int startPort = Integer.parseInt(args[0]);
        int endPort = Integer.parseInt(args[1]);

        for (int i = startPort; i < endPort; i++) {
            try {
                Socket socket = new Socket("localhost", i);
                System.out.println("Port " + i + " 열려 있습니다.");
                System.out.println(socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + " - "
                        + socket.getLocalAddress().getHostAddress() + ":" + socket.getLocalPort());

                socket.close();
            } catch (UnknownHostException e) {
                // System.err.println("Host를 찾을 수 없습니다. : " + e.getMessage());
            } catch (IOException e) {
                // System.err.println("Socket 생성에 오류가 발생하였습니다. : " + e.getMessage());
            }
        }

    }
}
