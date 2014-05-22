package display;

import gamecore.GameInformations;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JTextField;

/**
 * class used to set initial parameters.
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public class InitialParametersInput implements Runnable, ActionListener
{

    private final GameInformations refToGameInformations;
    
    /**
     * Main frame of the parameters.
     */
    private JFrame MainFrame;
    
    /**
     * contents the layout of the JFrame.
     */
    private JPanel MainPannel;
    
    /**
     * contents the number of guard parameter.
     */
    private JTextField numberOfGuards;
    
    /**
     * Map file chooser button.
     */
    private JButton mapLoaderButton;
    
    /**
     * contents the number of guard parameter.
     */
    private JTextField numberOfSpies;
    
    private boolean inputFinish;

    public InitialParametersInput(GameInformations gamedatas)
    {
        this.inputFinish = false;
        this.refToGameInformations = gamedatas;
    }

    @Override
    public void run()
    {
        // Frame initialization
        this.MainFrame = new JFrame();
        this.MainFrame.setTitle("Game Parameters");
        this.MainFrame.setSize(300, 500);
        this.MainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.MainFrame.setResizable(false);
        
        // Layout 
        this.MainPannel = new JPanel();
        this.MainPannel.setLayout(new GridLayout(15, 1));
        this.MainFrame.setContentPane(this.MainPannel);
        
        // Add imputs
        this.MainPannel.add(new JLabel("Enter the number of guards (2..8):"));
        this.numberOfGuards = new JTextField(String.valueOf(this.refToGameInformations.getNumberOfGuards()));
        this.MainPannel.add(this.numberOfGuards);
        this.MainPannel.add(new JLabel("Enter the number of spies (2..8):"));
        this.numberOfSpies = new JTextField(String.valueOf(this.refToGameInformations.getNumberOfSpies()));
        this.MainPannel.add(this.numberOfSpies);
        this.MainPannel.add(new JLabel("Ouvrir l'emplacement du fichier de la map:"));
        this.mapLoaderButton = new JButton("Cliquez ici");
        this.mapLoaderButton.addActionListener(this);
        this.MainPannel.add(this.mapLoaderButton);
        JFileChooser dialogue = new JFileChooser(new File("."));
        dialogue.showOpenDialog(null);
//        this.
        // Frame display
        this.MainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the inputFinish
     */
    public boolean isInputFinish()
    {
        return inputFinish;
    }


}
