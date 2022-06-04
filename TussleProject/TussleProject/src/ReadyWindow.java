import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReadyWindow extends JPanel implements ActionListener {
	
	
	String Quote = "";
	Color BackgroundColor = new Color(200, 100, 60);
	private JTextField encourgeQuote;
	private JButton ok;
	private static JFrame ReadyWindowFrame = new JFrame("Ready?!");

	public ReadyWindow() {
		
Random randQuote = new Random();
		
setBackground(BackgroundColor);

		int QuoteNum = randQuote.nextInt(4);
		
		switch(QuoteNum) {
		case 0:
			Quote = "“Only the dead have seen the end of war.”― Plato";
			break;
		case 1:
			Quote = "“War does not determine who is right – only who is left.”― Bertrand Russell";
			break;
		case 2:
			Quote = "“Peace is defined as period of time to allow for preparation for the next war.”― Terry Pratchett";
			break;
		case 3:
			Quote = "“Well, politics is war, and in war, truth is the first casualty.”― Jeff Greenfield";
			break;
		}
		
		encourgeQuote = new JTextField(Quote);
		encourgeQuote.setEditable(false);
		encourgeQuote.setBackground(BackgroundColor);
		encourgeQuote.setOpaque(false);
		encourgeQuote.setBorder(null);
		
		ok = new JButton(" READY TO TUSSLE! ");
		ok.setBackground(new Color(250,0,0));
		ok.addActionListener(e -> { 
			Tussle.MainWindowFIELD.setVisible(false);
			ReadyWindowFrame.dispose();
			Tussle.MainMenuMusic.stop();
			TussleGame.openGame();
			WelcomeWindow.openWelcome();
});
		JPanel text = new JPanel();
		text.setLayout(new GridLayout(4,0, 0,30));
		text.setBackground(BackgroundColor);
		text.add(encourgeQuote);
		text.add(ok);
		
		add(text, BorderLayout.CENTER);
	}
	
	public static void OpenReadyMessege() {
		ReadyWindow notset = new ReadyWindow();
		JFrame ReadyFrame = new JFrame("Ready?!");
		ReadyFrame.setBounds(430, 225, 525, 150);
		Container c3 = ReadyFrame.getContentPane();
		c3.add(notset);	
		setTOwindowFrame(ReadyFrame);
		ReadyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ReadyFrame.setResizable(false);
		ReadyFrame.setVisible(true);
	}
	
	public static void setTOwindowFrame(JFrame J)
	{	
		ReadyWindowFrame = J;
	}
	
	public static void main(String[] args) {
		OpenReadyMessege();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
