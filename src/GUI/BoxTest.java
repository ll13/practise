package GUI;

import java.awt.BorderLayout;
import java.awt.Panel;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BoxTest extends JFrame {
	Box box1, box2, basebox, p1;

	public BoxTest() {

		box1 = Box.createVerticalBox();
		box1.add(new JLabel("姓名:"));
		box1.add(Box.createVerticalStrut(15));
		box1.add(new JLabel("密码:"));
		box1.add(Box.createVerticalStrut(15));
		box2 = Box.createVerticalBox();
		box2.add(new JTextField(15));
		box2.add(Box.createVerticalStrut(9));
		box2.add(new JTextField(15));
		box2.add(Box.createVerticalStrut(9));
		p1 = Box.createHorizontalBox();
		p1.add(Box.createVerticalStrut(8));
		p1.add(new JButton("登录"));
		p1.add(Box.createVerticalStrut(8));
		p1.add(new JButton("取消"));
		p1.add(Box.createVerticalStrut(9));

		basebox = Box.createHorizontalBox();
		basebox.add(box1);
		basebox.add(Box.createVerticalStrut(8));
		basebox.add(box2);
		basebox.add(Box.createVerticalStrut(9));
		setTitle("测试BOXLayout布局管理器");
		add(basebox, BorderLayout.CENTER);
		add(p1, BorderLayout.SOUTH);

	}

	public static void main(String args[]) {
		JFrame jframe = new BoxTest();
		jframe.setSize(300, 150);
		jframe.setVisible(true);
        jframe.setLocation(600, 400);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
