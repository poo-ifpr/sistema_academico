package menu;

import java.util.List;

import dao.MateriaDAO;
import facade.FacadeCurso;
import model.Curso;
import model.Materia;
import util.Console;

public class MenuMateria implements Menu {

	@Override
	public void executar() {
		int opcao = escolheOpcao();
		switch(opcao){
		
		case 1:
			inserirMateria();
			break;
		case 2:
			buscarMateria();
			break;
		case 3:
			alterarMateria();
			break;
		case 4:
			removerMateria();
			break;
		default:
			break;
		}

	}
	
	private void removerMateria() {
		MateriaDAO materiaDAO = new MateriaDAO();
		Materia materia = buscarMateriaPorId();
		if(materia == null){
			Console.mensagem("Nenhuma matéria foi encontrada");
			return;
		}
		materiaDAO.remover(materia);
		Console.mensagem("A matéria foi removida.");		
	}

	private void alterarMateria() {
		MateriaDAO materiaDAO = new MateriaDAO();
		Materia materia = buscarMateriaPorId();
		if(materia == null){
			Console.mensagem("Nenhuma matéria foi encontrada");
			return;
		}
		Console.mensagem("Matéria escolhida: " + materia);
		String nome = Console.lerString("Digite o nome da Matéria");
		if(! nome.isEmpty()){
			materia.setNome(nome);
		}
		materiaDAO.alterar(materia);
		Console.mensagem("Matéria atualizada: " + materia);
		
	}
	
	private Materia buscarMateriaPorId(){
		Long id_materia = new Long(Console.
				lerNumeroObrigatorio("Digite o id da materia"));
		MateriaDAO materiaDAO = new MateriaDAO();
		return materiaDAO.buscarPorId(id_materia);

	}


	private void buscarMateria() {
		String nomeMateria = Console.
				lerStringObrigatoria("Digite parte do nome da Matéria");
		MateriaDAO materiaDAO = new MateriaDAO();
		List<Materia> materias= materiaDAO.buscarPorNome(nomeMateria);
		Console.mensagem("Foram encontrados (" + materias.size() +") matérias");
		for(Materia materia: materias){
			Console.mensagem(materia.toString());
		}
	}

	private void inserirMateria() {
		Materia novaMateria= getNovaMateria();
		MateriaDAO materiaDAO = new MateriaDAO();
		materiaDAO.inserir(novaMateria);
	}

	private Materia getNovaMateria() {
		Curso curso = MenuCurso.getCurso();
		String nome = Console.lerStringObrigatoria("Digite o nome da Matéria");
		Materia materia = new Materia(nome, curso);
		return materia;
	}

	private int escolheOpcao() {
		Console.mensagem("\n-----Menu Matéria-----\n");
		Console.mensagem("1. Inserir");
		Console.mensagem("2. Buscar matéria por nome");
		Console.mensagem("3. Alterar matéria (por id)");
		Console.mensagem("4. Remover uma matéria (por id)");
		Console.mensagem("9. Voltar ao Menu Principal");
		return Console.lerNumeroObrigatorio("");
	}

}
