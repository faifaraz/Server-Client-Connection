import java.net.*;
import java.io.*;

public class DateClient {
    public static void main(String[] args) {
        try {
            Socket sock = new Socket("172.16.34.35", 7000);
            System.out.println("Connected to server.");

            BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter outputToServer = new PrintWriter(sock.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Server: " + inputFromServer.readLine());
            System.out.println("Type a message to send (type 'exit' to quit):");

            String userMessage;
            while (true) {
                System.out.print("Client: ");
                userMessage = userInput.readLine();

                if (userMessage == null || userMessage.equalsIgnoreCase("exit")) {
                    outputToServer.println("exit");
                    System.out.println("Connection closed.");
                    break;
                }

                outputToServer.println(userMessage);

                String response = inputFromServer.readLine();
                if (response != null) {
                    System.out.println("Server: " + response);
                } else {
                    System.out.println("Server disconnected.");
                    break;
                }
            }

            sock.close();
            inputFromServer.close();
            outputToServer.close();
            userInput.close();

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
