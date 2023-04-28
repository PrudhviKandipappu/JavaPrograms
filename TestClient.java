// import java.io.*;
// import java.net.*;

// class ReceiveMessage implements Runnable {
//     DataInputStream dataReceiver;
//     Socket client;

//     ReceiveMessage(Socket client) throws IOException {
//         this.client = client;
//         dataReceiver = new DataInputStream(client.getInputStream());
//     }

//     public void run() {
//         try {
//             while (true) {
//                 System.out.println("Receiving...");
//                 String message = dataReceiver.readUTF();
//                 System.out.println(message);
//             }
//         } catch (IOException e) {
//             System.out.println("Error receiving message: " + e.getMessage());
//         }
//     }
// }

// class SendMessage implements Runnable {
//     Socket client;
//     DataOutputStream dataSender;

//     SendMessage(Socket client) throws IOException {
//         this.client = client;
//         dataSender = new DataOutputStream(client.getOutputStream());
//     }

//     public void run() {
//         try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//             while (true) {
//                 System.out.print("Enter message to send: ");
//                 String message = br.readLine();
//                 dataSender.writeUTF(message);
//                 dataSender.flush();
//             }
//         } catch (IOException e) {
//             System.out.println("Error sending message: " + e.getMessage());
//         }
//     }
// }

// class TestSocketClient {
//     public static void main(String[] args) {
//         try {
//             Socket client = new Socket("192.168.214.247", 4123);
//             ReceiveMessage receive = new ReceiveMessage(client);
//             Thread receiveThread = new Thread(receive);
//             receiveThread.start();
//             SendMessage send = new SendMessage(client);
//             Thread sendThread = new Thread(send);
//             sendThread.start();
//             System.out.println("Connected to server.");
//         } catch (IOException e) {
//             System.out.println("Error connecting to server: " + e.getMessage());
//         }
//     }
// }


// Client socket program to connect to server

import java.io.*;
import java.net.*;
import java.util.Scanner;

class ChatClient {

    private static final String HOST = "192.168.1.37";
    private static final int PORT = 4123;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Scanner scanner;

    public ChatClient()
    {
        try
        {
            socket = new Socket(HOST, PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            scanner = new Scanner(System.in);

            Thread receiveThread = new Thread(new Runnable() {
                public void run() {
                    receiveMessages();
                }
            });
            receiveThread.start();

            sendMessage();
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void sendMessage()
    {
        while (true)
        {
            String message = scanner.nextLine();
            out.println(message);
        }
    }

    public void receiveMessages()
    {
        try
        {
            while (true)
            {
                String message = in.readLine();
                System.out.println(message);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args)
    {
        new ChatClient();
}
}