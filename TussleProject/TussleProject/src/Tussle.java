import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.tools.javac.Main;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;


// Author: Omar

public class Tussle extends JPanel implements ActionListener{
	
	Color BackgroundColor = new Color(200, 100, 60);
	Color buttonColors = new Color(255, 30, 10);
	private JButton exit, help, settings, play, myEmpire;
    public static Sound MainMenuMusic;
	public static JFrame MainWindowFIELD;	
	
	//other window stuff
	private static boolean volumeCheck = true;
	
	public Tussle() {
		
		setBackground(BackgroundColor);
		
		// Buttons Set UP
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(4, 0, 75, 40));
		
		play = new JButton("! TUSSLE !");
		play.addActionListener(this);
		myEmpire = new JButton(" My Empire ");
		myEmpire.addActionListener(this);
		settings = new JButton(" * Settings * ");
		settings.addActionListener(this);
		exit = new JButton(" Exit ");
		exit.addActionListener(this);
		
		play.setBackground(buttonColors);
		myEmpire.setBackground(buttonColors);
		settings.setBackground(buttonColors);
		exit.setBackground(buttonColors);
          
		//test
		JLabel Iconn =new JLabel();
		Iconn.setBounds(0, 0, 150, 100);
		Iconn.setBackground(BackgroundColor);
		Iconn.setIcon(new ImageIcon("warIconOne-removebg-preview.png"));
		Iconn.setOpaque(true);

		buttons.setBackground(BackgroundColor);
		buttons.add(play);
		buttons.add(myEmpire);
		buttons.add(settings);
		buttons.add(exit);
		add(buttons, BorderLayout.CENTER);
        add(Iconn,BorderLayout.EAST);

		// Main music initiate
		 MainMenuMusic = new Sound("MainMenuMusic.wav");
	}
	  
	public static void openTussle() {
		// Main JFrame
		JFrame MainWindow = new JFrame("Tussle!");
		MainWindow.setBounds(530, 150, 330, 300);
		Container c = MainWindow.getContentPane();
		c.add(new Tussle());
				
		// Casuals
		MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainWindow.setResizable(false);
		MainWindow.setVisible(true);
		MainWindowFIELD = MainWindow;

		// Main Menu Sound
		settingsWindow.setToVolumeCheck(volumeCheck);
		MainMenuMusic.loop();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();

		if(b == exit) {
			 System.exit(1);
			 }
		
		else if(b == settings) {
			settingsWindow.OpenSettings();
		}
		
		else if(b == myEmpire) {
			myEmpireWindow.OpenMYEMPIRE();
		}
		
		else if(b == play && myEmpireWindow.DoneCheck == false) {
			empireNOTsetWindow.OpenEmpireNOTsetMessege();
		}
		else if(b == play && myEmpireWindow.DoneCheck == true) {
			ReadyWindow.OpenReadyMessege();
		}
	
	}
	
	// MAIN METHOD ****&&&****
	public static void main(String[] args) {
		openTussle();
	}

	
}




// wack things:
// press Enter in empror/empire Name to save
// Hamidian-->esc conqer bug
