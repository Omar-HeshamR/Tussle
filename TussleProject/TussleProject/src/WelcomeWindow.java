import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WelcomeWindow extends JPanel implements ActionListener{

	Color BackgroundColor = new Color(255, 230, 116);
	private JTextArea WHATisTussle, howGameWorks, statsInfo;
	private JButton ok;
	private static JFrame WelcomeWindow = new JFrame("(Game Information)");
	
	public WelcomeWindow() {
		setBackground(BackgroundColor);
		
		WHATisTussle = new JTextArea(" -*- The game objective is to attack all other empires and control the world! " 
		+ "\n Good Luck Commander " + myEmpireWindow.emprorNameString + "!!\n Praise " + myEmpireWindow.empireNameString +"!!"+ "                                                     *Read Lore For Higher Knowldlege*  ");
		WHATisTussle.setEditable(false);
		WHATisTussle.setBackground(BackgroundColor);
		WHATisTussle.setBorder(null);

		howGameWorks = new JTextArea(" -*-  After a certain period of time you will be recving news, and then you can take actions"
				+ "\n based on the incoming news, these actions affect your empire or others, right decsions make you stronger"
				+ "\n weaker decsions makes you weaker, get strong and prepare to defend yourself and attack others. Each in-game"
				+ "\n year has brings changes based on the current stances: Deafult changes are PopMorale -2, FoodStocks-2, and"
				+ "\n  money + Annual Income. If other changes take place.. you will be notified");
		howGameWorks.setEditable(false);
		howGameWorks.setBackground(BackgroundColor);
		howGameWorks.setBorder(null);
		
		statsInfo = new JTextArea(" -*- Clicking on other empires will provide you with their stats. Most stats are self-explanitory"
				+ "\n, but population morale is a score 1 to 100, 100 being best. Similarly food stocks, technology, and Military loyalty is a "
				+ "\nscore from 1 to 100. Surpassing 100 score is possible but very rare. Med, EDU, Inafstrecutue funding is the percentage"
				+ "\n of care for the following industries");
		statsInfo.setEditable(false);
		statsInfo.setBackground(BackgroundColor);
		statsInfo.setBorder(null);
		
		ok = new JButton(" Gotcha! ");
		ok.setBackground(new Color(250,0,0));
		ok.addActionListener(e -> { 
			WelcomeWindow.dispose();
			});
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,0, 0,20));
		panel.setBackground(BackgroundColor);
		panel.add(WHATisTussle);
		panel.add(howGameWorks);
		panel.add(statsInfo);
		panel.add(ok);
		
		add(panel, BorderLayout.CENTER);
	}
	
	public static void openWelcome() {
		WelcomeWindow ww = new WelcomeWindow();
		JFrame ReadyFrame = new JFrame("(Game Information)?!");
		ReadyFrame.setBounds(318, 175, 725, 410);
		Container c3 = ReadyFrame.getContentPane();
		c3.add(ww);	
		setTOwindowFrame(ReadyFrame);
		ReadyFrame.setResizable(false);
		ReadyFrame.setVisible(true);
	}
	
	public static void setTOwindowFrame(JFrame J)
	{	
		WelcomeWindow = J;
	}
	
	public static void main(String[] args) {
		openWelcome();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
