package es.edu.alter.practica0.modelo;
import java.util.ArrayList;
import java.util.List;
public abstract class PiedraPapelTijeraFactory {
	 public static final int PIEDRA=1;
	 public static final int PAPEL=2;
	 public static final int TIJERA=3;
	 public static final int LAGARTO = 4;
	 public static final int SPOCK= 5;
	 protected String descripcionResultado;
	 private static List<PiedraPapelTijeraFactory> elementos;
	 
	 
	 protected String nombre;
	 protected int numero;
	 
	 public PiedraPapelTijeraFactory(String nombre, int numero) {
		 super();
		 this.nombre=nombre;
		 this.numero=numero;
	 }

	public String getDescripcionResultado() {
		return descripcionResultado;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public abstract boolean isMe(int pNUM);
	public abstract int comparar(PiedraPapelTijeraFactory pPPTFact);

	 
	public static PiedraPapelTijeraFactory getInstance(int pNUM) {
        elementos = new ArrayList<PiedraPapelTijeraFactory>();
        elementos.add(new Piedra());
        elementos.add(new Papel());
        elementos.add(new Tijera());
        elementos.add(new Lagarto());
        elementos.add(new Spock());
        
        for (PiedraPapelTijeraFactory piedraPapelTijeraFactory : elementos) {
			if(piedraPapelTijeraFactory.isMe(pNUM)) {
				return piedraPapelTijeraFactory;
			}
		}
		return null;
	}

	 public String toString() {
		 return getNumero() + "-" + getNombre();
	 }
	 
}