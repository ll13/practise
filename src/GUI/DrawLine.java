package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

public class DrawLine extends MouseMotionAdapter {
   public void mouseDragged(MouseEvent e){
	   DrawLine_JApplet d=new DrawLine_JApplet();
	   JPanel p = new JPanel();
	   Graphics g=p.getGraphics();
	   g.setColor(Color.red);
	   int x=e.getX();
	   int y=e.getY();
	   g.drawLine(DrawLine_JApplet.lastX, DrawLine_JApplet.lastY, x, y);
	   DrawLine_JApplet.record(x,y);
   }
}
