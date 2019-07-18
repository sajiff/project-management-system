package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class MarkDistribution extends JFrame implements ActionListener
{
	private JLabel title,stdId,oopPr,pack,exHand,dataDeg,frameNav,pres,total;
	private JTextField stdIdTxt,oopPrTxt,packTxt,exHandTxt,dataDegTxt,frameNavTxt,presTxt,totalTxt;
	private JButton logout,back,update,insert,delete,load,refresh,getAll;
	private Color backColor;
	private Font myFont,myFont2,myFont3,myFont4;
	private Facultyf f;
	private JPanel panel;
	private JTable stdTable;
	private JScrollPane stdTableSP;

	private User user;
	private Studentrepo sr;
	private Userrepo ur;
	private Marksrepo mr;
	
	public MarkDistribution()
	{
		super("Project Management System - Student's Mark Distribution");
		this.setSize(1250,830);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		sr = new Studentrepo();
		ur = new Userrepo();
		mr = new Marksrepo();
		
		myFont = new Font("Bahnschrift Condensed",Font.BOLD | Font.ITALIC, 18);
		myFont3 = new Font("Bahnschrift Condensed",Font.BOLD , 30);
		myFont2 = new Font("Bahnschrift SemiBold SemiConden", Font.BOLD, 40);
		myFont4 = new Font("Bahnschrift Condensed",Font.BOLD , 12);
		
		panel = new JPanel();
		backColor = new Color(51,49,59);
		panel.setBackground(backColor);
		panel.setLayout(null);

		title = new JLabel("Marks Distribution");
		title.setBounds(400,50,350,90);
		title.setForeground(Color.WHITE);
		title.setFont(myFont2);
		panel.add(title);

		String data[][] = {{"","", "", "", "", "", "", ""}};
		String head[] = {"Id","OOP Principles", "Package","Exception Handling", "Database Design and Operation", "Frame Navigation","Presentation","Total Marks"};
		
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

		back = new JButton("Back");
		back.setBounds(100,80,130,50);
		back.setBackground(new Color(0,183,168));
		back.setForeground(Color.WHITE);
		back.setFont(myFont);
		back.addActionListener(this);
		panel.add(back);
		
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
		
		getAll = new JButton("Get All");
		getAll.setBounds(900,620,200,50);
		getAll.setBackground(new Color(0,183,168));
		getAll.setForeground(Color.WHITE);
		getAll.setFont(myFont);
		getAll.addActionListener(this);
		panel.add(getAll);
		
		
		stdId = new JLabel("ID:");
		stdId.setBounds(750,150,60,40);
		stdId.setForeground(Color.WHITE);
		stdId.setFont(myFont);
		panel.add(stdId);
		
		stdIdTxt = new JTextField();
		stdIdTxt.setBounds(950,150,200,40);
		stdIdTxt.addActionListener(this);
		panel.add(stdIdTxt);
		
		oopPr = new JLabel("OOP Principles:");
		oopPr.setBounds(750,200,170,40);
		oopPr.setForeground(Color.WHITE);
		oopPr.setFont(myFont);
		panel.add(oopPr);
		
		oopPrTxt = new JTextField();
		oopPrTxt.setBounds(950,200,200,40);
		oopPrTxt.addActionListener(this);
		panel.add(oopPrTxt);
		
		pack = new JLabel("Package:");
		pack.setBounds(750,250,100,40);
		pack.setForeground(Color.WHITE);
		pack.setFont(myFont);
		panel.add(pack);
		
		packTxt = new JTextField();
		packTxt.setBounds(950,250,200,40);
		packTxt.addActionListener(this);
		panel.add(packTxt);
		
		exHand = new JLabel("Exception Handling:");
		exHand.setBounds(750,300,180,40);
		exHand.setForeground(Color.WHITE);
		exHand.setFont(myFont);
		panel.add(exHand);
		
		exHandTxt = new JTextField();
		exHandTxt.setBounds(950,300,200,40);
		exHandTxt.addActionListener(this);
		panel.add(exHandTxt);
		
		dataDeg = new JLabel("Database Design:");
		dataDeg.setBounds(750,350,180,40);
		dataDeg.setForeground(Color.WHITE);
		dataDeg.setFont(myFont);
		panel.add(dataDeg);
		
		dataDegTxt = new JTextField();
		dataDegTxt.setBounds(950,350,200,40);
		dataDegTxt.addActionListener(this);
		panel.add(dataDegTxt);
		
		frameNav = new JLabel("Frame Navigation:");
		frameNav.setBounds(750,400,180,40);
		frameNav.setForeground(Color.WHITE);
		frameNav.setFont(myFont);
		panel.add(frameNav);
		
		frameNavTxt = new JTextField();
		frameNavTxt.setBounds(950,400,200,40);
		frameNavTxt.addActionListener(this);
		panel.add(frameNavTxt);
		
		pres = new JLabel("Presentation:");
		pres.setBounds(750,450,140,40);
		pres.setForeground(Color.WHITE);
		pres.setFont(myFont);
		panel.add(pres);
		
		presTxt = new JTextField();
		presTxt.setBounds(950,450,200,40);
		presTxt.addActionListener(this);
		panel.add(presTxt);
		
		total = new JLabel("Total Marks:");
		total.setBounds(750,510,150,50);
		total.setForeground(Color.WHITE);
		total.setFont(myFont);
		panel.add(total);
		
		totalTxt = new JTextField();
		totalTxt.setBounds(950,510,200,50);
		totalTxt.addActionListener(this);
		totalTxt.setEnabled(false);
		panel.add(totalTxt);
		
		
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
			FacultyTable ftb = new FacultyTable();
			ftb.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(load.getText()))
		{
			if(!stdIdTxt.getText().equals(null))
			{
				Marks m = mr.searchmarks(stdIdTxt.getText());
				
				if(m!= null)
				{
					oopPrTxt.setText(m.getoopp()+"");
					packTxt.setText(m.getpa()+"");
					exHandTxt.setText(m.geteh()+"");
					dataDegTxt.setText(m.getdd()+"");
					frameNavTxt.setText(m.getfn()+"");
					presTxt.setText(m.getpr()+"");
					totalTxt.setText(m.getoopp()+m.getpa()+m.geteh()+m.getdd()+m.getfn()+m.getpr()+"");
					
					stdIdTxt.setEnabled(false);
					oopPrTxt.setEnabled(true);
					packTxt.setEnabled(true);
					exHandTxt.setEnabled(true);
					dataDegTxt.setEnabled(true);
					frameNavTxt.setEnabled(true);
					presTxt.setEnabled(true);
					totalTxt.setEnabled(true);
					
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
				stdIdTxt.setText("");
				oopPrTxt.setText("");
				packTxt.setText("");
				exHandTxt.setText("");
				dataDegTxt.setText("");
				frameNavTxt.setText("");
				presTxt.setText("");
				totalTxt.setText("");
				
				stdIdTxt.setEnabled(true);
				load.setEnabled(true);
				insert.setEnabled(true);
				update.setEnabled(true);
				delete.setEnabled(true);
				refresh.setEnabled(false);
			}
			else if(command.equals(insert.getText()))
			{
				Marks m = new Marks();
				User u = new User();
				Student st = new Student();
				
				m.setstid(stdIdTxt.getText());
				m.setoopp(Double.parseDouble(oopPrTxt.getText()));
				m.setpa(Double.parseDouble(packTxt.getText()));
				m.seteh(Double.parseDouble(exHandTxt.getText()));
				m.setdd(Double.parseDouble(dataDegTxt.getText()));
				m.setfn(Double.parseDouble(frameNavTxt.getText()));
				m.setpr(Double.parseDouble(presTxt.getText()));
				m.setto(Double.parseDouble(totalTxt.getText()));
				
				mr.insertInDB(m);
				sr.insertStudent(st);
				
				JOptionPane.showMessageDialog(this, "Inserted, Id: " +stdIdTxt.getText());
				
				stdIdTxt.setText("");
				oopPrTxt.setText("");
				packTxt.setText("");
				exHandTxt.setText("");
				dataDegTxt.setText("");
				frameNavTxt.setText("");
				presTxt.setText("");
				totalTxt.setText("");
				
				load.setEnabled(true);
				insert.setEnabled(true);
				update.setEnabled(false);
				delete.setEnabled(false);
				refresh.setEnabled(true);
			}
			else if(command.equals(delete.getText()))
			{
				mr.deleteFromDB(stdIdTxt.getText());
				
				JOptionPane.showMessageDialog(this,"Deleted!!");
				
				stdIdTxt.setText("");
				oopPrTxt.setText("");
				packTxt.setText("");
				exHandTxt.setText("");
				dataDegTxt.setText("");
				frameNavTxt.setText("");
				presTxt.setText("");
				totalTxt.setText("");
				
				stdIdTxt.setEnabled(true);
				oopPrTxt.setEnabled(true);
				packTxt.setEnabled(true);
				exHandTxt.setEnabled(true);
				dataDegTxt.setEnabled(true);
				frameNavTxt.setEnabled(true);
				presTxt.setEnabled(true);
				totalTxt.setEnabled(true);
		
				load.setEnabled(true);
				insert.setEnabled(true);
				update.setEnabled(false);
				delete.setEnabled(false);
				refresh.setEnabled(true);
			}
			else if(command.equals(update.getText()))
			{
				Student st = new Student();
				Marks m = new Marks();
				
				m.setstid(stdIdTxt.getText());
				m.setoopp(Double.parseDouble(oopPrTxt.getText()));
				m.setpa(Double.parseDouble(packTxt.getText()));
				m.seteh(Double.parseDouble(exHandTxt.getText()));
				m.setdd(Double.parseDouble(dataDegTxt.getText()));
				m.setfn(Double.parseDouble(frameNavTxt.getText()));
				m.setpr(Double.parseDouble(presTxt.getText()));
				m.setto(Double.parseDouble(totalTxt.getText()));
		
				mr.updateInDB(m);
				sr.updateStudent(st);
				
				JOptionPane.showMessageDialog(this, "Updated!!");
				
				stdIdTxt.setText("");
				oopPrTxt.setText("");
				packTxt.setText("");
				exHandTxt.setText("");
				dataDegTxt.setText("");
				frameNavTxt.setText("");
				presTxt.setText("");
				totalTxt.setText("");
				
				load.setEnabled(true);
				insert.setEnabled(true);
				update.setEnabled(false);
				delete.setEnabled(false);
				refresh.setEnabled(true);
			}
			else if(command.equals(getAll.getText()))
			{
				String data[][] = mr.getAllMarks();
				String head[] = {"Id","OOP Principles", "Package","Exception Handling", "Database Design and Operation", "Frame Navigation","Presentation","Total Marks"};
				
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