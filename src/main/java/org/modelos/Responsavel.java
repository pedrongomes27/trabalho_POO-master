package org.modelos;

import javax.persistence.Entity;

@Entity
public class Responsavel extends Pessoa {
    
    protected String endereco;

    public Responsavel() {

    }

    public Responsavel(String nome, String cpf, String dt_nascimento, String contato, String endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.dt_nascimento = dt_nascimento;
        this.contato = contato;
        this.endereco = endereco;
    }

    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

}
