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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import utils.GameInformationLoaderFromFile;
import static utils.GameInformationLoaderFromFile.fileExists;
import utils.ValidFileRapport;

/**
 * class used to set initial parameters.
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public class InitialParametersInput implements Runnable, ActionListener {

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
     * Quest file chooser button.
     */
    private JButton questLoaderButton;

    /**
     * start game button.
     */
    private JButton startGame;

    /**
     * contents the number of guard parameter.
     */
    private JTextField numberOfSpies;

    /**
     * is the input finish?
     */
    private boolean inputFinish;

    public InitialParametersInput(GameInformations gamedatas) {
        this.inputFinish = false;
        this.refToGameInformations = gamedatas;
    }

    @Override
    public void run() {
        // Frame initialization
        this.MainFrame = new JFrame();
        this.MainFrame.setTitle("Game Parameters");
        this.MainFrame.setSize(300, 500);
        this.MainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.MainFrame.setResizable(false);

        // Layout 
        this.MainPannel = new JPanel();
        this.MainPannel.setLayout(new GridLayout(10, 1));
        this.MainFrame.setContentPane(this.MainPannel);

        // Add imputs
        this.MainPannel.add(new JLabel("Enter the number of guards (2..8):"));
        this.numberOfGuards = new JTextField(String.valueOf(this.refToGameInformations.getNumberOfGuards()));
        this.MainPannel.add(this.numberOfGuards);
        this.MainPannel.add(new JLabel("Enter the number of spies (2..8):"));
        this.numberOfSpies = new JTextField(String.valueOf(this.refToGameInformations.getNumberOfSpies()));
        this.MainPannel.add(this.numberOfSpies);
        this.MainPannel.add(new JLabel("Open map file location:"));
        this.mapLoaderButton = new JButton("Click here");
        this.mapLoaderButton.addActionListener(this);
        this.MainPannel.add(this.mapLoaderButton);
        this.MainPannel.add(new JLabel("Open quests file location:"));
        this.questLoaderButton = new JButton("Click here");
        this.questLoaderButton.addActionListener(this);
        this.MainPannel.add(this.questLoaderButton);
        this.MainPannel.add(new JLabel(""));
        this.startGame = new JButton("Start game!");
        this.startGame.addActionListener(this);
        this.MainPannel.add(this.startGame);
        // Frame display
        this.MainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionSelected) {
        JButton selectedButton = (JButton) actionSelected.getSource();

        if (selectedButton == this.mapLoaderButton) {
            JFileChooser mapFileChooser = new JFileChooser();
            int returnVal = mapFileChooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                this.refToGameInformations.setMapLocation(mapFileChooser.getSelectedFile().getAbsolutePath());
            }
        }

        if (selectedButton == this.questLoaderButton) {
            JFileChooser questFileChooser = new JFileChooser();
            int returnVal = questFileChooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                this.refToGameInformations.setQuestsLocation(questFileChooser.getSelectedFile().getAbsolutePath());
            }
        }
        
        if (selectedButton == this.startGame) {
            this.refToGameInformations.setNumberOfGuards(Integer.parseInt(this.numberOfGuards.getText()));
            this.refToGameInformations.setNumberOfSpies(Integer.parseInt(this.numberOfSpies.getText()));
            if ((this.refToGameInformations.getNumberOfGuards()<2)||(this.refToGameInformations.getNumberOfGuards()>8))
            {
                JOptionPane.showMessageDialog(this.MainFrame, "Guard number invalid", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if ((this.refToGameInformations.getNumberOfSpies()<2)||(this.refToGameInformations.getNumberOfSpies()>8))
            {
                JOptionPane.showMessageDialog(this.MainFrame, "Spies number invalid", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            if (!GameInformationLoaderFromFile.fileExists(this.refToGameInformations.getMapLocation()))
            {
                JOptionPane.showMessageDialog(this.MainFrame, "Map file does not exist", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            if (!GameInformationLoaderFromFile.fileExists(this.refToGameInformations.getQuestsLocation()))
            {
                JOptionPane.showMessageDialog(this.MainFrame, "Quests file does not exist", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            ValidFileRapport validMapRapport = GameInformationLoaderFromFile.isMapFileValid(this.refToGameInformations.getMapLocation()); 
            if (!validMapRapport.fileIsValid)
            {
                JOptionPane.showMessageDialog(this.MainFrame, new JLabel("Invalid Map file:\n"+validMapRapport.invalidFilerapport), "ERROR", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            ValidFileRapport validQuestRapport = GameInformationLoaderFromFile.isQuestFileValid(this.refToGameInformations.getQuestsLocation()); 
            if (!validQuestRapport.fileIsValid)
            {
                JOptionPane.showMessageDialog(this.MainFrame, new JLabel("Invalid Quest file:\n"+validQuestRapport.invalidFilerapport), "ERROR", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            this.inputFinish = true;
            this.MainFrame.dispose();
            
            }
    }

    /**
     * @return the inputFinish
     */
    public boolean isInputFinish() {
        return inputFinish;
    }

}
