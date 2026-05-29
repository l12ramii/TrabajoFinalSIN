/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author aramo
 */
public class Utils {
     public static ImageIcon getScaledIcon(String path, int targetWidth) {
        try {
            java.net.URL imgURL = Utils.class.getResource(path);
            if (imgURL == null) {
                System.err.println("No se encontró la imagen en: " + path);
                return null;
            }
            
            ImageIcon icon = new ImageIcon(imgURL);
            Image img = icon.getImage();
            
            // Calculamos la proporción
            double ratio = (double) img.getHeight(null) / img.getWidth(null);
            int targetHeight = (int) (targetWidth * ratio);
            
            // Reescalado
            Image newImg = img.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
            return new ImageIcon(newImg);
            
        } catch (Exception e) {
            return null;
        }
    }
}
