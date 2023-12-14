import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private BufferedReader reader;
    private PrintWriter writer;
    private String clientName;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            this.reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            this.writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())), true);
            this.clientName = reader.readLine();
            System.out.println("Client " + clientName + " connected.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = reader.readLine();
                if (message == null || "exit".equalsIgnoreCase(message)) {
                    break;
                }
                System.out.println(clientName + ": " + message);
                Server.broadcastMessage(clientName + ": " + message, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void sendMessage(String message) {
        writer.println(message);
    }

    private void closeConnection() {
        try {
            System.out.println("Client " + clientName + " disconnected.");
            clientSocket.close();
            Server.removeClient(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
