
package client;

import java.io.*;
import java.net.Socket;

public class Client {
    void main() {
        try {
            // Étape 1
            Socket socket = new Socket("localhost", 1234);
            IO.println("Connecté au serveur");

            // Étape 2
            BufferedReader clavier = new BufferedReader(
                    new InputStreamReader(System.in)
            );

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            PrintStream out = new PrintStream(socket.getOutputStream());

            // Étape 3
            IO.println("Donner l'operation (exemple : 55 * 25) :");
            String msg = clavier.readLine();

            out.println(msg);

            // Étape 4
            String resultat = in.readLine();
            IO.println("Résultat reçu du serveur : " + resultat);

            socket.close();

        } catch (IOException _) {
        }
    }
}
