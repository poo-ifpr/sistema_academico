package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Aluno;
import model.Curso;
import util.EntityManagerUtil;

public class AlunoDAO extends GenericDAO<Aluno> {

	
	public AlunoDAO(){
		super(Aluno.class);
	}
	
	public List<Aluno> buscarPorNome(String nome) {
		return super.buscarPorCriterio("nome", nome);
		
	}
	
	public List<Aluno> buscarPorCursoPorNome(Curso curso, String nome){
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<Aluno> query = em.createQuery("SELECT a FROM Aluno a"
				+ " join a.cursos c WHERE c.id = :id and a.nome like :nome", Aluno.class);
		query.setParameter("id", curso.getId());
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}
	
	//Adaptador
	public void inserir(Aluno aluno){
		adicionar(aluno);
	}
}
