package tcp;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author deyvison
 */
public class ServerTCP {
	private int serverPort;
	private ServerSocket listenSocket;		
	
	public ServerTCP(int serverPort) {		
		this.setServerPort(serverPort);
		try {
			listenSocket = new ServerSocket(serverPort);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listen(){    
        try {                                    
            while(true){
                Socket client = listenSocket.accept();
                new ConectionTCP(client);                
            }                        
        } catch (IOException ex) {
            Logger.getLogger(ServerTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	public int getServerPort() {
		return serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}
}
