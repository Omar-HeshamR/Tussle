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

public class NextEventTimer {
	
	static int interval;
	static Timer timer;
	 static JTextField NextEventTimer;
	
	public static JTextField getTimer() {
		
		Scanner sc = new Scanner(System.in);
		    String secs = "113";
		    int delay = 1000;
		    int period = 1000;
		    timer = new Timer();
		    interval = Integer.parseInt(secs);
		    
			NextEventTimer = new JTextField("Next Event In: " + secs);
		    
		    timer.scheduleAtFixedRate(new TimerTask() {

		        public void run() {
		        	NextEventTimer.setText("Next Event In: " + setInterval());
		        	if(interval == 1) {
		        		newEvent();
		        	}
		        }
		    }, delay, period);
		    
			NextEventTimer.setBounds(300, 180, 500, 54);
			NextEventTimer.setLocation(515,680);
			NextEventTimer.setBorder(null);
			NextEventTimer.setFocusable(false);
			NextEventTimer.setEditable(false);
			NextEventTimer.setOpaque(false);
			NextEventTimer.setFont(new Font("Monospaced", Font.BOLD, 37));
			NextEventTimer.setForeground(new Color(198, 0, 0 ));	
			
		    return NextEventTimer;
	}
	
	private static final String setInterval() {
	    if (interval == 1)
	    	interval = 63;
	    return "" + --interval;
	}
	
	private static void newEvent() {
		EventWindow.openEvent();
	}
	
	public static void main(String[] args) {

	}

}