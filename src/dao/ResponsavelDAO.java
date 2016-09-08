package dao;

import java.util.List;

import model.Responsavel;

public class ResponsavelDAO extends GenericDAO<Responsavel> {

	
	public ResponsavelDAO(){
		super(Responsavel.class);
	}
	
	public List<Responsavel> buscarPorNome(String nome) {
		return super.buscarPorCriterio("nome", nome);
		
	}
	
	//Adaptador
	public void inserir(Responsavel responsavel){
		adicionar(responsavel);
	}
}
