package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class DrawChar extends KeyAdapter  {
    public void keyTyped(KeyEvent e){
    	JPanel p = new JPanel();
    	DrawLine_JApplet d=new DrawLine_JApplet();
    	Graphics g=p.getGraphics();
    	g.setColor(Color.blue);
    	String s=String.valueOf(e.getKeyChar());
    	g.drawString(s, d.lastX, d.lastY);
    	d.record(d.lastX+8,d.lastY);
    	
    }
}
