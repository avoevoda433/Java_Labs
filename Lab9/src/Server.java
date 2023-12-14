import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static final int PORT = 8080;
    private static List<ClientHandler> clients = new ArrayList<>();


    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                addClient(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : getClients()) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    public static synchronized List<ClientHandler> getClients() {
        return new ArrayList<>(clients);
    }

    public static synchronized void addClient(ClientHandler client) {
        clients.add(client);
    }

    public static synchronized void removeClient(ClientHandler client) {
        clients.remove(client);
    }

}
