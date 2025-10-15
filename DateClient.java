import java.net.*;
import java.io.*;

public class DateClient {
    public static void main(String[] args) {
        try {
            // Connect to server at localhost:6013
            Socket sock = new Socket("172.16.34.35", 7000);
            System.out.println("Host Connected");

            // Create input stream to read data from server
            InputStream in = sock.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));

            // Read and print lines received from server
            String line;
            while ((line = bin.readLine()) != null) {
                System.out.println(line);
            }

            // Close connection
            sock.close();
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
