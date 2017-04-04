package game;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                GameFrame gameframe = new GameFrame();
                gameframe.setLocationRelativeTo(null);
                gameframe.setVisible(true);


            }
        });
    }
}