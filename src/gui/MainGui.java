package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainGui extends JPanel implements ActionListener {
	
	public MainGui() {
		JPanel map = new MapGui();
		JPanel walk = new WalkingGui();
		setLayout(new GridLayout(2, 1));
		//map.setBounds(0, 700, 100, 100);
		//walk.setBounds(0, 500, 170, 170);
		add (map);
		add (walk);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
