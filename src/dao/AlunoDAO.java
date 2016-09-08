package dao;

import java.util.List;

import model.Aluno;

public class AlunoDAO extends GenericDAO<Aluno> {

	
	public AlunoDAO(){
		super(Aluno.class);
	}
	
	public List<Aluno> buscarPorNome(String nome) {
		return super.buscarPorCriterio("nome", nome);
		
	}
	
	//Adaptador
	public void inserir(Aluno aluno){
		adicionar(aluno);
	}
}
