package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import player.Player;

@SuppressWarnings("serial")
public class MapGui extends JPanel {
	
	@SuppressWarnings("unused")
	private Player pl;
	
	@SuppressWarnings("unused")
	private Image background;
	private BufferedImage map;
	private BufferedImage player;

	public MapGui(Player play) {
		this.pl = play;
		setPreferredSize(new Dimension(250, 200));
		setLayout(null);
		try {
			map = ImageIO.read(new File("./sprites/10x10.png"));
			setBackgroundImage(map);
			player = ImageIO.read(new File("./sprites/player.png"));
			JLabel p = new JLabel(new ImageIcon(player));
			p.setBounds(80, 80, 20, 20);
			add(p);
		} catch (Exception i) {
			i.printStackTrace();
		}
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
        	map = ImageIO.read(new File("./sprites/10x10.png"));
        	g.drawImage(map, 0, 0, this);
        } catch (Exception i) {
			i.printStackTrace();
		}
    }
	
	 public void setBackgroundImage(Image backgroundImage) {
         this.background = backgroundImage;
         repaint();
     }
}
