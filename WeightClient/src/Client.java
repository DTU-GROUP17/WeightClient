import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	Socket sock = null;
	String hostname;
	int port = 8000; // default port
	DataInputStream input = null;
	DataOutputStream output = null;
	BufferedReader br = null;

	// constructor
	public Client(String hostname, int port) {
		try {
			this.hostname = hostname;
			this.port = port;
			sock = new Socket(hostname, port);
			// input = new DataInputStream(sock.getInputStream()); // maybe not
			// needed since br maybe does the same
			output = new DataOutputStream(sock.getOutputStream());
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + hostname + "on port: " + port);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the host: " + hostname + "on port: " + port);
			e.printStackTrace();
		}

	}

	public void send(String msg) {
		if (sock != null && input != null && output != null) {
			try {
				output.writeBytes(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// prefered way to send is trough this method, since there is a catch in it
	public void receive() {
		String responseLine;
		try {
			while ((responseLine = br.readLine()) != null) {
				System.out.println("Server: " + responseLine);
			}
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the host: " + hostname + "on port: " + port);
			e.printStackTrace();
		}
	}

	public void close() {

		// close down properly
		try {
			output.close();
			input.close();
			sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
