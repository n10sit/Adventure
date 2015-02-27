package gui;


import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Console extends JPanel {
  private JTextArea console;

  public Console() {
     
      console = new JTextArea (5, 5);
      console.setText("I was thinking this could be the console. Output what the player does in here.");
      console.setEditable(false);
      setPreferredSize (new Dimension (400, 200));
      setLayout (new BorderLayout());

     
      add (console);

     
      console.setBounds (0, 0, 555, 515);
      JScrollPane scrollPane = new JScrollPane(console);
      
      this.add(scrollPane, BorderLayout.CENTER);
      /* I can't figure out how to make the scroll pane be vertical instead of horizontal... */
  }


  /*public static void main (String[] args) {
      JFrame frame = new JFrame ("Console");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add (new Console());
      frame.pack();
      frame.setVisible (true);
  }*/
}
