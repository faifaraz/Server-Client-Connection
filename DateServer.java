import java.net.*;
import java.io.*;

public class DateServer {
    public static void main(String[] args) {
        try {
            // Create a server socket on port 6013
            ServerSocket sock = new ServerSocket(7000);
            System.out.println("Server started 7000");

            // Listen indefinitely for connections
            while (true) {
                try (Socket client = sock.accept() // Accept client connection
                ) {
                    System.out.println("Client Connected");
                    // Create a PrintWriter to send data to the client
                    PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
                    // Send current date and time
                    pout.println(new java.util.Date().toString());
                    // Close connection with client
                }
            }
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}