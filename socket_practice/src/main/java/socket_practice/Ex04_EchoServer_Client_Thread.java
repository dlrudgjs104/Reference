package socket_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Ex04_EchoServer_Client_Thread {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;

        Scanner scanner = new Scanner(System.in);

        try (Socket socket = new Socket(host, port)) {
            System.out.println("서버에 연결되었습니다.");
            
            Thread thread = new Thread(() -> {
                BufferedReader input;
                try {
                    String line;
                    input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    while (!(line = input.readLine()).equals("exit")) {
                        System.out.println(line);
    
                        socket.getOutputStream().write((line + "\n").getBytes());
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                
            });
            thread.start();

            while(!Thread.currentThread().isInterrupted()){
            }

        } catch (Exception ignore) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다.");
        }
    }
}
