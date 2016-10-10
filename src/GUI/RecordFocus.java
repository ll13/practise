package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RecordFocus extends MouseAdapter{
	DrawLine_JApplet d=new DrawLine_JApplet();
public void mouseEntered(MouseEvent e){
	d.record(e.getX(),e.getY());
	
}
public void mousePressed(MouseEvent e){
	d.record(e.getX(),e.getY());
	
}


}
