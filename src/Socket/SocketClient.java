package Socket;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SocketClient extends JFrame implements ActionListener{
   Socket connet;
   Box p1, p2, p3, p4;
	JLabel l5 = new JLabel(" ");
	JTextField newword = new JTextField(15);
	JTextField word = new JTextField(15);
	JTextField port = new JTextField(15);
	JTextField ip = new JTextField(15);
	JButton start = new JButton("连接");
	JButton send = new JButton("发送");
	static Socket connect = null;
   SocketClient(){
	   p1= Box.createVerticalBox();
		p2=Box.createHorizontalBox();
		p3=Box.createHorizontalBox();
		p4=Box.createHorizontalBox();
		JLabel ipLabel = new JLabel("ip地址：");		
		JLabel portLabel = new JLabel("端口号：");
		
		
		p2.add(ipLabel);
		p2.add(Box.createVerticalStrut(8));
		p2.add(ip);
		p2.add(Box.createVerticalStrut(8));
		p2.add(portLabel);
		p2.add(Box.createVerticalStrut(8));
		p2.add(port);
		p2.add(Box.createVerticalStrut(8));
		p2.add(start);

		JLabel content = new JLabel("内容：");	
		
		p3.add(content);
		p3.add(Box.createVerticalStrut(8));
		p3.add(word);
		p3.add(Box.createVerticalStrut(8));
		p3.add(send);
		
		JLabel returncontent = new JLabel("转换结果：");	
		p4.add(returncontent);
		p4.add(Box.createVerticalStrut(8));
		p4.add(newword);
       
		p1.add(p2);
		p1.add(Box.createVerticalStrut(8));
		p1.add(p3);
		p1.add(Box.createVerticalStrut(8));
		p1.add(p4);
		p1.add(Box.createVerticalStrut(8));
		p1.add(l5);
		p1.add(Box.createVerticalStrut(8));
	
		add(p1, BorderLayout.CENTER);
		add(l5, BorderLayout.SOUTH);
	   
		start.addActionListener(this);
	    send.addActionListener(this);
   }
   public void actionPerformed(ActionEvent e){
	  JButton b=(JButton)e.getSource();
	  if(b.equals(start)){
		  try{
			  String h=ip.getText();
			  String p=port.getText();
			  if(h.equals("")||p.equals("")){
				  JOptionPane.showMessageDialog(this, "请输入服务器名称和端口号！","提示信息",JOptionPane.INFORMATION_MESSAGE);
			      
			  }else{
				  connet=new Socket(InetAddress.getByName(h),Integer.parseInt(p));
				  l5.setText("连接服务器成功！");
				  
				  
			  }
			  
		  }catch(Exception ee){
			  l5.setText("连接服务器失败！");
		  }
	  }
	  if(b.equals(send)){
			 
		  try{
			  word.setText("kk");
			  String s=""+connet.getPort();
				  word.setText(s); 
				  	  
			  PrintWriter out=new PrintWriter(connect.getOutputStream());
			  out.println(word.getText());
			  
			 word.setText("ll");
			  
			 
			  BufferedReader in =new BufferedReader(new InputStreamReader(connet.getInputStream()));			 
			  String line=in.readLine();
			  newword.setText(line);
			  out.flush();
			  in.close();
			  out.close();
			  connet.close();
		  }catch(Exception ioe){
			  l5.setText("数据传输错误");
		  }
	  }
  
   }
   public static void main(String args[]) throws Exception {
		JFrame jframe = new SocketClient ();
		jframe.setSize(400, 150);
		jframe.setVisible(true);
        jframe.setLocation(600, 400);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
