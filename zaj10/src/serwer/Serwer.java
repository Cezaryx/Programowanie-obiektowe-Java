package serwer;
/*Serwer należy uruchomić przed utworzeniem klientów, należy to zrobić w terminalu komendą: java ChatServer "wstaw port nasłuchujący"
  niestety program nie ma możliwości przesyłania zdjęć czy rysowanych obrazków */
import java.io.*;
import java.net.*;
import java.util.*;


public class Serwer {
    private int port;
    private Set<String> userNames = new HashSet<>();
    private Set<UserThread> userThreads = new HashSet<>();

    public void ChatServer(int port) {
        this.port = port;
    }

    public void execute() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Chat Server is listening on port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New user connected");
                UserThread newUser = new UserThread(socket, this);
                userThreads.add(newUser);
                newUser.start();
            }
        } catch (IOException ex) {
            System.out.println("Error in the server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Syntax: java ChatServer <port-number>");
            System.exit(0);
        }
        int port = Integer.parseInt(args[0]);
        Serwer server = new Serwer();
        server.execute();
    }

    void broadcast(String message, UserThread excludeUser) {
        for (UserThread aUser : userThreads) {
            if (aUser != excludeUser) {
                aUser.sendMessage(message);
            }
        }
    }
    void addUserName(String userName) {
        userNames.add(userName);
    }
    void removeUser(String userName, UserThread aUser) {
        boolean removed = userNames.remove(userName);
        if (removed) {
            userThreads.remove(aUser);
            System.out.println("The user " + userName + " quitted");
        }
    }

    Set<String> getUserNames() {
        return this.userNames;
    }

    boolean hasUsers() {
        return !this.userNames.isEmpty();
    }
}