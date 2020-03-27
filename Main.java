import javax.swing.*;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;

public class Main{

	public static void main(String[] args) throws IOException{

		JFileChooser dialogue = new JFileChooser(new File("."));
		PrintWriter sortie;
		File fichier;
		if(dialogue.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			fichier = dialogue.getSelectedFile();
			sortie = new PrintWriter(new FileWriter(fichier.getPath(),true));
			sortie.println(args[0]);
			sortie.close();
		}else{

		Tableau tableau = new Tableau();
		Grille grille = new Grille(tableau);
		JFrame fenetre = new JFrame("Sudoku");

		//tableau.setValue(0,0,0,1);

		fenetre.addMouseListener(grille);
		//fenetre.addMouseMotionListener(grille);
		fenetre.setSize(1000, 500);
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    fenetre.add(grille, BorderLayout.CENTER);
	    fenetre.setResizable(false);
	    //System.out.println("valeur : " + tableau.getValeur(0,0,5));
	    fenetre.setVisible(true);
		}
	}
}