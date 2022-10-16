package org.interfaces;

import javax.persistence.Query;

import org.classes.Pessoa;
import org.hibernate.Session;

public interface Pessoa_Interface {
    
    public Long getId();

    public void setId(Long id);

	public String getCpf();

    public void setCpf(String cpf);

	public String getNome();

    public void setNome(String nome);
	
	public String getDataNascimento();

    public void setDataNascimento(String datanascimento);

	public String getContato();
    
    public void setContato(String contato);

    //----CRUD-----//
    
    public void createPessoa(Pessoa pessoa, Session session);

    public void selectPessoa(Session session);

    public void updatePessoa(Session session);

    public void deletePessoa(Session session);

    public void findPessoa(Session session);
}
