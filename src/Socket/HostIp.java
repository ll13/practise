package Socket;

import java.applet.Applet;
import java.awt.Graphics;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostIp extends Applet{
	InetAddress Hostaddr;
	public void paint(Graphics g){
		
		g.drawString("Host name/IP: "+Hostaddr.toString(), 10, 30);
	}
    public void start(){
    	try{
    		 Hostaddr = InetAddress.getLocalHost();
    		
    	}catch(UnknownHostException e){
    		System.out.println(e.getMessage());
    	}
    	repaint();
    }
}
