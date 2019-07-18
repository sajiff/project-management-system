package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class StudentTable extends JFrame implements ActionListener
{
	private JLabel title;
	private JButton logout,back;
	private Color backColor;
	private Font myFont,myFont2,myFont3;
	private Student st;
	private JPanel panel;
	private JTable stdTable;
	private JScrollPane stdTableSP;
	private String stid;
	private User user;
	private Marksrepo mr;

	public StudentTable(String stid)
	{	
		
		super("Project Management System - Student's Mark Distribution");
		this.setSize(1200,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		mr = new Marksrepo();
		this.stid = stid;
		
		myFont = new Font("Bahnschrift Condensed",Font.BOLD | Font.ITALIC, 20);
		myFont3 = new Font("Bahnschrift Condensed",Font.BOLD , 30);
		myFont2 = new Font("Bahnschrift SemiBold SemiConden", Font.BOLD, 40);
		
		panel = new JPanel();
		backColor = new Color(51,49,59);
		panel.setBackground(backColor);
		panel.setLayout(null);

		title = new JLabel("Marks Distribution");
		title.setBounds(400,200,350,100);
		title.setForeground(Color.WHITE);
		title.setFont(myFont2);
		panel.add(title);

		
		logout = new JButton("Log Out");
		logout.setBounds(970,80,120,40);
		logout.setBackground(new Color(0,183,168));
		logout.setForeground(Color.WHITE);
		logout.setFont(myFont);
		logout.addActionListener(this);
		panel.add(logout);

		back = new JButton("Back");
		back.setBounds(100,80,130,50);
		back.setBackground(new Color(0,183,168));
		back.setForeground(Color.WHITE);
		back.setFont(myFont);
		back.addActionListener(this);
		panel.add(back);

		String data[][] = {{"","", "", "", "", "", "", ""}};
		String head[] = {"StdId","OOP Principles", "Package","Exception Handling", "Database Design and Operation", "Frame Navigation","Presentation","Total Marks"};
		
		Marks st = new Marks();
		st = mr.searchmarks(stid);
		for(int i=0; i<1; i++)
		{
			data[i][0] = stid;
			data[i][1] = st.getoopp()+"";
			data[i][2] = st.getpa()+"";
			data[i][3] = st.geteh()+"";
			data[i][4] = st.getdd()+"";
			data[i][5] = st.getfn()+"";
			data[i][6] = st.getpr()+"";
			data[i][7] = st.getoopp()+ st.getpa() + st.geteh() + st.getdd() + st.getfn() + st.getpr()+"";
		}
		stdTable = new JTable(data,head);
		stdTableSP = new JScrollPane(stdTable);
		stdTableSP.setBounds(200,350,800,150);
		stdTable.setBackground(new Color(0,183,168));
		stdTable.setForeground(Color.WHITE);
		stdTable.setFont(new Font("Bahnschrift Condensed",Font.BOLD, 12));
		stdTable.setEnabled(false);
		panel.add(stdTableSP);
		
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
		else if(command.equals(back.getText()))
		{
			Studentf st = new Studentf(stid);
			st.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
}


