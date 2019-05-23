import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui_poker extends JFrame {

	
	public Gui_poker(){
		
		super("Video Poker");
		this.setLayout(new GridLayout());
		Container cont = this.getContentPane();
		JPanel principal = new JPanel();
		ImageIcon im1 = new ImageIcon(".\\src\\images\\spades_ace.jpg");
		ImageIcon im2 = new ImageIcon(".\\src\\images\\spades_ace.jpg");
		ImageIcon im3 = new ImageIcon(".\\src\\images\\spades_ace.jpg");
		ImageIcon im4 = new ImageIcon(".\\src\\images\\spades_ace.jpg");
		ImageIcon fundo = new ImageIcon(".\\src\\images\\feltro.jpg");
		JLabel back = new JLabel(fundo);
		
		int alt = this.getHeight();
		int larg = this.getWidth();
		
		principal.add(back);
		cont.add(principal, BorderLayout.CENTER);
		JLabel carta1 = new JLabel();
		JLabel carta2 = new JLabel();
		JLabel carta3 = new JLabel();
		JLabel carta4 = new JLabel();
		carta1.setIcon(im1);
		carta2.setIcon(im2);
		carta3.setIcon(im3);
		carta4.setIcon(im4);
		cont.add(carta1);
		cont.add(carta2);
		cont.add(carta3);
		cont.add(carta4);
		
		setSize(1000,800);
		setLocation(600,300);
	
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	
}
