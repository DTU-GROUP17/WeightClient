
import java.io.IOException;

import java.util.Scanner;

public class Main {
	
	//
	public static void close(Client client, Scanner stdIn, Menu menu) {
		client.send("Q\r\n");
		client.close();
		stdIn.close();
		menu.exit();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {

		Client client;
		String hostname;
		Scanner stdIn;
		Menu menu;

		if (args.length < 2 | args.length > 2) {
			throw new IllegalArgumentException("\nusage: Main <hostname> <port>");
		}

		client = new Client(args[0], Integer.parseInt(args[1]));
		stdIn = new Scanner(System.in);
		hostname = client.hostname;
		menu = new Menu();

		menu.operator();
		int operatoernummer = stdIn.nextInt();
		
		//checks if the operator id is 12
		if (!(operatoernummer == 12)) {
			close(client, stdIn, menu);
		}
		else {
			client.send("D \"" + operatoernummer + "\"\r\n");
			client.receive();
		}
		
		while (true) {

			menu.display();

			System.out.print(hostname + "$ ");
			int input = stdIn.nextInt();

			switch (input) {
			case 1:
				break;
			case 2:
				client.send("RM20 8 \"1234\" \"\" \"&3\"\r\n");
				client.receive();
				client.send("P111 \"Vaegten skal vaere ubelastet\"\r\n");
				client.receive();
				break;
			case 3:
				client.send("T\r\n");
				client.receive();
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
				close(client, stdIn, menu);
				break;
			default:
				menu.wrong();
			}
		}
	}

}
