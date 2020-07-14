package tests;

import udp.ClientUDP;

public class ClientUDPTest {
	public static void main(String[] args){
		ClientUDP client = new ClientUDP("127.0.0.1", 9632); 
		client.send("Client 1");
		System.out.println(client.read());
	}
}
