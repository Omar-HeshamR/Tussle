import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class EmpireStatsWindow extends JPanel implements ActionListener{

	private static JFrame statsFrame = new JFrame(" ||  Empire Statistics || ");
	private JTextArea stats;
	private JLabel emprorPicture ;
	private JButton goBack, flagpic, Ename, commander;
	Color BackgroundColor = new Color(183, 161, 246);

	public EmpireStatsWindow(Empire emp) {
		
		setBackground(BackgroundColor);
        setLayout(null);

		Ename = new JButton(emp.getEmpireNameString());
		Ename.setBackground(BackgroundColor);
		Ename.setOpaque(false);
		Ename.setBorderPainted(false); 
		Ename.setContentAreaFilled(false); 
		Ename.setFocusPainted(false);
		Ename.setFont(new Font("Monospaced", Font.PLAIN, 40));
	      Dimension size = Ename.getPreferredSize();
	      Ename.setBounds(300, 180, size.width, size.height);
	      Ename.setLocation(30,20);
	      Ename.setForeground(new Color(109, 35, 32 ));

	      commander = new JButton(" Person in Power: ");
	      commander.setBackground(BackgroundColor);
	      commander.setOpaque(false);
	      commander.setBorderPainted(false); 
	      commander.setContentAreaFilled(false); 
	      commander.setFocusPainted(false);
	      commander.setFont(new Font("Monospaced", Font.PLAIN, 28));
		      Dimension size6 = commander.getPreferredSize();
		      commander.setBounds(300, 180, size6.width, size6.height);
		      commander.setLocation(540,80);
		      commander.setForeground(new Color(109, 35, 32 ));

		ImageIcon fN = new ImageIcon(emp.getflagName());
		flagpic = new JButton(fN);
		flagpic.setBackground(BackgroundColor);
		flagpic.setOpaque(false);
		flagpic.setBorderPainted(false); 
		flagpic.setContentAreaFilled(false); 
		flagpic.setFocusPainted(false);
		 Dimension size2 = flagpic.getPreferredSize();
		 flagpic.setBounds(300, 180, size2.width, size2.height);
		 flagpic.setLocation(680,40);
	      
		stats = new JTextArea(" Money: " + emp.getMoney() +" $"
				+ "\n Population: " + emp.getPopulation() + " million"
				+ "\n Income: " + emp.getAnnualIncome() + " $"
				+ "\n Debt: " + emp.getDebt() + " thousand $"
				+ "\n Population Morale: " + emp.getPopulationMorale() + " ✿"
				+ "\n Food Stocks Level: " + emp.getFoodStocks() + " ❧"
				+ "\n Technology Level: " + emp.getTechLevel() + " ❉"
				+ "\n Wood: " + emp.getRecources(1) + "m  Metals: " + emp.getRecources(2) + "m Coal: " + emp.getRecources(3) + "m"
				+ "\n Oil: " + emp.getRecources(4) + "m  Gas: " + emp.getRecources(5) + "m  "
				+ "\n Guns"+ "#: " + emp.getWeaponry(1)+ "m"+ " Tanks#: " + emp.getWeaponry(2) + " ✪"
				+ "\n Planes#: " +emp.getWeaponry(3) + "  Ships#: " + emp.getWeaponry(4) + " ✪"
				+ "\n Taxs Level: " + emp.getTaxLevel() + "%"
				+ "\n Medical Funding: " + emp.getMedLevel() + " %"
				+ "\n Education Fundings: " + emp.getEduLevel() + " %"
				+ "\n Infrastructure Funding: " + emp.getInfaLevel() + " %"
				+ "\n Military Loyalty: " + emp.getMilitaryLoyality() + " %"
				);
		
		stats.setEditable(false);
		stats.setBackground(BackgroundColor);
		stats.setBorder(null);
		stats.setFont(new Font("SansSerif", Font.PLAIN, 24));
		 Dimension size3 = stats.getPreferredSize();
		 stats.setBounds(300, 180, size3.width, size3.height);
		stats.setLocation(40,90);

		goBack = new JButton(" Acknowldged ! ");
		goBack.setBackground(new Color(250,0,0));
		goBack.addActionListener(e -> { 
			statsFrame.dispose();
			});
	      Dimension size4 = goBack.getPreferredSize();
	      goBack.setBounds(300, 180, size4.width, size4.height);
	      goBack.setLocation(350,600);
	      
		JLabel empPic =new JLabel();
		empPic.setBackground(BackgroundColor);
		empPic.setIcon(new ImageIcon(emp.getEmpPic()));
		empPic.setOpaque(true);
		Dimension size5 = empPic.getPreferredSize();
		empPic.setBounds(300, 180, size5.width, size5.height);
		empPic.setLocation(570,130);
	
		add(commander);
		add(Ename);
		add(flagpic);
		add(stats);
		add(empPic);
		add(goBack);
	}
	
	public static void OpenEmpireStats(Empire e) {
		EmpireStatsWindow esw = new EmpireStatsWindow(e);
		JFrame statsFrame = new JFrame(" ||  Empire Statistics || ");
		statsFrame.setBounds(250, 20, 895,680);
		Container c3 = statsFrame.getContentPane();
		c3.add(esw);	
		setTOwindowFrame(statsFrame);
		// statsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		statsFrame.setResizable(false);
		statsFrame.setVisible(true);
	}
	
	public static void setTOwindowFrame(JFrame J)
	{	
		statsFrame = J;
	}
	
	public static void main(String[] args) {
		int[] r1 = new int[5];
		r1[0] = 14;
		r1[1] = 16;
		r1[2] = 15;
		r1[3] = 17;
		r1[4] = 19;

		Empire test = new Empire("Test Empire", "flag2Icon.png", "Abdulhamid.jpg", 10,10,10,10,16,16,16, new int[] {1,2,3,4,5} , r1, 16,16,16,16,16, true);
		 OpenEmpireStats(test);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
