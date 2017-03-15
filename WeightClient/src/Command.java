/**
 * The Command.java class is where the errors occurring for the commands treated with throw.
 * There is a getter for the variable userInput so the Main.java class get input such as
 * operator id or batch id for further use.
 * StringBuilder is used to get only the needed part of a string and saving it for the getter.
 */

import java.io.IOException;

class ExceptionCommand extends Exception {
	private static final long serialVersionUID = 1L;
	public ExceptionCommand(String msg) {super(msg);}
}

public class Command {

	private StringBuilder sb;
	private String userInput;
	
	
	public Command() {
		sb = new StringBuilder();
	}

	public double S(Client client) throws IOException, ExceptionCommand {
		String response = client.receive();
		sb.append(response);
		if (response.contains("S I")) {
			throw new ExceptionCommand("S I: Kommandoen kunne ikke køres");
		}
		if (response.contains("S +")) {
			throw new ExceptionCommand("S +: Der er overload");
		}
		if (response.contains("S -")) {
			throw new ExceptionCommand("S -: Der er underload");
		}
		if (response.contains("\"ES\"")) {
			throw new ExceptionCommand("ES: Fejl i kommando. Kan ikke gendkende kommandoen");
		}
		sb.delete(0,11);
		sb.delete(3,6);
		response = sb.toString();
		sb.delete(0, sb.length());
		sb.setLength(0);
		return Double.parseDouble(response);
	}
	public void T(Client client) throws IOException, ExceptionCommand {
		String response = client.receive();
		sb.append(response);
		if (response.contains("T I")) {
			throw new ExceptionCommand("T I: Kommandoen kunne ikke køres");
		}
		if (response.contains("T L")) {
			throw new ExceptionCommand("T L: Forstod ikke parametret");
		}
		if (response.contains("\"ES\"")) {
			throw new ExceptionCommand("ES: Fejl i kommando. Kan ikke gendkende kommandoen");
		}
		response = sb.toString();
		sb.setLength(0);
		System.out.println("Server: "+response);
	}

	public void RM20(Client client) throws IOException, ExceptionCommand {
		String response = client.receive();
		sb.append(response);
		if (response.contains("RM20 A \"")) {
			userInput = sb.substring(7, sb.length());
		}
		if (response.contains("RM20 I")) {
			throw new ExceptionCommand("RM20 I: Kommandoen kunne ikke køres");
		}
		if (response.contains("RM20 L")) {
			throw new ExceptionCommand("RM20 L: Forstod ikke parametret");
		}
		if (response.contains("RM20 C")) {
			throw new ExceptionCommand("RM20 C: Kommandooen blev afbrudt");
		}
		if (response.contains("\"ES\"")) {
			throw new ExceptionCommand("ES: Fejl i kommando. Kan ikke gendkende kommandoen");
		}
		response = sb.toString();
		sb.setLength(0);
		System.out.println("Server: "+response);
	}
	
	public void P111(Client client) throws IOException, ExceptionCommand {
		String response = client.receive();
		sb.append(response);
		if (response.contains("P111 I")) {
			throw new ExceptionCommand("P111 I: Kommandoen kunne ikke køres");
		}
		if (response.contains("P111 L")) {
			throw new ExceptionCommand("P111 L: Teksten kan vaere alt for lang");
		}
		if (response.contains("\"ES\"")) {
			throw new ExceptionCommand("ES: Fejl i kommando. Kan ikke gendkende kommandoen");
		}
		response = sb.toString();
		sb.setLength(0);
		System.out.println("Server: "+response);
	}
	
	public String getInputUser() {
		return userInput;
	}

}
