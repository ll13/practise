package Applet;

import java.applet.Applet;
import java.awt.Graphics;

public class AppletMethod extends Applet{
     public static String s;
     public void init(){
    	 System.out.println("This is init");
    	 s=new String("Java Applet Method");
     }
     public void start(){
    	 System.out.println("This is start");
    	 stop();
     }
     public void stop(){
    	 System.out.println("This is stop");
    	
     }
     public void destroy(){
    	 System.out.println("This is destory");
    	
     }
     public void paint(Graphics g){
    	 System.out.println("This is paint");
    	 g.drawString(s, 40, 40);
    	 destroy();
     }
     
}
