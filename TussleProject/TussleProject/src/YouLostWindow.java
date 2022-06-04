import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.Timer;
import java.util.TimerTask;

public class YouLostWindow extends JPanel implements ActionListener{

	private static JFrame YLWindow = new JFrame("(GG!)");
	Color BackgroundColor = new Color(228, 157, 235);
	private JTextField NewYearText;
	private JTextArea ChangesMess;
	private JButton goBack;
	
	public YouLostWindow(String s) {
	setBackground(BackgroundColor);
	
	ChangesMess = new JTextArea(s);
	ChangesMess.setEditable(false);
	ChangesMess.setBackground(BackgroundColor);
	ChangesMess.setOpaque(false);
	ChangesMess.setFont(new Font("Monospaced", Font.BOLD, 14));
	ChangesMess.setBorder(null);

		goBack = new JButton(" !  I TESTIFY TO GIVE BETTER RULE NEXT GAME  ! ");
		goBack.setBackground(new Color(255,0,100));
		goBack.addActionListener(e -> { 
			System.exit(1);
		 });
		
		JPanel text = new JPanel();
		text.setLayout(new GridLayout(2,0, 0,25));
		text.setBackground(BackgroundColor);
		text.add(ChangesMess);
		text.add(goBack);
		
		add(text, BorderLayout.CENTER);
	}
	
	public YouLostWindow(String s, String f) {
	setBackground(BackgroundColor);
	
	ChangesMess = new JTextArea(s);
	ChangesMess.setEditable(false);
	ChangesMess.setBackground(BackgroundColor);
	ChangesMess.setOpaque(false);
	ChangesMess.setFont(new Font("Monospaced", Font.BOLD, 14));
	ChangesMess.setBorder(null);

		goBack = new JButton(f);
		goBack.setBackground(new Color(255,0,100));
		goBack.addActionListener(e -> { 
			System.exit(1);
		 });
		
		JPanel text = new JPanel();
		text.setLayout(new GridLayout(2,0, 0,25));
		text.setBackground(BackgroundColor);
		text.add(ChangesMess);
		text.add(goBack);
		
		add(text, BorderLayout.CENTER);
	}
	
	public static void openWindow1() {
		YouLostWindow ww = new YouLostWindow("-*- Your population morale has dropped signficntly low, the people are fed up"
				+ "\n with your careless ruling! A revolution starts to replace the government!"
				+ "\n Your forced to step down  -*-");
		JFrame YLFrame = new JFrame("(GG!)");
		YLFrame.setBounds(400, 225, 655, 210);
		Container c3 = YLFrame.getContentPane();
		c3.add(ww);	
		setTOwindowFrame(YLFrame);
		YLFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		YLFrame.setResizable(false);
		YLFrame.setVisible(true);
	}
	
	public static void openWidnow2() {
		YouLostWindow ww = new YouLostWindow("-*- Your military loyality has dropped signficntly low, the generals are fed up"
				+ "\n with your careless/weak ruling! A coup starts to overthrow the government!"
				+ "\n You fall to your demise  -*-" );
		JFrame YLFrame = new JFrame("(GG!)");
		YLFrame.setBounds(400, 225, 655, 210);
		Container c3 = YLFrame.getContentPane();
		c3.add(ww);	
		setTOwindowFrame(YLFrame);
		YLFrame.setResizable(false);
		YLFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		YLFrame.setVisible(true);
	}
	
	public static void openWinScreen() {
		YouLostWindow ww = new YouLostWindow("-*- Well done Empror " + myEmpireWindow.emprorNameString + "-*-"
				+ "\n The world is now yours!", "Long Live: " + myEmpireWindow.empireNameString);
		JFrame YLFrame = new JFrame("(GG!)");
		YLFrame.setBounds(400, 225, 655, 210);
		Container c3 = YLFrame.getContentPane();
		c3.add(ww);	
		setTOwindowFrame(YLFrame);
		YLFrame.setResizable(false);
		YLFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		YLFrame.setVisible(true);
	}
	
	public static void setTOwindowFrame(JFrame J)
	{	
		YLWindow = J;
	}
	
	public static void main(String[] args) {
		openWidnow2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
