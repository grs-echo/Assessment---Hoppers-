import javax.swing.*;       //import swing classes (JFrame, JPanel, JButton, JTextField, JLabel, ImageIcon, etc)
import java.awt.*;          //import layout managers (FlowLayout, GridLayout, BorderLayout)
import java.awt.event.*;    //need this to integrate listeners


/*public class LevelSelect //implements ActionListener   //this class uses listeners, so this addition needs to be here for the class definition
{
    private String[] levelButtons;
    private String answer;
    private JOptionPane levelSelect;

    public LevelSelect(JFrame frame)
    {
        levelButtons = new String[4];

        for (int i=0; i<levelButtons.length; i++)
        {
            levelButtons[i] = ("Level " + (i+1));
        }

        int choice = JOptionPane.showOptionDialog(frame, "Please select your level.", "Level Select", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, levelButtons, null);
        //parent frame, message, title, message type, icon, options, initial value
        /*if (choice == 0)
        {
            level1();
        }/*
        if (choice == 1)
        {
            level2();
        }
        if (choice == 2)
        {
            level3();
        }
        if (choice == 3)
        {
            level4();
        }*/
        /*public void actionPerformed(ActionEvent e)
        {
            System.out.println("Yee");
        }
    }

}*/