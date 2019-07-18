package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import entity.*;
import repository.*;

public class Login extends JFrame implements MouseListener, ActionListener 
{
	private JLabel userLabel, passLabel,title,imageLabel;
	private JTextField userTF;
	private JPasswordField passPF;
	private JButton login, exit, showPass;
	private Color backColor;
	private Font myFont,myFont2;
	private ImageIcon image;
	private JPanel panel;
	
	
	public Login()
	{
		super("Project Management System - Login Window");
		this.setSize(1200,830);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		myFont = new Font("Bahnschrift Condensed",Font.BOLD | Font.ITALIC, 20);
		myFont2 = new Font("Bahnschrift Condensed",Font.BOLD, 25);
		
		panel = new JPanel();
		backColor = new Color(51,49,59);
		panel.setBackground(backColor);
		panel.setLayout(null);
		
		image = new ImageIcon("LOGO.jpg");
		imageLabel = new JLabel(image);
		imageLabel.setBounds(360,100,480,340);
		panel.add(imageLabel);
		
		title = new JLabel("Login Desk");
		title.setBounds(540,400,200,40);
		title.setForeground(Color.WHITE);
		title.setFont(myFont2);
		panel.add(title);
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(400,460,150,30);
		userLabel.setForeground(Color.WHITE);
		userLabel.setFont(myFont);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(400,500,400,40);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(400,560,150,30);
		passLabel.setForeground(Color.WHITE);
		passLabel.setFont(myFont);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(400,600,400,40);
		passPF.setEchoChar('$');
		panel.add(passPF);
		
		login = new JButton("Login");
		login.setBounds(400,650,195,40);
		login.setBackground(new Color(0,183,168));
		login.setForeground(Color.WHITE);
		login.setFont(myFont);
		login.addActionListener(this);
		panel.add(login);
		
		exit = new JButton("Exit");
		exit.setBounds(605,650,195,40);
		exit.setBackground(new Color(0,183,168));
		exit.setForeground(Color.WHITE);
		exit.setFont(myFont);
		exit.addActionListener(this);
		panel.add(exit);
		
		showPass = new JButton("Show");
		showPass.setBounds(810,600,80,30);
		showPass.setBackground(Color.GRAY);
		showPass.setForeground(Color.BLACK);
		showPass.addMouseListener(this);
		panel.add(showPass);
		
		this.add(panel);
	}
	
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me)
	{
		passPF.setEchoChar((char)0);
	}
	public void mouseReleased(MouseEvent me)
	{
		passPF.setEchoChar('$');
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(login.getText()))
		{
			Userrepo ur = new Userrepo();
			User user = ur.getuser(userTF.getText(), passPF.getText());
			
			if(user != null)
			{
				if(user.getstatus() == 1)
				{
					Facultyf f = new Facultyf(user);
					f.setVisible(true);
					this.setVisible(false);
				}
				else if(user.getstatus() == 0)
				{
					Studentf st = new Studentf(userTF.getText());
					st.setVisible(true);
					this.setVisible(false);
				}
				else{}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invaild Id or Password");
			}
			
		}
		if(command.equals(exit.getText()))
		{
			System.exit(0);
		}
		else{}
	}
}