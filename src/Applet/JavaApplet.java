package Applet;

import java.applet.Applet;
import java.awt.Graphics;

public class JavaApplet extends Applet {
    String print_text;
    public void init(){
    	print_text="Java Applet";
    	
    }
    public void paint(Graphics g){
    	g.drawString(print_text, 20, 20);
    }
}
