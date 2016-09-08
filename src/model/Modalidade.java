package model;

public enum Modalidade {

	INTEGRADO(1),
	SUBSEQUENTE(2);
	
	
	private int tipo;
	
	Modalidade(int tipo){
		this.tipo = tipo;
	}
	
	
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
	
	private String nomePorTipo(){
		if(tipo == 1)
			return "Integrado";
		return "Subsequente";
	}
	
	public String toString(){
		return nomePorTipo();
	}
}
