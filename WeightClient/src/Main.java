
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

	public static void main(String[] args) throws IOException {
		final Client client;
		final String hostname;
		final Scanner stdIn;
		final Menu menu;
		final Command command;
		double tara = 0, netto = 0, brutto = 0; 

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
				try {
					command.RM20(client);
					command.RM20(client);
				} catch (ExceptionCommand e) {
					e.getMessage();
				}
					client.send("RM20 8 \"Indtast batchnummer\" \"\" \"&3\"\r\n");
				try {
					command.RM20(client);
					command.RM20(client);
				} catch (ExceptionCommand e) {
					e.getMessage();
				}
					client.send("P111 \"Vaegten skal vaere ubelastet\"\r\n");
				try {
					command.P111(client);
				} catch (ExceptionCommand e) {
					e.getMessage();
				}
					client.send("T\r\n");
				try {
					command.T(client);
				} catch (ExceptionCommand e) {
					e.getMessage();
				}
					client.send("RM20 8 \"Placer tom tara\" \"\" \"&3\"\r\n");
				try {
					command.RM20(client);
					command.RM20(client);
				} catch (ExceptionCommand e) {
					e.getMessage();
				}
					client.send("S\r\n");		
				try {
					tara = command.S(client);
				} catch (ExceptionCommand e) {
					e.getMessage();
				}
					client.send("T\r\n");
				try {
					command.T(client);
				} catch (ExceptionCommand e) {
					e.getMessage();
				}
					client.send("RM20 8 \"Placer netto\" \"\" \"&3\"\r\n");
				try {
					command.RM20(client);
					command.RM20(client);
				} catch (ExceptionCommand e) {
					e.getMessage();
				}
					client.send("S\r\n");		
				try {
					netto = command.S(client);
				} catch (ExceptionCommand e) {
					e.getMessage();
				}
					client.send("T\r\n");
				try {
					command.T(client);
				} catch (ExceptionCommand e) {
					e.getMessage();
				}
					client.send("RM20 8 \"Fjern brutto\" \"\" \"&3\"\r\n");
				try {
					command.RM20(client);
					command.RM20(client);
				} catch (ExceptionCommand e) {
					e.getMessage();
				}
					client.send("S\r\n");		 
				try {
					brutto = command.S(client);
				} catch (ExceptionCommand e) {
					e.getMessage();
				}
					client.send("T\r\n");
				try {
					command.T(client);
				} catch (ExceptionCommand e) {
					e.getMessage();
				}
					client.send("P111 \"OK\"\r\n");
				try {
					command.P111(client);
				} catch (ExceptionCommand e) {
					e.getMessage();
				}
										
					
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
