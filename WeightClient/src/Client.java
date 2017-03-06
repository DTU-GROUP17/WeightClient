import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client implements ISock{

	Socket sock = null;
	String hostname;
	int port = 8000; // default port
	BufferedReader br = null;
	BufferedWriter bw = null;
	

	// constructor that takes a hostname and a port
	public Client(String hostname, int port) {
		try {
			this.hostname = hostname;
			this.port = port;
			sock = new Socket(hostname, port);
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			

		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + hostname + "on port: " + port);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the host: " + hostname + "on port: " + port);
		}

	}

	public void send(String msg) {
		if (sock != null && br != null && bw != null) {
			try {
				bw.write(msg);
				bw.newLine();
				bw.flush();
			} catch (IOException e) {
				System.err.println("Couldn't get I/O for the host: " + hostname + "on port: " + port);
			}
		}
	}

	public void receive() {
		try {
			
			
			
			for (String response = br.readLine(); response != null; response = br.readLine()) {
			System.out.println("Server: " + response);
			}
			
			
			
				
			
			
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the host: " + hostname + "on port: " + port);
		}
		
	}

	// close down properly
	public void close() {

		try {
			bw.close();
			br.close();
			sock.close();
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the host: " + hostname + "on port: " + port);
		}
	}

}
