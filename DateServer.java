import java.net.*;
import java.io.*;

public class DateServer {
    public static void main(String[] args) {
        try {
            ServerSocket sock = new ServerSocket(7000);
            System.out.println("Server started on port 7000");

            while (true) {
                Socket client = sock.accept();
                System.out.println("Client connected.");

                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                // Initial welcome message
                out.println("Welcome! Current server time: " + new java.util.Date().toString());

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Client: " + message);

                    if (message.equalsIgnoreCase("exit")) {
                        out.println("Goodbye!");
                        break;
                    }

                    // Send only the current date/time (no message echo)
                    out.println("Server time: " + new java.util.Date().toString());
                }

                client.close();
                System.out.println("Client disconnected.");
            }
        } catch (IOException ioe) {
            System.err.println("Error: " + ioe.getMessage());
        }
    }
}
