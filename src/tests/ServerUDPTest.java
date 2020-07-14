package tests;

import udp.ServerUDP;

public class ServerUDPTest {
	public static void main(String[] args){
		ServerUDP server = new ServerUDP(9632);
		server.listen();
	}
}
