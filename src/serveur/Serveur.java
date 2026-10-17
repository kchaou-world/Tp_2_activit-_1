package serveur;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
     void main() {
        try {
            // Étape 1
            ServerSocket serverSocket = new ServerSocket(1234);
            IO.println("Je suis un serveur en attente la connexion d'un client ");
            IO.println("Serveur calculatrice en attente de connexion...");

            // Étape 2
            Socket socket = serverSocket.accept();
            IO.println("un client est connecté");
            //DataInputStream dis = new DataInputStream(socket.getInputStream());
            //DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Étape 3

            String msg = "";
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            PrintStream out = new PrintStream(socket.getOutputStream());
            msg = in.readLine();
            int x = Integer.parseInt(msg.split(" ")[0]);
            String op = msg.split(" ")[1];
            int y = Integer.parseInt(msg.split(" ")[2]);
            int res;
            switch (op){
                case "+":
                    res = x + y;
                    break;
                case "-":
                    res = x - y;
                    break;
                case "*":
                    res = x * y;
                    break;
                case "/":
                    res = x / y;
                    break;
                default:
                    res = 0;
                    break;

            }
            out.println(msg + " = " + res);

            socket.close();
            serverSocket.close();
        } catch (IOException _) {
        }
    }
}


