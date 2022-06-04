import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class myEmpireWindow extends JPanel implements ActionListener{

	Color BackgroundColor = new Color(200, 100, 60);
	Color buttonColors = new Color(200, 70, 60);
	Color entryButtonColors = new Color(220, 80, 50);

	private JTextField empireName, emprorName, empireEntry, emprorEntry;
	private JRadioButton flag, flagTwo, flagThree;
	private JCheckBox Done;
	private JButton flag1icon, flag2icon, flag3icon, goBack;
	private static JFrame myEmpireWindoFrame = new JFrame("My Empire");
	
	// ENTRIES
	public static boolean DoneCheck = false;
    public static String emprorNameString;
    public static String empireNameString;
    public static String flagChoice = "flag1icon.png";
    
	public myEmpireWindow() {
		setBackground(BackgroundColor);
		
		 empireName = new JTextField("Empire Name:");
		 emprorName = new JTextField("Empror Name:");
		 empireName.setEditable(false);
		 emprorName.setEditable(false);
		
		 empireEntry = new JTextField();
		 empireEntry.addActionListener(e -> { 
			 empireNameString = empireEntry.getText();
		// empireEntry.setText(empireNameString);
			 });
		 emprorEntry = new JTextField();
		 emprorEntry.addActionListener(e -> { 
			emprorNameString = emprorEntry.getText();
		//	emprorEntry.setText(emprorNameString);
			 });
		 
		 flag = new JRadioButton("Flag1", true);
		 flag.addActionListener(e -> { 
			if(flag.isSelected()) {
				flagChoice = "flag1icon.png";
			}
		 });
		 flagTwo = new JRadioButton("Flag2");
		 flagTwo.addActionListener(e -> { 
				if(flagTwo.isSelected()) {
					flagChoice = "flag2icon.png";
				}
			 });
		 
		 flagThree = new JRadioButton("Flag3");
		 flagThree.addActionListener(e -> { 
				if(flagThree.isSelected()) {
					flagChoice = "flag3icon.png";
				}
			 });
		 
		 ImageIcon flag1ic = new ImageIcon("flag1icon.png");
		 ImageIcon flag2ic = new ImageIcon("flag2icon.png");
		 ImageIcon flag3ic = new ImageIcon("flag3icon.png");
		 
		 flag1icon = new JButton(flag1ic);
		 flag2icon = new JButton(flag2ic);
		 flag3icon = new JButton(flag3ic);
		 
		 Done = new JCheckBox(" Done ");
		 Done.addActionListener(e -> { 
			if(Done.isSelected())
			 DoneCheck = true;
			else
				 DoneCheck = false;
			// System.out.println(DoneCheck);
		 });
		 
		 goBack = new JButton("Go Back");
		 goBack.addActionListener(e -> { 
			 myEmpireWindoFrame.dispose();
		 });
		 
		 ButtonGroup gr = new ButtonGroup();
		 gr.add(flag);
		 gr.add(flagTwo);
		 gr.add(flagThree);

			// Buttons Set UP
			JPanel Namebuttons = new JPanel();
			Namebuttons.setLayout(new GridLayout(5, 5, 40, 18));
			
			JPanel Otherbuttons = new JPanel();
			Otherbuttons.setLayout(new GridLayout(0, 2, 40, 10));
			
			Namebuttons.setBackground(BackgroundColor);
			Otherbuttons.setBackground(BackgroundColor);
			empireName.setBackground(BackgroundColor);
			emprorName.setBackground(BackgroundColor);
			empireEntry.setBackground(entryButtonColors);
			emprorEntry.setBackground(entryButtonColors);
			flag.setBackground(buttonColors);
			flagTwo.setBackground(buttonColors);
			flagThree.setBackground(buttonColors);
			flag1icon.setBackground(BackgroundColor);
			flag2icon.setBackground(BackgroundColor);
			flag3icon.setBackground(BackgroundColor);
			Done.setBackground(buttonColors);
			goBack.setBackground(new Color(250, 100, 60));
			
			Namebuttons.add(emprorName);
			Namebuttons.add(emprorEntry);
			Namebuttons.add(empireName);
			Namebuttons.add(empireEntry);
			Namebuttons.add(flag);
			Namebuttons.add(flag1icon);
			Namebuttons.add(flagTwo);
			Namebuttons.add(flag2icon);
			Namebuttons.add(flagThree);
			Namebuttons.add(flag3icon);
			
			Otherbuttons.add(Done);
			Otherbuttons.add(goBack);
		
			add(Namebuttons, BorderLayout.WEST);
			add(Otherbuttons, BorderLayout.CENTER);

	}
	
	public static void setTOwindowFrame(JFrame J)
	{	
		myEmpireWindoFrame = J;
	}
	
	public static void setToDoneCheck(boolean b) {
		b = DoneCheck;
	}
	
	public static void OpenMYEMPIRE() {
		myEmpireWindow myEmpire = new myEmpireWindow();		
		JFrame myEmpireWindowFrame = new JFrame("My Empire");
		myEmpireWindowFrame.setBounds(530, 150, 330, 350);
		Container c2 = myEmpireWindowFrame.getContentPane();
		c2.add(myEmpire);	
		setTOwindowFrame(myEmpireWindowFrame); // so goBack button works
		myEmpireWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myEmpireWindowFrame.setResizable(false);
		myEmpireWindowFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		OpenMYEMPIRE();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
