package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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

	@JoinColumn(name="curso_id", referencedColumnName="id")
	@OneToMany(cascade=CascadeType.ALL)
	private List<Materia> materias = new ArrayList<Materia>();
	
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
	
	public List<Materia> getMaterias() {
		return materias;
	}



	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}



	public String toString(){
		return "[" + id + "] " + nome + " (" +  modalidade + ")";
	}
	
	
	
}
