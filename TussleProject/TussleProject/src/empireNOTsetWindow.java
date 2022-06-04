import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Random;

public class empireNOTsetWindow  extends JPanel implements ActionListener{

	Color BackgroundColor = new Color(200, 100, 60);
	private JTextField errorMess;
	private JButton goBack;
	String Quote = "";
	public static boolean t = false;
	private static JFrame ErrorWindowFrame = new JFrame("Ready?!");
	private static EasySound GameMusic;

	public empireNOTsetWindow() {
		setBackground(BackgroundColor);
		
		errorMess = new JTextField("MAKE SURE TO SET YOUR EMPIRE CHARCTARSTICS BEFORE PLAYING!");
		errorMess.setEditable(false);
		errorMess.setBackground(BackgroundColor);
		errorMess.setOpaque(false);
		errorMess.setBorder(null);

		goBack = new JButton(" Go Back ");
		goBack.setBackground(new Color(225,10,10));
		goBack.addActionListener(e -> { 
			ErrorWindowFrame.dispose();
		 });
		
		JPanel text = new JPanel();
		text.setLayout(new GridLayout(2,0, 0,30));
		text.setBackground(BackgroundColor);
		text.add(errorMess);
		text.add(goBack);
		
		add(text, BorderLayout.CENTER);
	}
	
	public static void setTOwindowFrame(JFrame J)
	{	
		ErrorWindowFrame = J;
	}
	
	public static void OpenEmpireNOTsetMessege() {
		empireNOTsetWindow notset = new empireNOTsetWindow();
		JFrame ERRORFrame = new JFrame("Error!");
		ERRORFrame.setBounds(430, 225, 515, 150);
		Container c3 = ERRORFrame.getContentPane();
		c3.add(notset);	
		setTOwindowFrame(ERRORFrame);
		ERRORFrame.setResizable(false);
		ERRORFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		OpenEmpireNOTsetMessege();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
