/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author kakes
 */
public class Configuration {

    public static String iconFolder = "images/";
    public static String masterPoolLocation = "masterPool/";
    public static String sendImageSubject = "Stegnography - Authenticated data ";
    public static void setIconOnLabel(String fileString, JLabel label) {
        // convert string file path to image icona and set on this label
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(iconFolder + fileString));
            Image scaledInstance = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(scaledInstance);
            label.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void setIconOnLabelFromFile(File file, JLabel label) {
        // convert string file path to image icona and set on this label
        BufferedImage img = null;
        try {
            img = ImageIO.read(file);
            Image scaledInstance = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(scaledInstance);
            label.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
