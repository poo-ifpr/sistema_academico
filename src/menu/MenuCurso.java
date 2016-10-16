package menu;

import java.util.List;

import facade.FacadeCurso;
import model.Curso;
import util.Console;
import view.AlterarCursoView;
import view.BuscarCursoPorIdView;
import view.BuscarCursoPorNomeView;
import view.ExibirCursosView;
import view.NenhumCursoEncontradoView;
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
		Long idCurso = BuscarCursoPorIdView.criar();
		Curso curso = FacadeCurso.buscarPorId(idCurso);
		if(curso == null){
			NenhumCursoEncontradoView.criar();
			return;
		}
		Curso cursoAlterado = AlterarCursoView.criar(curso);
		FacadeCurso.alterar(cursoAlterado);
	}

	private void buscarCurso() {
		String nomeCurso = BuscarCursoPorNomeView.criar();
		List<Curso> cursos = FacadeCurso.buscar(nomeCurso);
		ExibirCursosView.criar(cursos);
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
