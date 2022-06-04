import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class settingsWindow extends JPanel implements ActionListener{

	private static JCheckBox volume; 
	private JButton goBack;
	private static boolean volumeCheck = false; //important 
	Color BackgroundColor = new Color(200, 100, 60);
	Color buttonColors = new Color(200, 70, 100);
	public static JFrame SettingWindowFrame = new JFrame("Settings");

	public settingsWindow() {
		
		
		setBackground(BackgroundColor);
		
		// Buttons Set UP
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(4, 0, 75, 40));
		volume = new JCheckBox(" Volume ", true);
		volume.addActionListener(e -> {
			 if(volume.isSelected()) {
					volumeCheck = true;
					Tussle.MainMenuMusic.loop();
				}
			 else {
					volumeCheck = false;
					Tussle.MainMenuMusic.stop();
			 }
			 // System.out.println(volumeCheck);
			});
		
		
		goBack = new JButton("Go Back");
		goBack.addActionListener(this);


		buttons.setBackground(BackgroundColor);
		volume.setBackground(buttonColors);
		goBack.setBackground(buttonColors);
		
		buttons.add(volume);
		buttons.add(goBack);

		add(buttons, BorderLayout.CENTER);

	}
	
	public static void setTOwindowFrame(JFrame J)
	{	
		SettingWindowFrame = J;
	}
	
	public static void setToVolumeCheck(boolean b) {
		volumeCheck = b;
		b = volumeCheck;
	}
	
	public static void OpenSettings() {
		settingsWindow settings = new settingsWindow();		
		JFrame SettingWindowFrame = new JFrame("Settings");
		SettingWindowFrame.setBounds(530, 150, 330, 300);
		Container c2 = SettingWindowFrame.getContentPane();
		c2.add(settings);	
		setTOwindowFrame(SettingWindowFrame); // so goBack button works
		SettingWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SettingWindowFrame.setResizable(false);
		SettingWindowFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();

		if(b == goBack) {	
			SettingWindowFrame.dispose();
		}
	}

		public static void main(String[] args) {
			OpenSettings();
	}


}
