package gui;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class MapGui extends JPanel {
	
	private BufferedImage map;
	private BufferedImage player;

	public MapGui() {
		setPreferredSize(new Dimension(100, 100));
		setLayout(null);
		try {
			map = ImageIO.read(new File("./sprites/10x10.png"));
			JLabel img = new JLabel(new ImageIcon(map));
			img.setBounds(0, 0, 200, 200);
			add(img);
		} catch (Exception i) {
			i.printStackTrace();
		}
	}
}
