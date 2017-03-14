
import java.io.IOException;

import java.util.Scanner;

public class Main {
	
	
	
	//
	public static void close(Client client, Scanner stdIn, Menu menu) throws IOException {
		client.send("Q\r\n");
		client.receive();
		client.close();
		stdIn.close();
		menu.exit();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException, ExceptionCommand {
		final Client client;
		final String hostname;
		final Scanner stdIn;
		final Menu menu;
		final Command command;
		double tara, netto, brutto; 

		if (args.length < 2 | args.length > 2) {
			throw new IllegalArgumentException("\nusage: Main <hostname> <port>");
		}
		client = new Client(args[0], Integer.parseInt(args[1]));
		command = new Command();
		stdIn = new Scanner(System.in);
		hostname = client.getHostname();
		menu = new Menu();

		
		while (true) {

			menu.display();

			System.out.print(hostname + "$ ");
			int input = stdIn.nextInt();

			switch (input) {
			case 1:
					client.send("RM20 8 \"Indtast operatoernummer\" \"\" \"&3\"\r\n");
					command.RM20(client);
					command.RM20(client);
					client.send("RM20 8 \"Indtast batchnummer\" \"\" \"&3\"\r\n");
					command.RM20(client);
					command.RM20(client);
					client.send("P111 \"Vaegten skal vaere ubelastet\"\r\n");
					command.P111(client);
					client.send("T\r\n");
					command.T(client);
					client.send("RM20 8 \"Placer tom tara\" \"\" \"&3\"\r\n");
					command.RM20(client);
					command.RM20(client);
					client.send("S\r\n");		
					tara = command.S(client);
					client.send("T\r\n");
					command.T(client);
					client.send("RM20 8 \"Placer netto\" \"\" \"&3\"\r\n");
					command.RM20(client);
					command.RM20(client);
					client.send("S\r\n");		
					netto = command.S(client);
					client.send("T\r\n");
					command.T(client);
					client.send("RM20 8 \"Fjern brutto\" \"\" \"&3\"\r\n");
					command.RM20(client);
					command.RM20(client);
					client.send("S\r\n");		 
					brutto = command.S(client);
					client.send("T\r\n");
					command.T(client);
					client.send("P111 \"OK\"\r\n");
					command.P111(client);
										
					
					menu.resultat(tara, netto, brutto);
					
					resultat: while (true) {
						input = stdIn.nextInt();
						switch (input) {
						case 1:
							break resultat;
						case 2:
							close(client, stdIn, menu);
							break;
						default:
							menu.wrong();
						}
					}
					
					
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
