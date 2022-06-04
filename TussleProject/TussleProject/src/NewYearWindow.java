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

public class NewYearWindow extends JPanel implements ActionListener{

	private static JFrame NYWindow = new JFrame("(New Year Updates!)");
	Color BackgroundColor = new Color(228, 157, 235);
	private JTextField NewYearText;
	private JTextArea ChangesMess;
	private JButton goBack;
	
	public NewYearWindow(String s) {
	setBackground(BackgroundColor);
		
	NewYearText = new JTextField("New Year Changes:");
	NewYearText.setEditable(false);
	NewYearText.setBackground(BackgroundColor);
	NewYearText.setOpaque(false);
	NewYearText.setFont(new Font("Monospaced", Font.BOLD, 18));
	NewYearText.setForeground(new Color(2, 100, 35 ));
	NewYearText.setBorder(null);
	
	ChangesMess = new JTextArea(s);
	ChangesMess.setEditable(false);
	ChangesMess.setBackground(BackgroundColor);
	ChangesMess.setOpaque(false);
	ChangesMess.setFont(new Font("Monospaced", Font.BOLD, 13));
	ChangesMess.setBorder(null);

		goBack = new JButton(" ! GOT IT ! ");
		goBack.setBackground(new Color(255,100,10));
		goBack.addActionListener(e -> { 
			NYWindow.dispose();
		 });
		
		JPanel text = new JPanel();
		text.setLayout(new GridLayout(3,0, 0,15));
		text.setBackground(BackgroundColor);
		text.add(NewYearText);
		text.add(ChangesMess);
		text.add(goBack);
		
		add(text, BorderLayout.CENTER);
	}
	
	public static void openWindow1() {
		NewYearWindow ww = new NewYearWindow("- Annual Income added to Money + DefChanges"
				+ "\n- Population Morale +13 due to high food stocks ");
		JFrame ErrorFrame = new JFrame("(New Year Updates!)");
		ErrorFrame.setBounds(430, 225, 515, 250);
		Container c3 = ErrorFrame.getContentPane();
		c3.add(ww);	
		setTOwindowFrame(ErrorFrame);
		ErrorFrame.setResizable(false);
		ErrorFrame.setVisible(true);
	}
	
	public static void openWidnow2() {
		NewYearWindow ww = new NewYearWindow("- Annual Income added to Money + DefChanges"
						+ "\n- Population morale is DANGROUSLY LOW! CARE! " );
		
		JFrame NYFrame = new JFrame("(New Year Updates!)");
		NYFrame.setBounds(430, 225, 535, 250);
		Container c3 = NYFrame.getContentPane();
		c3.add(ww);	
		setTOwindowFrame(NYFrame);
		NYFrame.setResizable(false);
		NYFrame.setVisible(true);
	}
	
	public static void openWindnow3() {
		NewYearWindow ww = new NewYearWindow("- Annual Income added to Money + DefChanges"
						+ "\n- Population morale is DANGROUSLY LOW! CARE for REVOLUTION! "
						+ "\n- Military loyalty is super low. Care for a Coup!" );
		
		JFrame NYFrame = new JFrame("(New Year Updates!)");
		NYFrame.setBounds(430, 225, 535, 250);
		Container c3 = NYFrame.getContentPane();
		c3.add(ww);	
		setTOwindowFrame(NYFrame);
		NYFrame.setResizable(false);
		NYFrame.setVisible(true);
	}
	
	public static void openWindnow4() {
		NewYearWindow ww = new NewYearWindow("- Annual Income added to Money + DefChanges"
						+ "\n- Military loyalty is super low. Care for a Coup! " );
		
		JFrame NYFrame = new JFrame("(New Year Updates!)");
		NYFrame.setBounds(430, 225, 535, 250);
		Container c3 = NYFrame.getContentPane();
		c3.add(ww);	
		setTOwindowFrame(NYFrame);
		NYFrame.setResizable(false);
		NYFrame.setVisible(true);
	}
	
	public static void setTOwindowFrame(JFrame J)
	{	
		NYWindow = J;
	}
	
	public static void main(String[] args) {
		openWindnow3();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
