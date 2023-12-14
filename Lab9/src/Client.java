import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to the server. Enter your name:");
            String name = scanner.nextLine();
            writer.println(name);

            Thread receivingThread = new Thread(() -> {
                try {
                    while (true) {
                        String message = reader.readLine();
                        if (message != null) {
                            System.out.println(message);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receivingThread.start();

            System.out.println("You can start typing messages. Type 'exit' to leave.");

            while (true) {
                String message = scanner.nextLine();
                if ("exit".equalsIgnoreCase(message)) {
                    break;
                }
                writer.println(message);
            }

            receivingThread.interrupt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
