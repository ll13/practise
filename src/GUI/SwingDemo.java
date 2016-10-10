package GUI;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.Calendar;

public class SwingDemo extends JFrame implements ActionListener {
        JLabel  jlabel1,jlabel2;
        JButton jbutton;
        
        SwingDemo(){
        	super("GUI 应用程序");
        	jlabel1=new JLabel("一个Swing的GUI应用程序",JLabel.CENTER);
        	jlabel2= new JLabel("");
        	jbutton=new JButton("现在时间");
        	jbutton.addActionListener(this);
        	getContentPane().add(jlabel1,BorderLayout.NORTH);
        	getContentPane().add(jlabel2,BorderLayout.CENTER);
        	getContentPane().add(jbutton,BorderLayout.SOUTH);
        	
        }
        public void actionPerformed(ActionEvent e){
        	
        	Calendar c=Calendar.getInstance();
        	if(e.getSource()==jbutton){
        		jlabel2.setText("现在时间是："+c.get(Calendar.HOUR_OF_DAY)+"时"+c.get(Calendar.MINUTE)+"分");
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