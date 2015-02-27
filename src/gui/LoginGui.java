package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import player.PlayerLogin;

@SuppressWarnings("serial")
public class LoginGui extends JPanel implements ActionListener {
    private JLabel logonlabel;
    private JTextField password;
    private JTextField user;
    
    private JLabel userlabel;
    private JLabel passwordlabel;
    private JButton jcomp6;
    
    public LoginGui() {
      
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (PlayerLogin.load(user.getText(), password.getText())) {
			Window w = SwingUtilities.getWindowAncestor(this);
			w.setVisible(false);
			JFrame frame = new JFrame ("Adventure");
        	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        	frame.getContentPane().add (new MainGui());
        	frame.setPreferredSize(new Dimension(500, 800));
        	frame.pack();
        	frame.setResizable(false);
        	frame.setVisible (true);
		}
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
