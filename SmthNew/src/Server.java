import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        final int PORT = 3456;
        ServerSocket ss = new ServerSocket(PORT);
        System.out.println("Starting server");
        Socket s = ss.accept();
        System.out.println("Connected!");

        PrintWriter os = new PrintWriter(
                s.getOutputStream(), true);
        BufferedReader is = new BufferedReader(
                new InputStreamReader(
                        s.getInputStream()
                )
        );
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter something: ");
        String x = scanner.nextLine();
        os.println(x);

        while(true) {
            x = is.readLine();
            System.out.println("CLIENT: " + x);
            boolean b = false;

            while (b == false) {
                System.out.print("Enter something new");
                x = scanner.nextLine();
                b = true;
            }
            os.println(x);
        }
    }
}