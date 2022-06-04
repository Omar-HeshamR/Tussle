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
import javax.swing.JTextField;
import java.util.Timer;
import java.util.TimerTask;

public class ErrorWindow extends JPanel implements ActionListener{

	private static JFrame ErrorWindow = new JFrame("(Error!)");
	Color BackgroundColor = new Color(225, 230, 116);
	private JTextField errorMess;
	private JButton goBack;
	
	public ErrorWindow(String s) {
	setBackground(BackgroundColor);
		
		errorMess = new JTextField(s);
		errorMess.setEditable(false);
		errorMess.setBackground(BackgroundColor);
		errorMess.setOpaque(false);
		errorMess.setFont(new Font("Monospaced", Font.BOLD, 17));
		errorMess.setBorder(null);

		goBack = new JButton(" ! GOT IT ! ");
		goBack.setBackground(new Color(255,100,10));
		goBack.addActionListener(e -> { 
			ErrorWindow.dispose();
		 });
		
		JPanel text = new JPanel();
		text.setLayout(new GridLayout(2,0, 0,30));
		text.setBackground(BackgroundColor);
		text.add(errorMess);
		text.add(goBack);
		
		add(text, BorderLayout.CENTER);
	}
	
	public static void openError() {
		ErrorWindow ww = new ErrorWindow(" Cannot Afford To Buy !!! ");
		JFrame ErrorFrame = new JFrame("(Error!)");
		ErrorFrame.setBounds(430, 225, 515, 150);
		Container c3 = ErrorFrame.getContentPane();
		c3.add(ww);	
		setTOwindowFrame(ErrorFrame);
		ErrorFrame.setResizable(false);
		ErrorFrame.setVisible(true);
	}
	
	public static void openError2() {
		ErrorWindow ww = new ErrorWindow(" Your at MAX level for this item! ");
		JFrame ErrorFrame = new JFrame("(Error!)");
		ErrorFrame.setBounds(430, 225, 535, 150);
		Container c3 = ErrorFrame.getContentPane();
		c3.add(ww);	
		setTOwindowFrame(ErrorFrame);
		ErrorFrame.setResizable(false);
		ErrorFrame.setVisible(true);
	}
	
	public static void openError3(String w, String l) {
		ErrorWindow ww = new ErrorWindow( l + " has lost war to " + w + " !!");
		JFrame ErrorFrame = new JFrame("(IMPORTANT!)");
		ErrorFrame.setBounds(430, 215, 675, 150);
		Container c3 = ErrorFrame.getContentPane();
		c3.add(ww);	
		setTOwindowFrame(ErrorFrame);
		ErrorFrame.setResizable(false);
		ErrorFrame.setVisible(true);
	}
	
	public static void openError4(String w, String l) {
		ErrorWindow ww = new ErrorWindow( w + " has succsefully conqured " + l + " !!");
		JFrame ErrorFrame = new JFrame("(IMPORTANT!)");
		ErrorFrame.setBounds(430, 205, 675, 150);
		Container c3 = ErrorFrame.getContentPane();
		c3.add(ww);	
		setTOwindowFrame(ErrorFrame);
		ErrorFrame.setResizable(false);
		ErrorFrame.setVisible(true);
	}
	
	public static void openError5(String s) {
		ErrorWindow ww = new ErrorWindow( s + " is already annihilated !!");
		JFrame ErrorFrame = new JFrame("(IMPORTANT!)");
		ErrorFrame.setBounds(430, 225, 515, 160);
		Container c3 = ErrorFrame.getContentPane();
		c3.add(ww);	
		setTOwindowFrame(ErrorFrame);
		ErrorFrame.setResizable(false);
		ErrorFrame.setVisible(true);
	}
	public static void openError6() {
		ErrorWindow ww = new ErrorWindow(" Insuffcient Weopanry !!");
		JFrame ErrorFrame = new JFrame("(IMPORTANT!)");
		ErrorFrame.setBounds(430, 225, 515, 160);
		Container c3 = ErrorFrame.getContentPane();
		c3.add(ww);	
		setTOwindowFrame(ErrorFrame);
		ErrorFrame.setResizable(false);
		ErrorFrame.setVisible(true);
	}
	public static void setTOwindowFrame(JFrame J)
	{	
		ErrorWindow = J;
	}
	
	public static void main(String[] args) {
		openError();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
