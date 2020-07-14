package tests;

import tcp.ClientTCP;

public class ClientTCPTest {
	public static void main(String[] args) {
		ClientTCP client = new ClientTCP(7896, "127.0.0.1");
		client.send("A test message.");
		System.out.println(client.read());		
	}
}
