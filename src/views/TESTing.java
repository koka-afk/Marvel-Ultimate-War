package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import engine.Game;
import engine.Player;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.Champion;

public class TESTing implements ActionListener {
	
	JButton button;
	JLabel label1, label2, label3;
	JFrame frame;
	
	public TESTing() {
		
		/*frame = new JFrame(); // Frame default layout is BorderLayout
		frame.setBounds(300, 200, 600, 600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		//GridLayout
		
		JPanel panel = new JPanel(); // Panel default layout is FlowLayout
		panel.setBounds(0, 0, 600, 300);
		panel.setLayout(new GridLayout(2, 3));
		panel.setBackground(Color.red);
		frame.add(panel);
		
		label = new JLabel();
		label.setBounds(500, 50, 300, 300);
		label.setText("Hello");
		panel.add(label);
		
		button = new JButton();
		button.setBounds(0, 0, 100, 100);
		button.setText("I am listener");
		button.addActionListener(this);
		panel.add(button);
		
		JButton button = new JButton();
		button.setSize(100, 100);
		button.setText("I am a button");
		panel.add(button);
		
		JButton button2 = new JButton();
		button2.setSize(100, 100);
		button2.setText("I am button2");
		panel.add(button2);
		
		JButton button3 = new JButton();
		button3.setSize(100, 100);
		button3.setText("I am button3");
		panel.add(button3);
		
		JButton button4 = new JButton();
		button4.setSize(100, 100);
		button4.setText("I am button2");
		panel.add(button4);
		
		JButton button5 = new JButton();
		button5.setSize(100, 100);
		button5.setText("I am button2");
		panel.add(button5);
		
		JButton button6 = new JButton();
		button6.setSize(100, 100);
		button6.setText("I am button2");
		panel.add(button6);
		
		for(int i=0; i<6; i++) {
			JButton button = new JButton();
			button.setBounds(0, 0, 100, 100);
			button.setText("I am button" + (i + 1));
			panel.add(button);
		}
		
		
		
		
		panel.setVisible(true);
		frame.setVisible(true);*/
		
		frame = new JFrame();
		frame.setBounds(200, 200, 600, 600);
		frame.setLayout(new GridLayout(2,2));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label1 = new JLabel();
		label1.setText("Ability Name");
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setVerticalAlignment(JLabel.CENTER);
		
		label2 = new JLabel();
		label2.setText("Ability Type");
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setVerticalAlignment(JLabel.CENTER);
		
		label3 = new JLabel();
		label3.setText("Counter");
		label3.setHorizontalAlignment(JLabel.CENTER);
		label3.setVerticalAlignment(JLabel.CENTER);
		
		button = new JButton();
		button.setText("Next");
		button.setBounds(0, 0, 300, 300);
		button.addActionListener(this);

		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(button);
		
		frame.setVisible(true);
		
	}
	
	public static void main(String []args) {
		new TESTing();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			Player player1 = new Player("Hady");
			Player player2 = new Player("Koka");
			Game game = new Game(player1, player2);
			
			try {
				game.loadAbilities("Abilities.csv");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			int size = 45;
			int randomIndex = (int) (Math.random() * size); // get index from 0 to size - 1
			
			label1.setText(game.getAvailableAbilities().get(randomIndex).getName());
			if(game.getAvailableAbilities().get(randomIndex) instanceof HealingAbility) {
				label2.setText("HealingAbility");
			}else if(game.getAvailableAbilities().get(randomIndex) instanceof DamagingAbility) {
				label2.setText("DamagingAbility");
			}else {
				label2.setText("CrowdControlAbility");
			}
			
			label3.setText(randomIndex + "");
			
		}
		
	}
	
}
