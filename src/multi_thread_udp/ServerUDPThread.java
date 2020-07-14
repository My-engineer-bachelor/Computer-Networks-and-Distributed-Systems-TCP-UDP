package multi_thread_udp;

import udp.ServerUDP;

public class ServerUDPThread extends ServerUDP implements Runnable {
	private Thread serverThread;
	
	public ServerUDPThread(int port) {
		super(port);		
	}

	public void start(){
		serverThread = new Thread(this);
		serverThread.start();
	}
	
	public void run() {		
		super.listen();
	}

}
