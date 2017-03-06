import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements ISock {

	Socket sock = null;
	String hostname;
	int port = 8000; // default port
	BufferedReader br = null;
	PrintWriter bw = null;

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
			bw.println(msg);
			bw.flush();
		}
	}

	public void receive() {

		/*
		 *  TODO must make a loop to get all input from the socket.
		 *  != null doesn't work, since it reads until socket gets closed.
		 *  
		 */
	
		// for (String response = br.readLine(); response != null; response =
		// br.readLine()) {
		// System.out.println("Server: " + response);
		// }
		try {
			
			
			System.out.println("Server: " + br.readLine());
//			while (sock.getInputStream().available() > 0) {
//
//				int ready = sock.getInputStream().available();
//				byte[] bytes = new byte[ready];
//				sock.getInputStream().read(bytes);
//				
//
//			}
			
			

		} catch (IOException e) {

			e.printStackTrace();
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
