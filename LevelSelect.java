import javax.swing.*;       //import swing classes (JFrame, JPanel, JButton, JTextField, JLabel, ImageIcon, etc)
import java.awt.*;          //import layout managers (FlowLayout, GridLayout, BorderLayout)
import java.awt.event.*;    //need this to integrate listeners


public class LevelSelect //implements ActionListener   //this class uses listeners, so this addition needs to be here for the class definition
{
    //private JButton[] levelButtons;
    private String[] levelButtons;
    //private Button l1, l2, l3, l4;
    private String answer;
    private JOptionPane levelSelect;

    public LevelSelect(/*frame*/)
    {
        
        //levelButtons = new JButton[4]
        levelButtons = new String[4];
        
        
        /*
        for (int i=0; i<levelButtons.length; i++)
        {
        levelButtons[i] = new JButton ("Level " i);
        levelButtons[i].addActionListener(this);
        }*/

        for (int i=0; i<levelButtons.length; i++)
        {
            levelButtons[i] = ("Level %i" + (i+1));
        }

        JOptionPane.showOptionDialog(null, "Please select your level.", "Level Select", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, levelButtons, null);

        /*public void actionPerformed(ActionEvent e)
        {
            System.out.println("Yee");
        }*/
    }

}