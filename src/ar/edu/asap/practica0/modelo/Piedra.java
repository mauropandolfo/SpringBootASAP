package ar.edu.asap.practica0.modelo;

public class Piedra extends PiedraPapelTijeraFactory {

	public Piedra(String nombre, int numero) {
		super(nombre, numero);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMe(int pNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int comparar(PiedraPapelTijeraFactory pPPTFact) {
		// TODO Auto-generated method stub
		return 0;
	}

}
