package vp_graphic;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Gui_poker extends JFrame  implements ActionListener{
 
    JCheckBox op1 = new JCheckBox();
    JCheckBox op2 = new JCheckBox();
    JCheckBox op3 = new JCheckBox();
    JCheckBox op4 = new JCheckBox();
    JCheckBox op5 = new JCheckBox();
    
    JTextArea aposta = new JTextArea();
    
    public int creditos;
    
    JButton confirma = new JButton("Confirmar");
    JButton troca = new JButton("Trocar cartas selecionadas");
    JButton entrar = new JButton("Começar novo jogo");
    
    
	public Gui_poker(){
		
		super("Video Poker");
		this.setLayout(new CardLayout());
		Container cont = this.getContentPane();
		JPanel principal = new JPanel();
                
                creditos = 200;
                int alt = 150;
		int larg = 200;
		
                principal.setLayout(new GridLayout(3,5));
                
		ImageIcon im1 = new ImageIcon(new ImageIcon("./src/images/spades_ace.jpg").getImage().getScaledInstance(alt, larg, Image.SCALE_DEFAULT));
		ImageIcon im2 = new ImageIcon(new ImageIcon("./src/images/spades_ace.jpg").getImage().getScaledInstance(alt, larg, Image.SCALE_DEFAULT));
		ImageIcon im3 = new ImageIcon(new ImageIcon("./src/images/spades_ace.jpg").getImage().getScaledInstance(alt, larg, Image.SCALE_DEFAULT));
		ImageIcon im4 = new ImageIcon(new ImageIcon("./src/images/spades_ace.jpg").getImage().getScaledInstance(alt, larg, Image.SCALE_DEFAULT));
                ImageIcon im5 = new ImageIcon(new ImageIcon("./src/images/spades_ace.jpg").getImage().getScaledInstance(alt, larg, Image.SCALE_DEFAULT));
		ImageIcon fundo = new ImageIcon("./src/images/feltro.jpg");
		//JLabel back = new JLabel(fundo);
              
             
                
                
                setSize(1000,800);
		
		//principal.add(back);
                
                cont.add(principal);
		JLabel carta1 = new JLabel(im1);
		JLabel carta2 = new JLabel(im2);
		JLabel carta3 = new JLabel(im3);
		JLabel carta4 = new JLabel(im4);
                JLabel carta5 = new JLabel(im5);
                       
		principal.add(carta1);
		principal.add(carta2);
		principal.add(carta3);
		principal.add(carta4);
		principal.add(carta5);
                
                principal.add(op1);
                principal.add(op2);
                principal.add(op3);
                principal.add(op4);
                principal.add(op5);
                
                
                principal.add(aposta);
                principal.add(confirma);
                principal.add(troca);
                
                troca.setEnabled(false);
                
		op1.addActionListener(this);
                op2.addActionListener(this);
                op3.addActionListener(this);
                op4.addActionListener(this);
                op5.addActionListener(this);
                
                
               
                
		setLocation(600,300);
	
		setVisible(true);
               
                        
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	


    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(op1.isSelected() || op2.isSelected() || op3.isSelected() || op4.isSelected() || op5.isSelected())
            troca.setEnabled(true);
        else
            troca.setEnabled(false);
        
        while(Integer.parseInt(aposta.getText()) <= 0){
                    
            confirma.setText("Valor Inválido");
            confirma.setEnabled(false);
                            
        }
                    
        
        
    }
	
}
