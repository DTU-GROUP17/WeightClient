import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		Client client;
		BufferedReader br;
		String input;

		if (args.length < 2 | args.length > 2) {
			throw new IllegalArgumentException("\nusage: Main <hostname> <port>");
		}

		client = new Client(args[0], Integer.parseInt(args[1]));
		br = new BufferedReader(new InputStreamReader(System.in));
		String hostname = client.hostname;

		// must get a response since we just connected to server.
		client.receive();

		System.out.println("Type \"quit\" to exit.");
		while (true) {

			System.out.print(hostname + "$ ");
			input = br.readLine();

			if (input.isEmpty())
				continue;

			if ("quit".equalsIgnoreCase(input)) {
				client.close();
				System.exit(0);
			}
			
			client.send(input);
			client.receive();
			
		}
	}

}
