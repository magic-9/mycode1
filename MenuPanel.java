package game;

import com.sun.glass.ui.Size;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Paweł on 2017-04-01.
 */
public class MenuPanel extends JPanel {

    //ImageFrame panel;
    JButton startButton,levelButton, scoreButton, helpButton, soundButton, endButton;
    JPanel buttons;
    HelpPanel helpPanel;
    ScoresPanel scoresPanel;
    String menuPath = "data\\resources\\pacman_logo.jpg";
    Image menuImage;
    private GameFrame gameFrame;

    private static int defaultWidth;
    private static int defaultHeight;


    public MenuPanel(GameFrame visibleFrame){

        defaultWidth = Config.dimensionX;
        defaultHeight = Config.dimensionY;

        menuImage = (new ImageIcon(menuPath).getImage());
        setPreferredSize(new Dimension(menuImage.getWidth(this), menuImage.getHeight(this)));

        this.gameFrame = visibleFrame;
        this.setLayout(new BorderLayout());

        helpPanel = new HelpPanel(gameFrame);
        scoresPanel = new ScoresPanel(gameFrame);


        buttons = new JPanel(new GridLayout(6, 1, 0 , 10));

        buttons.add(startButton = new JButton("Start"));
        buttons.add(levelButton = new JButton("Poziom"));
        buttons.add(scoreButton = new JButton("Najlepsze wyniki"));
        buttons.add(helpButton = new JButton("Pomoc"));
        buttons.add(soundButton = new JButton("Dźwięk"));
        buttons.add(endButton = new JButton("Koniec"));
        //panel.add(buttons,BorderLayout.SOUTH);


        scoreButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameFrame.changePanel(scoresPanel);
            }});

        helpButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameFrame.changePanel(helpPanel);
            }});

        endButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exit");
                System.exit(0);
            }});

        this.add(buttons, BorderLayout.SOUTH);
        this.setVisible(true);
        //setLocationRelativeTo(null);
    }


    /*public void changePanel(JPanel next){
        this.remove(currentPanel);			// usuniecie z ramki obecnie wyswietlanego panelu
        this.add(next);						// wlozenie nowego panelu
        repaint();							// odrysowanie zawartości
        this.pack();						// spakowanie w ramke
        currentPanel = next;				// przypisanie referencji na obecnie wyswietlany panel
    }*/


    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        g.drawImage(menuImage, 0, 0, getWidth(), getHeight(), this);

    }

    /*public Dimension getPreferredSize(){

        return new Dimension(defaultWidth, defaultHeight);

    }*/



}

