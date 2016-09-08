package menu;

import dao.CursoDAO;
import model.Curso;
import model.Modalidade;
import util.Console;

public class MenuCurso implements Menu {

	@Override
	public void executar() {
		int opcao = escolheOpcao();
		if(opcao == 1){
			inserirCurso();
		}
	}
	
	private void inserirCurso() {
		System.out.println("Vou Inserir um Curso");
		Curso novoCurso = getNovoCurso();
		CursoDAO cursoDAO = new CursoDAO();
		cursoDAO.inserir(novoCurso);
		
	}

	private Curso getNovoCurso() {
		String nome = Console.lerStringObrigatoria("Digite o nome do Curso");
		Modalidade modalidade = getModalidade();
		Curso curso = new Curso();
		curso.setNome(nome);
		curso.setModalidade(modalidade);
		return curso;
	}

	private Modalidade getModalidade() {
		int numeroModalidade = Console.
				lerNumeroObrigatorio("Digite a Modalidade (número).\n"
						+ "1. Técnico Integrado\n"
						+ "2. Técnico Subsequente");
		try{
			return Modalidade.getModalidade(numeroModalidade);
		}
		catch(IllegalArgumentException e){
			return getModalidade();
		}
	}

	public int escolheOpcao(){
		System.out.println("Inserir um curso");
		return 1;
	}

}
