package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JApplet;
import javax.swing.JPanel;

public class DrawLine_JApplet extends JApplet {
	static int lastX;
	static int lastY;

	public void init() {
		addMouseListener(new RecordFocus() {
			public void mouseEntered(MouseEvent e) {
				record(e.getX(), e.getY());
				

			}

			public void mousePressed(MouseEvent e) {
				record(e.getX(), e.getY());
				
			}
		});
		addMouseMotionListener(new DrawLine() {
			public void mouseDragged(MouseEvent e) {

				Graphics g = getGraphics();
				g.setColor(Color.red);
				int x = e.getX();
				int y = e.getY();
				g.drawLine(lastX, lastY, x, y);
				DrawLine_JApplet.record(x, y);
			}
		});

		addKeyListener(new DrawChar() {
			public void keyTyped(KeyEvent e) {
				System.out.println("aaa");
				Graphics g = getGraphics();
				g.setColor(Color.blue);
				String s = String.valueOf(e.getKeyChar());
				g.drawString(s, lastX, lastY);
				record(lastX + 8, lastY);

			}
		});
	}

	static void record(int x, int y) {
		lastX = x;
		lastY = y;
	}

}
