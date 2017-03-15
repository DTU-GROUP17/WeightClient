/**
 * The Client.java class creates the socket for the weight client.
 * It contains send and receive methods to communicate with the weight simulator.
 * There is created a close method to ensure proper closing of the weight client.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

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
			System.err.println("Kender ikke host: " + hostname + "paa port: " + port);
		} catch (IOException e) {
			System.err.println("Kunne ikke faa I/O for host: " + hostname + "paa port: " + port);
		}

	}

	public void send(String msg) {
		if (sock != null && br != null && bw != null) {
			bw.write(msg);
			bw.flush();
		}
	}

	public String receive() throws IOException {

		String response = br.readLine();
		System.out.println(response);
		return response;

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
			System.err.println("Kunne ikke faa I/O for host: " + hostname + "paa port: " + port);
		}
	}

}
