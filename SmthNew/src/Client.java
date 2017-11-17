import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        int PORT = 3456;
        String HOST = "localhost";
        Socket s = new Socket(HOST, PORT);

        PrintWriter os = new PrintWriter(
                s.getOutputStream(), true);
        BufferedReader is = new BufferedReader(
                new InputStreamReader(
                        s.getInputStream()
                )
        );
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String x = is.readLine();
            System.out.println("SERVER: " + x);
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