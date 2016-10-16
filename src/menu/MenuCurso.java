package menu;

import facade.FacadeCurso;
import model.Curso;
import util.Console;
import view.NovoCursoView;

public class MenuCurso implements Menu {

	@Override
	public void executar() {
		int opcao = escolheOpcao();
		switch(opcao){
		
		case 1:
			inserirCurso();
			break;
		case 2:
			buscarCurso();
			break;
		case 3:
			alterarCurso();
			break;
		case 4:
			removerCurso();
			break;
		case 5:
			listarMateriasPorNome();
			break;
		default:
			break;
		}
	}
	
	private void listarMateriasPorNome() {
		
	}

	private void removerCurso() {
		
	}

	private void alterarCurso() {
		
	}

	private void buscarCurso() {
		
	}
	
	

	//Reutilizado em MenuMatéria
	public Curso inserirCurso() {
		Curso novoCurso = NovoCursoView.criar();
		return FacadeCurso.inserir(novoCurso);
	}


	public int escolheOpcao(){
		Console.mensagem("\n-----Menu Curso-----\n");
		Console.mensagem("1. Inserir");
		Console.mensagem("2. Buscar curso por nome");
		Console.mensagem("3. Alterar Curso (por id)");
		Console.mensagem("4. Remover um Curso (por id)");
		Console.mensagem("5. Listar matérias do Curso (por parte do nome)");
		Console.mensagem("9. Voltar ao Menu Principal");
		return Console.lerNumeroObrigatorio("");
	}

}
