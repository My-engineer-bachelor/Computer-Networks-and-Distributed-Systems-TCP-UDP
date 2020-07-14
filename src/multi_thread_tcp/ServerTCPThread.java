package multi_thread_tcp;

import tcp.ServerTCP;

public class ServerTCPThread extends ServerTCP implements Runnable{
	private Thread serverThread;
	
	public ServerTCPThread(int serverPort) {
		super(serverPort);		
	}

	public void start(){
		serverThread = new Thread(this);
		serverThread.start();
	}
	
	public void run() {
		super.listen();
	}

}
