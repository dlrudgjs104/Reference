package socket_practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex06_EchoServer_Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            while (!Thread.currentThread().isInterrupted()) {
                Socket socket = serverSocket.accept();

                System.out.println("Connected: " + socket.getInetAddress().getHostAddress());

                String line;
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                while (true) {
                    if (!(line = input.readLine()).equals("exit")) {
                        System.out.println(line);

                        socket.getOutputStream().write((line + "\n").getBytes());

                    } else {
                        System.out.println("Disconnected: " + socket.getInetAddress().getHostAddress());
                        break;
                    }

                }

                socket.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
