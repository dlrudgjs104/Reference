package socket_practice;

import java.net.Socket;
import java.util.Scanner;

public class Ex02_DataSend {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;

        Scanner scanner = new Scanner(System.in);

        try(Socket socket = new Socket(host, port)){
            System.out.println("서버에 연결되었습니다.");
            System.out.print("전송할 내용 입력: ");
            String sendString = scanner.nextLine();

            while(!sendString.equals("exit")){
                socket.getOutputStream().write((sendString + "\n").getBytes());
                System.out.print("전송할 내용 입력: ");
                sendString = scanner.nextLine();
            }
            
            return;
      
        }
        catch(Exception ignore){
            System.err.println(host + ":" + port + "에 연결할 수 없습니다.");
        }
    }
}
