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
    private boolean clicked = false;
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
            (buttons[i].getButton()).addActionListener(this);
            panel.add(buttons[i].getButton());
        }
        Hoppers.setVisible(true);
    }
        //3.1 - make sure it can detect when Squares are clicked - should be done, hopefully
        //3.3 - make sure that if a user clicks a Square when already clicking on a Square, it moves the piece from A to B using moveTo - since it relies on 3.2, probably not
        //5 - determine when the game is won and add support for multiple levels

        
    /*public void actionPerformed(ActionEvent e)
    {
        if (clicked == false)
        {
            if (e.getSource().getIcon() == "RedFrog.png")
            {
                e.getSource().setIcon(new ImageIcon("RedFrog2.png"));
            }
            else if (e.getSource().getIcon() == "GreenFrog.png")
            {
                e.getSource().setIcon(new ImageIcon("GreenFrog2.png"));
            }
            current = e.getSource().getButton();
            clicked = true;
            return;
        }
        else if (clicked == true && e.getSource().getIcon() == "LilyPad.png")
        {
            target = e.getSource().getButton();
            /*if (target.getIndex() == current.getIndex())
            {
                if (current.getIcon() == "RedFrog2.png")
                {
                    current.setIcon(new ImageIcon("RedFrog.png"));
                }
                else if (current.getIcon() == "GreenFrog2.png")
                {
                    current.setIcon(new ImageIcon("GreenFrog.png"));
                }
            }
            else
            {
                moveTo(current, target);
            }
            clicked = false;
        }
    }*/
    public void actionPerformed(ActionEvent e)
    {
        for (int i=0; i<buttons.length; i++)
        {
            if (e.getSource().equals(buttons[i].getButton()))         //e.getSource gets the button you click
            {
                working = buttons[i];                   //working becomes the square corresponding to the button you click        
            }
        }
        if (clicked == false)
        {
            // if this square is a red frog
            if (working.getType() == 'r')
            {
                // ...change the image of the square to the highlighted red frog
                working.setImage("RedFrog2.png");
            }
            
            
            
            else if (working.getType() == 'g')
            {
                working.setImage("GreenFrog2.png");
            }
            current = working;
            clicked = true;
            return;
        }
       /* else if (clicked == true && working.getType() == 'p')
        {
            target = working;
            if (target.getIndex() == current.getIndex())
            {
                if (current.getIcon() == "RedFrog2.png")
                {
                    current.setIcon(new ImageIcon("RedFrog.png"));
                }
                else if (current.getIcon() == "GreenFrog2.png")
                {
                    current.setIcon(new ImageIcon("GreenFrog.png"));
                }
            }
            else
            {
                moveTo(current, target);
            }
            clicked = false;
        }*/
    }
}