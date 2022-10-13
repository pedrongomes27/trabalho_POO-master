package org.example;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner; 


public class Main {

	public static void main(String args[]) throws InterruptedException, IOException {
		String key = " ";
		HibernateUtil hu = new HibernateUtil();
		SessionFactory sessionFactory = hu.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		do {
			limpaConsole();
			menu(key);
			Scanner k = new Scanner(System.in); 
			System.out.print("Escolha uma das opções do nosso menu: ");
			key = k.nextLine().toUpperCase();

			switch (key) {

				case "C": //CREATE - C
					session.beginTransaction();
					Scanner c = new Scanner(System.in); 
					
					Pessoa p1 = new Pessoa();
					
					System.out.print("\nNome: ");
					String nome = c.nextLine();
					p1.setNome(nome);

					System.out.print("CPF: ");
					String cpf = c.nextLine();
					p1.setCpf(cpf);

					System.out.print("Data de Nascimento: ");
					String dataNasci = c.nextLine();
					p1.setDataNascimento(dataNasci);

					System.out.print("Contato: ");
					String contato = c.nextLine();
					p1.setContato(contato);

					session.save(p1);
					session.flush();

					// session.save( new Pessoa(nome, cpf, dataNasci, contato));
					session.getTransaction().commit();
					break;
	
				case "R": //READ - R
					System.out.println("\n--- SELECT ---");
					session.beginTransaction();
					session.flush();

					List result = session.createQuery( "from Pessoa" ).list();
					for ( Pessoa pessoa : (List<Pessoa>) result ) {
						System.out.println( pessoa.getId() + " - " + pessoa.getNome() + " - " + pessoa.getCpf() + " - " + pessoa.getDataNascimento() + " - " + pessoa.getContato());
					}
					session.getTransaction().commit();	

					break;
	
				case "U": //UPDATE - U
					System.out.println("\n--- UPDATE com WHERE ---");
					session.beginTransaction();
					Query query = session.createQuery( "UPDATE Pessoa p SET p.nome = :newnome WHERE p.cpf = :cpf" );
					String newnome = "Othon";
					query.setParameter("cpf","78978978913");
					query.setParameter("newnome", newnome);
					query.executeUpdate();
					session.flush();
					session.getTransaction().commit();	
					break;
	
				case "D": //DELETE - D
					System.out.println("\n--- DELETE ---");
					session.beginTransaction();
					query = session.createQuery( "DELETE FROM Pessoa p WHERE p.cpf = :cpf" );
					query.setParameter("cpf","09829992809");
					query.executeUpdate();
					session.getTransaction().commit();
					break;
	
				// case "0":
				// 	//System.exit(0);
				// 	break;
				default:
					break;
			}

			System.out.println(key);


		}
		while (!key.equals("0"));
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
