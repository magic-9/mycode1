package game;

import javax.swing.*;

/**
 * Created by Paweł on 2017-04-02.
 */
public class GameFrame extends JFrame {

    private JPanel activePanel;
    public static MenuPanel panel_menu;

public GameFrame(){

    try{
        new Config();
    }catch(Exception io){
        System.out.println("Exception: " + io);
    }

    panel_menu = new MenuPanel(this);
    this.activePanel = panel_menu;

    this.setTitle("Pac-Man");
    this.add(panel_menu);
    this.pack();

}

    public void changePanel(JPanel next){
        this.remove(activePanel);
        this.add(next);
        //repaint();
        this.pack();
        activePanel = next;

    }

}
