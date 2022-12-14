package org.example;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;  // Import the Scanner class


public class Main {

	public static void main(String args[]) throws InterruptedException, IOException {
		String key = " ";
		HibernateUtil hu = new HibernateUtil();
		SessionFactory sessionFactory = hu.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		do {
			menu(key);
			Scanner input = new Scanner(System.in); 
			System.out.print("Escolha uma das opções do nosso menu:");
			key = input.nextLine();
			switch (key) {

				case "C": //CREATE - C
					System.out.println("");
					session.beginTransaction();
					session.save( new Pessoa("09829992809", "Raphael"));
					session.save( new Pessoa("64783763565", "Alana"));
					session.getTransaction().commit();
					limpaConsole();
					break;
	
				case "R": //READ - R
					//busca todos os dados na base
					System.out.println("\n--- SELECT ---");
					List result = session.createQuery( "from Pessoa" ).list();
					for ( Pessoa pessoa : (List<Pessoa>) result ) {
						System.out.println( pessoa.getId() + " - " + pessoa.getCpf() + " - " + pessoa.getNome());
					}
					limpaConsole();
					break;
	
				case "U": //UPDATE - U
					System.out.println("\n--- UPDATE com WHERE ---");
					session.beginTransaction();
					Query query = session.createQuery( "UPDATE Pessoa p SET p.nome = :newnome WHERE p.cpf = :cpf" );
					String nome = "Jorge";
					query.setParameter("cpf","09829992809");
					query.setParameter("newnome", nome);
					query.executeUpdate();
					session.getTransaction().commit();	
					limpaConsole();
					break;
	
				case "D": //DELETE - D
					System.out.println("\n--- DELETE ---");
					session.beginTransaction();
					query = session.createQuery( "DELETE FROM Pessoa p WHERE p.cpf = :cpf" );
					query.setParameter("cpf","09829992809");
					query.executeUpdate();
					session.getTransaction().commit();
					limpaConsole();
					break;
	
				case "0":
					System.exit(0);
					break;
				default:
					break;
			}

		}
		while (key != "0");
		session.close();
		sessionFactory.close();
	}

	public static void menu(String key){
		System.out.println("\n--- Cia do Saber Reforço Escolar ---");
		System.out.println("\sC - reate\n R - ead\n U - pdate\n D - elete");
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
