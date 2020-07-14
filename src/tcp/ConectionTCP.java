/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author deyvison
 */
public class ConectionTCP extends Thread {
	private DataInputStream in;
	private DataOutputStream out;
	private Socket clientSocket;

	public ConectionTCP(Socket clientSocket) {
		try {
			this.setClientSocket(clientSocket);
			in = new DataInputStream(clientSocket.getInputStream());
			out = new DataOutputStream(clientSocket.getOutputStream());
			this.start();
		} catch (IOException ex) {
			Logger.getLogger(ConectionTCP.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void run() {
		try {					
			out.writeUTF(this.action(in.readUTF()));
		} catch (IOException ex) {
			Logger.getLogger(ConectionTCP.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public String action(String data){
		return data.toUpperCase();
	}
	
	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

}
