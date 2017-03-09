
import java.io.IOException;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Client client;
		Scanner stdIn;
		Menu menu;

		if (args.length < 2 | args.length > 2) {
			throw new IllegalArgumentException("\nusage: Main <hostname> <port>");
		}

		client = new Client(args[0], Integer.parseInt(args[1]));
		stdIn = new Scanner(System.in);
		String hostname = client.hostname;
		menu = new Menu();

		while (true) {
			menu.display();
			System.out.print(hostname + "$ ");
			int input = stdIn.nextInt();

			switch (input) {
			case 1:
				client.send("P111 \"Indtast operatoernummer\"\r\n");
				client.receive();
				break;
			case 2:
				client.send("RM20 8 \"Indtast batchnummer\" \"\" \"&3\"\r\n");
				client.receive();
				// client.receive();
				client.send("P111 \"Vaegten skal vaere ubelastet\"\r\n");
				client.receive();
				break;
			case 3:

				client.send("P111 \"Placer tara paa vaegten\"\r\n");
				client.receive();
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				client.send("Q\r\n");
				client.close();
				stdIn.close();
				menu.exit();
				break;
			default:
				menu.wrong();
			}

		}

	}

}
