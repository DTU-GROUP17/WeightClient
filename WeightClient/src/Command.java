import java.io.IOException;

public class Command {

	private StringBuilder sb;
	
	
	public Command() {
		sb = new StringBuilder();
	}

	public double S(Client client) throws IOException {
		String response = client.receive();
		int result;
		sb.append(response);
		result = sb.indexOf("S I");
		if (result == 1)
			client.close();
		sb.delete(0,11);
		sb.delete(3,6);
		response = sb.toString();
		sb.delete(0, sb.length());
		sb.setLength(0);
		return Double.parseDouble(response);
	}
	public void T(Client client) throws IOException {
		String response = client.receive();
		int result;
		sb.append(response);
		result = sb.indexOf("T I");
		if (result == 1)
			client.close();
		response = sb.toString();
		sb.setLength(0);
		System.out.println("Server: "+response);
	}

	public void RM20(Client client) throws IOException {
		String response = client.receive();
		int result;
		sb.append(response);
		result = sb.indexOf("RM20 I");
		if (result == 1)
			client.close();
		result = sb.indexOf("RM20 L");
		if (result == 1)
			client.close();
		response = sb.toString();
		sb.setLength(0);
		System.out.println("Server: "+response);
	}
	
	public void P111(Client client) throws IOException {
		String response = client.receive();
		int result;
		sb.append(response);
		result = sb.indexOf("P I");
		if (result == 1)
			client.close();
		result = sb.indexOf("P L");
		if (result == 1)
			client.close();
		response = sb.toString();
		sb.setLength(0);
		System.out.println("Server: "+response);
	}

}
