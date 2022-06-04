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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class loreWindow extends JPanel implements ActionListener{

	
	Color BackgroundColor = new Color(255, 230, 116);
	private static JButton ok;
	private JTextArea Lore;
	private static JScrollPane scroll;
	private static JFrame loreWindow = new JFrame("Lore 🔥");
	
	public loreWindow() {
		
		setBackground(BackgroundColor);
		
		Lore = new JTextArea(" "+ myEmpireWindow.empireNameString + ":: " + myEmpireWindow.emprorNameString + " served as a soldier of the VVG to protect the community from the skrimish attacks by enemies. Your village"
				+ " and other \n near villages united creating the " + myEmpireWindow.empireNameString + " . As one of the best serving soldiers and being a great leader you were chosen to command the " + myEmpireWindow.empireNameString +"."
				+ "\n\n Sandrisa Imperial State:: An Imperial State that is looking to rule the world, it is run by a monarchy"
				+ "\n\n Republic of Padara:: Padara is the only republic, they are strong belivers of democracy. They absolutely hate Sandrisa."
				+ "\n\n Fredz Fedration:: A federation of the enitre south american contintent"
				+ "\n\n Kingdom of Esctour:: This little kingdom was formed on its own, its leader loves copmiulnisim and is keen on implementing in the entire world."
				+ "\n\n United Tribes of Alkebulan:: The Fredz Fedration wanted to grow its influnce globally and attacked african tribes consistently. Then a super leader got the clever idea of uniting the tribes"
				+ " the tribes then unite as a one nation."
				+ "\n\n Sultanate of Krixxun:: An immensly wealthy state that relies on its recources income."
				+ "\n\n Vaulter Military State:: who doesnt love a good coup?, coups happen everywhere, but this time, the coup went to a whole other level. The Shunshia"
				+ "\n empire was a big empire in the east north, as time passed by its #1 military general organized a coup and took his rule to another level of control and dictitaorship."
				+ "\n\n Holy Vulpine Empire:: the europes decided to unite"
				+ "\n\n Eastfront Union:: the south east asain countries decided to unite to form an unbreackble union that has the power to defeat the west for once."
				+ "\n\n The Arabian State:: The arab-speaking nations formed a union"
				+ "\n\n Alkoz Kingdom:: The kingdom has lasted there for a very long time, even before history for the area was recorded."
				+ "\n\n Zeon Emirate:: A very techonlogically advanced nation, but lacks all other capbilties");
		Lore.setEditable(false);
		Lore.setBackground(BackgroundColor);
		Lore.setBorder(null);
		Lore.setFont(new Font("Dialouge", Font.PLAIN, 18));
		Lore.setForeground(new Color(109, 35, 32 ));
		 scroll = new JScrollPane (Lore, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		ok = new JButton(" Get me back to war! ");
		ok.setBackground(new Color(250,0,0));
		ok.addActionListener(e -> { 
			loreWindow.dispose();
			});
		
	}
	
	public static void openLore() {
		loreWindow ww = new loreWindow();
		JFrame loreFrame = new JFrame("Lore 🔥");
		loreFrame.setBounds(250, 0, 895,680);
		Container c3 = loreFrame.getContentPane();
		c3.add(ww);	
		setTOwindowFrame(loreFrame);
		loreFrame.add(scroll);
		loreFrame.add(ok, BorderLayout.SOUTH);
		//loreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loreFrame.setResizable(false);
		loreFrame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		openLore();
	}

	public static void setTOwindowFrame(JFrame J)
	{	
		loreWindow = J;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
