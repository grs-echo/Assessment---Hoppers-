import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Board //implements ActionListener
{
    private JFrame Hoppers;
    private JPanel panel;
    private Square[] buttons;     
    private GridLayout layout;
    //private boolean clicked = false;
    //private JButton current, target;

    public Board()
    {
        Hoppers = new JFrame("Hoppers!");
        Hoppers.setSize(700,700);
        panel = new JPanel();
        Hoppers.setContentPane(panel);
        GridLayout layout = new GridLayout(5,5);
        panel.setLayout(layout);
        Hoppers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttons = new Square[25];

        for (int i=0; i<buttons.length; i++)
        {
            if ((i%2)==0)                       //the remainder when i is divided by 2 is 0 (even). Because i starts at 0, this will apply to odd numbered tiles instead
            {
                buttons[i] = new Square('p', i);
            }
            else                                //odd
            {
                buttons[i] = new Square('w', i);
            }

            if (i==6 || i==8 || i==12 || i==20 || i==24)
            {
                buttons[i] = new Square('g', i);
            }
            if (i==22)
            {
                buttons[i] = new Square ('r', i);
            }
            //(buttons[i].getButton()).addActionListener(this);
            panel.add(buttons[i].getButton());
        }

        //3.1 - make sure it can detect when Squares are clicked - should be done, hopefully
        //3.3 - make sure that if a user clicks a Square when already clicking on a Square, it moves the piece from A to B using moveTo - since it relies on 3.2, probably not
        //5 - determine when the game is won and add support for multiple levels

        /*
        public void actionPerformed(ActionEvent e)
        {
            if (clicked == false)
            {
                if (e.getIcon() == "RedFrog.png")           //e? this? not sure, can't see e or this being used in any online examples
                {
                    e.setIcon(new ImageIcon("RedFrog2.png"));
                }
                else if (e.getIcon() == "GreenFrog.png")
                {
                    e.setIcon(newImageIcon("GreenFrog2.png"));
                }
                current = e;
                clicked = true;
                return;
            }
            if (clicked == true)
            {
                target = e;
                moveTo(current, target);
                clicked = false;
            }
        }
        */

        Hoppers.setVisible(true);
    }
}