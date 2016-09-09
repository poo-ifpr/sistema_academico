package dao;

import java.util.List;

import model.Materia;


public class MateriaDAO extends GenericDAO<Materia> {

	
	public MateriaDAO(){
		super(Materia.class);
	}
	
	public List<Materia> buscarPorNome(String nome) {
		return super.buscarPorCriterio("nome", nome);
		
	}
	
	//Adaptador
	public void inserir(Materia materia){
		adicionar(materia);
	}
}
