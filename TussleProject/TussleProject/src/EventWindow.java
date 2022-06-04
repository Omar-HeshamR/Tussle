import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EventWindow extends JPanel implements ActionListener{

	private int EventChooser;
	Color BackgroundColor = new Color(255, 162, 127 );
	public static JFrame EVENTWindow = new JFrame("(Event!)");
	private JTextField EventText;

	public EventWindow() {
		setBackground(BackgroundColor);
		setLayout(null);
		
		EventText = new JTextField("Event:");
		EventText.setEditable(false);
		EventText.setBackground(BackgroundColor);
		EventText.setOpaque(false);
		EventText.setFont(new Font("Monospaced", Font.BOLD, 23));
		EventText.setForeground(new Color(47, 0, 29 ));
		EventText.setBorder(null);
		 Dimension size1 = EventText.getPreferredSize();
		 EventText.setBounds(300, 180, size1.width, size1.height);
		EventText.setLocation(10, 10);
		add(EventText);   
		
		EventChooser = (int)(Math.random() * 4 ) + 1 ;
		// if i need to check an event EventChooser = 6;
		switch(EventChooser) {   
	      case 1:
	    	  MakeEvent1();
	    	  break;  
	      case 2:
	    	  if(TussleGame.hamidian.getIsAlive() == true && TussleGame.esctour.getIsAlive() == true) {MakeEvent2();}
	    	  else { MakeEvent3(); } 
	    	  break;
	      case 3:
	    	  MakeEvent3();
	    	  break;
	      case 4:
	    	  if(TussleGame.alkoz.getIsAlive() == true) {MakeEvent4();}
	    	  else { MakeEvent3(); }
	    	  break;
	      case 5:
	    	  MakeEvent5();
	    	  break;
	      case 6:
	    	  MakeEvent6();
	    	  break;
	      }
	      
		
		
	}
	
	public static void openEvent() {
		EventWindow event = new EventWindow();
		JFrame EventFrame = new JFrame("(Event!)");
		EventFrame.setBounds(270, 155, 855, 310);
		Container c3 = EventFrame.getContentPane();
		c3.add(event);	
		setTOwindowFrame(EventFrame);
		EventFrame.setResizable(false);
		EventFrame.setVisible(true);
		}

	public static void setTOwindowFrame(JFrame J)
	{	
		EVENTWindow = J;
	}
	
	public JTextArea makeEventDesc(String dsc) {
		JTextArea eventDesc;
		eventDesc = new JTextArea(dsc);
		eventDesc.setEditable(false);
		eventDesc.setBackground(BackgroundColor);
		eventDesc.setOpaque(false);
		eventDesc.setFont(new Font("Monospaced", Font.PLAIN, 13));
		eventDesc.setForeground(new Color(47, 0, 29 ));
		eventDesc.setBorder(null);
		 Dimension size1 = eventDesc.getPreferredSize();
		 eventDesc.setBounds(300, 180, size1.width, size1.height);
		 eventDesc.setLocation(10, 50);
		return eventDesc;
	}
	
	public JTextArea makeOPDesc(String dsc, int xPos, int yPos) {
		JTextArea eventDesc;
		eventDesc = new JTextArea(dsc);
		eventDesc.setEditable(false);
		eventDesc.setBackground(BackgroundColor);
		eventDesc.setOpaque(false);
		eventDesc.setFont(new Font("Monospaced", Font.BOLD, 13));
		eventDesc.setForeground(new Color(0, 20, 69 ));
		eventDesc.setBorder(null);
		 Dimension size1 = eventDesc.getPreferredSize();
		 eventDesc.setBounds(300, 180, size1.width, size1.height);
		 eventDesc.setLocation(xPos, yPos);
		return eventDesc;
	}
	
	public JButton makeOption(int xPos, int yPos) {
		JButton option;
		option = new JButton("Take This");
		option.setBackground(new Color(255, 170, 0));
		 Dimension size = option.getPreferredSize();
		 option.setBounds(300, 180, size.width, size.height);
		 option.setLocation(xPos,yPos);
		return option;
	}
	
	public void MakeEvent1() {
	   	 add(makeEventDesc(" Some weapon dealers are out looking for customrs to buy some of their just made weapons, they "
	   	 		+ "\n are making spcial offers and deals on the following:  "));
		 add(makeOPDesc("Pay 10,000,000$ for\n 15 tanks", 50, 130));
		 add(makeOPDesc("Pay 40,000,000$ for\n 18 Planes", 340, 130));
		 add(makeOPDesc("Pay 20,000,000$ for\n 25 ships", 630, 130));

	   	 JButton E1O1 = makeOption( 50, 200);
	   	 E1O1.addActionListener(e -> { 
	   		 if(TussleGame.player.getMoney() < 10000000) {
	   			 ErrorWindow.openError();
	   	   		 EVENTWindow.dispose();
	   		 }
	   		 else {
	   	   		TussleGame.player.setMoney(TussleGame.player.getMoney() - 10000000 );
	   	   	TussleGame.player.setWeaponry(2, TussleGame.player.getWeaponry(2) + 15);
  	   		 EVENTWindow.dispose();
	   		 }
				});
	   	 add(E1O1);
	   	 
	   	 JButton E1O2 = makeOption(340, 200);
	   	 E1O2.addActionListener(e -> { 
	   		 if(TussleGame.player.getMoney() < 40000000) {
	   			 ErrorWindow.openError();
	   	   		 EVENTWindow.dispose();
	   		 }
	   		 else {
	   	   		TussleGame.player.setMoney(TussleGame.player.getMoney() - 40000000 );
	   	   	TussleGame.player.setWeaponry(3, TussleGame.player.getWeaponry(3) + 18);
  	   		 EVENTWindow.dispose();
	   		 }		
	   		 });
	   	 add(E1O2);
	   	 
	   	 JButton E1O3 = makeOption(630, 200);
	   	 E1O3.addActionListener(e -> { 
	   		 if(TussleGame.player.getMoney() < 20000000) {
	   			 ErrorWindow.openError();
	   	   		 EVENTWindow.dispose();
	   		 }
	   		 else {
	   	   		TussleGame.player.setMoney(TussleGame.player.getMoney() - 20000000 );
	   	   	TussleGame.player.setWeaponry(4, TussleGame.player.getWeaponry(4) + 25);
  	   		 EVENTWindow.dispose();
	   		 }
	   		 });
	   	 add(E1O3);
		}
		
	public void MakeEvent2() {
	   	 add(makeEventDesc(" Your intllegince are telling you that The Arabian State are going to conquer"
	   	 		+ " Esctour Kingdom "));
		 add(makeOPDesc("Stay Silent and recieve\n 40,000,000 from Hamidian", 50, 130));
		 add(makeOPDesc("Warn Esctour for 70 Metal \nas a gift", 340, 130));
		 add(makeOPDesc("Warn Esctour for 90 Wood \nas a gift", 630, 130));

	   	 JButton E1O1 = makeOption( 50, 200);
	   	 E1O1.addActionListener(e -> { 
	   		 TussleGame.player.setMoney(TussleGame.player.getMoney() + 40000000);
   	   		Empire.conquers(TussleGame.hamidian, TussleGame.esctour);
	   		 EVENTWindow.dispose();
				});
	   	 add(E1O1);
	   	 
	   	 JButton E1O2 = makeOption(340, 200);
	   	 E1O2.addActionListener(e -> { 
	   		TussleGame.player.setRecources(2, TussleGame.player.getRecources(2) + 70);
	   	   		Empire.conquers(TussleGame.hamidian, TussleGame.esctour);
	   		 EVENTWindow.dispose();
	   		 });
	   	 add(E1O2);
	   	 
	   	 JButton E1O3 = makeOption(630, 200);
	   	 E1O3.addActionListener(e -> { 
		   		TussleGame.player.setRecources(1, TussleGame.player.getRecources(1) + 90);
	   	   		Empire.conquers(TussleGame.hamidian, TussleGame.esctour); 		 
	   		 EVENTWindow.dispose();
	   		 });
	   	 add(E1O3);
		}
	
	public void MakeEvent3() {
	   	 add(makeEventDesc(" Which help would you like to recieve from the nationlist \n" + TussleGame.player.getEmpireNameString() + " foundation?"));
		 add(makeOPDesc("35,000,000$ from a \nfund rasier", 50, 130));
		 add(makeOPDesc("+8 Population Morale \nthrough nationalistic propganda", 340, 130));
		 add(makeOPDesc("+13 Military Loyality \nthrough gitfting military \ngenerals", 630, 130));

	   	 JButton E1O1 = makeOption( 50, 200);
	   	 E1O1.addActionListener(e -> { 
	   		 TussleGame.player.setMoney(TussleGame.player.getMoney() + 35000000);
	   		 EVENTWindow.dispose();		
				});
	   	 add(E1O1);
	   	 
	   	 JButton E1O2 = makeOption(340, 200);
	   	 E1O2.addActionListener(e -> { 
	   		TussleGame.player.setPopulationMorale(TussleGame.player.getPopulationMorale() + 8);
	   		 EVENTWindow.dispose();
	   		 });
	   	 add(E1O2);
	   	 
	   	 JButton E1O3 = makeOption(630, 200);
	   	 E1O3.addActionListener(e -> { 
	   		TussleGame.player.setMilitaryLoyality(TussleGame.player.getMilitaryLoyality() + 13);
	   		 EVENTWindow.dispose();
	   		 });
	   	 add(E1O3);
		}
	
	public void MakeEvent4() {
	   	 add(makeEventDesc("Forests are burning bad in the Alkoz Kingdom"));
		 add(makeOPDesc("Send Help for 55,000,000$\n+ 2 population morale \nfor helping humanity", 50, 130));
		 add(makeOPDesc("Listen to Eastfront embassy\n and ignore them for 20,000,000$ +\n 1m Guns", 290, 130));
		 add(makeOPDesc("Send Secret operation to burn \n120 of their ships while they are \ndistracted", 600, 130));

	   	 JButton E1O1 = makeOption( 50, 200);
	   	 E1O1.addActionListener(e -> { 
	   		TussleGame.player.setMoney(TussleGame.player.getMoney() + 55000000);
	   		TussleGame.player.setPopulationMorale(TussleGame.player.getPopulationMorale() + 2);
	   		 EVENTWindow.dispose();		
				});
	   	 add(E1O1);
	   	 
	   	 JButton E1O2 = makeOption(340, 200);
	   	 E1O2.addActionListener(e -> { 
	   		TussleGame.player.setMoney(TussleGame.player.getMoney() + 20000000);
	   		TussleGame.player.setWeaponry(1, TussleGame.player.getWeaponry(1) + 1);
	   		TussleGame.eastfront.setMoney(TussleGame.eastfront.getMoney() - 20000000);
	   		 EVENTWindow.dispose();
	   		 });
	   	 add(E1O2);
	   	 
	   	 JButton E1O3 = makeOption(630, 200);
	   	 E1O3.addActionListener(e -> { 
	   		 if(TussleGame.alkoz.getWeaponry(4) >=120)
	   		TussleGame.alkoz.setWeaponry(4, TussleGame.alkoz.getWeaponry(4)- 120);
	   		 else
	   			TussleGame.alkoz.setWeaponry(2, TussleGame.alkoz.getWeaponry(2) - 40);
	   		 EVENTWindow.dispose();
	   		 });
	   	 add(E1O3);
		}
	
	public void MakeEvent5() {
	   	 add(makeEventDesc("The Eastfront Union has a border dispute with the Military State"));
		 add(makeOPDesc("Stay Nutural, gain \n +3 population morale \n +3 military loyality", 50, 130));
		 add(makeOPDesc("Side with the Eastfront Union\n for 1m guns \n and 30 metal", 340, 130));
		 add(makeOPDesc("Side with the Military \nState for 50 tanks", 630, 130));

	   	 JButton E1O1 = makeOption( 50, 200);
	   	 E1O1.addActionListener(e -> { 
		   		TussleGame.player.setPopulationMorale(TussleGame.player.getPopulationMorale() + 3);
		   		TussleGame.player.setMilitaryLoyality(TussleGame.player.getMilitaryLoyality() + 3);
	   		 EVENTWindow.dispose();		
				});
	   	 add(E1O1);
	   	 
	   	 JButton E1O2 = makeOption(340, 200);
	   	 E1O2.addActionListener(e -> { 
		   		TussleGame.player.setWeaponry(1, TussleGame.player.getWeaponry(1) + 1);
		   		TussleGame.player.setRecources(2, TussleGame.player.getRecources(2) + 30);
	   		 EVENTWindow.dispose();
	   		 });
	   	 add(E1O2);
	   	 
	   	 JButton E1O3 = makeOption(630, 200);
	   	 E1O3.addActionListener(e -> { 
		   		TussleGame.player.setWeaponry(1, TussleGame.player.getWeaponry(2) + 50);
	   		 EVENTWindow.dispose();
	   		 });
	   	 add(E1O3);
		}
	
	public void MakeEvent6() {
	   	 add(makeEventDesc("Your Nation is suffring a horrific water shortage"));
		 add(makeOPDesc("Ignore, -15 population \nmorale and -6 \nMilitary loyality", 50, 130));
		 add(makeOPDesc("Spend 30,000,000$ \n to resolve \n(make sure you have)", 340, 130));
		 add(makeOPDesc("Sell 30 of your \n tanks to resolve \n(make sure you have)", 630, 130));

	   	 JButton E1O1 = makeOption( 50, 200);
	   	 E1O1.addActionListener(e -> { 
		   		TussleGame.player.setPopulationMorale(TussleGame.player.getPopulationMorale() - 15);
		   		TussleGame.player.setMilitaryLoyality(TussleGame.player.getMilitaryLoyality() - 6);
	   		 EVENTWindow.dispose();		
				});
	   	 add(E1O1);
	   	 
	   	 JButton E1O2 = makeOption(340, 200);
	   	 E1O2.addActionListener(e -> { 
	   		 if(TussleGame.alkoz.getMoney() >= 30000000)
	   		TussleGame.alkoz.setMoney(TussleGame.alkoz.getMoney()- 30000000);
	   		 else
	   			TussleGame.player.setPopulationMorale(TussleGame.player.getPopulationMorale() - 15);
		   		TussleGame.player.setMilitaryLoyality(TussleGame.player.getMilitaryLoyality() - 6);
	   		 EVENTWindow.dispose();
	   		 });
	   	 add(E1O2);
	   	 
	   	 JButton E1O3 = makeOption(630, 200);
	   	 E1O3.addActionListener(e -> { 
	   		 if(TussleGame.player.getWeaponry(2) >= 30)
	 	   	   	TussleGame.player.setWeaponry(2, TussleGame.player.getWeaponry(2) - 30);
	   		 else
	   			TussleGame.player.setPopulationMorale(TussleGame.player.getPopulationMorale() - 15);
		   		TussleGame.player.setMilitaryLoyality(TussleGame.player.getMilitaryLoyality() - 6);
	   		 EVENTWindow.dispose();
	   		 });
	   	 add(E1O3);
		}
	
	
	public static void main(String[] args) {
		openEvent();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}


}
