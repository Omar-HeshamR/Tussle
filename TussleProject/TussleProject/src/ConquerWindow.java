import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ConquerWindow extends JPanel implements ActionListener{

	private static JFrame ConquerWindow = new JFrame("⚔️ Conquer ⚔️");
	private JButton Conq;
	Color BackgroundColor = new Color(255, 136, 92);
	private JRadioButton Hamidian, Sandrisa, Padara, Zeon, Fredz, Alkoz, Vulpine, Military, tribes, esctour, eastfront, krixxun;
	private String whoISgettingConq;
	
	public ConquerWindow() {
		setBackground(BackgroundColor);
		setLayout(null);
		
		
		 // Buttons
		
		Hamidian = new JRadioButton("The Arabian State");
		Hamidian.setOpaque(false);
		Hamidian.setFont(new Font("SansSerif", Font.PLAIN, 20));
		Hamidian.addActionListener(e -> { 
			if(Hamidian.isSelected()) {
				whoISgettingConq = "H";
			}
		 });
		Sandrisa = new JRadioButton("Sandrisa Imperial State");
		Sandrisa.setOpaque(false);
		Sandrisa.setFont(new Font("SansSerif", Font.PLAIN, 20));
		Sandrisa.addActionListener(e -> { 
			if(Sandrisa.isSelected()) {
				whoISgettingConq = "S";
			}
		 });
		Padara = new JRadioButton("Republic of Padara");
		Padara.setOpaque(false);
		Padara.setFont(new Font("SansSerif", Font.PLAIN, 20));
		Padara.addActionListener(e -> { 
			if(Padara.isSelected()) {
				whoISgettingConq = "P";
			}
		 });
		Zeon = new JRadioButton("Zeon Emirate");
		Zeon.setOpaque(false);
		Zeon.setFont(new Font("SansSerif", Font.PLAIN, 20));
		Zeon.addActionListener(e -> { 
			if(Zeon.isSelected()) {
				whoISgettingConq = "Z";
			}
		 });
		Fredz = new JRadioButton("Fredz Fedration");
		Fredz.setOpaque(false);
		Fredz.setFont(new Font("SansSerif", Font.PLAIN, 20));
		Fredz.addActionListener(e -> { 
			if(Fredz.isSelected()) {
				whoISgettingConq = "F";
			}
		 });
		Alkoz = new JRadioButton("Alkoz Kingdom");
		Alkoz.setOpaque(false);
		Alkoz.setFont(new Font("SansSerif", Font.PLAIN, 20));
		Alkoz.addActionListener(e -> { 
			if(Alkoz.isSelected()) {
				whoISgettingConq = "A";
			}
		 });
		Vulpine = new JRadioButton("Holy Vulpine Empire");
		Vulpine.setOpaque(false);
		Vulpine.setFont(new Font("SansSerif", Font.PLAIN, 20));
		Vulpine.addActionListener(e -> { 
			if(Vulpine.isSelected()) {
				whoISgettingConq = "V";
			}
		 });
		Military = new JRadioButton("Vaulter Military State");
		Military.setOpaque(false);
		Military.setFont(new Font("SansSerif", Font.PLAIN, 20));
		Military.addActionListener(e -> { 
			if(Military.isSelected()) {
				whoISgettingConq = "M";
			}
		 });
		tribes = new JRadioButton("United Tribes of Alkebulan");
		tribes.setOpaque(false);
		tribes.setFont(new Font("SansSerif", Font.PLAIN, 20));
		tribes.addActionListener(e -> { 
			if(tribes.isSelected()) {
				whoISgettingConq = "T";
			}
		 });
		esctour = new JRadioButton("Kingdom of Esctour");
		esctour.setOpaque(false);
		esctour.setFont(new Font("SansSerif", Font.PLAIN, 20));
		esctour.addActionListener(e -> { 
			if(esctour.isSelected()) {
				whoISgettingConq = "E";
			}
		 });
		eastfront = new JRadioButton("Eastfront Union");
		eastfront.setOpaque(false);
		eastfront.setFont(new Font("SansSerif", Font.PLAIN, 20));
		eastfront.addActionListener(e -> { 
			if(eastfront.isSelected()) {
				whoISgettingConq = "EF";
			}
		 });
		krixxun = new JRadioButton("Krixxun Sultanate");
		krixxun.setOpaque(false);
		krixxun.setFont(new Font("SansSerif", Font.PLAIN, 20));
		krixxun.addActionListener(e -> { 
			if(krixxun.isSelected()) {
				whoISgettingConq = "K";
			}
		 });
		ButtonGroup gr = new ButtonGroup();
		gr.add(Hamidian);
		gr.add(Vulpine);
		gr.add(Padara);
		gr.add(Military);
		gr.add(eastfront);
		gr.add(krixxun);
		gr.add(tribes);
		gr.add(Fredz);
		gr.add(Alkoz);
		gr.add(Sandrisa);
		gr.add(Alkoz);
		gr.add(esctour);
		gr.add(Zeon);

		JPanel choiceButton = new JPanel();
		choiceButton.setLayout(new GridLayout(4, 3, 20, 20));
		choiceButton.setBackground(BackgroundColor);
		choiceButton.setOpaque(false);
		choiceButton.setBounds(300, 180, 860, 250);
		choiceButton.setLocation(40, 50);
		choiceButton.add(Hamidian);
		choiceButton.add(Vulpine);
		choiceButton.add(Padara);
		choiceButton.add(Military);
		choiceButton.add(eastfront);
		choiceButton.add(krixxun);
		choiceButton.add(tribes);
		choiceButton.add(Fredz);
		choiceButton.add(Alkoz);
		choiceButton.add(Sandrisa);
		choiceButton.add(esctour);
		choiceButton.add(Zeon);
		add(choiceButton);
		
	     //go back perhaps
		Conq = new JButton("    ⚔️ Conquer ⚔️");
		Conq.setBackground(new Color(255, 19, 0));
			 Dimension size = Conq.getPreferredSize();
			 Conq.setBounds(300, 180, size.width+137, size.height+30);
			 Conq.setLocation(300,360);
			 Conq.setFocusPainted(false);
			 Conq.setFont(new Font("SansSerif", Font.PLAIN, 28));
			 Conq.addActionListener(e -> { 
				 ConquerWindow.dispose();
				 switch(whoISgettingConq) {
				 case "H":
					 Empire.conquers(TussleGame.player, TussleGame.hamidian);
					 break;
				 case "F":
					 Empire.conquers(TussleGame.player, TussleGame.fredz);
					 break;
				 case "S":
					 Empire.conquers(TussleGame.player, TussleGame.sandrisa);
					 break;
				 case "P":
					 Empire.conquers(TussleGame.player, TussleGame.padara);
					 break;
				 case "E":
					 Empire.conquers(TussleGame.player, TussleGame.esctour);
					 break;
				 case "EF":
					 Empire.conquers(TussleGame.player, TussleGame.eastfront);
					 break;
				 case "Z":
					 Empire.conquers(TussleGame.player, TussleGame.zeon);
					 break;
				 case "K":
					 Empire.conquers(TussleGame.player, TussleGame.krixxun);
					 break;
				 case "V":
					 Empire.conquers(TussleGame.player, TussleGame.vulpine);
					 break;
				 case "M":
					 Empire.conquers(TussleGame.player, TussleGame.military);
					 break;
				 case "A":
					 Empire.conquers(TussleGame.player, TussleGame.alkoz);
					 break;
				 case "T":
					 Empire.conquers(TussleGame.player, TussleGame.tribes);
					 break;
				 }
				 
				});
			add(Conq);
	}
	
	public static void OpenConqWindow() {
		ConquerWindow ww = new ConquerWindow();
		JFrame ConqFrame = new JFrame("⚔️ Conquer ⚔️");
		ConqFrame.setBounds(240, 100, 895,480);
		Container c3 = ConqFrame.getContentPane();
		c3.add(ww);	
		setTOwindowFrame(ConqFrame);
	//	MarketFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ConqFrame.setResizable(false);
		ConqFrame.setVisible(true);
	}
	
	public static void setTOwindowFrame(JFrame J)
	{	
		ConquerWindow = J;
	}
	
	public static void main(String[] args) {
		OpenConqWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
