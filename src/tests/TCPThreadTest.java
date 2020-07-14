package tests;

import multi_thread_tcp.ClientTCPThread;
import multi_thread_tcp.ServerTCPThread;

public class TCPThreadTest {
	public static void main(String[] args){
		int port = 9653;
		ServerTCPThread serverTCPThread = new ServerTCPThread(port);
		serverTCPThread.start();
		ClientTCPThread clientTCPThread = new ClientTCPThread(port, "127.0.0.1");
		clientTCPThread.start();	}
}
