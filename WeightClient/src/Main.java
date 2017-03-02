import java.io.IOException;


public class Main {

	Client client;
	
	public static void main(String[] args) {
		if (args.length < 1 | args.length < 2 | args.length > 3) {
			System.out.println("usage Main <hostname> <port>");
			System.exit(0);
		}
		Client client = new Client(args[0], Integer.parseInt(args[1]));
		try {
			client.output.writeBytes("test\n");
			client.send("Hello");
			client.receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
