package multi_thread_tcp;

import tcp.ClientTCP;

public class ClientTCPThread extends ClientTCP implements Runnable{
	private Thread clientThread;
	
	public ClientTCPThread(int serverPort, String serverIpAddress) {
		super(serverPort, serverIpAddress);
		// TODO Auto-generated constructor stub
	}

	public void start(){
		clientThread = new Thread(this);
		clientThread.start();
	}
	
	public void run() {		
		super.send("A test message");
		System.out.println(super.read());
	}
	
}
