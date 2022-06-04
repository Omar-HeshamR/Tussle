import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import java.awt.Image;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class TussleGame extends JPanel implements ActionListener {

	public static Sound GameMusicField = new Sound("GameMusic.wav");
    private JPanel flagJPANEL = new JPanel();
    private LocalDateTime now;
	  private JTextField IRLdate;	
    private boolean winCheck = false;
	  
    // Initialize empires here
   public static Empire hamidian = new Empire("The Arabian State", "EmpireFlag-Hamid.png","HamidEmpror.jpg", 867000000, 953,
		   31000000, 0, 95, 98, 91, new int[] {97, 143, 119, 230, 160}, new int[] {11, 1004, 470, 670},0,21,25,18, 94, true);
   public static Empire fredz = new Empire("Fredz Fedration", "FredzFlag.png","FedzEmpror.jpg", 337000000, 760,
		   13000000, 0, 73, 79, 70, new int[] {132, 86, 121, 120, 103}, new int[] {10, 470, 212, 630},7,10,11,13, 85, true);
   public static Empire tribes = new Empire("United Tribes of Alkebulan","TribesFlag.png","TribesEmpror.jpg", 190000000, 910,
		   19000000, 0, 83, 75, 71, new int[] {129, 139, 152, 124, 110}, new int[] {10, 530, 189, 281},5,13,11,9,76, true);
   public static Empire vulpine = new Empire("Holy Vulpine Empire", "VulpineEmpireFlag.png","VulpineEmpror.jpg", 634000000, 470,
		   23000000, 0, 87, 98, 96, new int[] {129, 126, 101, 96, 117}, new int[] {8, 437, 296, 337},13,21,25,18,91, true);
   public static Empire sandrisa = new Empire("Sandrisa Imperial State", "SandrisaFlag.jpg", "SandrisaEmpror.jpg",1020000000, 212,
		   18000000, 0, 72, 83, 81, new int[] {111, 130, 100, 114, 126}, new int[] {9,460, 380, 780},8,16,16,15,88, true);
   public static Empire alkoz = new Empire("Alkoz Kingdom","AlkozKingdomFlag.png", "AlkozEmpror.jpg", 520000000,  221,
		   10000000, 0, 76, 92, 81, new int[] {107, 112, 116, 107, 121}, new int[] {7,210,354, 723},8,17,16,16,90, true);
   public static Empire eastfront = new Empire("Eastfront Union", "EastfrrontUnionFlag.png","EastfrontEmpror.jpg",1020000000, 1860,
		   28000000, 0, 72, 77, 80, new int[] {127, 123, 137, 113, 128}, new int[] {15,1021, 401, 610},3,15,12,17,86, true);
   public static Empire esctour = new Empire("Kingdom of Esctour","EsctourKingdomFlag.jpg", "EsctourEmpror.jpg",90000000, 170,
		   1800000, 0, 63, 51, 84, new int[] {43, 97, 56, 70, 64}, new int[] {4, 411, 114, 54},13, 8,9,18,90, true);
   public static Empire padara = new Empire("Republic of Padara","PadaraStateFlag.png", "padaraEmpror.jpg", 280000000, 183,
		   11200000, 0, 76, 81, 85, new int[] {101, 117, 94, 83, 118}, new int[] {8, 389, 224, 643},7, 14,15,15,79, true);
   public static Empire military = new Empire("Vaulter Military State", "MilitaryStateFlag.jpg","MilitaryStateEmpror.jpg", 670000000, 547,
		   11700000, 0, 65, 84, 82, new int[] {107, 92, 163, 118, 104}, new int[] {14, 1400, 600, 732},16,7,10,19,100, true);
   public static Empire krixxun = new Empire("Krixxun Sultanate","KrixxunKingdomFlag.jpg", "KrixxunEmpror.jpg", 1000000000, 87,
		   25000000, 0, 91, 98, 82, new int[] {76, 97, 86, 147, 101}, new int[] {5, 220, 196, 299},0,18,19, 20,89, true);
   public static Empire zeon = new Empire("Zeon Emirate", "ZeonRepublicFlag.png","ZeonEmpror.png", 67000000,  63,
		   1710000, 0, 56, 50, 93, new int[] {52, 27, 31, 17, 23}, new int[] {2, 196, 179, 41},19,18,23, 19,75, true);
   public static Empire player = new Empire(myEmpireWindow.empireNameString,myEmpireWindow.flagChoice, "PlayerEmpror.png", 250000000, 200,
		   11200000, 0, 80, 86, 78, new int[] {65, 67, 93, 76, 79}, new int[] {4, 218, 165, 98},11,17,18, 16,87, true);
   
   // flag location holders
   private int HamidXpos = 716, HamidYpos = 280, FredzXpos = 380, FredzYpos = 470, TribesXpos = 681, TribesYpos = 487;
   private int VulpineXpos = 670, VulpineYpos = 146, SandrisaXpos = 199, SandrisaYpos = 130, AlkozXpos = 1090, AlkozYpos = 545;
   private int EastXpos = 935, EastYpos = 255, EscXpos = 713, EscYpos = 365, PadaraXpos = 210, PadaraYpos = 273;
   private int MilitaryXpos = 1054, MilitaryYpos = 117, KrixXpos = 610, KrixYpos = 341, ZeonXpos =808, ZeonYpos =88;
   private int playerXpos = 898, playerYpos = 149;
   
	public TussleGame() {
	
		setBackground(new Color(43, 116, 255));
        setLayout(null);
	
        // flags      - I cant use a method since I wont be able to refresh da frame  
		JButton FlagButtonHamid;
		ImageIcon flagIcon = new ImageIcon("EmpireFlag-Hamid.png");
		FlagButtonHamid = new JButton(flagIcon);
	      Dimension size5 = FlagButtonHamid.getPreferredSize();
	      FlagButtonHamid.setBounds(300, 180, size5.width, size5.height);
	      FlagButtonHamid.setLocation(HamidXpos,HamidYpos);
	      FlagButtonHamid.setOpaque(false);
	      FlagButtonHamid.setBorderPainted(false); 
	      FlagButtonHamid.setContentAreaFilled(false); 
	      FlagButtonHamid.setFocusPainted(true);
	      FlagButtonHamid.addActionListener(e -> { 
	    	  EmpireStatsWindow.OpenEmpireStats(hamidian);
	 				 });
	 		     add(FlagButtonHamid);
	 		     
		JButton FlagButtonFredz;
			ImageIcon flagIcon2 = new ImageIcon("FredzFlag.png");
			FlagButtonFredz = new JButton(flagIcon2);	
		      Dimension size6 = FlagButtonHamid.getPreferredSize();
		      FlagButtonFredz.setBounds(300, 180, size6.width, size6.height);
		      FlagButtonFredz.setLocation(FredzXpos,FredzYpos);
		      FlagButtonFredz.setOpaque(false);
		      FlagButtonFredz.setBorderPainted(false); 
		      FlagButtonFredz.setContentAreaFilled(false); 
		      FlagButtonFredz.setFocusPainted(true);
		      FlagButtonFredz.addActionListener(e -> { 
		    	  EmpireStatsWindow.OpenEmpireStats(fredz);
				 });
		     add(FlagButtonFredz);
		     
				JButton FlagButtonTribes;
				ImageIcon flagIcon3 = new ImageIcon("TribesFlag.png");
				FlagButtonTribes = new JButton(flagIcon3);	
			      Dimension size7 = FlagButtonHamid.getPreferredSize();
			      FlagButtonTribes.setBounds(300, 180, size7.width, size7.height);
			      FlagButtonTribes.setLocation(TribesXpos,TribesYpos);
			      FlagButtonTribes.setOpaque(false);
			      FlagButtonTribes.setBorderPainted(false); 
			      FlagButtonTribes.setContentAreaFilled(false); 
			      FlagButtonTribes.setFocusPainted(true);
			      FlagButtonTribes.addActionListener(e -> { 
			    	  EmpireStatsWindow.OpenEmpireStats(tribes);
					 });
			     add(FlagButtonTribes);
			     
			  	JButton FlagButtonVulpine;
				ImageIcon flagIcon4 = new ImageIcon("VulpineEmpireFlag.png");
				FlagButtonVulpine = new JButton(flagIcon4);	
			      Dimension size8 = FlagButtonHamid.getPreferredSize();
			      FlagButtonVulpine.setBounds(300, 180, size8.width, size8.height);
			      FlagButtonVulpine.setLocation(VulpineXpos,VulpineYpos);
			      FlagButtonVulpine.setOpaque(false);
			      FlagButtonVulpine.setBorderPainted(false); 
			      FlagButtonVulpine.setContentAreaFilled(false); 
			      FlagButtonVulpine.setFocusPainted(true);
			      FlagButtonVulpine.addActionListener(e -> { 
			    	  EmpireStatsWindow.OpenEmpireStats(vulpine);
			    	  });
			     add(FlagButtonVulpine);
			     
			      JButton FlagButtonSandrisa;
					ImageIcon flagIcon5 = new ImageIcon("SandrisaFlag.jpg");
					FlagButtonSandrisa = new JButton(flagIcon5);	
				      Dimension size9 = FlagButtonHamid.getPreferredSize();
				      FlagButtonSandrisa.setBounds(300, 180, size9.width, size9.height);
				      FlagButtonSandrisa.setLocation(SandrisaXpos,SandrisaYpos);
				      FlagButtonSandrisa.setOpaque(false);
				      FlagButtonSandrisa.setBorderPainted(false); 
				      FlagButtonSandrisa.setContentAreaFilled(false); 
				      FlagButtonSandrisa.setFocusPainted(true);
				      FlagButtonSandrisa.addActionListener(e -> { 
				    	  EmpireStatsWindow.OpenEmpireStats(sandrisa);
				    	  });
				     add(FlagButtonSandrisa);
				     
				      JButton FlagButtonAlkoz;
						ImageIcon flagIcon6 = new ImageIcon("AlkozKingdomFlag.png");
						FlagButtonAlkoz = new JButton(flagIcon6);	
					      Dimension size10 = FlagButtonHamid.getPreferredSize();
					      FlagButtonAlkoz.setBounds(300, 180, size10.width, size10.height);
					      FlagButtonAlkoz.setLocation(AlkozXpos,AlkozYpos);
					      FlagButtonAlkoz.setOpaque(false);
					      FlagButtonAlkoz.setBorderPainted(false); 
					      FlagButtonAlkoz.setContentAreaFilled(false); 
					      FlagButtonAlkoz.setFocusPainted(true);
					      FlagButtonAlkoz.addActionListener(e -> { 
					    	  EmpireStatsWindow.OpenEmpireStats(alkoz);
							 });
					     add(FlagButtonAlkoz);
					     
					      JButton FlagButtonEast;
							ImageIcon flagIcon7 = new ImageIcon("EastfrrontUnionFlag.png");
							FlagButtonEast = new JButton(flagIcon7);	
						      Dimension size11 = FlagButtonHamid.getPreferredSize();
						      FlagButtonEast.setBounds(300, 180, size11.width, size11.height);
						      FlagButtonEast.setLocation(EastXpos,EastYpos);
						      FlagButtonEast.setOpaque(false);
						      FlagButtonEast.setBorderPainted(false); 
						      FlagButtonEast.setContentAreaFilled(false); 
						      FlagButtonEast.setFocusPainted(true);
						      FlagButtonEast.addActionListener(e -> { 
						    	  EmpireStatsWindow.OpenEmpireStats(eastfront);
								 });
						     add(FlagButtonEast);
						      
						      JButton FlagButtonEsc;
								ImageIcon flagIcon8 = new ImageIcon("EsctourKingdomFlag.jpg");
								FlagButtonEsc = new JButton(flagIcon8);	
							      Dimension size12 = FlagButtonHamid.getPreferredSize();
							      FlagButtonEsc.setBounds(300, 180, size12.width, size12.height);
							      FlagButtonEsc.setLocation(EscXpos,EscYpos);
							      FlagButtonEsc.setOpaque(false);
							      FlagButtonEsc.setBorderPainted(false); 
							      FlagButtonEsc.setContentAreaFilled(false); 
							      FlagButtonEsc.setFocusPainted(true);
							      FlagButtonEsc.addActionListener(e -> { 
							    	  EmpireStatsWindow.OpenEmpireStats(esctour);
									 });
							     add(FlagButtonEsc);
							      
							      JButton FlagButtonPadara;
									ImageIcon flagIcon9 = new ImageIcon("PadaraStateFlag.png");
									FlagButtonPadara = new JButton(flagIcon9);	
								      Dimension size13 = FlagButtonHamid.getPreferredSize();
								      FlagButtonPadara.setBounds(300, 180, size13.width, size13.height);
								      FlagButtonPadara.setLocation(PadaraXpos,PadaraYpos);
								      FlagButtonPadara.setOpaque(false);
								      FlagButtonPadara.setBorderPainted(false); 
								      FlagButtonPadara.setContentAreaFilled(false); 
								      FlagButtonPadara.setFocusPainted(true);
								      FlagButtonPadara.addActionListener(e -> { 
								    	  EmpireStatsWindow.OpenEmpireStats(padara);
										 });
								     add(FlagButtonPadara);
								     
								      JButton FlagButtonMilitary;
										ImageIcon flagIcon10 = new ImageIcon("MilitaryStateFlag.jpg");
										FlagButtonMilitary = new JButton(flagIcon10);	
									      Dimension size14 = FlagButtonHamid.getPreferredSize();
									      FlagButtonMilitary.setBounds(300, 180, size14.width, size14.height);
									      FlagButtonMilitary.setLocation(MilitaryXpos,MilitaryYpos);
									      FlagButtonMilitary.setOpaque(false);
									      FlagButtonMilitary.setBorderPainted(false); 
									      FlagButtonMilitary.setContentAreaFilled(false); 
									      FlagButtonMilitary.setFocusPainted(true);						      
									      FlagButtonMilitary.addActionListener(e -> { 
									    	  EmpireStatsWindow.OpenEmpireStats(military);
											 });
									     add(FlagButtonMilitary);
									      
									      JButton FlagButtonKrix;
											ImageIcon flagIcon11 = new ImageIcon("KrixxunKingdomFlag.jpg");
											FlagButtonKrix = new JButton(flagIcon11);	
										      Dimension size15 = FlagButtonHamid.getPreferredSize();
										      FlagButtonKrix.setBounds(300, 180, size15.width, size15.height);
										      FlagButtonKrix.setLocation(KrixXpos,KrixYpos);
										      FlagButtonKrix.setOpaque(false);
										      FlagButtonKrix.setBorderPainted(false); 
										      FlagButtonKrix.setContentAreaFilled(false); 
										      FlagButtonKrix.setFocusPainted(true);	    
										      FlagButtonKrix.addActionListener(e -> { 
										    	  EmpireStatsWindow.OpenEmpireStats(krixxun);
												 });
										     add(FlagButtonKrix);
										     
										      JButton FlagButtonZeon;
												ImageIcon flagIcon12 = new ImageIcon("ZeonRepublicFlag.png");
												FlagButtonZeon = new JButton(flagIcon12);	
											      Dimension size16 = FlagButtonHamid.getPreferredSize();
											      FlagButtonZeon.setBounds(300, 180, size16.width, size16.height);
											      FlagButtonZeon.setLocation(ZeonXpos,ZeonYpos);
											      FlagButtonZeon.setOpaque(false);
											      FlagButtonZeon.setBorderPainted(false); 
											      FlagButtonZeon.setContentAreaFilled(false); 
											      FlagButtonZeon.setFocusPainted(true);	
											      FlagButtonZeon.addActionListener(e -> { 
											    	  EmpireStatsWindow.OpenEmpireStats(zeon);
													 });
											     add(FlagButtonZeon);
											           
											      JButton FlagButtonPlayer;
													ImageIcon flagIcon13 = new ImageIcon(myEmpireWindow.flagChoice);
													FlagButtonPlayer = new JButton(flagIcon13);	
												      Dimension size17 = FlagButtonHamid.getPreferredSize();
												      FlagButtonPlayer.setBounds(300, 180, size17.width, size17.height);
												      FlagButtonPlayer.setLocation(playerXpos,playerYpos);
												      FlagButtonPlayer.setOpaque(false);
												      FlagButtonPlayer.setBorderPainted(false); 
												      FlagButtonPlayer.setContentAreaFilled(false); 
												      FlagButtonPlayer.setFocusPainted(true);	
												      FlagButtonPlayer.addActionListener(e -> { 
												    	  EmpireStatsWindow.OpenEmpireStats(player);
														 });
												     add(FlagButtonPlayer);
												     
        // Help Button
        JButton help;
        help = new JButton(" *Help* ");
	      Dimension size = help.getPreferredSize();
	      help.setBounds(300, 180, size.width, size.height);
	      help.setLocation(25,560);
	      help.setOpaque(false);
	      help.setBorderPainted(false); 
	      // help.setContentAreaFilled(false); 
	      help.setFocusPainted(false);
	      help.addActionListener(e -> { 
				WelcomeWindow.openWelcome();
			 });
	     add(help);
        
	     // stats on map - PUASED
	  JTextArea statsOnMap = new JTextArea(" Money: " + player.getMoney() +" $"
					+ "\n Population Morale: " + player.getPopulationMorale() + " ✿");
	     statsOnMap.setEditable(false);
	     statsOnMap.setBorder(null);
	     statsOnMap.setFont(new Font("SansSerif", Font.PLAIN, 20));
			 Dimension size3 = statsOnMap.getPreferredSize();
			 statsOnMap.setBounds(300, 180, size3.width, size3.height);
			 statsOnMap.setLocation(20,500);
			 statsOnMap.setOpaque(false);
			 statsOnMap.setForeground(Color.BLACK);
			 statsOnMap.setBackground(new Color(43, 116, 255));	     
	     
	     // Attack Button
	     JButton attack;
	     attack = new JButton("🏴 CONQUER 🏴");
		      attack.setBounds(300, 180, 165, 64);
		      attack.setLocation(25,644);
		      attack.setOpaque(false);
		      attack.setBorderPainted(false); 
		      // help.setContentAreaFilled(false); 
		      //attack.setFocusPainted(false);
		      attack.setFont(new Font("Monospaced", Font.BOLD, 17));
		    //  attack.setBackground(new Color(200,70,80));
		      attack.setForeground(new Color(109, 35, 32 ));
		      attack.addActionListener(e -> { 
					ConquerWindow.OpenConqWindow();
				 });
		     add(attack);
		     
		// Lore Button
		     JButton Lore;
		     Lore = new JButton("Lore 🔥");
		     Lore.setBounds(300, 180, size.width, size.height);
		     Lore.setLocation(115,560);
		     Lore.setOpaque(false);
		     Lore.setBorderPainted(false); 
			      // help.setContentAreaFilled(false); 
		     Lore.setFocusPainted(false);
		     Lore.addActionListener(e -> { 
					loreWindow.openLore();
				 });
			     add(Lore);	     
			     
		// Market Button
			JButton Market;
			Market = new JButton("💰 Market 💰");
			Market.setBounds(300, 180,  165, 44);
			Market.setLocation(25,595);
			Market.setOpaque(false);
			Market.setBorderPainted(false); 
		 // help.setContentAreaFilled(false); 
			Market.setFocusPainted(true);
			Market.setFont(new Font("Monospaced", Font.BOLD, 17));
			Market.setForeground(new Color(46, 165, 46));
			Market.addActionListener(e -> { 
			MarketWindow.OpenMarketWindow();
			 });
		add(Market);
		
		// Surrnder Button
		JButton Surrnder;
		Surrnder = new JButton("Surrnder 🏳️");
		Surrnder.setBounds(300, 180, 128, 24);
		Surrnder.setLocation(1232,12);
		// Surrnder.setOpaque(false);
		Surrnder.setBorderPainted(false); 
		 Surrnder.setContentAreaFilled(true); 
		Surrnder.setFocusPainted(false);
		Surrnder.setBackground(Color.white);
		Surrnder.setFont(new Font("Monospaced", Font.PLAIN, 15));
		Surrnder.setForeground(new Color(134, 106, 45));
		Surrnder.addActionListener(this);
	add(Surrnder);
	
	// IRL date
	    now = LocalDateTime.now();  
	   	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");  
	   IRLdate = new JTextField(dtf.format(now));
	   IRLdate.setBounds(300, 180, 195, 24);
	   IRLdate.setLocation(13,7);
	   IRLdate.setBorder(null);
	   IRLdate.setFocusable(false);
	   IRLdate.setEditable(false);
	   IRLdate.setOpaque(false);
	   IRLdate.setFont(new Font("Monospaced", Font.BOLD, 17));
	   IRLdate.setForeground(new Color(108, 0, 0 ));
   	add(IRLdate);

	// TIME TILL NEXT EVENT
	add(NextEventTimer.getTimer());
	add(NextYearTimer.getTimer());
	
		//frame refresher for conquers/IRLdate 
		Timer timer = new Timer();
		int begin = 1000;
		int timeInterval = 1000;

		timer.scheduleAtFixedRate(new TimerTask() {
		    @Override
		    public void run() {
				
		    	// IRL Date
		    	remove(IRLdate);
		   	    now = LocalDateTime.now();  
			 	   IRLdate.setText(dtf.format(now));

				// Conquer flag swaps
		    	if(Empire.JustConqured != null) {		    
			 		remove(FlagButtonHamid);
					remove(FlagButtonSandrisa);
					remove(FlagButtonPadara);
					remove(FlagButtonFredz);
					remove(FlagButtonAlkoz);
					remove(FlagButtonTribes);
					remove(FlagButtonEast);
					remove(FlagButtonMilitary);
					remove(FlagButtonEsc);
					remove(FlagButtonKrix);
					remove(FlagButtonVulpine);
					remove(FlagButtonZeon);
					remove(FlagButtonPlayer);
			         replaceFlag (Empire.JustConqured, Empire.gotConqured);
			       
			   
			         //here
			   	  if(hamidian.getIsAlive() == true) {
			   		add(FlagButtonHamid); }
			   	      if(fredz.getIsAlive() == true) {
			   	    	add(FlagButtonFredz); }
			   	      if(tribes.getIsAlive() == true) {
			   	    	add(FlagButtonTribes); }
			   	      if(vulpine.getIsAlive() == true) {
			   	    	add(FlagButtonVulpine); }
			   	      if(sandrisa.getIsAlive() == true) {
			   	    	add(FlagButtonSandrisa); }
			   	      if(alkoz.getIsAlive() == true) {
			   	    	add(FlagButtonAlkoz); }
			   	      if(eastfront.getIsAlive() == true) {
			   	    	add(FlagButtonEast);}
			   	      if(esctour.getIsAlive() == true) {
			   	    	add(FlagButtonEsc);}
			   	      if(padara.getIsAlive() == true) {
			   	    	add(FlagButtonPadara); }
			   	      if(military.getIsAlive() == true) {
			   	    	add(FlagButtonMilitary); }
			   	      if(krixxun.getIsAlive() == true) {
			   	    	add(FlagButtonKrix);}
			   	      if(zeon.getIsAlive() == true) {
			   	    	add(FlagButtonZeon); }
			   	      if(player.getIsAlive() == true) {
			   	    	add(FlagButtonPlayer);}  
				}
		    	
		        // to check for hamid invasion if they own esctour:
		         if( hamidian.ID == 13 && esctour.ID == 1) {
		        	 esctour.setID(13);
		        	 replaceFlag (player, esctour);
		         }
		         
		         // to check if player won
		         if( hamidian.ID == 13 && esctour.ID == 13 && zeon.ID == 13 && vulpine.ID == 13 && sandrisa.ID == 13 && padara.ID == 13
		        		 && tribes.ID == 13 && krixxun.ID == 13 && alkoz.ID == 13 && fredz.ID == 13 && eastfront.ID ==13 && military.ID == 13 
		        		 && winCheck == false) {
		        	 YouLostWindow.openWinScreen();
		        	 winCheck = true;
		         }
			         updateUI();
			         revalidate();
			         repaint();
				     	add(IRLdate);	
		    }
		}, begin, timeInterval);
		
		
	}

	public static void openGame() {
		JFrame MainWindow = new JFrame("Tussle!");
		MainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
		Container c = MainWindow.getContentPane();
		c.add(new TussleGame());
		MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainWindow.setResizable(false);
		MainWindow.setVisible(true);
	//	BufferedImage  mainwindowImg;
	//	mainwindowImg = new BufferedImage("folderICON.png");
	//	MainWindow.setIconImage(mainwindowImg);
		GameMusicField.loop(); 
	}

	// FLAGS SECTION
//	
//	public void showFlags() { // NOT USED METHOD
//	  if(hamidian.getIsAlive() == true) {
//      showFlag("EmpireFlag-Hamid.png", HamidXpos,HamidYpos); }
//      if(fredz.getIsAlive() == true) {
//      showFlag("FredzFlag.png", FredzXpos, FredzYpos); }
//      if(tribes.getIsAlive() == true) {
//      showFlag("TribesFlag.png", TribesXpos, TribesYpos); }
//      if(vulpine.getIsAlive() == true) {
//      showFlag("VulpineEmpireFlag.png", VulpineXpos, VulpineYpos); }
//      if(sandrisa.getIsAlive() == true) {
//      showFlag("SandrisaFlag.jpg", SandrisaXpos, SandrisaYpos); }
//      if(alkoz.getIsAlive() == true) {
//      showFlag("AlkozKingdomFlag.png", AlkozXpos, AlkozYpos); }
//      if(eastfront.getIsAlive() == true) {
//      showFlag("EastfrrontUnionFlag.png", EastXpos, EastYpos); }
//      if(esctour.getIsAlive() == true) {
//      showFlag("EsctourKingdomFlag.jpg", EscXpos, EscYpos); }
//      if(padara.getIsAlive() == true) {
//      showFlag("PadaraStateFlag.png", PadaraXpos, PadaraYpos); }
//      if(military.getIsAlive() == true) {
//      showFlag("MilitaryStateFlag.jpg", MilitaryXpos, MilitaryYpos); }
//      if(krixxun.getIsAlive() == true) {
//      showFlag("KrixxunKingdomFlag.jpg", KrixXpos,KrixYpos); }
//      if(zeon.getIsAlive() == true) {
//      showFlag("ZeonRepublicFlag.png", ZeonXpos, ZeonYpos); }
//      if(player.getIsAlive() == true) {
//      showFlag(myEmpireWindow.flagChoice, playerXpos,playerYpos); }
//	}
	
	public void showFlag(String s, int x, int y) {
		JButton FlagButton;
		ImageIcon flagIcon = new ImageIcon(s);
		FlagButton = new JButton(flagIcon);
	      Dimension size = FlagButton.getPreferredSize();
	      FlagButton.setBounds(300, 180, size.width, size.height);
	  	FlagButton.setLocation(x,y);
		FlagButton.setOpaque(false);
		FlagButton.setBorderPainted(false); 
		FlagButton.setContentAreaFilled(false); 
		FlagButton.setFocusPainted(true);
	
		FlagButton.addActionListener(e -> { 
			String r = myEmpireWindow.flagChoice;
			switch(s) {
			case"EmpireFlag-Hamid.png":
				EmpireStatsWindow.OpenEmpireStats(hamidian);
				break;
			case"FredzFlag.png":
				EmpireStatsWindow.OpenEmpireStats(fredz);
				break;
			case"TribesFlag.png":
				EmpireStatsWindow.OpenEmpireStats(tribes);
				break;
			case"VulpineEmpireFlag.png":
				EmpireStatsWindow.OpenEmpireStats(vulpine);
				break;
			case"SandrisaFlag.jpg":
				EmpireStatsWindow.OpenEmpireStats(sandrisa);
				break;
			case"AlkozKingdomFlag.png":
				EmpireStatsWindow.OpenEmpireStats(alkoz);
				break;
			case"EastfrrontUnionFlag.png":
				EmpireStatsWindow.OpenEmpireStats(eastfront);
				break;
			case"PadaraStateFlag.png":
				EmpireStatsWindow.OpenEmpireStats(padara);
				break;
			case"MilitaryStateFlag.jpg":
				EmpireStatsWindow.OpenEmpireStats(military);
				break;
			case"KrixxunKingdomFlag.jpg":
				EmpireStatsWindow.OpenEmpireStats(krixxun);
				break;
			case"EsctourKingdomFlag.jpg":
				EmpireStatsWindow.OpenEmpireStats(esctour);
				break;
			case"ZeonRepublicFlag.png":
				EmpireStatsWindow.OpenEmpireStats(zeon);
				break;
			case "flag1icon.png":
				EmpireStatsWindow.OpenEmpireStats(player);
				break;
			case "flag2icon.png":
				EmpireStatsWindow.OpenEmpireStats(player);
				break;
			case "flag3icon.png":
				EmpireStatsWindow.OpenEmpireStats(player);
				break;
			}
		});
			
	     add(FlagButton); 
	}
	
	public void replaceFlag(Empire conq, Empire conqed) {
		int XposHolder = 0;
		int YposHolder = 0;
		
		switch (conqed.getflagName()) {
		case"EmpireFlag-Hamid.png":
			XposHolder = HamidXpos;
			YposHolder = HamidYpos;
			break;
		case"FredzFlag.png":
			XposHolder = FredzXpos;
			YposHolder = FredzYpos;
			break;
		case"TribesFlag.png":
			XposHolder = TribesXpos;
			YposHolder = TribesYpos;
			break;
		case"VulpineEmpireFlag.png":
			XposHolder = VulpineXpos;
			YposHolder = VulpineYpos;
			break;
		case"SandrisaFlag.jpg":
			XposHolder = SandrisaXpos;
			YposHolder = SandrisaYpos;
			break;
		case"AlkozKingdomFlag.png":
			XposHolder = AlkozXpos;
			YposHolder = AlkozYpos;
			break;
		case"EastfrrontUnionFlag.png":
			XposHolder = EastXpos;
			YposHolder = EastYpos;
			break;
		case"PadaraStateFlag.png":
			XposHolder = PadaraXpos;
			YposHolder = PadaraYpos;
			break;
		case"MilitaryStateFlag.jpg":
			XposHolder = MilitaryXpos;
			YposHolder = MilitaryYpos;
			break;
		case"KrixxunKingdomFlag.jpg":
			XposHolder = KrixXpos;
			YposHolder = KrixYpos;
			break;
		case"EsctourKingdomFlag.jpg":
			XposHolder = EscXpos;
			YposHolder = EscYpos;
			break;
		case"ZeonRepublicFlag.png":
			XposHolder = ZeonXpos;
			YposHolder = ZeonYpos;
			break;
		case "flag1icon.png":
			XposHolder = playerXpos;
			YposHolder = playerYpos;
			break;
		case "flag2icon.png":
			XposHolder = playerXpos;
			YposHolder = playerYpos;
			break;
		case "flag3icon.png":
			XposHolder = playerXpos;
			YposHolder = playerYpos;
			break;
		}
		
		showFlag(conq.getflagName(), XposHolder,YposHolder);
	}
	
	// BORDERS SECTION
	 public void paintComponent(Graphics g) 
	    {
	        super.paintComponent(g);
	        ImageIcon map = new ImageIcon("World_Map.png");	        
	        g.drawImage(map.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	      
	       Stroke previousStroke = ((Graphics2D) g).getStroke();	 
	       ((Graphics2D) g).setStroke(new BasicStroke(2.0f));
	       
	        // empire 1: NORTH AMERICA 1
	       if(sandrisa.getIsAlive() == true) {
	        g.setColor(new Color(255,140,0));
	        g.drawOval(143, 87, 219, 138);}
	        if(sandrisa.getIsAlive() != true && sandrisa.ID == 13) {
	        	g.setColor(Color.red);
	        	  g.drawOval(143, 87, 219, 138); }
	        if(sandrisa.getIsAlive() != true &&  sandrisa.ID == 12) {
	        	g.setColor(Color.BLUE);
	        	  g.drawOval(143, 87, 219, 138);}
	        if(sandrisa.getIsAlive() != true &&  sandrisa.ID == 11) {
	        	g.setColor(Color.cyan);
	        	  g.drawOval(143, 87, 219, 138); }
	        if(sandrisa.getIsAlive() != true &&  sandrisa.ID == 10) {
	        	g.setColor(Color.white);
	        	  g.drawOval(143, 87, 219, 138); }
	        if(sandrisa.getIsAlive() != true &&  sandrisa.ID == 9) {
	        	g.setColor(Color.green);
	        	  g.drawOval(143, 87, 219, 138); }
	        if(sandrisa.getIsAlive() != true &&  sandrisa.ID == 8) {
	        	g.setColor(new Color(255,20,147));
	        	  g.drawOval(143, 87, 219, 138); }
	        if(sandrisa.getIsAlive() != true &&  sandrisa.ID == 7) {
	        	g.setColor(new Color(165,42,42));
	        	  g.drawOval(143, 87, 219, 138); }
	        if(sandrisa.getIsAlive() != true &&  sandrisa.ID == 6) {
	        	g.setColor(new Color(153,153,0));
	        	  g.drawOval(143, 87, 219, 138);}
	        if(sandrisa.getIsAlive() != true &&  sandrisa.ID == 5) {
	        	g.setColor(new Color(255,140,0));
	        	  g.drawOval(143, 87, 219, 138); }
	        if(sandrisa.getIsAlive() != true &&  sandrisa.ID == 4) {
	        	g.setColor(new Color(128,0,128));
	        	  g.drawOval(143, 87, 219, 138); }
	        if(sandrisa.getIsAlive() != true &&  sandrisa.ID == 3) {
	        	g.setColor(Color.GRAY);
	        	  g.drawOval(143, 87, 219, 138); }
	        if(sandrisa.getIsAlive() != true &&  sandrisa.ID == 2) {
	        	g.setColor(new Color(255,150,122));
	        	  g.drawOval(143, 87, 219, 138); }
	        if(sandrisa.getIsAlive() != true &&  sandrisa.ID == 1) {
	        	g.setColor(Color.black);
	        	  g.drawOval(143, 87, 219, 138); } 
	       
	        // empire 2: NORTH AMERICA 2
	       if(padara.getIsAlive() == true) {
	        g.setColor(new Color(255,20,147));
	        g.drawOval(185, 237, 149, 114);}
	        if(padara.getIsAlive() != true && padara.ID == 13) {
	        	g.setColor(Color.red);
	        	g.drawOval(185, 237, 149, 114); }
	        if(padara.getIsAlive() != true &&  padara.ID == 12) {
	        	g.setColor(Color.BLUE);
	        	g.drawOval(185, 237, 149, 114); }
	        if(padara.getIsAlive() != true &&  padara.ID == 11) {
	        	g.setColor(Color.cyan);
	        	g.drawOval(185, 237, 149, 114); }
	        if(padara.getIsAlive() != true &&  padara.ID == 10) {
	        	g.setColor(Color.white);
	        	g.drawOval(185, 237, 149, 114); }
	        if(padara.getIsAlive() != true &&  padara.ID == 9) {
	        	g.setColor(Color.green);
	        	g.drawOval(185, 237, 149, 114); }
	        if(padara.getIsAlive() != true &&  padara.ID == 8) {
	        	g.setColor(new Color(255,20,147));
	        	g.drawOval(185, 237, 149, 114);}
	        if(padara.getIsAlive() != true &&  padara.ID == 7) {
	        	g.setColor(new Color(165,42,42));
	        	g.drawOval(185, 237, 149, 114);}
	        if(padara.getIsAlive() != true &&  padara.ID == 6) {
	        	g.setColor(new Color(153,153,0));
	        	g.drawOval(185, 237, 149, 114); }
	        if(padara.getIsAlive() != true &&  padara.ID == 5) {
	        	g.setColor(new Color(255,140,0));
	        	g.drawOval(185, 237, 149, 114); }
	        if(padara.getIsAlive() != true &&  padara.ID == 4) {
	        	g.setColor(new Color(128,0,128));
	        	g.drawOval(185, 237, 149, 114);}
	        if(padara.getIsAlive() != true &&  padara.ID == 3) {
	        	g.setColor(Color.GRAY);
	        	g.drawOval(185, 237, 149, 114); }
	        if(padara.getIsAlive() != true &&  padara.ID == 2) {
	        	g.setColor(new Color(255,150,122));
	        	g.drawOval(185, 237, 149, 114); }
	        if(padara.getIsAlive() != true &&  padara.ID == 1) {
	        	g.setColor(Color.black);
	        	g.drawOval(185, 237, 149, 114);} 
	       
	        // empire 3: SOUTH AMERICA
	       if(fredz.getIsAlive() == true) {
	        g.setColor(new Color(255,150,122));
	        g.drawOval(350, 437, 149, 114); }
	        if(fredz.getIsAlive() != true && fredz.ID == 13) {
	        	g.setColor(Color.red);
	        	g.drawOval(350, 437, 149, 114); }
	        if(fredz.getIsAlive() != true &&  fredz.ID == 12) {
	        	g.setColor(Color.BLUE);
	        	g.drawOval(350, 437, 149, 114); }
	        if(fredz.getIsAlive() != true &&  fredz.ID == 11) {
	        	g.setColor(Color.cyan);
	        	g.drawOval(350, 437, 149, 114);}
	        if(fredz.getIsAlive() != true &&  fredz.ID == 10) {
	        	g.setColor(Color.white);
	        	g.drawOval(350, 437, 149, 114); }
	        if(fredz.getIsAlive() != true &&  fredz.ID == 9) {
	        	g.setColor(Color.green);
	        	g.drawOval(350, 437, 149, 114); }
	        if(fredz.getIsAlive() != true &&  fredz.ID == 8) {
	        	g.setColor(new Color(255,20,147));
	        	g.drawOval(350, 437, 149, 114); }
	        if(fredz.getIsAlive() != true &&  fredz.ID == 7) {
	        	g.setColor(new Color(165,42,42));
	        	g.drawOval(350, 437, 149, 114); }
	        if(fredz.getIsAlive() != true &&  fredz.ID == 6) {
	        	g.setColor(new Color(153,153,0));
	        	g.drawOval(350, 437, 149, 114); }
	        if(fredz.getIsAlive() != true &&  fredz.ID == 5) {
	        	g.setColor(new Color(255,140,0));
	        	g.drawOval(350, 437, 149, 114); }
	        if(fredz.getIsAlive() != true &&  fredz.ID == 4) {
	        	g.setColor(new Color(128,0,128));
	        	g.drawOval(350, 437, 149, 114);}
	        if(fredz.getIsAlive() != true &&  fredz.ID == 3) {
	        	g.setColor(Color.GRAY);
	        	g.drawOval(350, 437, 149, 114); }
	        if(fredz.getIsAlive() != true &&  fredz.ID == 2) {
	        	g.setColor(new Color(255,150,122));
	        	g.drawOval(350, 437, 149, 114); }
	        if(fredz.getIsAlive() != true &&  fredz.ID == 1) {
	        	g.setColor(Color.black);
	        	g.drawOval(350, 437, 149, 114); } 
	       
	        // empire 4: AUSTERLIA
	       if(alkoz.getIsAlive() == true) {
	        g.setColor(new Color(153,153,0));
	        g.drawOval(1070, 533, 135, 72);}
	        if(alkoz.getIsAlive() != true && alkoz.ID == 13) {
	        	g.setColor(Color.red);
	        	g.drawOval(1070, 533, 135, 72); }
	        if(alkoz.getIsAlive() != true &&  alkoz.ID == 12) {
	        	g.setColor(Color.BLUE);
	        	g.drawOval(1070, 533, 135, 72);}
	        if(alkoz.getIsAlive() != true &&  alkoz.ID == 11) {
	        	g.setColor(Color.cyan);
	        	g.drawOval(1070, 533, 135, 72); }
	        if(alkoz.getIsAlive() != true &&  alkoz.ID == 10) {
	        	g.setColor(Color.white);
	        	g.drawOval(1070, 533, 135, 72);}
	        if(alkoz.getIsAlive() != true &&  alkoz.ID == 9) {
	        	g.setColor(Color.green);
	        	g.drawOval(1070, 533, 135, 72); }
	        if(alkoz.getIsAlive() != true &&  alkoz.ID == 8) {
	        	g.setColor(new Color(255,20,147));
	        	g.drawOval(1070, 533, 135, 72); }
	        if(alkoz.getIsAlive() != true &&  alkoz.ID == 7) {
	        	g.setColor(new Color(165,42,42));
	        	g.drawOval(1070, 533, 135, 72); }
	        if(alkoz.getIsAlive() != true &&  alkoz.ID == 6) {
	        	g.setColor(new Color(153,153,0));
	        	g.drawOval(1070, 533, 135, 72); }
	        if(alkoz.getIsAlive() != true &&  alkoz.ID == 5) {
	        	g.setColor(new Color(255,140,0));
	        	g.drawOval(1070, 533, 135, 72);}
	        if(alkoz.getIsAlive() != true &&  alkoz.ID == 4) {
	        	g.setColor(new Color(128,0,128));
	        	g.drawOval(1070, 533, 135, 72); }
	        if(alkoz.getIsAlive() != true &&  alkoz.ID == 3) {
	        	g.setColor(Color.GRAY);
	        	g.drawOval(1070, 533, 135, 72); }
	        if(alkoz.getIsAlive() != true &&  alkoz.ID == 2) {
	        	g.setColor(new Color(255,150,122));
	        	g.drawOval(1070, 533, 135, 72);}
	        if(alkoz.getIsAlive() != true &&  alkoz.ID == 1) {
	        	g.setColor(Color.black);
	        	g.drawOval(1070, 533, 135, 72); }
	        
	        // empire 5: Africa 1
	       if(tribes.getIsAlive() == true) {
	        g.setColor(Color.GRAY);
	        g.drawOval(680, 433, 105, 162);}
	        if(tribes.getIsAlive() != true && tribes.ID == 13) {
	        	g.setColor(Color.red);
	        	 g.drawOval(680, 433, 105, 162); }
	        if(tribes.getIsAlive() != true &&  tribes.ID == 12) {
	        	g.setColor(Color.BLUE);
	        	 g.drawOval(680, 433, 105, 162); }
	        if(tribes.getIsAlive() != true &&  tribes.ID == 11) {
	        	g.setColor(Color.cyan);
	        	 g.drawOval(680, 433, 105, 162); }
	        if(tribes.getIsAlive() != true &&  tribes.ID == 10) {
	        	g.setColor(Color.white);
	        	 g.drawOval(680, 433, 105, 162);}
	        if(tribes.getIsAlive() != true &&  tribes.ID == 9) {
	        	g.setColor(Color.green);
	        	 g.drawOval(680, 433, 105, 162); }
	        if(tribes.getIsAlive() != true &&  tribes.ID == 8) {
	        	g.setColor(new Color(255,20,147));
	        	 g.drawOval(680, 433, 105, 162); }
	        if(tribes.getIsAlive() != true &&  tribes.ID == 7) {
	        	g.setColor(new Color(165,42,42));
	        	 g.drawOval(680, 433, 105, 162); }
	        if(tribes.getIsAlive() != true &&  tribes.ID == 6) {
	        	g.setColor(new Color(153,153,0));
	        	 g.drawOval(680, 433, 105, 162); }
	        if(tribes.getIsAlive() != true &&  tribes.ID == 5) {
	        	g.setColor(new Color(255,140,0));
	        	 g.drawOval(680, 433, 105, 162); }
	        if(tribes.getIsAlive() != true &&  tribes.ID == 4) {
	        	g.setColor(new Color(128,0,128));
	        	 g.drawOval(680, 433, 105, 162); }
	        if(tribes.getIsAlive() != true &&  tribes.ID == 3) {
	        	g.setColor(Color.GRAY);
	        	 g.drawOval(680, 433, 105, 162); }
	        if(tribes.getIsAlive() != true &&  tribes.ID == 2) {
	        	g.setColor(new Color(255,150,122));
	        	 g.drawOval(680, 433, 105, 162);}
	        if(tribes.getIsAlive() != true &&  tribes.ID == 1) {
	        	g.setColor(Color.black);
	        	 g.drawOval(680, 433, 105, 162); } 
	       
	        // empire 6: Africa 2
	       if(krixxun.getIsAlive() == true) {
	        g.setColor(Color.WHITE);
	        g.drawOval(590, 328, 135, 72);}
	        if(krixxun.getIsAlive() != true && krixxun.ID == 13) {
	        	g.setColor(Color.red);
	        	g.drawOval(590, 328, 135, 72); }
	        if(krixxun.getIsAlive() != true &&  krixxun.ID == 12) {
	        	g.setColor(Color.BLUE);
	        	g.drawOval(590, 328, 135, 72); }
	        if(krixxun.getIsAlive() != true &&  krixxun.ID == 11) {
	        	g.setColor(Color.cyan);
	        	g.drawOval(590, 328, 135, 72);}
	        if(krixxun.getIsAlive() != true &&  krixxun.ID == 10) {
	        	g.setColor(Color.white);
	        	g.drawOval(590, 328, 135, 72); }
	        if(krixxun.getIsAlive() != true &&  krixxun.ID == 9) {
	        	g.setColor(Color.green);
	        	g.drawOval(590, 328, 135, 72); }
	        if(krixxun.getIsAlive() != true &&  krixxun.ID == 8) {
	        	g.setColor(new Color(255,20,147));
	        	g.drawOval(590, 328, 135, 72);}
	        if(krixxun.getIsAlive() != true &&  krixxun.ID == 7) {
	        	g.setColor(new Color(165,42,42));
	        	g.drawOval(590, 328, 135, 72); }
	        if(krixxun.getIsAlive() != true &&  krixxun.ID == 6) {
	        	g.setColor(new Color(153,153,0));
	        	g.drawOval(590, 328, 135, 72); }
	        if(krixxun.getIsAlive() != true &&  krixxun.ID == 5) {
	        	g.setColor(new Color(255,140,0));
	        	g.drawOval(590, 328, 135, 72); }
	        if(krixxun.getIsAlive() != true &&  krixxun.ID == 4) {
	        	g.setColor(new Color(128,0,128));
	        	g.drawOval(590, 328, 135, 72); }
	        if(krixxun.getIsAlive() != true &&  krixxun.ID == 3) {
	        	g.setColor(Color.GRAY);
	        	g.drawOval(590, 328, 135, 72); }
	        if(krixxun.getIsAlive() != true &&  krixxun.ID == 2) {
	        	g.setColor(new Color(255,150,122));
	        	g.drawOval(590, 328, 135, 72); }
	        if(krixxun.getIsAlive() != true &&  krixxun.ID == 1) {
	        	g.setColor(Color.black);
	        	g.drawOval(590, 328, 135, 72); } 
	       
	        //empire 7: Africa 3
	        if(esctour.getIsAlive() == true) {
	        g.setColor(Color.cyan);
	        g.drawOval(725, 361, 77, 54); }
	        if(esctour.getIsAlive() != true && esctour.ID == 13) {
	        	g.setColor(Color.red);
		        g.drawOval(725, 361, 77, 54); }
	        if(esctour.getIsAlive() != true &&  esctour.ID == 12) {
	        	g.setColor(Color.BLUE);
		        g.drawOval(725, 361, 77, 54); }
	        if(esctour.getIsAlive() != true &&  esctour.ID == 11) {
	        	g.setColor(Color.cyan);
		        g.drawOval(725, 361, 77, 54); }
	        if(esctour.getIsAlive() != true &&  esctour.ID == 10) {
	        	g.setColor(Color.white);
		        g.drawOval(725, 361, 77, 54); }
	        if(esctour.getIsAlive() != true &&  esctour.ID == 9) {
	        	g.setColor(Color.green);
		        g.drawOval(725, 361, 77, 54); }
	        if(esctour.getIsAlive() != true &&  esctour.ID == 8) {
	        	g.setColor(new Color(255,20,147));
		        g.drawOval(725, 361, 77, 54); }
	        if(esctour.getIsAlive() != true &&  esctour.ID == 7) {
	        	g.setColor(new Color(165,42,42));
		        g.drawOval(725, 361, 77, 54); }
	        if(esctour.getIsAlive() != true &&  esctour.ID == 6) {
	        	g.setColor(new Color(153,153,0));
		        g.drawOval(725, 361, 77, 54); }
	        if(esctour.getIsAlive() != true &&  esctour.ID == 5) {
	        	g.setColor(new Color(255,140,0));
		        g.drawOval(725, 361, 77, 54); }
	        if(esctour.getIsAlive() != true &&  esctour.ID == 4) {
	        	g.setColor(new Color(128,0,128));
		        g.drawOval(725, 361, 77, 54); }
	        if(esctour.getIsAlive() != true &&  esctour.ID == 3) {
	        	g.setColor(Color.GRAY);
		        g.drawOval(725, 361, 77, 54); }
	        if(esctour.getIsAlive() != true &&  esctour.ID == 2) {
	        	g.setColor(new Color(255,150,122));
		        g.drawOval(725, 361, 77, 54); }
	        if(esctour.getIsAlive() != true &&  esctour.ID == 1) {
	        	g.setColor(Color.black);
		        g.drawOval(725, 361, 77, 54); }
	        
	        //empire 8: Middle East 
	        if(hamidian.getIsAlive() == true) {
	        	g.setColor(Color.black);
		        g.drawOval(696, 255, 140, 90);}
	        if(hamidian.getIsAlive() != true && hamidian.ID == 13) {
	        	g.setColor(Color.red);
		        g.drawOval(688, 255, 150, 100);}

	        if(hamidian.getIsAlive() != true &&  hamidian.ID == 12) {
	        	g.setColor(Color.BLUE);
		        g.drawOval(688, 255, 150, 100);}

	        if(hamidian.getIsAlive() != true &&  hamidian.ID == 11) {
	        	g.setColor(Color.cyan);
	        	g.drawLine(715,328, 780, 330);
		        g.drawOval(688, 255, 150, 100);}

	        if(hamidian.getIsAlive() != true &&  hamidian.ID == 10) {
	        	g.setColor(Color.white);
		        g.drawOval(688, 255, 150, 100);}

	        if(hamidian.getIsAlive() != true &&  hamidian.ID == 9) {
	        	g.setColor(Color.green);
		        g.drawOval(688, 255, 150, 100);}

	        if(hamidian.getIsAlive() != true &&  hamidian.ID == 8) {
	        	g.setColor(new Color(255,20,147));
		        g.drawOval(688, 255, 150, 100);}

	        if(hamidian.getIsAlive() != true &&  hamidian.ID == 7) {
	        	g.setColor(new Color(165,42,42));
		        g.drawOval(688, 255, 150, 100);}

	        if(hamidian.getIsAlive() != true &&  hamidian.ID == 6) {
	        	g.setColor(new Color(153,153,0));
		        g.drawOval(688, 255, 150, 100);}

	        if(hamidian.getIsAlive() != true &&  hamidian.ID == 5) {
	        	g.setColor(new Color(255,140,0));
		        g.drawOval(688, 255, 150, 100);}

	        if(hamidian.getIsAlive() != true &&  hamidian.ID == 4) {
	        	g.setColor(new Color(128,0,128));
		        g.drawOval(688, 255, 150, 100);}

	        if(hamidian.getIsAlive() != true &&  hamidian.ID == 3) {
	        	g.setColor(Color.GRAY);
		        g.drawOval(688, 255, 150, 100);}

	        if(hamidian.getIsAlive() != true &&  hamidian.ID == 2) {
	        	g.setColor(new Color(255,150,122));
		        g.drawOval(688, 255, 150, 100);}

	        if(hamidian.getIsAlive() != true &&  hamidian.ID == 1) {
	        	g.setColor(Color.black);
		        g.drawOval(688, 255, 150, 100);}

	        if(hamidian.getIsAlive() != true &&  hamidian.ID == 13 & esctour.ID == 1) {
	        	g.setColor(Color.red);
		        g.drawOval(688, 255, 150, 100);}


	        // empire 9: Asia 1
	        if(military.getIsAlive() == true) {
	        g.setColor(Color.green);
	        g.drawOval(1030, 67, 148, 148); }
	        if(military.getIsAlive() != true && military.ID == 13) {
	        	g.setColor(Color.red);
	            g.drawOval(1030, 67, 148, 148);  }
	        if(military.getIsAlive() != true &&  military.ID == 12) {
	        	g.setColor(Color.BLUE);
	            g.drawOval(1030, 67, 148, 148); }
	        if(military.getIsAlive() != true &&  military.ID == 11) {
	        	g.setColor(Color.cyan);
	            g.drawOval(1030, 67, 148, 148); }
	        if(military.getIsAlive() != true &&  military.ID == 10) {
	        	g.setColor(Color.white);
	            g.drawOval(1030, 67, 148, 148);  }
	        if(military.getIsAlive() != true &&  military.ID == 9) {
	        	g.setColor(Color.green);
	            g.drawOval(1030, 67, 148, 148); }
	        if(military.getIsAlive() != true &&  military.ID == 8) {
	        	g.setColor(new Color(255,20,147));
	            g.drawOval(1030, 67, 148, 148); }
	        if(military.getIsAlive() != true &&  military.ID == 7) {
	        	g.setColor(new Color(165,42,42));
	            g.drawOval(1030, 67, 148, 148); }
	        if(military.getIsAlive() != true &&  military.ID == 6) {
	        	g.setColor(new Color(153,153,0));
	            g.drawOval(1030, 67, 148, 148); }
	        if(military.getIsAlive() != true &&  military.ID == 5) {
	        	g.setColor(new Color(255,140,0));
	            g.drawOval(1030, 67, 148, 148); }
	        if(military.getIsAlive() != true &&  military.ID == 4) {
	        	g.setColor(new Color(128,0,128));
	            g.drawOval(1030, 67, 148, 148); }
	        if(military.getIsAlive() != true &&  military.ID == 3) {
	        	g.setColor(Color.GRAY);
	            g.drawOval(1030, 67, 148, 148); }
	        if(military.getIsAlive() != true &&  military.ID == 2) {
	        	g.setColor(new Color(255,150,122));
	            g.drawOval(1030, 67, 148, 148); }
	        if(military.getIsAlive() != true &&  military.ID == 1) {
	        	g.setColor(Color.black);
	            g.drawOval(1030, 67, 148, 148); }
	        
	        // empire 10: Asia 2
	        if(eastfront.getIsAlive() == true) {
	        g.setColor(new Color(165,42,42));
	        g.drawOval(879, 242, 205, 78); }
			        if(eastfront.getIsAlive() != true && eastfront.ID == 13) {
			        	g.setColor(Color.red);
			        	g.drawOval(879, 242, 205, 78);  }
			        if(eastfront.getIsAlive() != true &&  eastfront.ID == 12) {
			        	g.setColor(Color.BLUE);
			        	g.drawOval(879, 242, 205, 78);  }
			        if(eastfront.getIsAlive() != true &&  eastfront.ID == 11) {
			        	g.setColor(Color.cyan);
			        	g.drawOval(879, 242, 205, 78);  }
			        if(eastfront.getIsAlive() != true &&  eastfront.ID == 10) {
			        	g.setColor(Color.white);
			        	g.drawOval(879, 242, 205, 78);  }
			        if(eastfront.getIsAlive() != true &&  eastfront.ID == 9) {
			        	g.setColor(Color.green);
			        	g.drawOval(879, 242, 205, 78);  }
			        if(eastfront.getIsAlive() != true &&  eastfront.ID == 8) {
			        	g.setColor(new Color(255,20,147));
			        	g.drawOval(879, 242, 205, 78);  }
			        if(eastfront.getIsAlive() != true &&  eastfront.ID == 7) {
			        	g.setColor(new Color(165,42,42));
			        	g.drawOval(879, 242, 205, 78); }
			        if(eastfront.getIsAlive() != true &&  eastfront.ID == 6) {
			        	g.setColor(new Color(153,153,0));
			        	g.drawOval(879, 242, 205, 78);  }
			        if(eastfront.getIsAlive() != true &&  eastfront.ID == 5) {
			        	g.setColor(new Color(255,140,0));
			        	g.drawOval(879, 242, 205, 78); }
			        if(eastfront.getIsAlive() != true &&  eastfront.ID == 4) {
			        	g.setColor(new Color(128,0,128));
			        	g.drawOval(879, 242, 205, 78); }
			        if(eastfront.getIsAlive() != true &&  eastfront.ID == 3) {
			        	g.setColor(Color.GRAY);
			        	g.drawOval(879, 242, 205, 78); }
			        if(eastfront.getIsAlive() != true &&  eastfront.ID == 2) {
			        	g.setColor(new Color(255,150,122));
			        	g.drawOval(879, 242, 205, 78); }
			        if(eastfront.getIsAlive() != true &&  eastfront.ID == 1) {
			        	g.setColor(Color.black);
			        	g.drawOval(879, 242, 205, 78); }
	        
	        // Empire 11: Asia 3 
	       if(zeon.getIsAlive() == true) {
	        g.setColor(Color.BLUE);
	        g.drawOval(820, 78, 72, 69); }
	        if(zeon.getIsAlive() != true && zeon.ID == 13) {
	        	g.setColor(Color.red);
	        	g.drawOval(820, 78, 72, 69); }
	        if(zeon.getIsAlive() != true &&  zeon.ID == 12) {
	        	g.setColor(Color.BLUE);
	        	g.drawOval(820, 78, 72, 69); }
	        if(zeon.getIsAlive() != true &&  zeon.ID == 11) {
	        	g.setColor(Color.cyan);
	        	g.drawOval(820, 78, 72, 69); }
	        if(zeon.getIsAlive() != true &&  zeon.ID == 10) {
	        	g.setColor(Color.white);
	        	g.drawOval(820, 78, 72, 69); }
	        if(zeon.getIsAlive() != true &&  zeon.ID == 9) {
	        	g.setColor(Color.green);
	        	g.drawOval(820, 78, 72, 69); }
	        if(zeon.getIsAlive() != true &&  zeon.ID == 8) {
	        	g.setColor(new Color(255,20,147));
	        	g.drawOval(820, 78, 72, 69); }
	        if(zeon.getIsAlive() != true &&  zeon.ID == 7) {
	        	g.setColor(new Color(165,42,42));
	        	g.drawOval(820, 78, 72, 69);}
	        if(zeon.getIsAlive() != true &&  zeon.ID == 6) {
	        	g.setColor(new Color(153,153,0));
	        	g.drawOval(820, 78, 72, 69); }
	        if(zeon.getIsAlive() != true &&  zeon.ID == 5) {
	        	g.setColor(new Color(255,140,0));
	        	g.drawOval(820, 78, 72, 69); }
	        if(zeon.getIsAlive() != true &&  zeon.ID == 4) {
	        	g.setColor(new Color(128,0,128));
	        	g.drawOval(820, 78, 72, 69);}
	        if(zeon.getIsAlive() != true &&  zeon.ID == 3) {
	        	g.setColor(Color.GRAY);
	        	g.drawOval(820, 78, 72, 69);}
	        if(zeon.getIsAlive() != true &&  zeon.ID == 2) {
	        	g.setColor(new Color(255,150,122));
	        	g.drawOval(820, 78, 72, 69);}
	        if(zeon.getIsAlive() != true &&  zeon.ID == 1) {
	        	g.setColor(Color.black);
	        	g.drawOval(820, 78, 72, 69);}
	        
	        // empire 12: EU1
	       if(vulpine.getIsAlive() == true) {
	        g.setColor(new Color(128,0,128));
	        g.drawOval(576, 140, 287, 54);}
	        if(vulpine.getIsAlive() != true && vulpine.ID == 13) {
	        	g.setColor(Color.red);
	        	 g.drawOval(576, 140, 287, 54); }
	        if(vulpine.getIsAlive() != true &&  vulpine.ID == 12) {
	        	g.setColor(Color.BLUE);
	        	 g.drawOval(576, 140, 287, 54); }
	        if(vulpine.getIsAlive() != true &&  vulpine.ID == 11) {
	        	g.setColor(Color.cyan);
	        	 g.drawOval(576, 140, 287, 54); }
	        if(vulpine.getIsAlive() != true &&  vulpine.ID == 10) {
	        	g.setColor(Color.white);
	        	 g.drawOval(576, 140, 287, 54); }
	        if(vulpine.getIsAlive() != true &&  vulpine.ID == 9) {
	        	g.setColor(Color.green);
	        	 g.drawOval(576, 140, 287, 54); }
	        if(vulpine.getIsAlive() != true &&  vulpine.ID == 8) {
	        	g.setColor(new Color(255,20,147));
	        	 g.drawOval(576, 140, 287, 54); }
	        if(vulpine.getIsAlive() != true &&  vulpine.ID == 7) {
	        	g.setColor(new Color(165,42,42));
	        	 g.drawOval(576, 140, 287, 54);}
	        if(vulpine.getIsAlive() != true &&  vulpine.ID == 6) {
	        	g.setColor(new Color(153,153,0));
	        	 g.drawOval(576, 140, 287, 54); }
	        if(vulpine.getIsAlive() != true &&  vulpine.ID == 5) {
	        	g.setColor(new Color(255,140,0));
	        	 g.drawOval(576, 140, 287, 54); }
	        if(vulpine.getIsAlive() != true &&  vulpine.ID == 4) {
	        	g.setColor(new Color(128,0,128));
	        	 g.drawOval(576, 140, 287, 54); }
	        if(vulpine.getIsAlive() != true &&  vulpine.ID == 3) {
	        	g.setColor(Color.GRAY);
	        	 g.drawOval(576, 140, 287, 54);}
	        if(vulpine.getIsAlive() != true &&  vulpine.ID == 2) {
	        	g.setColor(new Color(255,150,122));
	        	 g.drawOval(576, 140, 287, 54);}
	        if(vulpine.getIsAlive() != true &&  vulpine.ID == 1) {
	        	g.setColor(Color.black);
	        	 g.drawOval(576, 140, 287, 54);}
	        
	        // empire 13: Player
	        g.setColor(Color.RED);
	        g.drawOval(891, 115, 115, 116);
	            
	    }
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(1);
		
	}
	
	
	public static void main(String[] args) {
		openGame();
	}
}
