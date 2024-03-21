package socket_practice;

import java.net.ServerSocket;
import java.net.Socket;

public class Ex05_ServerSocket {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            while (!Thread.currentThread().isInterrupted()) {
                Socket socket = serverSocket.accept();

                System.out.println("Connected: " + socket.getInetAddress().getHostAddress());

                socket.getOutputStream().write("Hello!".getBytes());
                socket.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
