package game;

import javax.swing.*;
import java.io.*;

/**
 * Created by Paweł on 2017-04-02.
 */
public class Config {

    public static int[] Point;
    public static int dimensionX, dimensionY;



    public Config() throws IOException {

        String line = null;

        try {
            File file = new File(System.getProperty("user.dir")+"\\data\\config\\config.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            LineNumberReader lnr = new LineNumberReader(bufferedReader);
            while ((line = lnr.readLine()) != null)

            {

                 //Wczytanie rozmiary planszy

                  if (line.equals("#Size")) {
                    String SizeString = lnr.readLine();
                    String[] SizeStringDivided = SizeString.split(" ", 0);

                        dimensionX = Integer.valueOf(SizeStringDivided[0]);
                      //System.out.println(dimensionX);
                        dimensionY = Integer.valueOf(SizeStringDivided[1]);
                      //System.out.println(dimensionY);

                    }
                /**
                 * Wczytanie punktacji
                 */
                else if (line.equals("#Point")) {
                    String PointString = lnr.readLine();
                    String[] PointStringDivided = PointString.split(" ", 0);
                    Point = new int[PointStringDivided.length];
                    for (int i = 0; i < PointStringDivided.length; i++) {
                        Point[i] = Integer.valueOf(PointStringDivided[i]);
                    }
                    System.out.println(Point[1]);

                }

                else
                    System.out.println("Sprawdz plik wejsciowy");

            }
            fileReader.close();

        }
            catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Blad plik wejsciowy");
            System.exit(0);}

            catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Popraw plik konfiguracyjny");
            System.exit(0);}

            catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Blad plik wejsciowy");
            System.exit(0);}
    }
}
