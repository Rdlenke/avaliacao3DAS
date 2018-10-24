package Cadastros;

public class CalculadoraDuracaoMinutos {
	
	private Viagem viagem;
	private int duracaoMinutos;
	
	public CalculadoraDuracaoMinutos(Viagem viagem, int duracaoMinutos) {
		this.viagem = viagem;
		this.duracaoMinutos = duracaoMinutos;
	}
	
	public int computar() {
		if (viagem.getMinutosTermino() > viagem.getMinutoInicio()) 
			duracaoMinutos = viagem.getMinutosTermino() - viagem.getMinutoInicio();
		else {
			duracaoMinutos = 60 - viagem.getMinutoInicio() + viagem.getMinutosTermino();
			if (duracaoMinutos == 60) //caso especial
				duracaoMinutos = 0;
		}
		return duracaoMinutos;
	}
}
