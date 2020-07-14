package tests;

import multi_thread_udp.ClientUDPThread;
import multi_thread_udp.ServerUDPThread;

public class UDPThreadTest {
	public static void main(String args[]){
		int port = 9653;
		ServerUDPThread serverUDPThread = new ServerUDPThread(port);
		serverUDPThread.start();
		ClientUDPThread clientUDPThread = new ClientUDPThread("127.0.0.1", port);
		clientUDPThread.start();
	}
}
