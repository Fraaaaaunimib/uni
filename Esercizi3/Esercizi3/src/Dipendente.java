package Esercizi3;

public abstract class Dipendente {
	private String nome;
	private int matricola;
	private double salarioMensile;
	
	public Dipendente(String nome, int matricola, double salario) throws DipendenteException{
		if (nome == null || nome == "" || matricola < 0 || salario < 1000) throw new DipendenteException();
		this.nome = nome;
		this.matricola = matricola;
		this.salarioMensile = salario;
	
}
	
	public abstract double calcolaRal();
	
	public double getSalarioMensile() {
		return salarioMensile;
	}

}
