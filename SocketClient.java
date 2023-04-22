// Connect to Socket Server

import java.io.*;
import java.net.*;

class ChatClient extends Thread
{
	DataInputStream inputStream;
	DataOutputStream outputStream;
	Socket client;
	ChatClient(String threadName) {
		super(threadName);
		try{
			client = new Socket("192.168.1.40", 4123);
			this.start();
			// this.sendMessages();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	public void run() {
		if (this.getName().equals("RecieveMessage")) {
			try{
				this.recieveMessages();
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}

		if (this.getName().equals("SendMessage")) {
			try{
				this.sendMessages();
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public void recieveMessages() throws Exception{
		inputStream = new DataInputStream(client.getInputStream());
		System.out.println("?");
		while (true) {
			System.out.println("Recieveing Messages.....");
			String message = inputStream.readUTF();
			System.out.println(message);
		}
	}

	public void sendMessages() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("->");
		String message = br.readLine();
		outputStream = new DataOutputStream(client.getOutputStream());
		while (true) {
			System.out.println("Sending Messages.....");
			outputStream.writeUTF(message);
			if (message.equals("bye")) {
				client.close();
				break;
			}
			System.out.print("->");
			message = br.readLine();
		}
	}

}

class TestSocketClient
{
	public static void main(String[] args) throws Exception
	{
		ChatClient recieve = new ChatClient("RecieveMessage");
		// client.start();
		ChatClient send = new ChatClient("SendMessage");
	}
}