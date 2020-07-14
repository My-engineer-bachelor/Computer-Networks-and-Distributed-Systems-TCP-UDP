package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientUDP {
	private String hostName,
					receivedData;	
	private DatagramSocket socketClient;		
	private InetAddress IPAddress;
	private int port;			
	
	public ClientUDP(String hostName, int port) {
		super();
		this.hostName = hostName;
		this.port = port;
		try {
			socketClient = new DatagramSocket();
			IPAddress = InetAddress.getByName(hostName);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}

	public void send(String data){					
		byte[] sendData = new byte[1024];				
		sendData = data.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
		try {
			socketClient.send(sendPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}							
	}
	
	public String read(){
		try {									
			byte[] receiveData = new byte[1024];						
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			socketClient.receive(receivePacket);
			return receivedData = new String(receivePacket.getData());					
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		throw new RuntimeException();
	}

	public void close(){
		socketClient.close();
	}
	
	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getReceivedData() {
		return receivedData;
	}

	public void setReceivedData(String receivedData) {
		this.receivedData = receivedData;
	}

	public DatagramSocket getSocketClient() {
		return socketClient;
	}

	public void setSocketClient(DatagramSocket socketClient) {
		this.socketClient = socketClient;
	}

	public InetAddress getIPAddress() {
		return IPAddress;
	}

	public void setIPAddress(InetAddress iPAddress) {
		IPAddress = iPAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}		
	
}
