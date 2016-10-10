package GUI;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class TestPen extends JFrame {
    Graphics redPen ;
    public TestPen(){
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        final JPanel p = new JPanel();
        this.add(p,BorderLayout.CENTER);
        JButton bt = new JButton("ªÒ»°ª≠± ");
        bt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                redPen = getGraphics();
                //redPen = p.getGraphics();“≤£œ£À
                redPen.setColor(Color.RED);
            }
        });
        this. add(bt,BorderLayout.SOUTH);
        p.setBorder(BorderFactory.createTitledBorder("PP"));
        addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e ) {
                if (redPen==null) return;
                redPen.fillOval(e.getX(), e.getY(), 5, 5);
            }
        });
        setVisible(true);
    }
    public void init(){
        /*redPen = getGraphics();
        redPen.setColor(Color.RED);
        addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e ) {
                redPen.fillOval(e.getX(), e.getY(), 10, 10);
            }
        });*/
    }
    public static void main(String[] args ) {
        
        new TestPen();
        
    }

}