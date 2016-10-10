package InputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class IntputOutput {

	public static void main(String args[]){
		int count;
		System.out.println("please input String");
		String read="";
		
		InputStreamReader reader=new InputStreamReader(System.in);
		
		BufferedReader breader=new BufferedReader(reader);
		try {
			read=breader.readLine();
			read=breader.readLine();
			System.out.println(read);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
