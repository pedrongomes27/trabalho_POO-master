package org.auxiliares.inputs;

import java.util.Scanner;

import org.modelos.Responsavel;

public class Responsavel_in {
    public Responsavel createResponsavel(){
		Responsavel responsavel = new Responsavel();

		Scanner c = new Scanner(System.in); 
							
		System.out.print("\nNome: ");
		String nome = c.nextLine();
		responsavel.setNome(nome);

		System.out.print("CPF: ");
		String cpf = c.nextLine();
		responsavel.setCpf(cpf);

		System.out.print("Data de Nascimento: ");
		String dataNasci = c.nextLine();
		responsavel.setDataNascimento(dataNasci);

		System.out.print("Contato: ");
		String contato = c.nextLine();
		responsavel.setContato(contato);

		System.out.print("Endereço: ");
		String endereco = c.nextLine();
		responsavel.setEndereco(endereco);

        return responsavel;
	}
}
