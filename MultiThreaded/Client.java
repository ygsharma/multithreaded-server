import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client { 

    public void run() throws UnknownHostException, IOException {
        int port = 8010; // Match the server's port
        InetAddress address = InetAddress.getByName("localhost");

        Socket socket = new Socket(address, port);
        System.out.println("Connected to server: " + socket.getRemoteSocketAddress());

        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        toSocket.println("Hello World from client " + socket.getLocalSocketAddress());

        String line = fromSocket.readLine();
        System.out.println("Received from server: " + line);

        // Close resources
        toSocket.close();
        fromSocket.close();
        socket.close();
    }

    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
