package tests;

import tcp.ServerTCP;

public class ServerTCPTest {
	public static void main(String[] args){
		ServerTCP serverTcp = new ServerTCP(7896);		
		serverTcp.listen();
	}
}
