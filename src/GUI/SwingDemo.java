package GUI;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.Calendar;

public class SwingDemo extends JFrame implements ActionListener {
        JLabel  jlabel1,jlabel2;
        JButton jbutton;
        
        SwingDemo(){
        	super("GUI Ӧ�ó���");
        	jlabel1=new JLabel("һ��Swing��GUIӦ�ó���",JLabel.CENTER);
        	jlabel2= new JLabel("");
        	jbutton=new JButton("����ʱ��");
        	jbutton.addActionListener(this);
        	getContentPane().add(jlabel1,BorderLayout.NORTH);
        	getContentPane().add(jlabel2,BorderLayout.CENTER);
        	getContentPane().add(jbutton,BorderLayout.SOUTH);
        	
        }
        public void actionPerformed(ActionEvent e){
        	
        	Calendar c=Calendar.getInstance();
        	if(e.getSource()==jbutton){
        		jlabel2.setText("����ʱ���ǣ�"+c.get(Calendar.HOUR_OF_DAY)+"ʱ"+c.get(Calendar.MINUTE)+"��");
        		jlabel2.setHorizontalAlignment(JLabel.CENTER);
        	}
        	
        }
        
        public static void main(String args[]){
        	JFrame jframe=new SwingDemo();
        	jframe.setSize(200,100);
        	jframe.setVisible(true);
        
        	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}  