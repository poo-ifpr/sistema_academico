package menu;

import model.Curso;

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
//		CursoDAO cursoDAO = new CursoDAO();
//		cursoDAO.inserir(curso);
		
	}

	private Curso getNovoCurso() {
		System.out.println("Vou digitar informações do Curso");
		Curso curso = new Curso();
		curso.setNome("Informática");
		curso.setModalidade("Integrado");
		return curso;
	}

	public int escolheOpcao(){
		System.out.println("Inserir um curso");
		return 1;
	}

}