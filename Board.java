import javax.swing.*;       //import swing classes (JFrame, JPanel, JButton, JTextField, JLabel, ImageIcon, etc)
import java.awt.*;          //import layout managers (FlowLayout, GridLayout, BorderLayout)
import java.awt.event.*;    //need this to integrate listeners


public class Board implements ActionListener               //this class uses listeners, so this addition needs to be here for the class definition
{
    private int victoryCount;                               //an integer value to see if the victory condition is triggered
    private JFrame hoppers;                                 //a window in the Host OS
    private JPanel panel;                                   //a container to hold the components of the window
    private Square[] buttons;                               //an array of Squares as established in Square.java
    private Square working, current, target;                //Square variables as established in Square.java
    private GridLayout layout;                              //a layout manager that fixes components into an nxm matrix
    private JOptionPane victoryMessage;                     //a dialogue window only opened if the victory condition is met
    
    private int choice;                                     //for the choice made my the user of which level to play
    private String[] levelButtons;                          //for the buttons to press to select the level

    public Board()
    {
        hoppers = new JFrame("Hoppers!");       
        hoppers.setSize(750,750);                                   //establishes hoppers as a new JFrame called 'Hoppers!' and sets its size
        panel = new JPanel();
        hoppers.setContentPane(panel);                              //establishes panel as a new JPanel and sets it to the hoppers JFrame
        GridLayout layout = new GridLayout(5,5);
        panel.setLayout(layout);                                    //establishes layout as a new GridLayout and sets it to the panel panel
        hoppers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //terminates application when the window is closed
        buttons = new Square[25];                                   //creates buttons as an array of 25 squares

        levelSelect();
    }


    public void actionPerformed(ActionEvent e)                          //this triggers if a button has been clicked
    {
        for (int i=0; i<buttons.length; i++)
        {
            if (e.getSource().equals(buttons[i].getButton()))           //e.getSource gets the button you click, when it's the same as a button from one of the squares on the board then...
            {
                working = buttons[i];                                   //...working becomes the square corresponding to the button you click        
            }
        }

        if (current == null)                                            //if nothing is currently selected...
        {
            if (working.getType() == 'r')
            {
                working.setImage("RedFrog2.png");                       //...if the current square is a red frog, change the image of the square to the highlighted red frog
            }
            else if (working.getType() == 'g')
            {
                working.setImage("GreenFrog2.png");                     //...if the current square is a green frog, change the image of the square to the highlighted green frog
            }
            else
            {
                working = null;                                         //...if the current square is not a frog, don't pass it along to the variable 'current'
            }
            current = working;                                          //...'current' takes the current square
            return;
        }

        else if (working == current)                    //if the same square has been selected twice...
        {
            if (current.getType() == 'r')
            {
                current.setImage("RedFrog.png");        //...if that square is a red frog, return the image of the square to the regular red frog
            }
            else if (current.getType() == 'g')
            {
                current.setImage("GreenFrog.png");      //...if that square is a green frog, return the image of the square to the regular green frog
            }
            working = null;
            current = null;
            target = null;                              //...return all Square variables to null, act as if the click never happened
        }

        else if (current != null && working.getType() == 'p')                                   //if the first click has happened and the square clicked second is empty...
        {
            if (buttons[getMiddle(current.getIndex(), working.getIndex())].getType() == 'g')    //...if the square in the middle of the current square and the target square has a green frog (because of the way this is defined, jumping over a red frog is an illegal move)...
            {
                if (current.legalityCheck(working))                                             //...if the move is also legal as well (horizontal, vertical or diagonal)
                {
                    target = working;
                    current.moveTo(target);                                                     //...perform the moveTo method on current using target as a parameter
                    buttons[getMiddle(current.getIndex(), working.getIndex())].setToBlank();    //...set the square in the middle of the two squares being operated on to a regular lilypad
                    working = null;
                    current = null;
                    target = null;                                                              //...return all Square variables to null, act as if the click never happened
                    for (int i=0; i<buttons.length; i++)
                    {
                        if (buttons[i].getType() == 'r')
                        {
                            victoryCount = victoryCount + 1;        //every red frog increases victoryCount by 1
                        }
                        else if (buttons[i].getType() == 'g')
                        {
                            victoryCount = victoryCount + 2;        //every green frog increases victoryCount by 2
                        }
                        else
                        {
                            victoryCount = victoryCount;            //pads and water do nothing to victoryCount
                        }
                    }
                    if (victoryCount == 1)
                    {
                        victory();                                  //if victoryCount is 1 by the end of the loop (ie the only frog is the red one), the player has won
                    }
                    else
                    {
                        victoryCount = 0;                           //if not, set victoryCount back to 0 so it can be recalculated on the next movement
                    }
                }
                else
                {
                   working = null;                                  //if the move itself isn't one of the three legal types (horizontal, vertical, diagonal), cancel the movement
                }
            }
            else
            {
                working = null;                                     //if the square in the middle of curent and target isn't a frog, cancel the movement
            }
        }
    }

