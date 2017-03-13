import java.io.IOException;

public class Commands {

	private StringBuilder sb;

	public Commands() {
		sb = new StringBuilder();
	}

	public String D(Client client) throws IOException {
		String response = "";
		int result;
		
			sb.append(response);
		
		
//		result = sb.indexOf("D A");
//		if (result == 1)
//			return sb.toString();
		result = sb.indexOf("D I");
		if (result == 1)
			client.close();
		result = sb.indexOf("D L");
		if (result == 1)
			client.close();
		response = sb.toString();
		sb.setLength(0);
		return response;
	}
	
	public String S(Client client) throws IOException {
		String response = "";
		int result;
		
			sb.append(response);
		
		
//		result = sb.indexOf("S S");
//		if (result == 1)
//			return sb.toString();
		result = sb.indexOf("S I");
		if (result == 1)
			client.close();
		response = sb.toString();
		sb.setLength(0);
		return response;
	}

	public String DW(Client client) throws IOException {
		String response = "";
		int result;
		
			sb.append(response);
		
		
//		result = sb.indexOf("DW A");
//		if (result == 1)
//			return sb.toString();
		result = sb.indexOf("DW I");
		if (result == 1)
			client.close();
		result = sb.indexOf("DW L");
		if (result == 1)
			client.close();
		response = sb.toString();
		sb.setLength(0);
		return response;
	}
	
	public String T(Client client) throws IOException {
		String response = "";
		int result;
		
			sb.append(response);
		
		
//		result = sb.indexOf("T S");
//		if (result == 1)
//			return sb.toString();
		result = sb.indexOf("T I");
		if (result == 1)
			client.close();
		response = sb.toString();
		sb.setLength(0);
		return response;
	}
	
	public String RM20(Client client) throws IOException {
		String response = "";
		int result;
		
		
			sb.append(response);
		
		
//		result = sb.indexOf("RM20 B");
//		if (result == 1)
//			return sb.toString();
//		result = sb.indexOf("RM20 B");
//		if (result == 1)
//			return sb.toString();
		result = sb.indexOf("RM20 I");
		if (result == 1)
			client.close();
		result = sb.indexOf("RM20 L");
		if (result == 1)
			client.close();
		response = sb.toString();
		sb.setLength(0);
		return response;
	}
	
	
}
