package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Responsavel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false, length=100)
	private String nome;
	
	@Column(nullable=false, length=10)
	private String telefone;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false, length=45)
	private Parentesco parentesco;
	
	@JoinColumn(name="responsavel_id",
			referencedColumnName="id")
	@OneToOne(mappedBy="responsavel")
	private Aluno aluno;
	
	public Responsavel(){
		
	}
	
	

	public Responsavel(String nome, String telefone, Parentesco parentesco) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.parentesco = parentesco;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Parentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public String toString(){
		return nome + "(" + parentesco + ")";
	}
	
}