    public int getMiddle(int a, int b)
    {
        a = a + b;
        a = a / 2;
        return a;                                               //an easy way to calculate the middle of two numbers
    }

    public void victory()
    {
        JOptionPane.showMessageDialog(hoppers, "Congratulations, you won!", "Victory", JOptionPane.PLAIN_MESSAGE);                                                                          //a victory message displayed as a popup
        int choice = JOptionPane.showOptionDialog(hoppers, "Would you like to play again?", "Replay?",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);                         //parent frame, message, title, message type, icon, options, initial value
        if (choice == JOptionPane.YES_OPTION)
        {
            levelSelect();
        }
        if (choice == JOptionPane.NO_OPTION)
        {
            System.exit(0);                                                                                 //if the user wants to play again, bring the level select back up, if not, exit the program
        }
    }

    public void levelSelect()       //even though there are 40 level cards available, only 4 have actually been implemented, implementing the rest would be very repetitive and just 4 is enough to demonstrate that the feature works as intended
    {
        levelButtons = new String[4];

        for (int i=0; i<levelButtons.length; i++)
        {
            levelButtons[i] = ("Level " + (i+1));
        }

        int choice = JOptionPane.showOptionDialog(hoppers, "Please select your level.", "Level Select",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, levelButtons, null);
        if (choice == 0)            //ie the first option
        {
            level1();               //this corresponds to level 22 of 40
        }
        if (choice == 1)
        {
            level2();               //this corresponds to level 23 of 40
        }
        if (choice == 2)
        {
            level3();               //this corresponds to level 24 of 40
        }
        if (choice == 3)
        {
            level4();               //this corresponds to level 25 of 40
        }
    }
    
    public void level1()
    {
        returnToBase();
        for (int i=0; i<buttons.length; i++)
        {
            if (i==6 || i==8 || i==12 || i==20 || i==24)
            {
                buttons[i] = new Square('g', i);                //set the green frogs to the appropriate index values
            }
            if (i==22)
            {
                buttons[i] = new Square ('r', i);               //set the red frog to the appropriate index value
            }
            (buttons[i].getButton()).addActionListener(this);   //need to add an ActionListener (listener for buttons) to each Square in the array. 'this' is in reference to the instance currently being operated on
            panel.add(buttons[i].getButton());                  //add the buttons from the array of Squares to the panel so they can be clicked on
            hoppers.setVisible(true);
        }
    }

    public void level2()
    {
        returnToBase();
        for (int i=0; i<buttons.length; i++)
        {
            if (i==4 || i==6 || i==8 || i==12 || i==16 || i==20)
            {
                buttons[i] = new Square('g', i);
            }
            if (i==24)
            {
                buttons[i] = new Square ('r', i);
            }
            (buttons[i].getButton()).addActionListener(this);
            panel.add(buttons[i].getButton());
            hoppers.setVisible(true);
        }
    }

    public void level3()
    {
        returnToBase();
        for (int i=0; i<buttons.length; i++)
        {
            if (i==2 || i==6 || i==8 || i==10 || i==12 || i==16)
            {
                buttons[i] = new Square('g', i);
            }
            if (i==24)
            {
                buttons[i] = new Square ('r', i);
            }
            (buttons[i].getButton()).addActionListener(this);
            panel.add(buttons[i].getButton());
            hoppers.setVisible(true);
        }
    }

    public void level4()
    {
        returnToBase();
        for (int i=0; i<buttons.length; i++)
        {
            
            if (i==6 || i==8 || i==14 || i==16 || i==20)
            {
                buttons[i] = new Square('g', i);
            }
            if (i==24)
            {
                buttons[i] = new Square ('r', i);
            }
            (buttons[i].getButton()).addActionListener(this);
            panel.add(buttons[i].getButton());
            hoppers.setVisible(true);
        }
    }

    public void returnToBase()
    {
        panel.removeAll();
        for (int i=0; i<buttons.length; i++)
        {
            if ((i%2)==0)                           //the remainder when i is divided by 2 is 0 (even). Because i starts at 0, this will apply to odd numbered tiles instead
            {
                buttons[i] = new Square('p', i);    //odd numbered tiles are always lilypads
            }
            else                                    //when the index is odd
            {
                buttons[i] = new Square('w', i);    //even numbered tiles are always just water
            }
        }
    }
}