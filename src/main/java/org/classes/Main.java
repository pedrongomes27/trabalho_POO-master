package org.classes;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;
// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;

public class Main {


	public static void main(String args[]) throws InterruptedException, IOException {
		String key = " ";
		HibernateUtil hu = new HibernateUtil();
		SessionFactory sessionFactory = hu.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		do {
			limpaConsole();
			menu();
			Scanner k = new Scanner(System.in); 
			System.out.print("Escolha uma das opções do nosso menu: ");
			key = k.nextLine().toUpperCase();
			Pessoa pessoa = new Pessoa();
			
			switch (key) {
				
				case "C": //CREATE - C
					pessoa.createPessoa(pessoa, session);
					break;
	
				case "R": //READ - R
					pessoa.selectPessoa(session);
					break;
	
				case "U": //UPDATE - U
					pessoa.updatePessoa(session);
					break;
	
				case "D": //DELETE - D
					pessoa.deletePessoa(session);
					break;

				case "F": //FIND - F
					pessoa.findPessoa(session);
					break;
	
				default:
					break;
			}

		}
		while (!key.equals("0"));
		session.close();
		sessionFactory.close();
	}

	// public static void menu(){
	// 	JFrame menu = new JFrame("Cia do Saber - Reforço Escolar");
    //     menu.setBounds(300, 90, 900, 600); 

    //     // componente JPanel
    //     JPanel menuPanel = new JPanel();
    //     menuPanel.setSize(300, 300);

    //     // // usamos este diseño para centrar los componentes de JPanel
    //     // menuPanel.setLayout(new GridBagLayout());

    //     JLabel nomeLabel = new JLabel();
	// 	nomeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
    //     nomeLabel.setBounds(400, 300, 300, 30);
    //     nomeLabel.setText("Nome:   ");
		
    //     JTextField miJTextField = new JTextField(20); 
		
	// 	nomeLabel.setLayout(null);
	// 	miJTextField.setLayout(null);
    //     // Componentes no panel
    //     menuPanel.add(nomeLabel);
    //     menuPanel.add(miJTextField);

    //     // conectar Jpanel a JFrame
    //     menu.add(menuPanel);

	// 	menu.setVisible(true);

	// }
	public static void menu(){
		System.out.println("\n--- Cia do Saber Reforço Escolar ---");
		System.out.println("\sC - reate\n R - ead\n U - pdate\n D - elete\n F - ind");
	}

	public static void limpaConsole() throws InterruptedException, IOException{
		Scanner s = new Scanner(System.in);
		System.out.print("\nPressione enter para continuar...");
		s.nextLine();

		if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
	}

}
