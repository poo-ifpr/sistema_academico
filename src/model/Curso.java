package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false, unique=true, length=45)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false, length=45)
	private Modalidade modalidade;

	
	
	public Curso() {
		super();
	}
	
	
	
	public Curso(String nome, Modalidade modalidade) {
		super();
		this.nome = nome;
		this.modalidade = modalidade;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}



	public Modalidade getModalidade() {
		return modalidade;
	}



	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}
	
	public String toString(){
		return "[" + id + "] " + nome + " (" +  modalidade + ")";
	}
	
	
	
}
