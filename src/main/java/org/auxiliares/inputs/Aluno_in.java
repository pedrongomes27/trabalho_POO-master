package org.auxiliares.inputs;

import java.util.Scanner;

import org.modelos.Aluno;

public class Aluno_in {
    public Aluno createAluno(){
		Aluno aluno = new Aluno();

		Scanner c = new Scanner(System.in); 
							
		System.out.print("\nNome: ");
		String nome = c.nextLine();
		aluno.setNome(nome);

		System.out.print("CPF: ");
		String cpf = c.nextLine();
		aluno.setCpf(cpf);

		System.out.print("Data de Nascimento: ");
		String dataNasci = c.nextLine();
		aluno.setDataNascimento(dataNasci);

		System.out.print("Contato: ");
		String contato = c.nextLine();
		aluno.setContato(contato);

		System.out.print("TipoPagamento - H/M (Hora/Aula)/(Mensalidade): ");
		String tipoPag = c.nextLine();
		aluno.setTipoPag(tipoPag);

        System.out.print("Nivel Escolar: ");
		String nivelEscolar = c.nextLine();
		aluno.setContato(nivelEscolar);

        System.out.print("Obs.: ");
		String observacao = c.nextLine();
		aluno.setContato(observacao);
        
        //Turmas
        //Frequencia
        
        return aluno;
	}
}
