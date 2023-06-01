package Esercizi3;

public class Dirigente extends Dipendente {
	private double benefit;
	
	public Dirigente(String nome, int matricola, double salario, double benefit) throws DipendenteException {
		super(nome, matricola, salario);
		if (benefit < 0) throw new DipendenteException();
		this.benefit = benefit;
	}

	@Override
	public double calcolaRal() {
		return 14 * getSalarioMensile() + benefit;
	}

    public double getBenefit(){
        return this.benefit;
    }
}

