package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import player.Player;
import player.PlayerLogin;

@SuppressWarnings("serial")
public class MainGui extends JPanel implements ActionListener {
	
	private Player p;
	
	public MainGui(Player player) {
		this.p = player;
	}
	
	class MainGui2 extends JPanel implements ActionListener {
		public MainGui2() {
			setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			
			JPanel walk = new WalkingGui();
			gbc.weightx = 0.5;
			gbc.weighty = 0.5;
			gbc.fill = GridBagConstraints.BOTH;
			gbc.gridx = 0;
			gbc.gridy = 0;
			add(walk, gbc);
			
			JPanel map = new MapGui(p);
			gbc.weightx = 0.5;
			gbc.fill = GridBagConstraints.BOTH;
			gbc.gridx = 1;
			gbc.gridy = 0;
			add(map, gbc);
			
			JButton save = new JButton("Save");
			gbc.weightx = 0.5;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 1;
			gbc.gridy = 1;
			add(save, gbc);
			save.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			PlayerLogin.save(p);
			System.out.println("Saved!!!");
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
