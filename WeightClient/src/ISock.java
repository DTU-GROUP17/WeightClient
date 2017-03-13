import java.io.IOException;

public interface ISock {
	void send (String msg);
	String receive() throws IOException;
	void close();
}
