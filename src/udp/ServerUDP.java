package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerUDP {
	private int port;
	private DatagramSocket socketServidor;		
		
	public ServerUDP(int port) {
		super();
		this.port = port;
		try {
			socketServidor = new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listen(){		
		try {			
			byte[] receiveData = new byte[1024];			
			while (true) {
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				socketServidor.receive(receivePacket);																				
				byte[] sendData = this.action(new String(receivePacket.getData())); 																
				socketServidor.send(
						new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort())
						);
			}	
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public byte[] action(String data){
		return data.toUpperCase().getBytes();
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public DatagramSocket getSocketServidor() {
		return socketServidor;
	}

	public void setSocketServidor(DatagramSocket socketServidor) {
		this.socketServidor = socketServidor;
	}
	
}
