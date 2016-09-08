package dao;

import java.util.List;

import model.Curso;

public class CursoDAO extends GenericDAO<Curso> {

	
	public CursoDAO(){
		super(Curso.class);
	}
	
	public List<Curso> buscarPorNome(String nome) {
		return super.buscarPorCriterio("nome", nome);
		
	}
	
	//Adaptador
	public void inserir(Curso curso){
		adicionar(curso);
	}
}
