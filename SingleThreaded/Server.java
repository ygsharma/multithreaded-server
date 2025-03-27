import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class Server {

    public void run() throws IOException, UnknownHostException {
        int port = 8010;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(20000);
            System.out.println("Server started. Listening on port: " + port);

            while (true) {
                try {
                    Socket acceptedConnection = serverSocket.accept();
                    System.out.println("Connected to " + acceptedConnection.getRemoteSocketAddress());

                    PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(), true);
                    BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));

                    String clientMessage = fromClient.readLine();
                    System.out.println("Received from client: " + clientMessage);

                    toClient.println("Hello World from the server");
                    System.out.println("Sent message to client");

                    // Clean up connection resources
                    fromClient.close();
                    toClient.close();
                    acceptedConnection.close();

                } catch (SocketTimeoutException ste) {
                    System.out.println("No client connected within the timeout period.");
                    // Optional: break the loop if desired
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null && !serverSocket.isClosed()) {
                try {
                    serverSocket.close();
                    System.out.println("Server socket closed.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
