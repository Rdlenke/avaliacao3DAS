package Cadastros;

public class CalculadoraDuracaoHoras {

	private Viagem viagem;
	private int duracaoHoras;
	
	 public CalculadoraDuracaoHoras(Viagem viagem, int duracaoHoras) {
		this.viagem = viagem;
		this.duracaoHoras = duracaoHoras;
	}
	 
	 public int computar() {
			if (horaTerminoEhIgualAHoraInicio())
				duracaoHoras = 0;
			if (horaTerminoEhMaiorQueHoraInicio()) //varias possibilidades... 
				if (viagem.getHoraTermino() == viagem.getHoraInicio() + 1) {  
					if (minutosTerminoEhMenorQueMinutosInicio())  //nao chegou a uma hora
						duracaoHoras = 0;
					else //durou pelo menos uma hora
						duracaoHoras = 1;
				} else { //possivelmente ultrapassou duas horas
					if (horasDecorridas() > 2) //
						duracaoHoras = horasDecorridas();
					else if (horasDecorridas() == 2 &&   //certamente menos de duas horas  
							 minutosTerminoEhMenorQueMinutosInicio())    //e mais de uma hora
						duracaoHoras = 1;
					else //duracao de duas horas, certamente
						duracaoHoras = 2;
						
				}
			if (horaTerminoEhMenorQueHoraInicio()) 
				duracaoHoras = -1; //para casos em que a hora de termino nao foi registrada
			return duracaoHoras;
	 }

	private boolean horaTerminoEhMenorQueHoraInicio() {
		return viagem.getHoraTermino() < viagem.getHoraInicio();
	}

	private int horasDecorridas() {
		return viagem.getHoraTermino() - viagem.getHoraInicio();
	}

	private boolean minutosTerminoEhMenorQueMinutosInicio() {
		return viagem.getMinutosTermino() < viagem.getMinutoInicio();
	}

	private boolean horaTerminoEhMaiorQueHoraInicio() {
		return viagem.getHoraTermino() > viagem.getHoraInicio();
	}

	private boolean horaTerminoEhIgualAHoraInicio() {
		return viagem.getHoraTermino() == viagem.getHoraInicio();
	}
}
