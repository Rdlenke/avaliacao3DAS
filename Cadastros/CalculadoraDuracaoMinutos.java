package Cadastros;

public class CalculadoraDuracaoMinutos {
	
	private Viagem viagem;
	private int duracaoMinutos;
	
	public CalculadoraDuracaoMinutos(Viagem viagem, int duracaoMinutos) {
		this.viagem = viagem;
		this.duracaoMinutos = duracaoMinutos;
	}
	
	public int computar() {
		if (minutosTerminoEhMaiorQueMinutosInicio()) 
			duracaoMinutos = minutosDecorridos();
		else {
			duracaoMinutos = 60 - viagem.getMinutoInicio() + viagem.getMinutosTermino();
			if (duracaoMinutos == 60) //caso especial
				duracaoMinutos = 0;
		}
		return duracaoMinutos;
	}

	private int minutosDecorridos() {
		return viagem.getMinutosTermino() - viagem.getMinutoInicio();
	}

	private boolean minutosTerminoEhMaiorQueMinutosInicio() {
		return viagem.getMinutosTermino() > viagem.getMinutoInicio();
	}
}
