package model;

public enum Modalidade {

	TECNICO,
	INTEGRADO;
	
	
	public static Modalidade getModalidade(int i){
		switch(i){
		case 0:
			return TECNICO;
		case 1:
			return INTEGRADO;
		default:
			throw new IllegalArgumentException("Valor Inválido");
		}
	}
}
