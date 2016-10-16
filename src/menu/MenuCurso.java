package menu;

import java.util.List;

import facade.FacadeCurso;
import facade.FacadeMateria;
import model.Curso;
import model.Materia;
import util.Console;
import view.curso.AlterarCursoView;
import view.curso.BuscarCursoPorIdView;
import view.curso.EscolhaNumeroCursoView;
import view.curso.ExibirCursosView;
import view.curso.LerNomeCursoView;
import view.curso.NenhumCursoEncontradoView;
import view.curso.NovoCursoView;
import view.materia.BuscarParteNomeMateriaView;
import view.materia.ExibirMateriasView;

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
		Curso curso = getCurso();
		String nomeMateria = BuscarParteNomeMateriaView.criar();
		List<Materia> materias = FacadeMateria.listarMateriasCursoPorNome(curso, nomeMateria);
		ExibirMateriasView.criar(materias);
		
	}

	private void removerCurso() {
		Long idCurso = BuscarCursoPorIdView.criar();
		Curso curso = FacadeCurso.buscarPorId(idCurso);
		if(curso == null){
			NenhumCursoEncontradoView.criar();
			return;
		}
		FacadeCurso.remover(curso);
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
		String nomeCurso = LerNomeCursoView.criar();
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

	//Utilizado em MenuMateria e MenuMatricula
	public static Curso getCurso(){
		String nomeCurso = LerNomeCursoView.criar();
		List<Curso> cursos = FacadeCurso.buscar(nomeCurso);
		if(cursos.isEmpty()){
			NenhumCursoEncontradoView.criar();
			Curso novoCurso = NovoCursoView.criar();
			cursos.add(FacadeCurso.inserir(novoCurso));
		}
		ExibirCursosView.criar(cursos);
		int i = EscolhaNumeroCursoView.criar();
		return cursos.get(i);
	}
	
}
