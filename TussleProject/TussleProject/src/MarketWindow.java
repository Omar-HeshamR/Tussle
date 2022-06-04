import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MarketWindow extends JPanel implements ActionListener{

	Color BackgroundColor = new Color(138, 255, 138);
	private static JFrame MarketWindow = new JFrame("💰 Market 💰");
	private JButton goBack;
	private JTextArea deals;
	
	public MarketWindow() {
		setBackground(BackgroundColor);
		setLayout(null);
		
		// deals lol
		deals = new JTextArea(" Pay 15,000,000$ -->  FoodStocks +2"
				+ "\n --------------------------------------------------------------------------------"
				+ "\n RECOURCES:"
				+ "\n Pay 20,000,000$ --> Oil +15 "
				+ "\n\n Pay 10,000,000$ --> Coal +10"
				+ "\n\n Pay 10,000,000$ --> Wood +24"
				+ "\n\n Pay 13,500,000$ --> Metal +10"
				+ "\n --------------------------------------------------------------------------------"
				+ "\n MILITARY:"
				+ "\n Pay 27,500,000$ for technical engineers --> Tech Level + 1"
				+ "\n\n Pay 51,000,000$ + 26 metal --> Guns +1m"
				+ "\n\n Pay 36,000,000$ + 11 coal + 31 oil + 12 Metal--> Tanks +42"
				+ "\n\n Pay 60,000,000$ + 13 wood + 16 metal + 19 oil --> Planes +20"
				+ "\n\n Pay 30,000,000$ + 28 wood + 13 metal + 20 coal --> Ships +30"
				+ "\n   --------------------------------------------------------------------------------");
		
		deals.setEditable(false);
		deals.setBorder(null);
		deals.setFont(new Font("SansSerif", Font.PLAIN, 20));
		 Dimension size3 = deals.getPreferredSize();
		 deals.setBounds(300, 180, size3.width, size3.height);
		 deals.setLocation(20,15);
		 deals.setOpaque(false);
		 deals.setForeground(Color.BLACK);
		 deals.setBackground(new Color(43, 116, 255));
	     add(deals);
	     
	     //Trade buttons
	     makeTradeButton("Trade 🍎🍎", 15);
	     makeTradeButton("Trade 🛢🛢", 85);
	     makeTradeButton("Trade ⛏⛏", 140);
	     makeTradeButton("Trade 🌳🌳", 195);
	     makeTradeButton("Trade 🔩🔩", 250);
	     makeTradeButton("Trade 🔬🔬", 320);
	     makeTradeButton("Trade 🔫🔫", 375);
	     makeTradeButton("Trade 🚓🚓", 430);
	     makeTradeButton(" Trade ✈✈️", 485);
	     makeTradeButton("Trade 🚢🚢", 540);


	     
	     //go back perhaps
		goBack = new JButton(" $💸 Done Dealing 💸$ ");
		goBack.setBackground(new Color(255, 170, 0));
		 Dimension size = goBack.getPreferredSize();
		 goBack.setBounds(300, 180, size.width, size.height);
		 goBack.setLocation(350,600);
		 goBack.addActionListener(e -> { 
			MarketWindow.dispose();
			});
		add(goBack);
	}
	
	public void makeTradeButton(String s, int y) {
		JButton TradeButton;
		TradeButton = new JButton(s);
	      Dimension size = TradeButton.getPreferredSize();
	      TradeButton.setBounds(300, 180, 119, 38);
	      TradeButton.setLocation(745,y);
	    //  TradeButton.setOpaque(false);
	      TradeButton.setBorderPainted(false); 
	      TradeButton.setForeground(new Color(195, 198, 44));
	      TradeButton.setBackground(new Color(84, 71, 66 ));
	    //  TradeButton.setContentAreaFilled(false); 
	    //  TradeButton.setFocusPainted(false);
	      TradeButton.addActionListener(e -> { 
	    	  switch(s) {
	    	  case"Trade 🍎🍎":
	    		if(TussleGame.player.getMoney() < 15000000) {
	    			ErrorWindow.openError();
	    		}
	    		 else if( TussleGame.player.getFoodStocks() >= 100) {
		    			ErrorWindow.openError2();
	     		  }
	    		else {
	    		  TussleGame.player.setMoney(TussleGame.player.getMoney() - 15000000);
	    		 TussleGame.player.setFoodStocks(TussleGame.player.getFoodStocks() + 2); }
	    		  break;
	    		  
	    	  case"Trade 🛢🛢":
	    			if(TussleGame.player.getMoney() < 20000000) {
		    			ErrorWindow.openError();
		    		}
	    			else {
	    			 TussleGame.player.setMoney(TussleGame.player.getMoney() - 20000000);
		    		 TussleGame.player.setRecources(4, TussleGame.player.getRecources(4) + 15); }
	    		  break;
	    		  
	    	  case"Trade ⛏⛏":
	    		  if(TussleGame.player.getMoney() < 10000000) {
		    			ErrorWindow.openError();
		    		}
	    		  else {
	    		  TussleGame.player.setMoney(TussleGame.player.getMoney() - 10000000);
		    		 TussleGame.player.setRecources(3, TussleGame.player.getRecources(3) + 10); }
		    		 break;
		    		 
	    	  case"Trade 🌳🌳":
	    		  if(TussleGame.player.getMoney() < 10000000) {
		    			ErrorWindow.openError();
		    		}
	    		  else {
	    		  TussleGame.player.setMoney(TussleGame.player.getMoney() - 10000000);
		    		 TussleGame.player.setRecources(1, TussleGame.player.getRecources(1) + 24); }
		    		 break;
		    		 
	    	  case"Trade 🔩🔩":
	    		  if(TussleGame.player.getMoney() < 13500000) {
		    			ErrorWindow.openError();
		    		}
	    		  else {
	    		  TussleGame.player.setMoney(TussleGame.player.getMoney() - 13500000);
		    		 TussleGame.player.setRecources(2, TussleGame.player.getRecources(2) + 10);	  }
		    		 break;
		    		 
	    	  case"Trade 🔬🔬":
	     		  if(TussleGame.player.getMoney() < 27500000) {
		    			ErrorWindow.openError();
		    		}
	     		  else if( TussleGame.player.getTechLevel() >= 100) {
		    			ErrorWindow.openError2();
	     		  }
	    		  else {
	    		  TussleGame.player.setMoney(TussleGame.player.getMoney() - 27500000);
		    		 TussleGame.player.setTechLevel( TussleGame.player.getTechLevel() + 1);	  }	    		
	     		  break;
	     		  
	    	  case"Trade 🔫🔫":
	    		  if(TussleGame.player.getMoney() < 51000000 || TussleGame.player.getRecources(2) < 26) {
		    			ErrorWindow.openError();
		    		}
	    		  else {
	    		  TussleGame.player.setMoney(TussleGame.player.getMoney() - 51000000); 
	    		  TussleGame.player.setRecources(2, TussleGame.player.getRecources(2) - 26);
	    		  TussleGame.player.setWeaponry(1, TussleGame.player.getWeaponry(1) + 1);
	    		  }
	    		  break;
	    		  
	    	  case"Trade 🚓🚓":
	    		  if(TussleGame.player.getMoney() < 36000000 || TussleGame.player.getRecources(3) < 11|| TussleGame.player.getRecources(4) < 31 || TussleGame.player.getRecources(2) < 12) {
		    			ErrorWindow.openError();
	    		  }
	    		  else {
	    			  TussleGame.player.setMoney(TussleGame.player.getMoney() - 36000000);
	    			  TussleGame.player.setRecources(3, TussleGame.player.getRecources(3) - 11);
	    			  TussleGame.player.setRecources(4, TussleGame.player.getRecources(4) - 31);
	    			  TussleGame.player.setRecources(2, TussleGame.player.getRecources(2) - 12);
	    			  TussleGame.player.setWeaponry(2, TussleGame.player.getWeaponry(2) + 42);
	    		  }
	    		  break;
	    	  case" Trade ✈✈️":
	    		  if(TussleGame.player.getMoney() < 60000000 || TussleGame.player.getRecources(1) < 13 || TussleGame.player.getRecources(2) < 16 || TussleGame.player.getRecources(4) < 19) {
	    				ErrorWindow.openError();
	    		  }
	    		  else {
	    			  TussleGame.player.setMoney(TussleGame.player.getMoney() - 60000000);
	    			  TussleGame.player.setRecources(1, TussleGame.player.getRecources(1) - 13);
	    			  TussleGame.player.setRecources(2, TussleGame.player.getRecources(2) - 16);
	    			  TussleGame.player.setRecources(4, TussleGame.player.getRecources(4) - 19);
	    			  TussleGame.player.setWeaponry(3, TussleGame.player.getWeaponry(3) + 20);
	    		  }
	    		  break;
	    	  case"Trade 🚢🚢":
	    		  if(TussleGame.player.getMoney() < 30000000 || TussleGame.player.getRecources(1) < 28 || TussleGame.player.getRecources(2) < 13 || TussleGame.player.getRecources(3) < 20) {
	    			  ErrorWindow.openError();  
	    		  }
	    		  else {
	    			  TussleGame.player.setMoney(TussleGame.player.getMoney() - 30000000);
	    			  TussleGame.player.setRecources(1, TussleGame.player.getRecources(1) - 28);
	    			  TussleGame.player.setRecources(2, TussleGame.player.getRecources(2) - 13);
	    			  TussleGame.player.setRecources(3, TussleGame.player.getRecources(3) - 20);
	    			  TussleGame.player.setWeaponry(4, TussleGame.player.getWeaponry(3) + 23);
	    		  }	    		
	    		  break;
	    	  }
	      });
	      add(TradeButton);
	}
	
	
	public static void OpenMarketWindow() {
		MarketWindow ww = new MarketWindow();
		JFrame MarketFrame = new JFrame("💰 Market 💰");
		MarketFrame.setBounds(250, 20, 895,680);
		Container c3 = MarketFrame.getContentPane();
		c3.add(ww);	
		setTOwindowFrame(MarketFrame);
	//	MarketFrame.add(scroll);
		//MarketFrame.add(ok, BorderLayout.SOUTH);
	//	MarketFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MarketFrame.setResizable(false);
		MarketFrame.setVisible(true);
	}
	
	public static void setTOwindowFrame(JFrame J)
	{	
		MarketWindow = J;
	}
	
	
	public static void main(String[] args) {
		OpenMarketWindow();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
