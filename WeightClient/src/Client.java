import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements ISock {

	private Socket sock = null;
	private String hostname;
	private int port = 8000; // default port
	private BufferedReader br = null;
	private PrintWriter bw = null;

	// constructor that takes a hostname and a port
	public Client(String hostname, int port) {
		try {
			this.hostname = hostname;
			this.port = port;
			sock = new Socket(hostname, port);
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			bw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));

		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + hostname + "on port: " + port);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the host: " + hostname + "on port: " + port);
		}

	}

	public void send(String msg) {
		if (sock != null && br != null && bw != null) {
			bw.write(msg);
			bw.flush();
		}
	}

	public String receive() throws IOException {
		
			String responseLine = br.readLine();
			return responseLine;
//			System.out.println("Server: " + responseLine);

		
		
	}
	
	public String getHostname() {
		return this.hostname;
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
