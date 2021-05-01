/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author USUARIO
 */
public class MainDesktopPane extends JDesktopPane{ 

    private Image image; 
     
    public MainDesktopPane() { 
        super(); 
        image = new ImageIcon(getClass().getResource("/Imagenes/fondo1.png")).getImage(); 
        setBackground(new Color(69, 64, 92)); 
    } 

    @Override 
    protected void paintComponent(Graphics g) { 
        super.paintComponent(g); 
        int h = (int)image.getHeight(null)/2; 
        int w = (int)(image.getWidth(null)/2); 
        g.drawImage(image, (int)getWidth()/2 - w, (int)getHeight()/2 - h, null); 
    } 
}  