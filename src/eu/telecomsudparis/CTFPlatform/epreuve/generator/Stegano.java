package eu.telecomsudparis.CTFPlatform.epreuve.generator;

import eu.telecomsudparis.CTFPlatform.epreuve.generator.helper.PanneauSteg;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*; 

import javax.imageio.ImageIO;

public class Stegano extends EpreuveGenerator {
    public Stegano() throws IOException {
    	//Thread.currentThread().getContextClassLoader().getResourceAsStream("./eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveStegano1");
        PanneauSteg p = new PanneauSteg();
        BufferedImage image = new BufferedImage(790, 977, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        p.paintComponent(g);        
        g.dispose();
        ImageIO.write(image, "jpeg", new File("eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveStegano1.jpeg"));
		new File("eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveStegano1.jpeg");
		p.creerEpreuve();
        //System.exit(0);
    }
}