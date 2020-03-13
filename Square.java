import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Square
{
    private JButton button;
    private char type;
    private ImageIcon image;
    private int index, x, y;


    public Square(char c, int i)
    {
        type=c;
        
        if (type=='w')
            image = new ImageIcon("Water.png");
        if (type=='g')
            image = new ImageIcon("GreenFrog.png");
        if (type=='r')
            image = new ImageIcon("RedFrog.png");
        if (type=='p')
            image = new ImageIcon("LilyPad.png");
        button = new JButton(image);
        button.setIcon(image);
        
        index = i;

        y = index / 5;
        y = 4 - y;
        
        x = index - y*5;
        x= x - 1;
    }


    public void moveTo(Square dest) //for button start and button end
    {
        if (type == 'r')
        {
            dest.setImage("RedFrog.png");
            dest.setType('r');
        }
        else if (type == 'g')
        {
            dest.setImage("GreenFrog.png");
            dest.setType('g');
        }
        setImage("LilyPad.png");
        setType('p');
        /*delete the one inbetween*/
    }

    public boolean legalityCheck(Square dest)
    {
        /*(pseudocode for now)
        check the x coordinates - are they the same
        check the y coordinates - are they the same
        if they aren't the same, are both of them different by a modulus of two
        if none of these, invalid move, never move target to working (working = null)*/
        if (getX() == dest.getX() || getY() == dest.getY())
        {
            return true;
        }
        else if (Math.abs(getX() - dest.getX()) == 2 && Math.abs(getY() - dest.getY()) == 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    

    public int getIndex()
    {
        return index;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {   
        return y;
    }

    public char getType()
    {
        return type;
    }

    public void setType(char s)
    {
        type = s;
    }

    public ImageIcon getImage()
    {
        return image;
    }

    public void setImage(String s)
    {
        button.setIcon(new ImageIcon(s));     
    }

    public JButton getButton()
    {
        return button;
    }
}