package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class Facultyf extends JFrame implements ActionListener
{
	private JLabel welcome,window;
	private JButton logout, changePass, showDetails;
	private Color backColor;
	private Font myFont,myFont2,myFont3;
	private User user;
	private MarkDistribution md;
	private JPanel panel;
	
	public Facultyf()
	{
		super("Project Management System - Faculty Window");
		this.setSize(1200,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		myFont = new Font("Bahnschrift Condensed",Font.BOLD | Font.ITALIC, 20);
		myFont3 = new Font("Bahnschrift Condensed",Font.BOLD , 30);
		myFont2 = new Font("Bahnschrift SemiBold SemiConden", Font.BOLD, 120);
		
		panel = new JPanel();
		backColor = new Color(51,49,59);
		panel.setBackground(backColor);
		panel.setLayout(null);

		
		welcome = new JLabel("Welcome!!");
		welcome.setBounds(300,100,650,300);
		welcome.setForeground(Color.WHITE);
		welcome.setFont(myFont2);
		panel.add(welcome);
		
		window = new JLabel("Faculty Window");
		window.setBounds(475,320,250,80);
		window.setForeground(Color.WHITE);
		window.setFont(myFont3);
		panel.add(window);
		
		logout = new JButton("Log Out");
		logout.setBounds(950,80,120,40);
		logout.setBackground(new Color(0,183,168));
		logout.setForeground(Color.WHITE);
		logout.setFont(myFont);
		panel.add(logout);
		
		showDetails = new JButton("Student Details");
		showDetails.setBounds(470,520,240,50);
		showDetails.setBackground(new Color(0,183,168));
		showDetails.setForeground(Color.WHITE);
		showDetails.setFont(myFont);
		showDetails.addActionListener(this);
		panel.add(showDetails);
	
		this.add(panel);
	}
	public Facultyf(User user)
	{
		super("Project Management System - Faculty Window");
		this.setSize(1200,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		myFont = new Font("Bahnschrift Condensed",Font.BOLD | Font.ITALIC, 20);
		myFont3 = new Font("Bahnschrift Condensed",Font.BOLD , 30);
		myFont2 = new Font("Bahnschrift SemiBold SemiConden", Font.BOLD, 120);
		
		panel = new JPanel();
		backColor = new Color(51,49,59);
		panel.setBackground(backColor);
		panel.setLayout(null);

		
		welcome = new JLabel("Welcome!!");
		welcome.setBounds(300,100,650,300);
		welcome.setForeground(Color.WHITE);
		welcome.setFont(myFont2);
		panel.add(welcome);
		
		window = new JLabel("Faculty Window");
		window.setBounds(475,320,250,80);
		window.setForeground(Color.WHITE);
		window.setFont(myFont3);
		panel.add(window);
		
		logout = new JButton("Log Out");
		logout.setBounds(950,80,120,40);
		logout.setBackground(new Color(0,183,168));
		logout.setForeground(Color.WHITE);
		logout.addActionListener(this);
		logout.setFont(myFont);
		panel.add(logout);
		
		showDetails = new JButton("Student Details");
		showDetails.setBounds(470,520,240,50);
		showDetails.setBackground(new Color(0,183,168));
		showDetails.setForeground(Color.WHITE);
		showDetails.setFont(myFont);
		showDetails.addActionListener(this);
		panel.add(showDetails);
		
	
		this.add(panel);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logout.getText()))
		{	
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(showDetails.getText()))
		{
			FacultyTable ftb = new FacultyTable(user);
			ftb.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
}