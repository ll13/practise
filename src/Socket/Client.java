package Socket;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.*;
public class Client {
	public static void main(String args[]){
     String host="192.168.43.96";
     int port=8919;
     try{
    	 Socket client=new Socket(host,port);
    	 Writer writer =new OutputStreamWriter(client.getOutputStream());
    	 writer.write("Hello From Client");
    	 writer.flush();
    	 writer.close();
    	 client.close();
     }catch(IOException e){
    	 e.printStackTrace();
     }
	}
}
