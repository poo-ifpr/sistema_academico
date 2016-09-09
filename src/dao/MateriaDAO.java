package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Aluno;
import model.Curso;
import model.Materia;
import util.EntityManagerUtil;


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
	
	public List<Materia> buscarPorCursoPorNome(Curso curso, String nome){
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<Materia> query = em.createQuery("SELECT m FROM Materia m"
				+ " join m.curso c WHERE c.id = :id and m.nome like :nome", Materia.class);
		query.setParameter("id", curso.getId());
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}
}
