import java.io.IOException;


public class Main {

	Client client;
	
	public static void main(String[] args) {
		Client client = new Client(Integer.parseInt(args[1]));
		try {
			client.output.writeBytes("test\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		//close down properly
		try {
			client.output.close();
			client.input.close();
			client.client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
