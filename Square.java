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
        
        index=i+1;

        y = index/5;
        y=y-1;
        
        x = index - y*5;
        x=x-1;
    }

    //3.2 - write a moveTo method that can be enacted on a Square and take another Square as a parameter - maybe?

    /*public void moveTo(button s, button e) //for button start and button end
    {
        if (s.getIcon == "RedFrog2.png")
        {
            e.setIcon(new ImageIcon("RedFrog.png"));
        }
        else if (s.getIcon == "GreenFrog2.png")
        {
            e.setIcon(new ImageIcon("GreenFrog.png"));
        }
        s.setIcon(new ImageIcon("LilyPad.png"));
    }*/

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