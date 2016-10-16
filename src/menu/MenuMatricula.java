package menu;

import java.util.List;

import dao.AlunoDAO;
import dao.CursoDAO;
import facade.FacadeCurso;
import model.Aluno;
import model.Curso;
import util.Console;

public class MenuMatricula implements Menu {

	@Override
	public void executar() {
		int opcao = escolheOpcao();
		switch(opcao){
			case 1:
				matricularAluno();
				break;
			case 2:
				removerAlunoCurso();
				break;
			case 3:
				listarAlunosCurso();
				break;
			default:
				break;
		}
	}
	
	private void listarAlunosCurso() {
		AlunoDAO alunoDAO = new AlunoDAO();
		Curso curso = MenuCurso.getCurso();
		String nomeAluno = Console.
				lerStringObrigatoria("Digite parte do nome do Aluno");
		List<Aluno> alunos = alunoDAO.buscarPorCursoPorNome(curso, nomeAluno);
		Console.mensagem("Foram encontrados (" + alunos.size() +") alunos");
		int i = 0;
		for(Aluno aluno: alunos){
			i++;
			Console.mensagem(aluno.toString());
		}
	}

	private void removerAlunoCurso() {
		CursoDAO cursoDAO = new CursoDAO();
		Curso curso = MenuCurso.getCurso();
		List<Aluno> alunos = curso.getAlunos();
		if(alunos.isEmpty()){
			Console.mensagem("Nenhum aluno encontrado");
			return;
		}
		Console.mensagem("Foram encontrados (" + alunos.size() +") alunos");
		int i = 0;
		for(Aluno aluno: alunos){
			i++;
			Console.mensagem("(" + i + ") " +aluno.toString());
		}
		i = Console.lerNumeroObrigatorio("Escolha o número do Aluno");
		alunos.remove(i - 1);
		curso.setAlunos(alunos);
		cursoDAO.alterar(curso);
	}

	private void matricularAluno(){
		Curso curso = MenuCurso.getCurso();
		Aluno aluno = getAluno();
		curso.getAlunos().add(aluno);
		CursoDAO cursoDAO = new CursoDAO();
		cursoDAO.alterar(curso);
	}
	
	private Aluno getAluno(){
		String nomeAluno = Console.
				lerStringObrigatoria("Digite parte do nome do Aluno");
		AlunoDAO alunoDAO = new AlunoDAO();
		List<Aluno> alunos = alunoDAO.buscarPorNome(nomeAluno);
		if(alunos.isEmpty()){
			Console.mensagem("Nenhum aluno encontrado. Adicione um");
			alunos.add(new MenuAluno().inserirAluno());
		}
		Console.mensagem("Foram encontrados (" + alunos.size() +") alunos");
		int i = 0;
		for(Aluno aluno: alunos){
			i++;
			Console.mensagem("(" + i + ") " +aluno.toString());
		}
		i = Console.lerNumeroObrigatorio("Escolha o número do Aluno");
		return alunos.get(i - 1);
	}
	
	private int escolheOpcao() {
		Console.mensagem("\n-----Menu Matrícula-----\n");
		Console.mensagem("1. Matricular aluno no Curso");
		Console.mensagem("2. Remover aluno do Curso");
		Console.mensagem("3. Listar alunos de um Curso (por parte do nome)");
		Console.mensagem("9. Voltar ao Menu Principal");
		return Console.lerNumeroObrigatorio("");
	}
}
