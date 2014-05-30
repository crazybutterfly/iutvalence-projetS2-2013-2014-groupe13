package display;

import gamedatas.AllPlayers;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Class used by MainFrame to change players pseudo.
 *
 * @author MOREL Charles
 */
public class ChangePseudo implements Runnable, ActionListener {

    /* ---------------------- START DECLARATIONS ---------------------- */
    private final JMenuItem[] refToAllPlayersItemMenu;

    private final AllPlayers refToAllPlayers;

    private JComboBox pseudoChoise;

    private JTextField newPseudo;

    private JFrame pseudoChangerFrame;

    private JPanel changePseudoLayout;

    private JButton validationButton;

    private JPanel validationCancelLayout;

    private JButton cancelButton;

    /* ---------------------- END DECLARATIONS ---------------------- */
    
    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public ChangePseudo(JMenuItem[] refToAllPlayersItemMenu, AllPlayers refToAllPlayers)
    {
        this.refToAllPlayersItemMenu = refToAllPlayersItemMenu;
        this.refToAllPlayers = refToAllPlayers;
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */
    
    /* ---------------------- START FUNCTION(S) ---------------------- */
    @Override
    public void run()
    {

        // Pseudo changer frame initialization
        this.pseudoChangerFrame = new JFrame();
        this.pseudoChangerFrame.setTitle("Change pseudo");
        this.pseudoChangerFrame.setSize(200, 300);
        this.pseudoChangerFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        // Layout 
        this.changePseudoLayout = new JPanel();
        this.changePseudoLayout.setLayout(new GridLayout(5, 1));
        this.pseudoChangerFrame.setContentPane(this.changePseudoLayout);

        // Add inputs
        this.changePseudoLayout.add(new JLabel("Select the player pseudo to change:"));
        String[] avaliblePseudos = new String[this.refToAllPlayersItemMenu.length];
        for (int i = 0; i < this.refToAllPlayersItemMenu.length; i++)
        {
            avaliblePseudos[i] = this.refToAllPlayersItemMenu[i].getText();
        }
        this.pseudoChoise = new JComboBox(avaliblePseudos);
        this.changePseudoLayout.add(this.pseudoChoise);
        this.changePseudoLayout.add(new JLabel("Enter the new pseudo:"));
        this.newPseudo = new JTextField("new pseudo");
        this.changePseudoLayout.add(this.newPseudo);

        // Add Sub-inputs
        this.validationCancelLayout = new JPanel();
        this.validationCancelLayout.setLayout(new GridLayout(1, 2));
        this.validationButton = new JButton("Valid");
        this.validationButton.addActionListener(this);
        this.validationCancelLayout.add(this.validationButton);
        this.cancelButton = new JButton("Cancel");
        this.cancelButton.addActionListener(this);
        this.validationCancelLayout.add(this.cancelButton);
        this.changePseudoLayout.add(this.validationCancelLayout);
        // Frame display
        this.pseudoChangerFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionSelected)
    {
        JButton selectedButton = (JButton) actionSelected.getSource();

        if (selectedButton == this.validationButton)
        {
            int selectedPlayer = this.pseudoChoise.getSelectedIndex();
            boolean pseudoChanged = false;
            if (selectedPlayer == 0)
            {
                pseudoChanged = this.refToAllPlayers.getGuardChiefPlayer().changePseudo(this.refToAllPlayers.getAllPlayersPseudos(), this.newPseudo.getText());
            }
            if ((selectedPlayer >= 1) && (selectedPlayer < this.refToAllPlayers.getNumberOfGuards()))
            {
                pseudoChanged = this.refToAllPlayers.getGuardsArray()[selectedPlayer - 1].changePseudo(this.refToAllPlayers.getAllPlayersPseudos(), this.newPseudo.getText());
            }
            if (selectedPlayer >= this.refToAllPlayers.getNumberOfGuards())
            {
                pseudoChanged = this.refToAllPlayers.getSpiesArray()[selectedPlayer - this.refToAllPlayers.getNumberOfGuards()].changePseudo(this.refToAllPlayers.getAllPlayersPseudos(), this.newPseudo.getText());
            }
            if (!pseudoChanged)
            {
                JOptionPane.showMessageDialog(this.pseudoChangerFrame, new JLabel("ERROR: this pseudo is already in use by an other player"), "ERROR", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            else
            {
                this.refToAllPlayersItemMenu[selectedPlayer].setText(this.newPseudo.getText());
                this.pseudoChangerFrame.dispose();
            }
        }
        if (selectedButton == this.cancelButton)
        {
            this.pseudoChangerFrame.dispose();
        }
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */
}
