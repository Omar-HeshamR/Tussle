import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class NextYearTimer {
	
	static int interval;
	static Timer timer;
	 static JTextField NextEventTimer;
	
	public static JTextField getTimer() {
		
		Scanner sc = new Scanner(System.in);
		    String secs = "120";
		    int delay = 1000;
		    int period = 1000;
		    timer = new Timer();
		    interval = Integer.parseInt(secs);
		    
			NextEventTimer = new JTextField("Next Year In: " + secs);
		    
		    timer.scheduleAtFixedRate(new TimerTask() {

		        public void run() {
		        	NextEventTimer.setText("Next Year In: " + setInterval());
		        	if(interval == 1) {
		        		NewYearChanges();
		        	}
		        }
		    }, delay, period);
		    
			NextEventTimer.setBounds(300, 180, 300, 54);
			NextEventTimer.setLocation(24,500);
			NextEventTimer.setBorder(null);
			NextEventTimer.setFocusable(false);
			NextEventTimer.setEditable(false);
			NextEventTimer.setOpaque(false);
			NextEventTimer.setFont(new Font("Monospaced", Font.BOLD, 18));
			NextEventTimer.setForeground(new Color(99, 98, 0));	
			
		    return NextEventTimer;
	}
	
	private static final String setInterval() {
	    if (interval == 1) {
	    	interval = 101;
    	 }
	    return "" + --interval;
	}
	
	public static void NewYearChanges(){
		
		// Money Changes
		TussleGame.player.setMoney(TussleGame.player.getMoney() + TussleGame.player.getAnnualIncome());
		TussleGame.zeon.setMoney(TussleGame.zeon.getMoney() + TussleGame.zeon.getAnnualIncome());
		TussleGame.tribes.setMoney(TussleGame.tribes.getMoney() + TussleGame.tribes.getAnnualIncome());
		TussleGame.alkoz.setMoney(TussleGame.alkoz.getMoney() + TussleGame.alkoz.getAnnualIncome());
		TussleGame.fredz.setMoney(TussleGame.fredz.getMoney() + TussleGame.fredz.getAnnualIncome());
		TussleGame.sandrisa.setMoney(TussleGame.sandrisa.getMoney() + TussleGame.sandrisa.getAnnualIncome());
		TussleGame.hamidian.setMoney(TussleGame.hamidian.getMoney() + TussleGame.hamidian.getAnnualIncome());
		TussleGame.padara.setMoney(TussleGame.padara.getMoney() + TussleGame.padara.getAnnualIncome());
		TussleGame.esctour.setMoney(TussleGame.esctour.getMoney() + TussleGame.esctour.getAnnualIncome());
		TussleGame.krixxun.setMoney(TussleGame.krixxun.getMoney() + TussleGame.krixxun.getAnnualIncome());
		TussleGame.military.setMoney(TussleGame.military.getMoney() + TussleGame.military.getAnnualIncome());
		TussleGame.vulpine.setMoney(TussleGame.vulpine.getMoney() + TussleGame.vulpine.getAnnualIncome());
		TussleGame.eastfront.setMoney(TussleGame.eastfront.getMoney() + TussleGame.eastfront.getAnnualIncome());

		//population Increase:
		TussleGame.player.setPopulation((long)(TussleGame.player.getPopulation() * 1.1));
		TussleGame.zeon.setPopulation((long)(TussleGame.zeon.getPopulation() * 1.1));
		TussleGame.tribes.setPopulation((long)(TussleGame.tribes.getPopulation() * 1.1));
		TussleGame.alkoz.setPopulation((long)(TussleGame.alkoz.getPopulation() * 1.1));
		TussleGame.fredz.setPopulation((long)(TussleGame.fredz.getPopulation() * 1.1));
		TussleGame.sandrisa.setPopulation((long)(TussleGame.sandrisa.getPopulation() * 1.1));
		TussleGame.hamidian.setPopulation((long)(TussleGame.hamidian.getPopulation() * 1.1));
		TussleGame.padara.setPopulation((long)(TussleGame.padara.getPopulation() * 1.1));
		TussleGame.esctour.setPopulation((long)(TussleGame.esctour.getPopulation() * 1.1));
		TussleGame.krixxun.setPopulation((long)(TussleGame.krixxun.getPopulation() * 1.1));
		TussleGame.military.setPopulation((long)(TussleGame.military.getPopulation() * 1.1));
		TussleGame.vulpine.setPopulation((long)(TussleGame.vulpine.getPopulation() * 1.1));
		TussleGame.eastfront.setPopulation((long)(TussleGame.eastfront.getPopulation() * 1.1));

		
		//other DECREASE
		TussleGame.player.setPopulationMorale(TussleGame.player.getPopulationMorale() - 2);
		TussleGame.player.setFoodStocks(TussleGame.player.getFoodStocks() - 2);
		TussleGame.player.setMilitaryLoyality(TussleGame.player.getMilitaryLoyality() - 1);
		
		// Morality and Military and FoodStocks Adjusments
		if(TussleGame.player.getPopulationMorale() <= 35) {
			YouLostWindow.openWindow1();
		}
		
		else if(TussleGame.player.getMilitaryLoyality() <= 35) {
			YouLostWindow.openWidnow2();
		}
		
		else if(TussleGame.player.getPopulationMorale() <= 50 && TussleGame.player.getMilitaryLoyality() <= 50 && TussleGame.player.getFoodStocks() >= 99) {
			TussleGame.player.setPopulationMorale(TussleGame.player.getPopulationMorale() + 13);
			NewYearWindow.openWindnow3();
		}
		
		else if(TussleGame.player.getPopulationMorale() <= 50 && TussleGame.player.getMilitaryLoyality() <= 50) {
			NewYearWindow.openWindnow3();
		}
		
		else if(TussleGame.player.getFoodStocks() >= 99) {
			TussleGame.player.setPopulationMorale(TussleGame.player.getPopulationMorale() + 13);
			NewYearWindow.openWindow1();
		}
		
		else if(TussleGame.player.getPopulationMorale() <= 50) {
			NewYearWindow.openWidnow2();
		}
		
		else if(TussleGame.player.getMilitaryLoyality() <= 50) {
			NewYearWindow.openWindnow4();
		}
		
	}
	
	public static void main(String[] args) {

	}

}