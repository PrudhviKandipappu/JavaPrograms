// Connect to Socket Server

import java.io.*;
import java.net.*;

class cRecieveMessage extends Thread
{
	DataInputStream dataReciever;
	Socket client;
	cRecieveMessage() {
		client = new SocketClient("192.168.214.247", 4123);
		dataReciever = new DataInputStream(client.getInputStream());
		this.start();
	}

	public void run() {
		String message;
		while (true) {
			message = dataReciever.readUTF();
			System.out.println(message);
		}
	}
}

class cSendMessage extends cRecieveMessage
{
	DataOutputStream dataSender;
	cSendMessage() {
		dataSender = new DataOutputStream(client.getOutputStream());
		this.start();
	}

	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String message = br.readLine();
			dataSender.writeUTF(message);
		}
	}
}

class cTestSocketClient
{
	public static void main(String[] args)
	{
		cRecieveMessage recive = new cRecieveMessage();
		cSendMessage send = new cSendMessage();
	}
}