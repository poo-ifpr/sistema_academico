package model;

public enum Modalidade {

	INTEGRADO,
	SUBSEQUENTE;
	
	
	public static Modalidade getModalidade(int i){
		switch(i){
		case 1:
			return INTEGRADO;
		case 2:
			return SUBSEQUENTE;
		default:
			throw new IllegalArgumentException("Valor Inválido");
		}
	}
}
