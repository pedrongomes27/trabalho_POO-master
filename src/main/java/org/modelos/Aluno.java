package org.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Aluno extends Pessoa {
    
    protected String tipoPag;
    @OneToMany
    @JoinColumn(name = "aluno")
    protected List<Responsavel> responsavel = new ArrayList<Responsavel>();
    protected String nivelEscolar;
    protected String observacao;

    public Aluno() {

    }

    public Aluno(String nome, String cpf, String dt_nascimento, String contato, String tipoPag, Responsavel responsavel, String nivelEscolar, String observacao){ //COMPLETAR TURMA E FREQUENCIA
        this.nome = nome;
        this.cpf = cpf;
        this.dt_nascimento = dt_nascimento;
        this.contato = contato;
        this.tipoPag = tipoPag;
        this.responsavel = responsavel;
        this.nivelEscolar = nivelEscolar;
        this.observacao = observacao;
    }

    public String getTipoPag() {
        return tipoPag;
    }
    public void setTipoPag(String tipoPag) {
        this.tipoPag = tipoPag;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }
    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public String getNivelEscolar() {
        return nivelEscolar;
    }public void setNivelEscolar(String nivelEscolar) {
        this.nivelEscolar = nivelEscolar;
    }

    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
