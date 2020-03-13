import javax.swing.*;       //import swing classes (JFrame, JPanel, JButton, JTextField, JLabel, ImageIcon, etc)

public class Square
{
    private JButton button;         //A pushable button
    private char type;              //the 'type' that the square has. An easy way to represent the image that the square has
    private ImageIcon image;        //the picture that the square has
    private int index, x, y;        //numbers to represent the square's position in board


    public Square(char c, int i)    //the square constructor requires the type and its index in the array from Board
    {
        type=c;
        
        if (type=='w')
            image = new ImageIcon("Water.png");     //w is the type letter corresponding to water
        if (type=='g')
            image = new ImageIcon("GreenFrog.png"); //g is the type letter corresponding to a green frog
        if (type=='r')
            image = new ImageIcon("RedFrog.png");   //r is the type letter corresponding to a red frog
        if (type=='p')
            image = new ImageIcon("LilyPad.png");   //p is the type letter corresponding to a lilypad
        button = new JButton(image);
        button.setIcon(image);                      //the button takes the correct image for its type
        
        index = i;

        y = index / 5;      //y represents the y coordinates of the square with a specific index value
        y = 4 - y;          //this isn't really necessary, but it works to bring the value of y more in line with the human understanding of coordinates (without this it would decrease as index increased)
        y = y + 1;

        x = index - y*5;    //x represents the x coordinates
        x = x + 1;
    }


    public void moveTo(Square dest)         //this is a method that acts on another Square; moving the image on the Square being acted on to the Square being provided as a parameter
    {
        if (type == 'r')
        {
            dest.setImage("RedFrog.png");
            dest.setType('r');              //if the type of the square being acted on is r, the destination would need to be a red frog 
        }
        else if (type == 'g')
        {
            dest.setImage("GreenFrog.png");
            dest.setType('g');              //if the type of the square being acted on is g, the destination would need to be a green frog
        }
        setToBlank();                       //the original square being acted on needs to be made blank (ie a normal lilypad)
    }

    public boolean legalityCheck(Square dest)
    {
        if (getX() == dest.getX())                      //if the x coordinates are the same
        {
            if (Math.abs(getY() - dest.getY()) == 4)    //the only valid move is if the y values of the start and destination are a magnitude of 4 squares apart (this is what Math.abs calculates)
                return true;
            else
                return false;
        }
        else if (getY() == dest.getY())                 //if the y coordinates are the same
        {
            if (Math.abs(getX() - dest.getX()) == 4)    //the only valid move is if the x values of the start and destination are a magnitude of 4 squares apart (this is what Math.abs calculates)
                return true;
            else
                return false;
        }
        else if (Math.abs(getX() - dest.getX()) == 2 && Math.abs(getY() - dest.getY()) == 2)    //this is to represent a diagonal movement
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
        return index;                       //an accessor for the index
    }

    public int getX()
    {
        return x;                           //an accessor for the x value
    }

    public int getY()
    {   
        return y;                           //an accessor for the y value
    }

    public char getType()
    {
        return type;                        //an accessor for the type
    }

    public void setType(char s)
    {
        type = s;                           // a mutator for the type
    }

    public ImageIcon getImage()
    {
        return image;                       //an accessor for the image
    }

    public void setImage(String s)
    {
        button.setIcon(new ImageIcon(s));   //a mutator for the image
    }

    public JButton getButton()
    {
        return button;                      //an accessor for the button
    }

    public void setToBlank()
    {
        setImage("LilyPad.png");
        setType('p');                       //a mutator to specifically turn the square into a lilypad square
    }
}