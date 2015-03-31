package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.Main;
import player.Player;
import player.PlayerLogin;

@SuppressWarnings("serial")
public class LoginGui extends JPanel implements ActionListener {
    private JLabel logonlabel;
    private JTextField password;
    private JTextField user;
    
    private JLabel userlabel;
    private JLabel passwordlabel;
    private JButton jcomp6;
    
    private Player p;
    
    public LoginGui(Player Player) {
    	this.p = Player;
    }
    
    public void createLoginGui() {
    	logonlabel = new JLabel ("Login to Game");
        password = new JTextField (5);
        user = new JTextField (5);
        userlabel = new JLabel ("Username:");
        passwordlabel = new JLabel ("Password:");
        jcomp6 = new JButton ("Enter");

        setPreferredSize (new Dimension (400, 400));
        setLayout (null);
        
        add (logonlabel);
        add (password);
        add (user);
        add (userlabel);
        add (passwordlabel);
        add (jcomp6);

        logonlabel.setBounds (80, 0, 150, 25);
        password.setBounds (0, 185, 100, 25);
        user.setBounds (0, 105, 100, 25);
        userlabel.setBounds (0, 80, 100, 25);
        passwordlabel.setBounds (0, 165, 100, 25);
        jcomp6.setBounds (290, 240, 100, 25);
        
        jcomp6.addActionListener(this);
    }
    
    public void load(String name, String pass) {
    	name = name.trim();
		name = name.toLowerCase();
		pass = pass.toLowerCase();
		if(!name.matches("[A-Za-z0-9 ]+")) {
			System.out.println("bad character");
			return;
		}
		if(name.length() > 12) {
			System.out.println("too long");
			return;
		}
		Player pl = new Player(-1);
		pl.name = name;
		pl.pass = pass;
		
		PlayerLogin.load(pl, pl.name, pl.pass);
		if(!Main.playerHandler.newPlayer(pl)) {
			
		} else {
			PlayerLogin.save(pl);
		}
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		load(user.getText(), password.getText());
		Window w = SwingUtilities.getWindowAncestor(this);
		w.setVisible(false);
		JFrame frame = new JFrame ("Adventure");
       	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new MainGui(p));
       	frame.setPreferredSize(new Dimension(500, 800));
       	frame.pack();
       	frame.setResizable(false);
        frame.setVisible (true);
	}
    
    

   /* stuff we need to add to the main
    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new guilogin());
        frame.pack();
        frame.setVisible (true);
    } */
}
