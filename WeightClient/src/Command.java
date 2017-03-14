import java.io.IOException;

class ExceptionCommand extends Exception {
	private static final long serialVersionUID = 1L;
	public ExceptionCommand(String msg) {super(msg);}
}

public class Command {

	private StringBuilder sb;
	
	
	public Command() {
		sb = new StringBuilder();
	}

	public double S(Client client) throws IOException, ExceptionCommand {
		String response = client.receive();
		int result;
		sb.append(response);
		result = sb.indexOf("S I");
		if (result == 1) {
			throw new ExceptionCommand("Kommandoen kunne ikke køres");
		}
		result = sb.indexOf("S +");
		if (result == 1) {
			throw new ExceptionCommand("Der er overload");
		}
		result = sb.indexOf("S -");
		if (result == 1) {
			throw new ExceptionCommand("Der er underload");
		}
		result = sb.indexOf("ES");
		if (result == 1) {
			throw new ExceptionCommand("Fejl i kommando. Kan ikke gendkende kommandoen");
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
		int result;
		sb.append(response);
		result = sb.indexOf("T I");
		if (result == 1) {
			throw new ExceptionCommand("Kommandoen kunne ikke køres");
		}
		result = sb.indexOf("T L");
		if (result == 1) {
			throw new ExceptionCommand("Forstod ikke parametret");
		}
		response = sb.toString();
		sb.setLength(0);
		System.out.println("Server: "+response);
	}

	public void RM20(Client client) throws IOException, ExceptionCommand {
		String response = client.receive();
		int result;
		sb.append(response);
		result = sb.indexOf("RM20 I");
		if (result == 1) {
			throw new ExceptionCommand("Kommandoen kunne ikke køres");
		}
		result = sb.indexOf("RM20 L");
		if (result == 1) {
			throw new ExceptionCommand("Forstod ikke parametret");
		}
		result = sb.indexOf("RM20 C");
		if (result == 1) {
			throw new ExceptionCommand("Kommandooen blev afbrudt");
		}
		response = sb.toString();
		sb.setLength(0);
		System.out.println("Server: "+response);
	}
	
	public void P111(Client client) throws IOException, ExceptionCommand {
		String response = client.receive();
		int result;
		sb.append(response);
		result = sb.indexOf("P111 I");
		if (result == 1) {
			throw new ExceptionCommand("Kommandoen kunne ikke køres");
		}
		result = sb.indexOf("P111 L");
		if (result == 1) {
			throw new ExceptionCommand("Teksten kan vaere alt for lang");
		}
		response = sb.toString();
		sb.setLength(0);
		System.out.println("Server: "+response);
	}

}
