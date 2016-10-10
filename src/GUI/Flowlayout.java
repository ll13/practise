package GUI;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Flowlayout {
	public static void main(String args[]){
    	JFrame frame =new JFrame("FlowLayout ²¼¾Ö");
    	Container c=frame.getContentPane();
    	//FlowLayout f=new FlowLayout(FlowLayout.LEFT,10,10);
        //GridLayout g=new GridLayout(3,2,2,5);
    	CardLayout card=new CardLayout(30,30);
    	c.setLayout((LayoutManager) card);
    	for(int i=0;i<6;i++){
    		c.add(new JButton("°´âo"+i));
    	}
    	frame.setSize(300,500);
    	frame.setVisible(true);
        
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
