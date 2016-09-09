package menu;

import java.util.List;

import dao.CursoDAO;
import dao.MateriaDAO;
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
		// TODO Auto-generated method stub
		
	}

	private void alterarMateria() {
		// TODO Auto-generated method stub
		
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
		Curso curso = getCurso();
		String nome = Console.lerStringObrigatoria("Digite o nome da Matéria");
		Materia materia = new Materia(nome, curso);
		return materia;
	}
	
	private Curso getCurso(){
		String nomeCurso = Console.lerStringObrigatoria("Digite parte do nome do Curso");
		CursoDAO cursoDAO = new CursoDAO();
		List<Curso> cursos = cursoDAO.buscarPorNome(nomeCurso);
		if(cursos.isEmpty()){
			Console.mensagem("Nenhum curso encontrado. Adicione um");
			cursos.add(new MenuCurso().inserirCurso());
		}
		Console.mensagem("Foram encontrados (" + cursos.size() +") cursos");
		int i = 0;
		for(Curso curso : cursos){
			i++;
			Console.mensagem("(" + i + ") " +curso.toString());
		}
		i = Console.lerNumeroObrigatorio("Escolha o número do Curso");
		return cursos.get(i - 1);
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
