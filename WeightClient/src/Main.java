
import java.io.IOException;

import java.util.Scanner;

public class Main {
	
	//
	public static void close(Client client, Scanner stdIn, Menu menu) {
		client.send("Q\r\n");
		client.receive();
		client.close();
		stdIn.close();
		menu.exit();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		final Client client;
		final String hostname;
		final Scanner stdIn;
		final Menu menu;
		final Commands commands;

		if (args.length < 2 | args.length > 2) {
			throw new IllegalArgumentException("\nusage: Main <hostname> <port>");
		}
		client = new Client(args[0], Integer.parseInt(args[1]));
		commands = new Commands();
		stdIn = new Scanner(System.in);
		hostname = client.getHostname();
		menu = new Menu();

		
		while (true) {

			menu.display();

			System.out.print(hostname + "$ ");
			final int input = stdIn.nextInt();

			switch (input) {
			case 1:
					client.send("RM20 8 \"Indtast operatoernummer\" \"\" \"&3\"\r\n");
					client.receive();
					client.receive();
					client.send("RM20 8 \"Indtast batchnummer\" \"\" \"&3\"\r\n");
					client.send("P111 \"Vaegten skal vaere ubelastet\"\r\n");
					client.receive();
					client.receive();
					client.receive();					
					client.send("P111 \"Placer tara paa vaegten\"\r\n");
					client.receive();
					client.send("T\r\n");
					client.receive();
					
					
				
				break;
			case 2:
				close(client, stdIn, menu);
				break;
			default:
				menu.wrong();
			}
		}
	}

}
