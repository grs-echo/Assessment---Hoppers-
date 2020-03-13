import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Board implements ActionListener
{
    private JFrame Hoppers;
    private JPanel panel;
    private Square[] buttons;
    private Square working, current, target;     
    private GridLayout layout;

    public Board()
    {
        Hoppers = new JFrame("Hoppers!");
        Hoppers.setSize(750,750);
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

            //level support
            if (i==6 || i==8 || i==12 || i==20 || i==24)
            {
                buttons[i] = new Square('g', i);
            }
            if (i==22)
            {
                buttons[i] = new Square ('r', i);
            }
            (buttons[i].getButton()).addActionListener(this);
            panel.add(buttons[i].getButton());
        }
        Hoppers.setVisible(true);
    }


    public void actionPerformed(ActionEvent e)
    {
        for (int i=0; i<buttons.length; i++)
        {
            if (e.getSource().equals(buttons[i].getButton()))           //e.getSource gets the button you click
            {
                working = buttons[i];                                   //working becomes the square corresponding to the button you click        
            }
        }

        if (current == null)                                            //if nothing is currently selected
        {
            if (working.getType() == 'r')                               //if this square is a red frog
            {
                working.setImage("RedFrog2.png");                       // ...change the image of the square to the highlighted red frog
            }
            else if (working.getType() == 'g')
            {
                working.setImage("GreenFrog2.png");
            }
            else
            {
                working = null;
            }
            current = working;
            return;
        }

        else if (working == current)                                    //the same square has been selected twice
        {
            if (current.getType() == 'r')
            {
                current.setImage("RedFrog.png");
            }
            else if (current.getType() == 'g')
            {
                current.setImage("GreenFrog.png");
            }
            current = null;
            target = null;
        }

        else if (current != null && working.getType() == 'p')           //the second clicked square is empty
        {
            if (current.legalityCheck(target) == true)
            {
            target = working;
            current.moveTo(target);
            current = null;
            target = null;
            }
            else
            {
                working = null;
            }
        }
    }
    //victory message
    //level select
}