package menu;

import java.util.Date;

import dao.AlunoDAO;
import model.Aluno;
import model.Parentesco;
import model.Responsavel;
import util.Console;

public class MenuAluno implements Menu {

	@Override
	public void executar() {
		int opcao = escolheOpcao();
		switch(opcao){
		
		case 1:
			inserirAluno();
			break;
		case 2:
			buscarAluno();
			break;
		case 3:
			alterarAluno();
			break;
		case 4:
			removerAluno();
			break;
		default:
			break;
		}

	}
	
	private void removerAluno() {
		// TODO Auto-generated method stub
		
	}

	private void alterarAluno() {
		// TODO Auto-generated method stub
		
	}

	private void buscarAluno() {
		// TODO Auto-generated method stub
		
	}

	private void inserirAluno() {
		Aluno novoAluno = getNovoAluno();
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.inserir(novoAluno);
	}

	private Aluno getNovoAluno() {
		String nome = Console.lerStringObrigatoria("Digite o nome do Aluno");
		String rg = Console.lerStringObrigatoria("Digite o rg do Aluno");
		String matricula = Console.lerStringObrigatoria("Digite a "
				+ "matrícula do aluno");
		Date dataNascimento = Console.lerDataObrigatoria("Digite a data de "
				+ "nascimento do aluno");
		Responsavel responsavel= getResponsavel();
		Aluno aluno = new Aluno(matricula, nome, dataNascimento,
				rg, responsavel);
		return aluno;
	}

	private Responsavel getResponsavel() {
		String nome = Console.lerStringObrigatoria("Digite o nome do Responsável");
		String telefone = Console.lerStringObrigatoria("Digite o telefone do Responsável");
		Parentesco parentesco = getParentesco();
		return new Responsavel(nome, telefone, parentesco);
	}
	
	private Parentesco getParentesco(){
		int tipoParentesco = Console.
				lerNumeroObrigatorio("Digite o Tipo do Parentesco (número).\n"
						+ "1. Mãe\n"
						+ "2. Pai\n"
						+ "3. Responsável");
		try{
			return Parentesco.getParentesco(tipoParentesco);
		}
		catch(IllegalArgumentException e){
			return getParentesco();
		}
	}

	public int escolheOpcao(){
		Console.mensagem("\n-----Menu Aluno-----\n");
		Console.mensagem("1. Inserir");
		Console.mensagem("2. Buscar aluno por nome");
		Console.mensagem("3. Alterar aluno (por id)");
		Console.mensagem("4. Remover um aluno (por id)");
		Console.mensagem("9. Voltar ao Menu Principal");
		return Console.lerNumeroObrigatorio("");
	}


}
