package multi_thread_udp;

import udp.ClientUDP;

public class ClientUDPThread extends ClientUDP implements Runnable {
	private Thread thread;
	
	public ClientUDPThread(String hostName, int port) {
		super(hostName, port);
	}

	public void start(){
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {		
		super.send("A test message");
		System.out.println(super.read());
	}

}
