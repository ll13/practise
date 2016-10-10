package Socket;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class SocketServer extends JFrame implements ActionListener {
	
	Box p1, p2, p3, p4;
	JLabel l5 = new JLabel(" ");
	JTextField newword = new JTextField(15);
	JTextField oldword = new JTextField(15);
	JTextField port = new JTextField(15);
	JTextField ip = new JTextField(15);
	JButton start = new JButton("启动");
	JButton change = new JButton("转换");
	
	
	static Socket connect = null;
	ServerSocket mysocket;

	SocketServer() throws IOException {
		p1=Box.createVerticalBox();
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
		
		JLabel content = new JLabel("收到内容：");			
		p3.add(content);
		p3.add(Box.createVerticalStrut(8));
		p3.add(oldword);
		p3.add(Box.createVerticalStrut(8));
		p3.add(change);
		
		
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
		
		add(p1, BorderLayout.CENTER);
		add(l5, BorderLayout.SOUTH);
		start.addActionListener(this);
		change.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		
		JButton b = (JButton) e.getSource();
		if (b.equals(start)) {
			try {
				String p = port.getText();
				if (!p.equals("")) {
					mysocket = new ServerSocket(Integer.parseInt(port.getText()));
					connect = mysocket.accept();
					ip.setText(""+connect.getInetAddress());
					l5.setText("服务器已启动！监听端口在" + p + ".");

				} else {
					JOptionPane.showMessageDialog(this, "请输入端口号！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception ee) {
				l5.setText("服务器启动错误！");
			}
		}
		if (b.equals(change)) {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));				
				String line = in.readLine();
				oldword.setText(line);
				newword.setText(line.toUpperCase());
				PrintWriter out = new PrintWriter(connect.getOutputStream());
				out.println(line.toUpperCase());
				 out.flush();
				  in.close();
				  out.close();
				  connect.close();
				  mysocket.close();
			} catch (Exception ioe) {
				l5.setText("数据传输错误！");
			}
		}
	}
	public static void main(String args[]) throws Exception {
		JFrame jframe = new SocketServer ();
		jframe.setSize(400, 150);
		jframe.setVisible(true);
        jframe.setLocation(600, 400);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
