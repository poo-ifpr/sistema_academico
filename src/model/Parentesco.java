package model;

public enum Parentesco {

	MAE(1),
	PAI(2),
	RESPONSAVEL(3);
	
	
	private int tipo;
	
	Parentesco(int tipo){
		this.tipo = tipo;
	}
	
	
	public static Parentesco getParentesco(int i){
		switch(i){
		case 1:
			return MAE;
		case 2:
			return PAI;
		case 3:
			return RESPONSAVEL;
		default:
			throw new IllegalArgumentException("Valor Inválido");
		}
	}
	
	private String nomePorTipo(){
		String nome = "";
		switch(tipo){
		case 1:
			nome = "Mãe";
			break;
		case 2:
			nome =  "Pai";
			break;
		default:
			nome =  "Responsável";
		}
		return nome;
	}
	
	public String toString(){
		return nomePorTipo();
	}
}
