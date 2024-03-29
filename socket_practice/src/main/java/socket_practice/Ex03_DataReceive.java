package socket_practice;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Ex03_DataReceive {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;

        Scanner scanner = new Scanner(System.in);

        try(Socket socket = new Socket(host, port)){
            System.out.println("서버에 연결되었습니다.");
            String line;
        
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while(!(line = input.readLine()).equals("exit")){
                System.out.println(line);
            }

        }
        catch(Exception ignore){
            System.err.println(host + ":" + port + "에 연결할 수 없습니다.");
        }
    }
}
