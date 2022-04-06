package es.edu.alter.practica0.modelo;

public class Piedra extends PiedraPapelTijeraFactory {

	public Piedra() {
		this("piedra", PiedraPapelTijeraFactory.PIEDRA);
	}
	
	public Piedra(String nombre, int numero) {
		super(nombre, numero);
	}

	@Override
	public boolean isMe(int pNum) {
		return pNum == PiedraPapelTijeraFactory.PIEDRA;
	}

	@Override
	public int comparar(PiedraPapelTijeraFactory pPPTFact) {
		int result=0;
		
		switch(pPPTFact.getNumero()) {
		
		case PiedraPapelTijeraFactory.TIJERA:
			result=1;
			this.descripcionResultado = nombre + " le gana a " + pPPTFact.getNombre();
			break;
		case PiedraPapelTijeraFactory.LAGARTO:
			result=1;
			this.descripcionResultado = nombre + " le gana a " + pPPTFact.getNombre();
			break;
		case PiedraPapelTijeraFactory.PAPEL:
			result= -1;
			this.descripcionResultado = nombre + " pierde con " + pPPTFact.getNombre();
			break;
		case PiedraPapelTijeraFactory.SPOCK:
			result=-1;
			this.descripcionResultado = nombre + " pierde con " + pPPTFact.getNombre();
			break;
		default:
			this.descripcionResultado = nombre + " empata con " + pPPTFact.getNombre();
			break;
		}
		return result;
	}

}
