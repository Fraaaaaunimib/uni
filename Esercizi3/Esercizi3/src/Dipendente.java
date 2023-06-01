package Esercizi3;

public abstract class Dipendente {
	private String nome;
	private int matricola;
	private double salarioMensile;
	
	public Dipendente(String nome, int matricola, double salario) throws DipendenteException{
		if (nome == null || nome.isBlank()) throw new DipendenteException("Nome errato");
		else this.nome = nome;

		if (matricola <= 0) throw new DipendenteException("matricola errata");
		else this.matricola = matricola;

		if (salario <= 0) throw new DipendenteException("Salario troppo basso");
		else this.salarioMensile = salario;
		}

	
	public abstract double calcolaRal();
	
	public double getSalarioMensile() {
		return salarioMensile;
	}

}
