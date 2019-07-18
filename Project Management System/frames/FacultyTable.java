package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class FacultyTable extends JFrame implements ActionListener
{
	private JLabel title,name,id,sec,proName,grpName,marks;
	private JTextField nameTxt,idTxt,secTxt,proNameTxt,grpNameTxt,marksTxt;
	private JButton logout,update,insert,delete,refresh,getAll,load,back,markDis;
	private Color backColor;
	private Font myFont,myFont2,myFont3,myFont4;
	private MarkDistribution md;
	private JPanel panel;
	private JTable stdTable;
	private JScrollPane stdTableSP;
	
	private User user;
	private Studentrepo sr;
	private Userrepo ur;
	private Facultyrepo fr;
	
	public FacultyTable()
	{
		super("Project Management System - Students' Details");
		this.setSize(1200,830);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		sr = new Studentrepo();
		ur = new Userrepo();
		fr = new Facultyrepo();
		
		myFont = new Font("Bahnschrift Condensed",Font.BOLD | Font.ITALIC, 20);
		myFont3 = new Font("Bahnschrift Condensed",Font.BOLD , 30);
		myFont2 = new Font("Bahnschrift SemiBold SemiConden", Font.BOLD, 40);
		myFont4 = new Font("Bahnschrift Condensed",Font.BOLD , 12);
		
		panel = new JPanel();
		backColor = new Color(51,49,59);
		panel.setBackground(backColor);
		panel.setLayout(null);

		title = new JLabel("Student Details!!");
		title.setBounds(450,50,350,90);
		title.setForeground(Color.WHITE);
		title.setFont(myFont2);
		panel.add(title);
		
		
		String data[][] = {{"", "", "","", "", ""}};
		String head[] = {"Id","Name","Section", "Group ID","Project name", "Total Marks"};
		
		stdTable = new JTable(data,head);
		stdTableSP = new JScrollPane(stdTable);
		stdTableSP.setBounds(100, 150, 630, 450);
		stdTable.setBackground(new Color(0,183,168));
		stdTable.setForeground(Color.WHITE);
		stdTable.setFont(myFont4);
		stdTable.setEnabled(false);
		panel.add(stdTableSP);
		
		
		logout = new JButton("Log Out");
		logout.setBounds(970,80,120,40);
		logout.setBackground(new Color(0,183,168));
		logout.setForeground(Color.WHITE);
		logout.setFont(myFont);
		logout.addActionListener(this);
		panel.add(logout);
		
		update = new JButton("Update");
		update.setBounds(100,620,130,50);
		update.setBackground(new Color(0,183,168));
		update.setForeground(Color.WHITE);
		update.setFont(myFont);
		update.addActionListener(this);
		update.setEnabled(false);
		panel.add(update);
		
		insert = new JButton("Insert");
		insert.setBounds(240,620,130,50);
		insert.setBackground(new Color(0,183,168));
		insert.setForeground(Color.WHITE);
		insert.setFont(myFont);
		insert.addActionListener(this);
		panel.add(insert);
		
		delete = new JButton("Delete");
		delete.setBounds(380,620,130,50);
		delete.setBackground(new Color(0,183,168));
		delete.setForeground(Color.WHITE);
		delete.setFont(myFont);
		delete.addActionListener(this);
		delete.setEnabled(false);
		panel.add(delete);
		
		refresh = new JButton("Refresh");
		refresh.setBounds(520,620,130,50);
		refresh.setBackground(new Color(0,183,168));
		refresh.setForeground(Color.WHITE);
		refresh.setFont(myFont);
		refresh.addActionListener(this);
		refresh.setEnabled(false);
		panel.add(refresh);
	
		load = new JButton("Load");
		load.setBounds(660,620,130,50);
		load.setBackground(new Color(0,183,168));
		load.setForeground(Color.WHITE);
		load.setFont(myFont);
		load.addActionListener(this);
		panel.add(load);
		
		back = new JButton("Back");
		back.setBounds(100,80,130,50);
		back.setBackground(new Color(0,183,168));
		back.setForeground(Color.WHITE);
		back.setFont(myFont);
		back.addActionListener(this);
		panel.add(back);
		
		markDis = new JButton("Mark Distribution");
		markDis.setBounds(850,620,250,50);
		markDis.setBackground(new Color(0,183,168));
		markDis.setForeground(Color.WHITE);
		markDis.setFont(myFont);
		markDis.addActionListener(this);
		panel.add(markDis);
		
		getAll = new JButton("Get All");
		getAll.setBounds(400,690,250,50);
		getAll.setBackground(new Color(0,183,168));
		getAll.setForeground(Color.WHITE);
		getAll.setFont(myFont);
		getAll.addActionListener(this);
		panel.add(getAll);
		
		id = new JLabel("ID:");
		id.setBounds(750,150,60,40);
		id.setForeground(Color.WHITE);
		id.setFont(myFont);
		panel.add(id);
		
		idTxt = new JTextField();
		idTxt.setBounds(900,150,200,40);
		idTxt.addActionListener(this);
		panel.add(idTxt);
		
		name = new JLabel("Name:");
		name.setBounds(750,220,60,40);
		name.setForeground(Color.WHITE);
		name.setFont(myFont);
		panel.add(name);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(900,220,200,40);
		nameTxt.addActionListener(this);
		panel.add(nameTxt);
		
		sec = new JLabel("Section:");
		sec.setBounds(750,290,80,40);
		sec.setForeground(Color.WHITE);
		sec.setFont(myFont);
		panel.add(sec);
		
		secTxt = new JTextField();
		secTxt.setBounds(900,290,200,40);
		secTxt.addActionListener(this);
		panel.add(secTxt);
		
		grpName = new JLabel("Group ID:");
		grpName.setBounds(750,360,130,40);
		grpName.setForeground(Color.WHITE);
		grpName.setFont(myFont);
		panel.add(grpName);
		
		grpNameTxt = new JTextField();
		grpNameTxt.setBounds(900,360,200,40);
		grpNameTxt.addActionListener(this);
		panel.add(grpNameTxt);
		
		proName = new JLabel("Project Name:");
		proName.setBounds(750,430,150,40);
		proName.setForeground(Color.WHITE);
		proName.setFont(myFont);
		panel.add(proName);
		
		proNameTxt = new JTextField();
		proNameTxt.setBounds(900,430,200,40);
		proNameTxt.addActionListener(this);
		panel.add(proNameTxt);
		
		marks = new JLabel("Total Marks:");
		marks.setBounds(750,510,130,40);
		marks.setForeground(Color.WHITE);
		marks.setFont(myFont);
		panel.add(marks);
		
		marksTxt = new JTextField();
		marksTxt.setBounds(900,510,200,40);
		marksTxt.addActionListener(this);
		panel.add(marksTxt);
		
		
	
		this.add(panel);
	}
	public FacultyTable(User user)
	{
		super("Project Management System - Students' Details");
		this.setSize(1200,830);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.user = user;
		
		sr = new Studentrepo();
		ur = new Userrepo();
		fr = new Facultyrepo();
		
		
		myFont = new Font("Bahnschrift Condensed",Font.BOLD | Font.ITALIC, 20);
		myFont3 = new Font("Bahnschrift Condensed",Font.BOLD , 30);
		myFont2 = new Font("Bahnschrift SemiBold SemiConden", Font.BOLD, 40);
		
		panel = new JPanel();
		backColor = new Color(51,49,59);
		panel.setBackground(backColor);
		panel.setLayout(null);

		title = new JLabel("Student Details!!");
		title.setBounds(450,50,350,90);
		title.setForeground(Color.WHITE);
		title.setFont(myFont2);
		panel.add(title);
		
		
		String data[][] = {{"", "", "","", "", ""}};
		String head[] = {"Id","Name","Section", "Group ID","Project name", "Total Marks"};
		
		stdTable = new JTable(data,head);
		stdTableSP = new JScrollPane(stdTable);
		stdTableSP.setBounds(100, 150, 630, 450);
		stdTable.setBackground(new Color(0,183,168));
		stdTable.setForeground(Color.WHITE);
		stdTable.setFont(myFont4);
		stdTable.setEnabled(false);
		panel.add(stdTableSP);
		
		
		logout = new JButton("Log Out");
		logout.setBounds(970,80,120,40);
		logout.setBackground(new Color(0,183,168));
		logout.setForeground(Color.WHITE);
		logout.setFont(myFont);
		logout.addActionListener(this);
		panel.add(logout);
		
		update = new JButton("Update");
		update.setBounds(100,620,130,50);
		update.setBackground(new Color(0,183,168));
		update.setForeground(Color.WHITE);
		update.setFont(myFont);
		update.addActionListener(this);
		update.setEnabled(false);
		panel.add(update);
		
		insert = new JButton("Insert");
		insert.setBounds(240,620,130,50);
		insert.setBackground(new Color(0,183,168));
		insert.setForeground(Color.WHITE);
		insert.setFont(myFont);
		insert.addActionListener(this);
		panel.add(insert);
		
		delete = new JButton("Delete");
		delete.setBounds(380,620,130,50);
		delete.setBackground(new Color(0,183,168));
		delete.setForeground(Color.WHITE);
		delete.setFont(myFont);
		delete.addActionListener(this);
		delete.setEnabled(false);
		panel.add(delete);
		
		refresh = new JButton("Refresh");
		refresh.setBounds(520,620,130,50);
		refresh.setBackground(new Color(0,183,168));
		refresh.setForeground(Color.WHITE);
		refresh.setFont(myFont);
		refresh.addActionListener(this);
		refresh.setEnabled(false);
		panel.add(refresh);
	
		load = new JButton("Load");
		load.setBounds(660,620,130,50);
		load.setBackground(new Color(0,183,168));
		load.setForeground(Color.WHITE);
		load.setFont(myFont);
		load.addActionListener(this);
		panel.add(load);
		
		back = new JButton("Back");
		back.setBounds(100,80,130,50);
		back.setBackground(new Color(0,183,168));
		back.setForeground(Color.WHITE);
		back.setFont(myFont);
		back.addActionListener(this);
		panel.add(back);
		
		markDis = new JButton("Mark Distribution");
		markDis.setBounds(850,620,250,50);
		markDis.setBackground(new Color(0,183,168));
		markDis.setForeground(Color.WHITE);
		markDis.setFont(myFont);
		markDis.addActionListener(this);
		panel.add(markDis);
		
		getAll = new JButton("Get All");
		getAll.setBounds(400,690,250,50);
		getAll.setBackground(new Color(0,183,168));
		getAll.setForeground(Color.WHITE);
		getAll.setFont(myFont);
		getAll.addActionListener(this);
		panel.add(getAll);
		
		id = new JLabel("ID:");
		id.setBounds(750,150,60,40);
		id.setForeground(Color.WHITE);
		id.setFont(myFont);
		panel.add(id);
		
		idTxt = new JTextField();
		idTxt.setBounds(900,150,200,40);
		idTxt.addActionListener(this);
		panel.add(idTxt);
		
		name = new JLabel("Name:");
		name.setBounds(750,220,60,40);
		name.setForeground(Color.WHITE);
		name.setFont(myFont);
		panel.add(name);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(900,220,200,40);
		nameTxt.addActionListener(this);
		panel.add(nameTxt);
		
		sec = new JLabel("Section:");
		sec.setBounds(750,290,80,40);
		sec.setForeground(Color.WHITE);
		sec.setFont(myFont);
		panel.add(sec);
		
		secTxt = new JTextField();
		secTxt.setBounds(900,290,200,40);
		secTxt.addActionListener(this);
		panel.add(secTxt);
		
		grpName = new JLabel("Group ID:");
		grpName.setBounds(750,360,130,40);
		grpName.setForeground(Color.WHITE);
		grpName.setFont(myFont);
		panel.add(grpName);
		
		grpNameTxt = new JTextField();
		grpNameTxt.setBounds(900,360,200,40);
		grpNameTxt.addActionListener(this);
		panel.add(grpNameTxt);
		
		proName = new JLabel("Project Name:");
		proName.setBounds(750,430,150,40);
		proName.setForeground(Color.WHITE);
		proName.setFont(myFont);
		panel.add(proName);
		
		proNameTxt = new JTextField();
		proNameTxt.setBounds(900,430,200,40);
		proNameTxt.addActionListener(this);
		panel.add(proNameTxt);
		
		marks = new JLabel("Total Marks:");
		marks.setBounds(750,510,130,40);
		marks.setForeground(Color.WHITE);
		marks.setFont(myFont);
		panel.add(marks);
		
		marksTxt = new JTextField();
		marksTxt.setBounds(900,510,200,40);
		marksTxt.addActionListener(this);
		panel.add(marksTxt);
		
	
		this.add(panel);
	}
	public FacultyTable(User user, MarkDistribution md)
	{
		super("Project Management System - Students' Details");
		this.setSize(1200,1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.user = user;
		this.md = md;
		
		
		sr = new Studentrepo();
		ur = new Userrepo();
		fr = new Facultyrepo();
		
		myFont = new Font("Bahnschrift Condensed",Font.BOLD | Font.ITALIC, 20);
		myFont3 = new Font("Bahnschrift Condensed",Font.BOLD , 30);
		myFont2 = new Font("Bahnschrift SemiBold SemiConden", Font.BOLD, 40);
		
		panel = new JPanel();
		backColor = new Color(51,49,59);
		panel.setBackground(backColor);
		panel.setLayout(null);

		title = new JLabel("Student Details!!");
		title.setBounds(450,50,350,90);
		title.setForeground(Color.WHITE);
		title.setFont(myFont2);
		panel.add(title);
		
		
		String data[][] = {{"", "", "","", "", ""}};
		String head[] = {"Id","Name","Section", "Group ID","Project name", "Total Marks"};
		
		stdTable = new JTable(data,head);
		stdTableSP = new JScrollPane(stdTable);
		stdTableSP.setBounds(100, 150, 630, 450);
		stdTable.setBackground(new Color(0,183,168));
		stdTable.setForeground(Color.WHITE);
		stdTable.setFont(myFont4);
		stdTable.setEnabled(false);
		panel.add(stdTableSP);
		
		
		logout = new JButton("Log Out");
		logout.setBounds(970,80,120,40);
		logout.setBackground(new Color(0,183,168));
		logout.setForeground(Color.WHITE);
		logout.setFont(myFont);
		logout.addActionListener(this);
		panel.add(logout);
		
		update = new JButton("Update");
		update.setBounds(100,620,130,50);
		update.setBackground(new Color(0,183,168));
		update.setForeground(Color.WHITE);
		update.setFont(myFont);
		update.addActionListener(this);
		update.setEnabled(false);
		panel.add(update);
		
		insert = new JButton("Insert");
		insert.setBounds(240,620,130,50);
		insert.setBackground(new Color(0,183,168));
		insert.setForeground(Color.WHITE);
		insert.setFont(myFont);
		insert.addActionListener(this);
		panel.add(insert);
		
		delete = new JButton("Delete");
		delete.setBounds(380,620,130,50);
		delete.setBackground(new Color(0,183,168));
		delete.setForeground(Color.WHITE);
		delete.setFont(myFont);
		delete.addActionListener(this);
		delete.setEnabled(false);
		panel.add(delete);
		
		refresh = new JButton("Refresh");
		refresh.setBounds(520,620,130,50);
		refresh.setBackground(new Color(0,183,168));
		refresh.setForeground(Color.WHITE);
		refresh.setFont(myFont);
		refresh.addActionListener(this);
		refresh.setEnabled(false);
		panel.add(refresh);
	
		load = new JButton("Load");
		load.setBounds(660,620,130,50);
		load.setBackground(new Color(0,183,168));
		load.setForeground(Color.WHITE);
		load.setFont(myFont);
		load.addActionListener(this);
		panel.add(load);
		
		back = new JButton("Back");
		back.setBounds(100,80,130,50);
		back.setBackground(new Color(0,183,168));
		back.setForeground(Color.WHITE);
		back.setFont(myFont);
		back.addActionListener(this);
		panel.add(back);
		
		markDis = new JButton("Mark Distribution");
		markDis.setBounds(850,620,250,50);
		markDis.setBackground(new Color(0,183,168));
		markDis.setForeground(Color.WHITE);
		markDis.setFont(myFont);
		markDis.addActionListener(this);
		panel.add(markDis);
		
		getAll = new JButton("Get All");
		getAll.setBounds(400,690,250,50);
		getAll.setBackground(new Color(0,183,168));
		getAll.setForeground(Color.WHITE);
		getAll.setFont(myFont);
		getAll.addActionListener(this);
		panel.add(getAll);
		
		id = new JLabel("ID:");
		id.setBounds(750,150,60,40);
		id.setForeground(Color.WHITE);
		id.setFont(myFont);
		panel.add(id);
		
		idTxt = new JTextField();
		idTxt.setBounds(900,150,200,40);
		idTxt.addActionListener(this);
		panel.add(idTxt);
		
		name = new JLabel("Name:");
		name.setBounds(750,220,60,40);
		name.setForeground(Color.WHITE);
		name.setFont(myFont);
		panel.add(name);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(900,220,200,40);
		nameTxt.addActionListener(this);
		panel.add(nameTxt);
		
		sec = new JLabel("Section:");
		sec.setBounds(750,290,80,40);
		sec.setForeground(Color.WHITE);
		sec.setFont(myFont);
		panel.add(sec);
		
		secTxt = new JTextField();
		secTxt.setBounds(900,290,200,40);
		secTxt.addActionListener(this);
		panel.add(secTxt);
		
		grpName = new JLabel("Group ID:");
		grpName.setBounds(750,360,130,40);
		grpName.setForeground(Color.WHITE);
		grpName.setFont(myFont);
		panel.add(grpName);
		
		grpNameTxt = new JTextField();
		grpNameTxt.setBounds(900,360,200,40);
		grpNameTxt.addActionListener(this);
		panel.add(grpNameTxt);
		
		proName = new JLabel("Project Name:");
		proName.setBounds(750,430,150,40);
		proName.setForeground(Color.WHITE);
		proName.setFont(myFont);
		panel.add(proName);
		
		proNameTxt = new JTextField();
		proNameTxt.setBounds(900,430,200,40);
		proNameTxt.addActionListener(this);
		panel.add(proNameTxt);
		
		marks = new JLabel("Total Marks:");
		marks.setBounds(750,510,130,40);
		marks.setForeground(Color.WHITE);
		marks.setFont(myFont);
		panel.add(marks);
		
		marksTxt = new JTextField();
		marksTxt.setBounds(900,510,200,40);
		marksTxt.addActionListener(this);
		panel.add(marksTxt);
		
	
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
			Facultyf f = new Facultyf(user);
			f.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(markDis.getText()))
		{
			MarkDistribution md = new MarkDistribution();
			md.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(load.getText()))
		{
			if(!nameTxt.getText().equals("") || !idTxt.getText().equals(null))
			{
				Student st = sr.searchstudent(idTxt.getText());
				
				if(st!= null)
				{
					nameTxt.setText(st.getstname());
					secTxt.setText(st.getsection());
					proNameTxt.setText(st.getprname());
					grpNameTxt.setText(st.getgrpid());
					marksTxt.setText(st.getmarks()+"");
					
					idTxt.setEnabled(false);
					nameTxt.setEnabled(true);
					secTxt.setEnabled(true);
					proNameTxt.setEnabled(true);
					grpNameTxt.setEnabled(true);
					marksTxt.setEnabled(true);
					
					update.setEnabled(true);
					delete.setEnabled(true);
					refresh.setEnabled(true);
					insert.setEnabled(false);
					load.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID!!");
				}
			}
		}
		else if(command.equals(refresh.getText()))
			{
				idTxt.setText("");
				nameTxt.setText("");
				secTxt.setText("");
				proNameTxt.setText("");
				grpNameTxt.setText("");
				marksTxt.setText("");
				
				idTxt.setEnabled(true);
				load.setEnabled(true);
				insert.setEnabled(true);
				update.setEnabled(true);
				delete.setEnabled(true);
				refresh.setEnabled(false);
			}
			else if(command.equals(insert.getText()))
			{
				Student st = new Student();
				User u = new User();
				
				Random rd = new Random();
				int a = rd.nextInt(9999999) +10000000;
				
				st.setstid(idTxt.getText());
				st.setstname(nameTxt.getText());
				st.setsection(secTxt.getText());
				st.setprname(proNameTxt.getText());
				st.setgrpid(grpNameTxt.getText());
				st.setmarks(Integer.parseInt(marksTxt.getText()));
				
				u.setuserid(idTxt.getText());
				u.setpassword( a+ "");
				u.setstatus(0);
				
				sr.insertStudent(st);
				ur.insertuser(u);
				
				JOptionPane.showMessageDialog(this, "Inserted, Id: " +idTxt.getText()+ "and Password: " +a);
				
				idTxt.setText("");
				nameTxt.setText("");
				secTxt.setText("");
				proNameTxt.setText("");
				grpNameTxt.setText("");
				marksTxt.setText("");
				
				load.setEnabled(true);
				insert.setEnabled(true);
				update.setEnabled(false);
				delete.setEnabled(false);
				refresh.setEnabled(true);
			}
			else if(command.equals(delete.getText()))
			{
				sr.deleteStudent(idTxt.getText());
				ur.deleteuser(idTxt.getText());
				
				JOptionPane.showMessageDialog(this,"Deleted!!");
				
				idTxt.setText("");
				nameTxt.setText("");
				secTxt.setText("");
				proNameTxt.setText("");
				grpNameTxt.setText("");
				marksTxt.setText("");
				
				idTxt.setEnabled(true);
				nameTxt.setEnabled(true);
				secTxt.setEnabled(true);
				proNameTxt.setEnabled(true);
				grpNameTxt.setEnabled(true);
				marksTxt.setEnabled(true);
		
				load.setEnabled(true);
				insert.setEnabled(true);
				update.setEnabled(false);
				delete.setEnabled(false);
				refresh.setEnabled(true);
			}
			else if(command.equals(update.getText()))
			{
				Student st = new Student();
				
				st.setstid(idTxt.getText());
				st.setstname(nameTxt.getText());
				st.setsection(secTxt.getText());
				st.setgrpid(grpNameTxt.getText());
				st.setprname(proNameTxt.getText());
				st.setmarks(Double.parseDouble(marksTxt.getText()));
				
				sr.updateStudent(st);
				
				JOptionPane.showMessageDialog(this, "Updated!!");
				
				idTxt.setText("");
				nameTxt.setText("");
				secTxt.setText("");
				proNameTxt.setText("");
				grpNameTxt.setText("");
				marksTxt.setText("");
				
				load.setEnabled(true);
				insert.setEnabled(true);
				update.setEnabled(false);
				delete.setEnabled(false);
				refresh.setEnabled(true);
				
				idTxt.setEnabled(true);
				nameTxt.setEnabled(true);
				secTxt.setEnabled(true);
				proNameTxt.setEnabled(true);
				grpNameTxt.setEnabled(true);
				marksTxt.setEnabled(true);
			}
			else if(command.equals(getAll.getText()))
			{
				String data[][] = sr.getallstudent();
				String head[] = {"Id","Name","Section", "Group Id", "Project name", "Total Marks"};
				
				panel.remove(stdTableSP);
				
				stdTable = new JTable(data,head);
				stdTable.setEnabled(false);
				stdTable.setBackground(new Color(0,183,168));
				stdTable.setForeground(Color.WHITE);
				stdTable.setFont(myFont4);
				stdTableSP = new JScrollPane(stdTable);
				stdTableSP.setBounds(100, 150, 630, 450);
				panel.add(stdTableSP);
				
				panel.revalidate();
				panel.repaint();
			}
			
		else{}
	}
	
}