package socket_practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex07_EchoServer_Server_Thread {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            while (!Thread.currentThread().isInterrupted()) {
                Socket socket = serverSocket.accept();

                System.out.println("Connected: " + socket.getInetAddress().getHostAddress());

                new Thread(() -> {
                    try {
                        String line;
                        var input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                        while (!(line = input.readLine()).equals("exit")) {
                            System.out.println(line);
                            socket.getOutputStream().write((line + "\n").getBytes());
                        }

                        System.out.println("Disconnected: " + socket.getInetAddress().getHostAddress());
                        socket.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }).start();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
