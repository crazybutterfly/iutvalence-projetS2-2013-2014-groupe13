package display;


import gamedatas.AllPlayers;
import display.classicdisplay.ClassicStoreScreen;
import display.guardchiefdisplay.GuardChiefMainMap;
import display.classicdisplay.ClassicMainMap;
import gamedatas.Map;
import display.guardchiefdisplay.GuardChiefStoreScreen;
import gamedatas.Store;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.awt.event.ActionListener;

public class MainDisplay implements Runnable, ActionListener
{

    public ClassicMainMap myClassicMainMap;
    public ClassicStoreScreen myClassicStoreScreen;
    public SideBar mySideBar;

    public MiniMap myMiniMap;
    public GuardChiefMainMap myGuardChiefMainMap;
    public GuardChiefStoreScreen myGuardChiefStoreScreen;

    public void refreshDisplay(Map myMap, Store stores, AllPlayers players)
    {
    }

    public void displayLastScreen()
    {
    }

    private JFrame fenetre;
    
    private JMenuItem menuItem;
    
    private JMenuItem menuJoueur;
    
    private JMenuItem menuFermer;
    
    
    
    @Override
    public void run()
    {
        this.fenetre = new JFrame();
        
        this.fenetre.setTitle("Spies & Guards");
        this.fenetre.setSize(720,610);
        this.fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JMenuBar barreDeMenu = new JMenuBar();
        
        JMenu menu = new JMenu("Menu");
  
        this.menuFermer = new JMenuItem("Fermer");
        this.menuFermer.addActionListener(this);
        menu.add(this.menuFermer);
        
        JMenu Joueur = new JMenu("Joueur");
        
              
        this.menuJoueur = new JMenuItem("J1");
        
        this.menuJoueur.addActionListener(this);
        
        menu.add(this.menuItem);
        
        
        barreDeMenu.add(menu);
        barreDeMenu.add(Joueur);
        
        this.fenetre.setJMenuBar(barreDeMenu);
        this.fenetre.setVisible(true);
             
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
      	JMenuItem itemSelectionne = (JMenuItem) event.getSource();

        if (itemSelectionne == this.menuJoueur)
        {
            JOptionPane.showMessageDialog(this.fenetre, "machin", "Truc", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (itemSelectionne == this.menuFermer)
        {

            if (JOptionPane.showConfirmDialog(this.fenetre, "Fermer l'application ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)

            this.fenetre.dispose();
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
